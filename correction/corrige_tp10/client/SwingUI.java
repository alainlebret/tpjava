/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2018 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 14000 Caen, France
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package corrige_tp10.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

/**
 * A graphical interface to use our basic calculator with the TCP protocol.
 *
 * @author Alain Lebret
 * @version 1.3
 */
public class SwingUI extends JFrame implements WindowListener, ActionListener {
    /**
     * The OS on which the client is running.
     */
    static String OS = System.getProperty("os.name").toLowerCase();

    /**
     * The item "Connecter" on the "Serveur" menu.
     */
    JMenuItem mConnect_ = null;

    /**
     * The item "Déconnecter" on the "Serveur" menu.
     */
    JMenuItem mDisconnect_ = null;

    /**
     * The item "Quitter" on the "Serveur" menu.
     */
    JMenuItem mQuit_ = null;

    /**
     * The item "A Propos" on the "Aide" menu.
     */
    JMenuItem mAbout_ = null;

    /**
     * The item "Editeur" on the "Aide" menu
     */
    JMenuItem mEditor_ = null;

    /**
     * The textfield to read the operation.
     */
    private JTextField tfOperation_;

    /**
     * The textarea to display results.
     */
    private JTextArea taResults_;

    /**
     * The {@code TcpClient} to send operations to a distant {@code TcpServer}.
     */
    private TcpClient client_;

    /**
     * Creates a new Swing UI.
     */
    public SwingUI() {
        super("Calculette avec SWING");

        client_ = new TcpClient(9090);

        initMenus();

        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        tfOperation_ = new JTextField();
        tfOperation_.setColumns(6);
        getContentPane().add(tfOperation_);
        tfOperation_.addActionListener(this);

        taResults_ = new JTextArea("", 3, 20);
        getContentPane().add(taResults_);
        addWindowListener(this);
        setSize(300, 150);
        setVisible(true);
    }

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);
    }

    public static boolean isSolaris() {
        return (OS.contains("sunos"));
    }

    /**
     * Initializes the menu bar.
     */
    private void initMenus() {
        /* Menu bar of the UI */
        JMenuBar menuBar = new JMenuBar();

        /* The "Serveur" menu */
        JMenu mServer = new JMenu("Serveur");
        mConnect_ = new JMenuItem("Connecter");
        mDisconnect_ = new JMenuItem("Déconnecter");
        mQuit_ = new JMenuItem("Quitter");

        /* The "Aide" menu */
        JMenu mHelp = new JMenu("Aide");
        mAbout_ = new JMenuItem("À Propos");
        mEditor_ = new JMenuItem("Aide");

        mServer.setMnemonic('S');
        mServer.add(mConnect_);
        mServer.add(mDisconnect_);
        mServer.addSeparator();
        mServer.add(mQuit_);

        mHelp.setMnemonic('A');
        mHelp.add(mAbout_);
        mHelp.addSeparator();
        mHelp.add(mEditor_);

        mConnect_.addActionListener(this);
        mDisconnect_.addActionListener(this);
        mQuit_.addActionListener(this);
        mAbout_.addActionListener(this);
        mEditor_.addActionListener(this);

        menuBar.add(mServer);
        menuBar.add(mHelp);
        setJMenuBar(menuBar);
    }

    public void windowActivated(WindowEvent evt) {
    }

    public void windowDeactivated(WindowEvent evt) {
    }

    public void windowClosed(WindowEvent evt) {
    }

    public void windowClosing(WindowEvent evt) {
        System.exit(0);
    }

    public void windowIconified(WindowEvent evt) {
    }

    public void windowDeiconified(WindowEvent evt) {
    }

    public void windowOpened(WindowEvent evt) {
    }

    /**
     * Manages the action events in the frame.
     *
     * @param evt The source event.
     */
    public void actionPerformed(ActionEvent evt) {
        /*
         * Verifies if some events happen in the textfield...
         */
        if (evt.getSource() == this.tfOperation_) {
            String operation = tfOperation_.getText();
            System.out.println("Calcul à envoyer : " + operation);
            String answer = client_.send(operation);

            // Updates the text area
            System.out.println("Résultat reçu : " + answer);
            taResults_.setText(answer);
        }

        /*
         * Verifies if the "Connecter" menu item has been selected
         */
        if (evt.getSource() == this.mConnect_) {
            System.out.println("Connexion en cours...");
            try {
                client_.connect("127.0.0.1");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Connexion effectuée");
        }

        /*
         * Verifies if the "Déconnecter" menu item has been selected
         */
        if (evt.getSource() == this.mDisconnect_) {
            System.out.println("Déconnexion en cours...");
            client_.disconnect();
            System.out.println("Client déconnecté");
        }

        /*
         * Verifies if the "Quitter" menu item has been selected
         */
        if (evt.getSource() == this.mQuit_) {
            System.exit(0);
        }

        /*
         * Verifies if the "A propos" menu item has been selected
         */
        if (evt.getSource() == this.mAbout_) {
            JOptionPane.showMessageDialog(this, "Calculator v. 1.10\nTSII - 2000",
                    "A Propos", JOptionPane.PLAIN_MESSAGE);
        }

        /*
         * Verifies if the "Editeur" menu item has been selected
         */
        if (evt.getSource() == this.mEditor_) {
            Executor executor = new Executor();
            String editor = "";

            if (isMac()) {
                editor = "mate ressources/aide.txt";
            } else if (isWindows()) {
                editor = "notepad.exe ressources/aide.txt";
            } else if (isUnix()) {
                editor = "gedit ressources/aide.txt";
            }

            executor.execute(editor);
        }
    }

}
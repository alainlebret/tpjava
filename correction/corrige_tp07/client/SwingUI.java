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
package corrige_tp07.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * A graphical interface to use our basic calculator with the UDP protocol.
 *
 * @author Alain Lebret
 * @version 1.1
 */
public class SwingUI extends JFrame implements WindowListener, ActionListener {
    /**
     * The {@code UdpSender} to send operations to a distant {@code UdpReceiver}.
     */
    private UdpSender udpSender_;

    /**
     * The {@code UdpReceiver} to receive results from a distant {@code UdpSender}.
     */
    private UdpReceiver udpReceiver_;

    /**
     * The item "Connecter" on the "Serveur" menu.
     */
    private JMenuItem mConnect_ = null;

    /**
     * The item "Déconnecter" on the "Serveur" menu.
     */
    private JMenuItem mDisconnect_ = null;

    /**
     * The item "Quitter" on the "Serveur" menu.
     */
    private JMenuItem mQuit_ = null;

    /**
     * The item "A Propos" on the "Aide" menu.
     */
    private JMenuItem mAbout_ = null;

    /**
     * The textfield to read the operation.
     */
    private JTextField tfOperation_;

    /**
     * The textarea to display results.
     */
    private JTextArea taResult_;

    /**
     * Creates a new Swing UI.
     */
    public SwingUI() {
        super("Calculette avec SWING");
        initMenus();

        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tfOperation_ = new JTextField();
        tfOperation_.setColumns(6);
        getContentPane().add(tfOperation_);
        tfOperation_.addActionListener(this);

        taResult_ = new JTextArea("", 3, 20);
        getContentPane().add(taResult_);
        addWindowListener(this);
        setSize(300, 150);
        setVisible(true);
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

        mServer.setMnemonic('S');
        mServer.add(mConnect_);
        mServer.add(mDisconnect_);
        mServer.addSeparator();
        mServer.add(mQuit_);

        mHelp.setMnemonic('A');
        mHelp.add(mAbout_);

        mConnect_.addActionListener(this);
        mDisconnect_.addActionListener(this);
        mQuit_.addActionListener(this);
        mAbout_.addActionListener(this);

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
        if (evt.getSource() == tfOperation_) {
            // Gets the text and sends it to the calculator
            udpSender_.send("127.0.0.1", tfOperation_.getText());

            // Updates the text area
            taResult_.setText(udpReceiver_.receive());
        }

        /*
         * Verifies if the "Connecter" menu item has been selected
         */
        if (evt.getSource() == mConnect_) {
            System.out.println("Connexion en cours...");
            udpSender_ = new UdpSender(4000);
            udpReceiver_ = new UdpReceiver(4001);
            System.out.println("Connexion effectuée");
        }

        /*
         * Verifies if the "Déconnecter" menu item has been selected
         */
        if (evt.getSource() == mDisconnect_) {
            System.out.println("Déconnexion en cours...");
            udpSender_ = null;
            udpReceiver_ = null;
            System.out.println("Client déconnecté");
        }

        /*
         * Verifies if the "Quitter" menu item has been selected
         */
        if (evt.getSource() == mQuit_) {
            udpSender_ = null;
            udpReceiver_ = null;
            System.exit(0);
        }

        /*
         * Verifies if the "A propos" menu item has been selected
         */
        if (evt.getSource() == mAbout_) {
            JOptionPane.showMessageDialog(this, "Calculator v. 1.7\nTSII - 2000",
                    "A Propos", JOptionPane.PLAIN_MESSAGE);
        }
    }

}

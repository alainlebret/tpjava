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
package corrige_tp05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * A graphical interface to use our basic calculator.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class SwingUI extends JFrame implements WindowListener, ActionListener {
    /**
     * The associated calculator.
     */
    private Calculator calculator_;

    /**
     * The textfield to read the operation.
     */
    private JTextField tfOperation_;

    /**
     * The textarea to display results.
     */
    private JTextArea taResults_;

    /**
     * Creates a new Swing GUI.
     */
    public SwingUI(Calculator calculator) {
        super("Calculator avec SWING");

        calculator_ = calculator;

        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tfOperation_ = new JTextField();
        tfOperation_.setColumns(6);
        getContentPane().add(tfOperation_);
        tfOperation_.addActionListener(this);

        taResults_ = new JTextArea("Calculator - v. 1.4\n", 6, 20);
        getContentPane().add(taResults_);
        addWindowListener(this);
        setSize(300, 150);
        setVisible(true);
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
         * Verify if some events happen in the textfield
         */
        if (evt.getSource() == tfOperation_) {
            // Transmits the operation from the textfield to the calculator
            calculator_.solve(tfOperation_.getText());

            // Updates the results textarea
            taResults_.setText("");
            taResults_.setText(calculator_.toString());
            tfOperation_.setText("");
        }
    }
}


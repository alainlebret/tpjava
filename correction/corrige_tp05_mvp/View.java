/*
 * SVEN is an open source Java library for machine learning, image analysis
 * and computer vision educational projects.
 *
 * Copyright (C) 2002-2018 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 4000 Caen, France
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

package corrige_tp05_mvp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * A view that respects the MVP pattern.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class View {
    /**
     * A list of listeners subscribed to this view
     */
    private final ArrayList<ViewListener> listeners_;
    /**
     * The textfield to read the operation
     */
    private JTextField tfOperation_;
    /**
     * The textarea to display results
     */
    private JTextArea taResults_;

    /**
     * Creates a new View object.
     */
    public View() {
        final JFrame frame = new JFrame("Calculette utilisant Swing et MVP");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        tfOperation_ = new JTextField();
        tfOperation_.setColumns(6);
        tfOperation_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                notifyListenersOnTextFieldActionPerformed();
            }
        });
        frame.add(tfOperation_);

        taResults_ = new JTextArea("Calculette - v. 1.4\n", 6, 20);
        frame.add(taResults_);

        listeners_ = new ArrayList<>();

        frame.setVisible(true);
    }

    /**
     * Iterates through the list, notifying each listener individually.
     */
    private void notifyListenersOnTextFieldActionPerformed() {
        for (final ViewListener listener : listeners_) {
            listener.onTextFieldActionPerformed();
        }
    }

    /**
     * Subscribes the given listener to the list.
     *
     * @param listener The listener to add.
     */
    public void addListener(final ViewListener listener) {
        listeners_.add(listener);
    }

    public JTextField getOperationTextField() {
        return tfOperation_;
    }

    public JTextArea getResultsTextArea() {
        return taResults_;
    }

}

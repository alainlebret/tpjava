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

package corrige_tp04_mvp;

/**
 * Responsible to responding to user interaction and updating the view
 */
public class Presenter implements ViewListener {
    private final View view;
    private final Calculator calculator_;

    public Presenter(final View view, final Calculator calculator) {
        this.view = view;
        view.addListener(this);
        this.calculator_ = calculator;
    }

    @Override
    public void onTextFieldActionPerformed() {
        // Update the model (ie. the state of the application)
        calculator_.solve(view.getOperationTextField().getText());
        // Update the view
        view.getResultsTextArea().setText("");
        view.getResultsTextArea().setText(calculator_.toString());
        view.getOperationTextField().setText("");
    }

    @Override
    public void onWindowClosing() {
        System.exit(0);
    }
}
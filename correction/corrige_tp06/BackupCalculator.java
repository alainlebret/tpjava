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
package corrige_tp06;

/**
 * A backup calculator that memorizes the <em>n</em>-last operations in a
 * circular buffer and stores them in a text file.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class BackupCalculator extends Calculator {
    /**
     * The text file used as a storage.
     */
    private final TextFile textFile_;

    /**
     * Creates a calculator object with a given buffer size and a text file
     * for storage.
     *
     * @param memorySize The maximum size of circular buffer.
     */
    public BackupCalculator(int memorySize) {
        super(memorySize);
        textFile_ = new TextFile();
    }

    /**
     * Saves the operations in the associated text file.
     */
    public void save() {
        try {
            textFile_.open("calculette.txt", "E");

            for (MathematicalOperation operation : operations_) {
                if (operation != null) {
                    textFile_.write(operation.toString());
                }
            }
            textFile_.close();
        } catch (java.io.IOException e) {
            System.err.println("BackupCalculator:save() - Erreur lors de la sauvegarde.");
        }
    }
}

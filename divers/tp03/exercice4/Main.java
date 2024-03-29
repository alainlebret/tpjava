/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2020 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 14000 Caen, France
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 *  or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package tp03.exercice4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileCopy fc = new FileCopy("divers/tp03/exercice4/ressources/test.txt", "divers/tp03/exercice4/ressources/test.cpy.txt");
        fc.setDelay(10);
        ThreadedFileCopy tc = new ThreadedFileCopy("Copieur de fichier", fc);
        tc.start();
        try {
            fc.duplicateFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tc.stop();
    }
}

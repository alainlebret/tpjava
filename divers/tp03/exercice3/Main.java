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
package tp03.exercice3;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] arg) {
        int charact;
        Rot13FilterOutputStream out = null;
        BufferedInputStream in = new BufferedInputStream(System.in);

        try {
            out = new Rot13FilterOutputStream(new FileOutputStream("divers/tp03/exercice3/ressources/output.cry"));
        } catch (FileNotFoundException e) {
            System.err.println("Rot13FilterOutputStream: " + e);
            System.exit(-1);
        }

        try {
            while ((charact = in.read()) != -1) {
                out.write(charact);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Rot13FilterOutputStream: " + e);
            System.exit(-1);
        }
    }
}

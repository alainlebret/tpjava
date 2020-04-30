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

import java.io.*;

/**
 * A simple test of a binary file using {@code DataInputStream} and {@code DataOutputStream}.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class BinaryFileTest {
    public static void main(String[] argument) {
        /* The output stream to write bytes */
        DataOutputStream fWo;

        /* The input stream to read bytes */
        DataInputStream fRo;

        /*
         * Opens an output stream to a binary file and writes some data.
         */
        try {
            fWo = new DataOutputStream(new FileOutputStream("ressources/test.bin"));
            fWo.writeBoolean(true);
            fWo.writeByte(10);
            fWo.writeChar(65);
            fWo.writeDouble(1.0);
            fWo.writeInt(1024);
            fWo.writeLong(131072);
            fWo.writeShort(8);
            fWo.close();
        } catch (IOException e) {
            System.err.println("Erreur durant l'écriture dans le fichier");
        }

        /*
         * Opens an input stream from a binary file and writes some data.
         */
        StringBuilder values = new StringBuilder();
        try {
            fRo = new DataInputStream(new FileInputStream("ressources/test.bin"));
            values.append("Lecture dans test.bin\n");
            values.append(fRo.readBoolean());
            values.append("\n");
            values.append(fRo.readByte());
            values.append("\n");
            values.append(fRo.readChar());
            values.append("\n");
            values.append(fRo.readDouble());
            values.append("\n");
            values.append(fRo.readInt());
            values.append("\n");
            values.append(fRo.readLong());
            values.append("\n");
            values.append(fRo.readShort());
            values.append("\n");
            fRo.close();
        } catch (IOException e) {
            System.err.println("Erreur durant la lecture dans le fichier");
        }
        System.out.println(values);
    }
}

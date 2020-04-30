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
 * Another class to manage object files (serialization/deserialization).
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class SimpleObjectFile {
    /**
     * The filename.
     */
    private final String name_;

    /**
     * Creates a new object file with the given filename.
     *
     * @param name Name of the file object
     * @see java.io.IOException
     */
    public SimpleObjectFile(String name) {
        name_ = name;
    }

    /**
     * Reads an object from the file (deserialization).
     *
     * @return A reference on the object.
     * @see java.io.IOException
     * @see java.lang.ClassNotFoundException
     */
    public Object read() {
        Object theObject = null;

        try {
            ObjectInputStream fRo = new ObjectInputStream(new FileInputStream(name_));
            theObject = fRo.readObject();
            fRo.close();
        } catch (IOException e) {
            System.err.println("SimpleObjectFile:read() - Erreur durant la lecture du fichier");
        } catch (ClassNotFoundException e) {
            System.err.println("SimpleObjectFile:read() - Erreur durant la lecture des objets");
        }

        return theObject;
    }

    /**
     * Writes the given object to the file (serialization).
     *
     * @param anObject A reference to the object to write.
     * @see java.io.IOException
     */
    public void write(Object anObject) {
        if (anObject instanceof Serializable) {
            try {
                ObjectOutputStream fWo = new ObjectOutputStream(new FileOutputStream(name_));
                fWo.writeObject(anObject);
                fWo.close();
            } catch (IOException e) {
                System.err.println("SimpleObjectFile:write() - Erreur durant l'écriture du fichier");
            }
        }
    }
}

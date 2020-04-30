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
 * A class to manage object files (serialization/deserialization).
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class ObjectFile {
    /**
     * Output stream to serialize objects.
     */
    private ObjectOutputStream fWo_ = null;

    /**
     * Input stream to deserialize objects.
     */
    private ObjectInputStream fRo_ = null;

    /**
     * The mode used (write or read).
     */
    private char mode_;

    /**
     * Opens the object file with the given filename and the given mode. The
     * mode can take the values "L" or "R" for reading and "E" or "W" for
     * writing.
     *
     * @param filename The name of the object file to open.
     * @param mode     The opening mode for the object file.
     * @see java.io.IOException
     */
    public void open(String filename, String mode) throws IOException {
        mode_ = (mode.toUpperCase()).charAt(0);

        if (mode_ == 'R' || mode_ == 'L') {
            fRo_ = new ObjectInputStream(new FileInputStream(filename));
        } else {
            if (mode_ == 'W' || mode_ == 'E') {
                fWo_ = new ObjectOutputStream(new FileOutputStream(filename));
            }
        }
    }

    /**
     * Closes the object file.
     *
     * @see java.io.IOException
     */
    public void close() throws IOException {
        if (mode_ == 'R' || mode_ == 'L') {
            fRo_.close();
        } else {
            if (mode_ == 'W' || mode_ == 'E') {
                fWo_.close();
            }
        }
    }

    /**
     * Reads an object from the file (deserialization).
     *
     * @return A reference on the deserialized object.
     * @see java.io.IOException
     * @see java.lang.ClassNotFoundException
     */
    public Object read() throws IOException, ClassNotFoundException {
        return fRo_.readObject();
    }

    /**
     * Writes the given object to the file (serialization).
     *
     * @param anObject A reference of the object to write.
     * @see java.io.IOException
     */
    public void write(Object anObject) throws IOException {
        if (anObject != null) {
            fWo_.writeObject(anObject);
        }
    }
}

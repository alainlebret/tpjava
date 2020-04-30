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
package corrige_tp07.server;

import java.io.*;

/**
 * A class to manage a text file.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class TextFile {
    /**
     * The associated writer.
     */
    private BufferedWriter fW_;

    /**
     * The associated reader.
     */
    private BufferedReader fR_;

    /**
     * The open mode of the text file.
     */
    private char mode_;

    /**
     * Opens the text file with the given name and mode.
     *
     * @param filename The name of the file to open
     * @param mode     The open mode (read ("L" or "R") / write ("E" or "W"))
     * @see java.io.IOException
     */
    public void open(String filename, String mode) throws IOException {
        mode_ = (mode.toUpperCase()).charAt(0);
        File f = new File(filename);

        if (mode_ == 'R' || mode_ == 'L') {
            fR_ = new BufferedReader(new FileReader(f));
        } else {
            if (mode_ == 'W' || mode_ == 'E') {
                fW_ = new BufferedWriter(new FileWriter(f));
            }
        }
    }

    /**
     * Closes the text file.
     *
     * @see java.io.IOException
     */
    public void close() throws IOException {
        if (mode_ == 'R' || mode_ == 'L') {
            fR_.close();
        } else {
            if (mode_ == 'W' || mode_ == 'E') {
                fW_.close();
            }
        }
    }

    /**
     * Reads a line in the text file.
     *
     * @return The line as a string.
     * @see java.io.IOException
     */
    public String read() throws IOException {
        return fR_.readLine();
    }

    /**
     * Writes the given string to the text file.
     *
     * @param s The string to write to the file.
     * @see java.io.IOException
     */
    public void write(String s) throws IOException {
        if (s != null) {
            fW_.write(s);
            fW_.newLine();
            fW_.flush();
        }
    }
}

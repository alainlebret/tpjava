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
package test.corrige_tp06;

import corrige_tp06.TextFile;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple test of the {@code TextFile} class
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class TextFileTest {
    public static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet,\n" +
            "consetetur sadipscing elitr, sed diam nonumy eirmod tempor\n" +
            "invidunt ut labore et dolore magna aliquyam erat, sed diam\n" +
            "voluptua. At vero eos et accusam et justo duo dolores et ea\n" +
            "rebum. Stet clita kasd gubergren, no sea takimata sanctus est\n";

    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    TextFile file = new TextFile();

    @Test
    public void openAndClose() {
        LOGGER.log(Level.INFO, "TextFile::open()");
        try {
            file.open("ressources/test.txt", "W");
            LOGGER.log(Level.INFO, "File opened");
            file.close();
            LOGGER.log(Level.INFO, "File closed");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.log(Level.INFO, "TextFile::openAndClose(): an exception occurred");
        }
    }

    @Test
    public void write() {
        LOGGER.log(Level.INFO, "TextFile::write()");
        try {
            file.open("ressources/test.txt", "W");
            file.write(LOREM_IPSUM);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, "Text has been written");
    }

    @Test
    public void read() {
        LOGGER.log(Level.INFO, "TextFile::read()");
        try {
            file.open("test.txt", "R");
            StringBuilder result = new StringBuilder();
            String temp;
            while ((temp = file.read()) != null) {
                result.append(temp).append("\n");
            }
            file.close();
            LOGGER.log(Level.INFO, "\n" + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, "Text has been read");
    }

}


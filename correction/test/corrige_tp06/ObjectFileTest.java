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

import corrige_tp06.MathematicalOperation;
import corrige_tp06.ObjectFile;
import corrige_tp06.OperationException;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectFileTest {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    MathematicalOperation om = new MathematicalOperation();
    ObjectFile file = new ObjectFile();

    @Test
    public void openAndClose() {
        LOGGER.log(Level.INFO, "ObjectFile::open()");
        try {
            file.open("test.o", "W");
            LOGGER.log(Level.INFO, "File opened");
            file.close();
            LOGGER.log(Level.INFO, "File closed");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.log(Level.INFO, "ObjectFile::openAndClose(): an exception occurred");
        }
    }

    @Test
    public void write() {
        LOGGER.log(Level.INFO, "ObjectFile::write()");
        try {
            file.open("test.o", "W");
            om.solve("1+2");
            file.write(om);
            file.close();
        } catch (IOException | OperationException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, "Objects have been written");
    }

    @Test
    public void read() {
        LOGGER.log(Level.INFO, "ObjectFile::read()");
        try {
            file.open("test.o", "R");
            MathematicalOperation result;
            result = (MathematicalOperation) file.read();
            LOGGER.log(Level.INFO, "\n" + result.toString());
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, "Objects have been read");
    }

}


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
import corrige_tp06.OperationException;
import corrige_tp06.SimpleObjectFile;
import org.junit.Test;

import java.io.EOFException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A simple test of the {@code TextFile} class
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class SimpleObjectFileTest {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    SimpleObjectFile file = new SimpleObjectFile("ressources/test.ser");

    @Test
    public void write() {
        LOGGER.log(Level.INFO, "SimpleObjectFile::write()");
        MathematicalOperation om = new MathematicalOperation();
        try {
            om.solve("1+2");
            file.write(om);
        } catch (OperationException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, "Object has been written");
    }

    @Test
    public void read() {
        Throwable exception1 = assertThrows(NullPointerException.class, () -> {
            throw new NullPointerException("File \"test.ser\" possibly inexistant!");
        });
        Throwable exception2 = assertThrows(EOFException.class, () -> {
            throw new EOFException("EOF exception in file \"test.ser\"");
        });
        LOGGER.log(Level.INFO, "SimpleObjectFile::read()");
        String result = file.read().toString();
        LOGGER.log(Level.INFO, "\n" + result);
        LOGGER.log(Level.INFO, "Object has been read");
    }

}

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
package tp01.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp01.Telegram;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test of the class Telegram using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
class TelegramTest {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    final String sentence = "Donec id elit non mi porta gravida at eget metus";
    final String telegram = "Donec. Stop. id. Stop. elit. Stop. non. Stop. mi. Stop. porta. Stop. gravida. Stop. at. Stop. eget. Stop. metus. Stop. ";

    // For display test
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUp() {
        LOGGER.log(Level.INFO, "Testing class Directory");
        //  For display test
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        LOGGER.log(Level.INFO, "Input/output have been redirected for testing");

    }

    /*
     * Shows how to test the main function n times by redirecting the
     * default System.out.
     */

    @Test
    public void testMainWithWellFormedInputs() {
        LOGGER.log(Level.INFO, "Telegram::main()");
        // Calls main
        Telegram.main(sentence.split(" "));
        assertEquals(telegram + "\n", getOutput());
        LOGGER.log(Level.INFO, "Sum::main() has passed");
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    /*
     * Restores the default system input and output.
     */
    @AfterEach
    void tearDown() {
        System.setIn(systemIn);
        System.setOut(systemOut);
        LOGGER.log(Level.INFO, "Input/output have been restored");
    }
}
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
package tp03.exercice1.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tp03.exercice1.FilteredDirectory;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Test of the class FilteredDirectory using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
public class FilteredDirectoryTest {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    FilteredDirectory filteredDirectory;
    String pathname = "divers/tp03/exercice1/ressources";
    String[] files = {"Class1.java", "Class2.java", "Class3.java"};

    // For display test
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUp() {
        LOGGER.log(Level.INFO, "Testing class FilterDirectory");
        filteredDirectory = new FilteredDirectory(pathname, "java");

        //  For display test
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        LOGGER.log(Level.INFO, "Input/output have been redirected for testing");
    }

    @Test
    @Tag("development")
    public void testList() {
        LOGGER.log(Level.INFO, "FilterDirectory::list()");
        assertArrayEquals(files, filteredDirectory.list());
        LOGGER.log(Level.INFO, "FilterDirectory::list() has passed");
    }

    @Test
    @Tag("development")
    public void testAccept() {
        LOGGER.log(Level.INFO, "FilterDirectory::accept()");
        assertTrue(filteredDirectory.accept(new File(pathname), files[0]));
        assertFalse(filteredDirectory.accept(new File(pathname), "f1.cc"));
        LOGGER.log(Level.INFO, "FilterDirectory::accept() has passed");
    }

    /* Shows how to test a display function by redirecting the
     * default System.out.
     */
    @Test
    @Tag("development")
    public void testDisplay() {
        LOGGER.log(Level.INFO, "FilterDirectory::display()");
        StringBuilder expectedOutput = new StringBuilder();
        for (String file : files) {
            expectedOutput.append(file);
            expectedOutput.append("\n");
        }
        filteredDirectory.display(filteredDirectory.list());
        assertEquals(expectedOutput.toString(), getOutput());
        LOGGER.log(Level.INFO, "FilterDirectory::display() has passed");

    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    void tearDown() {
        // Restore default system input and output
        System.setIn(systemIn);
        System.setOut(systemOut);
        LOGGER.log(Level.INFO, "Input/output have been restored");
    }
}

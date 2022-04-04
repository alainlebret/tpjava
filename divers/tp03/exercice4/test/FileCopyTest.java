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
package tp03.exercice4.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp03.exercice4.FileCopy;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test of the class FileCopy using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
public class FileCopyTest {
    static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    static final String BASENAME = "divers/tp03/exercice4/ressources";
    String sourceFilename = BASENAME + "/test.txt";
    String destFilename = BASENAME + "/test.cpy.txt";
    FileCopy fc = new FileCopy(sourceFilename, destFilename);

    @BeforeEach
    public void setUp() {
        LOGGER.log(Level.INFO, "Testing class FileCopy");
        fc.setDelay(3);
    }

    @AfterEach
    public void tearDown() {
        if (fc.isFinished()) {
            LOGGER.log(Level.INFO, "File has been copied (" + fc.getNumberOfBytesCopied() + " bytes copied)");
        }
    }

    @Test
    public void testDuplicateFile() throws IOException {
        LOGGER.log(Level.INFO, "FileCopy::duplicateFile()");
        fc.duplicateFile();
        String orig = readFile(sourceFilename, Charset.defaultCharset()); // or StandardCharsets.UTF_8);
        String dest = readFile(destFilename, Charset.defaultCharset());
        assertEquals(orig, dest);
        LOGGER.log(Level.INFO, "FileCopy::duplicateFile() has passed");
    }

    /*
     * To read all content from a "tiny" file into a string.
     */

    /* Between Java 7 and Java 11 */
    private static String readFile(String filename, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filename));
        return new String(encoded, encoding);
    }

    /* Java 11 and above */
//    private static String readFile2(String filename, Charset encoding) throws IOException {
//        return Files.readString(filename); // if UTF-8
//        return Files.readString(filename, encoding);
//    }
}
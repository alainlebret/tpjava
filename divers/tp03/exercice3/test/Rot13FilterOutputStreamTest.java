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
package tp03.exercice3.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tp03.exercice3.Rot13FilterOutputStream;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
 * Test of the class Rot13FilterOutputStream using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
public class Rot13FilterOutputStreamTest {
    static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    static final String BASENAME = "divers/tp03/exercice3/ressources";
    static final String OUT_ENCODED_FILENAME = "test1.cry";
    static final String OUT_UNENCODED_FILENAME = "test1.uncry";

    char[] unencodedChars = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|".toCharArray();
    char[] encodedChars = "!\"#$%&'()*+,-./0123456789:;<=>?@NOPQRSTUVWXYZABCDEFGHIJKLM[\\]^_`nopqrstuvwxyzabcdefghijklm{|".toCharArray();

    File outEncoded;
    File outUnencoded;
    Rot13FilterOutputStream rfOutEncoded;
    Rot13FilterOutputStream rfOutUnencoded;

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        LOGGER.log(Level.INFO, "Testing class Rot13FilterOutputStream");
        outEncoded = new File(BASENAME + "/" + OUT_ENCODED_FILENAME);
        outUnencoded = new File(BASENAME + "/" + OUT_UNENCODED_FILENAME);
        rfOutEncoded = new Rot13FilterOutputStream(new FileOutputStream(outEncoded));
        rfOutUnencoded = new Rot13FilterOutputStream(new FileOutputStream(outUnencoded));
    }

    @Test
    @Tag("development")
    public void testWrite() throws IOException {
        int charact;
        char[] result;

        LOGGER.log(Level.INFO, "Rot13FilterOutputStreamTest::write()");
        for (charact = 33; charact < 125; charact++) {
            rfOutEncoded.write(charact);
        }
        rfOutEncoded.close();
        assertArrayEquals(encodedChars, readAsciiCodes(BASENAME + "/" + OUT_ENCODED_FILENAME));

        for (int i = 0; i < 92; i++) {
            rfOutUnencoded.write(encodedChars[i]);
        }
        rfOutUnencoded.close();
        assertArrayEquals(unencodedChars, readAsciiCodes(BASENAME + "/" + OUT_UNENCODED_FILENAME));

        LOGGER.log(Level.INFO, "Rot13FilterOutputStreamTest::write() has passed");
    }

    private char[] readAsciiCodes(String filename) throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        char[] asciiCodes = new char[92];
        int c;
        int i = 0;

        while ((c = br.read()) != -1) {
            char character = (char) c;
            asciiCodes[i++] = character;
        }
        return asciiCodes;
    }

    @AfterEach
    public void tearDown() throws Exception {
//        _outEncoded.delete();
//        _outUnencoded.delete();
    }

}
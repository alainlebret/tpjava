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
package tp03.exercice5.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp03.exercice5.RingBuffer;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test of the class CircularBufferTest using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
public class RingBufferTest {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    final static String[] messages = {"message 1", "message 2", "message 3", "message 4", "message 5", "message 6",
            "message 7", "message 8", "message 9", "message 10", "message 11"};
    static int SIZE = 5;
    RingBuffer cb = new RingBuffer(SIZE);

    @BeforeEach
    public void setUp() {
        LOGGER.log(Level.INFO, "Testing class CircularBuffer");
    }

    @Test
    public void testPutAndGet() {
        LOGGER.log(Level.INFO, "CircularBuffer::putAndget()");
        // Non thread access
        for (String message : messages) {
            cb.push(message);
            assertEquals(message, cb.pop());
        }
        LOGGER.log(Level.INFO, "CircularBuffer::putAndget() has passed");
    }

}
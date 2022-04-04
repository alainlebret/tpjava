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
package tp02.exo3.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tp02.exo3.SortableInteger;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Test of the class SortableInteger using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
class SortableIntegerTest {
    static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static final int NUMBER_OF_INTEGERS = 100;
    static final int MIN = -1000;
    static final int MAX = 1000;

    int[] randomValues;
    SortableInteger[] someSortableIntegers;

    @BeforeEach
    void setUp() {
        LOGGER.log(Level.INFO, "Testing class SortableInteger");
        randomValues = new int[NUMBER_OF_INTEGERS];
        someSortableIntegers = new SortableInteger[NUMBER_OF_INTEGERS];
        for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
            randomValues[i] = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            someSortableIntegers[i] = new SortableInteger("" + randomValues[i]);
        }
    }

    @RepeatedTest(5)
    @Tag("development")
    public void testEgal() {
        LOGGER.log(Level.INFO, "SortableInteger::egal()");
        for (int i = 0; i < NUMBER_OF_INTEGERS - 1; i++) {
            for (int k = i + 1; k < NUMBER_OF_INTEGERS; k++) {
                if (randomValues[i] == randomValues[k]) {
                    assertTrue(someSortableIntegers[i].egal(someSortableIntegers[k]));
                } else {
                    assertFalse(someSortableIntegers[i].egal(someSortableIntegers[k]));
                }
            }
        }
        LOGGER.log(Level.INFO, "SortableInteger::egal() has passed");
    }

    @RepeatedTest(5)
    @Tag("development")
    public void testCompareTo() {
        LOGGER.log(Level.INFO, "SortableInteger::compareTo()");
        for (int i = 0; i < NUMBER_OF_INTEGERS - 1; i++) {
            for (int k = i + 1; k < NUMBER_OF_INTEGERS; k++) {
                switch (randomValues[i] - randomValues[k]) {
                    case 0:
                        assertEquals(0, someSortableIntegers[i].compareTo(someSortableIntegers[k]));
                        break;
                    case -1:
                        assertTrue(someSortableIntegers[i].compareTo(someSortableIntegers[k]) < 0);
                        break;
                    case 1:
                        assertTrue(someSortableIntegers[i].compareTo(someSortableIntegers[k]) > 0);
                        break;
                }
            }
        }
        LOGGER.log(Level.INFO, "SortableInteger::compareTo() has passed");
    }

    @Test
    @Tag("development")
    public void testToString() {
        LOGGER.log(Level.INFO, "SortableInteger::toString()");
        for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
            assertEquals(someSortableIntegers[i].toString(), "" + randomValues[i], "toString() has returned a bad string");
        }
        LOGGER.log(Level.INFO, "SortableInteger::toString() has passed");
    }
}
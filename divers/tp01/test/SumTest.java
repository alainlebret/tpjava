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

import org.junit.jupiter.api.*;

import tp01.Sum;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test of the class Sum using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
class SumTest {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    final int NUMBER_OF_INTEGERS = 20;
    final int MIN = -100;
    final int MAX = 100;

    int[] randomValues;

    // For display test
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUp() {
        LOGGER.log(Level.INFO, "Testing class Directory");
        // Getting some random integers
        randomValues = new int[NUMBER_OF_INTEGERS];
        for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
            randomValues[i] = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
        }
        //  For display test
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        LOGGER.log(Level.INFO, "Input/output have been redirected for testing");

    }

    @Test
    public void testMainWithMalformedInputs() {
        LOGGER.log(Level.INFO, "Sum::main(): test with a NumberFormatException");
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Sum.main(new String[] {"1", "10", "-3 ", "1O", "6"}); // "1O" is composed of the digit '1' and the letter 'O'
        });
        LOGGER.log(Level.INFO, "The NumberFormatException has been thrown");
    }

    /*
     * Shows how to test the main function n times by redirecting the
     * default System.out.
     */

    @RepeatedTest(5)
    public void testMainWithWellFormedInputs() {
        LOGGER.log(Level.INFO, "Sum::main()");

        // Gets a string input array from random values
        IntStream intStream = Arrays.stream(randomValues);
        String[] inputValues = intStream.sorted().mapToObj(String::valueOf).toArray(String[]::new);
        StringBuilder builder = new StringBuilder();
        for(String s : inputValues) {
            builder.append(s);
            builder.append(" ");
        }
        LOGGER.log(Level.INFO, "inputs = " + builder.toString());

        // Gets the sum from random values
        int sum = Arrays.stream(randomValues).sum();
        LOGGER.log(Level.INFO, "sum = " + sum);

        // Constructs the output result
        String expectedOutput = "Sum = " + sum + "\n";

        // Calls main
        Sum.main(inputValues);

        assertEquals(expectedOutput, getOutput());

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
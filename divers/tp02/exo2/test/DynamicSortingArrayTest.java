package tp02.exo2.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp02.exo2.DynamicSortingArray;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Test of the class SimpleSort using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
class DynamicSortingArrayTest {
    static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    static final int NUMBER_OF_INTEGERS = 10;
    static final int DEFAULT_INCREMENT = 10;
    static final int MIN = -1000;
    static final int MAX = 1000;

    int[] randomValues;
    int[] moreRandomValues;
    DynamicSortingArray someSimpleSort;

    @BeforeEach
    void setUp() {
        LOGGER.log(Level.INFO, "Testing class SimpleSort");
        randomValues = new int[NUMBER_OF_INTEGERS];
        moreRandomValues = new int[DEFAULT_INCREMENT];
        someSimpleSort = new DynamicSortingArray(NUMBER_OF_INTEGERS, DEFAULT_INCREMENT);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void elements() {
        for (int i = 0; i < someSimpleSort.getCapacity(); i++) {
            LOGGER.log(Level.INFO, "" + someSimpleSort.elements());
            LOGGER.log(Level.INFO, "Before inserting >> " + someSimpleSort.toString());
            someSimpleSort.insert(randomValues[i]);
            LOGGER.log(Level.INFO, "" + someSimpleSort.elements());
            LOGGER.log(Level.INFO, "After inserting >> " + someSimpleSort.toString());
        }
    }

    @Test
    void insert() {
        LOGGER.log(Level.INFO, someSimpleSort.toString());
        for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
            randomValues[i] = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            someSimpleSort.insert(randomValues[i]);
        }
        LOGGER.log(Level.INFO, someSimpleSort.toString());
        for (int i = 0; i < DEFAULT_INCREMENT; i++) {
            moreRandomValues[i] = ThreadLocalRandom.current().nextInt(MIN,
                    MAX + 1);
            someSimpleSort.insert(randomValues[i]);
        }
        LOGGER.log(Level.INFO, someSimpleSort.toString());
    }

    @Test
    void remove() {
    }

}
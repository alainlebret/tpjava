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
package tp03.exercice2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tp03.exercice2.WordOccurrences;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test of the class WordOccurrences using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
public class WordOccurrencesTest {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    final String baseName = "divers/tp03/exercice2/ressources";
    final String[] pathNames = {"test1.txt", "test2.txt"};

    WordOccurrences occ1;
    WordOccurrences occ2;

    @BeforeEach
    public void setUp() throws Exception {
        LOGGER.log(Level.INFO, "Testing class WordOccurrences");
        occ1 = new WordOccurrences();
        occ2 = new WordOccurrences();
        occ1.read(baseName + "/" + pathNames[0]);
        occ2.read(baseName + "/" + pathNames[1]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1.txt", "test2.txt"})
    @Tag("development")
    public void firstTestOfGetWordsAndOccurrences(String filename) {
        LOGGER.log(Level.INFO, "WordOccurrences::getWordsAndOccurrences(): " + filename);
        HashMap<String, Integer> keysAndValues;
        if (pathNames[0].equals(filename)) {
            keysAndValues = occ1.getWordsAndOccurrences();
            assertEquals((Integer) 6, keysAndValues.get("opinion"));
        } else if (pathNames[1].equals(filename)) {
            keysAndValues = occ2.getWordsAndOccurrences();
            assertEquals((Integer) 4, keysAndValues.get("Prince"));
            assertEquals((Integer) 5, keysAndValues.get("partez"));
            assertEquals((Integer) 6, keysAndValues.get("en"));
            assertEquals((Integer) 7, keysAndValues.get("diligence"));
            assertEquals((Integer) 8, keysAndValues.get("Néron"));
            assertEquals((Integer) 9, keysAndValues.get("impatient"));

        }
        LOGGER.log(Level.INFO, "WordOccurrences::getWordsAndOccurrences() has passed");
    }
}

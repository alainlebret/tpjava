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
package tp02.exo1.test;

import org.junit.jupiter.api.*;
import tp02.exo1.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Test of the class Document using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
class DocumentTest {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    List<Document> documents;
    List<Integer> numbers;
    List<String> titles;

    @BeforeEach
    void setUp() {
        LOGGER.log(Level.INFO, "Testing class Document");
        documents = new ArrayList();
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 10, 14, 75, 654, 2534, 117531, 546321, 2));
        titles = new ArrayList<>(Arrays.asList("FAQ du langage C", "Charte visuelle", "HowTo Java",
                "Tutoriel Python", "Mémento de chimie inorganique", "Formules de trigonométrie",
                "FAQ du langage C", "Réglement intérieur", "Mémento d'algèbre", "La règle de 3", "Charte visuelle"));
        for (int i = 0; i < numbers.size(); i++) {
            documents.add(new Document(numbers.get(i), titles.get(i)));
        }
    }

    @Test
    @Tag("development")
    public void testCopyConstructeurWithNonNullDocument() {
        LOGGER.log(Level.INFO, "Document::Document(Document d): testing non-null document");
        Document copy = null;

        try {
            copy = new Document(documents.get(2));
        } catch (Exception e) {
            fail("Exception: " + e);
        }
        assertEquals(copy, documents.get(2), "Expected document is not equal to actual.");
        LOGGER.log(Level.INFO, "The document has been created");
    }

    @Test
    @Tag("development")
    void testCopyConstructorWithNullDocument() {
        LOGGER.log(Level.INFO, "Document::Document(Document d): testing with null document");
        Document d = null;
        assertThrows(NullPointerException.class, () -> {
            Document copy = new Document(d);
        });
        LOGGER.log(Level.INFO, "The NullPointerException has been thrown");
    }

    @Test
    @Tag("development")
    @DisplayName("getNumber() examples")
    void testGetNumber() {
        LOGGER.log(Level.INFO, "Document::getNumber()");
        assertIterableEquals(numbers, getActualNumbers()); // Iterative assertion on collections
        LOGGER.log(Level.INFO, "Document::getNumber() has passed");
    }

    private List<Integer> getActualNumbers() {
        List<Integer> actualNumbers = new ArrayList();
        for (Document d : documents) {
            actualNumbers.add(d.getNumber());
        }
        return actualNumbers;
    }

    @Test
    @Tag("development")
    void testGetTitle() {
        LOGGER.log(Level.INFO, "Document::getTitle()");
        assertIterableEquals(titles, getActualTitles());
        LOGGER.log(Level.INFO, "Document::getTitle() has passed");
    }

    private List<String> getActualTitles() {
        List<String> actualTitles = new ArrayList();
        for (Document d : documents) {
            actualTitles.add(d.getTitle());
        }
        return actualTitles;
    }

    @Test
    @Tag("development")
    void testEquals() {
        int maxIndex = documents.size() - 1;

        LOGGER.log(Level.INFO, "Document::equals()");
        assertEquals(documents.get(1), documents.get(1), "Document is not equal to itself");
        for (int i = 0; i < documents.size() - 1; i++) {
            for (int k = i + 1; k < documents.size(); k++) {
                if (i == 1 && k == maxIndex) {
                    assertEquals(documents.get(1), documents.get(10), "Document 1 is not equal to document " + maxIndex);
                } else {
                    assertNotEquals(documents.get(i), documents.get(k), "Document " + i + " is equal to document " + k);
                }
            }
        }
        LOGGER.log(Level.INFO, "Document::equals() has passed");
    }

    @Test
    @Tag("development")
    void testHashCode() {
        int hc, i = 0;

        LOGGER.log(Level.INFO, "Document::hashCode()");
        for (Document d : documents) {
            hc = 31 * (31 * 17 + numbers.get(i)) + titles.get(i).hashCode();
            assertEquals(d.hashCode(), hc, "Bad hashcode.");
            i++;
        }

        LOGGER.log(Level.INFO, "Document::hashCode() has passed");
    }

    @Test
    @Tag("development")
    void testToString() {
        String expectedToString;
        int i = 0;

        LOGGER.log(Level.INFO, "Document::toString()");
        for (Document d : documents) {
            expectedToString = String.format("[%06d]|%s", numbers.get(i), titles.get(i));
            assertEquals(d.toString(), expectedToString, "Bad string returned by toString.");
            i++;
        }
        LOGGER.log(Level.INFO, "Document::toString() has passed");
    }
}
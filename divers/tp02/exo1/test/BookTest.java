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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tp02.exo1.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Test of the class Book using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
class BookTest {
    static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    List<Book> books;
    List<Integer> numbers;
    List<String> titles;
    List<String> authors;

    @BeforeEach
    void setUp() {
        LOGGER.log(Level.INFO, "Testing class Book");
        LOGGER.log(Level.INFO, "Document: setUp");
        books = new ArrayList<>();
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 10, 14, 75, 654, 2534, 117531, 546321, 2));
        titles = new ArrayList<>(Arrays.asList("FAQ du langage C", "Charte visuelle", "HowTo Java",
                "Tutoriel Python", "Mémento de chimie inorganique", "Formules de trigonométrie",
                "FAQ du langage C", "Réglement intérieur", "Mémento d'algèbre", "La règle de 3", "Charte visuelle"));
        authors = new ArrayList<>(Arrays.asList("Jean Saigne", "Paul Tron", "Jean Saigne",
                "Jacques Cepte", "Jacques Adi", "Jeanne Aimare",
                "Jean Saigne", "Mel Ange", "Jeanne Aimare", "Jeanne Aimare", "Paul Tron"));
        for (int i = 0; i < numbers.size(); i++) {
            books.add(new Book(numbers.get(i), titles.get(i), authors.get(i)));
        }
        LOGGER.log(Level.INFO, "SetUp has passed");
    }

    @Test
    public void testCopyConstructeurWithNonNullDocument() {
        LOGGER.log(Level.INFO, "Book::Book(Book b): testing non-null book");
        Book copy = null;

        try {
            copy = new Book(books.get(2));
        } catch (Exception e) {
            fail("Exception: " + e);
        }
        assertEquals(copy, books.get(2), "Expected book is not equal to actual.");
        LOGGER.log(Level.INFO, "The document has been created");
    }

    @Test
    void testCopyConstructorWithNullDocument() {
        LOGGER.log(Level.INFO, "Book::Book(Book b): testing with null book");
        Book d = null;
        assertThrows(NullPointerException.class, () -> {
            Book copy = new Book(d);
        });
        LOGGER.log(Level.INFO, "The NullPointerException has been thrown");
    }

    @Test
    @DisplayName("getNumber() examples")
    void testGetNumber() {
        LOGGER.log(Level.INFO, "Book::getNumber()");
        assertIterableEquals(numbers, getActualNumbers()); // Iterative assertion on collections
        LOGGER.log(Level.INFO, "Book::getNumber() has passed");
    }

    private List<Integer> getActualNumbers() {
        List<Integer> actualNumbers = new ArrayList<>();
        for (Book b : books) {
            actualNumbers.add(b.getNumber());
        }
        return actualNumbers;
    }

    @Test
    void testGetTitle() {
        LOGGER.log(Level.INFO, "Book::getTitle()");
        assertIterableEquals(titles, getActualTitles());
        LOGGER.log(Level.INFO, "Book::getTitle() has passed");
    }

    private List<String> getActualTitles() {
        List<String> actualTitles = new ArrayList<>();
        for (Book b : books) {
            actualTitles.add(b.getTitle());
        }
        return actualTitles;
    }

    @Test
    void testGetAuthor() {
        LOGGER.log(Level.INFO, "Book::getAuthor()");
        assertIterableEquals(authors, getActualAuthors());
        LOGGER.log(Level.INFO, "Book::getAuthor() has passed");
    }

    private List<String> getActualAuthors() {
        List<String> actualAuthors = new ArrayList<>();
        for (Book b : books) {
            actualAuthors.add(b.getAuthor());
        }
        return actualAuthors;
    }

    @Test
        // Not as good as it should...
    void testEquals() {
        int maxIndex = books.size() - 1;

        LOGGER.log(Level.INFO, "Book::equals()");
        assertEquals(books.get(1), books.get(1), "Book is not equal to itself");
        for (int i = 0; i < books.size() - 1; i++) {
            for (int k = i + 1; k < books.size(); k++) {
                if (i == 1 && k == maxIndex) {
                    assertEquals(books.get(1), books.get(10), "Book 1 is not equal to book " + maxIndex);
                } else {
                    assertNotEquals(books.get(i), books.get(k), "Book " + i + " is equal to book " + k);
                }
            }
        }
        LOGGER.log(Level.INFO, "Book::equals() has passed");
    }

    @Test
    void testHashCode() {
        int hc;
        int i = 0;

        LOGGER.log(Level.INFO, "Book::hashCode()");
        for (Book b : books) {
            hc = 31 * (31 * (31 * 17 + numbers.get(i)) + titles.get(i).hashCode()) + authors.get(i).hashCode();
            assertEquals(b.hashCode(), hc, "Bad hashcode.");
            i++;
        }
        LOGGER.log(Level.INFO, "Book::hashCode() has passed");
    }

    @Test
    void testToString() {
        String expectedToString;
        int i = 0;

        LOGGER.log(Level.INFO, "Book::toString()");
        for (Book b : books) {
            expectedToString = String.format("[%06d]|%s. \"%s\"", numbers.get(i), authors.get(i), titles.get(i));
            assertEquals(b.toString(), expectedToString, "Bad string returned by toString.");
            i++;
        }
        LOGGER.log(Level.INFO, "Book::toString() has passed");
    }
}
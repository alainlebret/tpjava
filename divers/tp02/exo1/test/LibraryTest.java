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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tp02.exo1.Book;
import tp02.exo1.Document;
import tp02.exo1.DocumentException;
import tp02.exo1.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * Test of the class Library using JUnit 5.
 * See: https://howtodoinjava.com/junit5
 */
class LibraryTest {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    final static int SIZE = 5;

    Library library;
    List<Integer> numbers;
    List<String> titles;
    List<String> authors;

    @BeforeEach
    void setUp() {
        LOGGER.log(Level.INFO, "Testing class Library");
        numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 10, 14, 75, 654, 2534, 117531, 546321, 2));
        titles = new ArrayList<>(Arrays.asList("FAQ du langage C", "Charte visuelle", "HowTo Java",
                "Tutoriel Python", "Mémento de chimie inorganique", "Formules de trigonométrie",
                "FAQ du langage C", "Réglement intérieur", "Mémento d'algèbre", "La règle de 3", "Charte visuelle"));
        authors = new ArrayList<>(Arrays.asList("Jean Saigne", "Paul Tron", "Jacques Adi", "Jeanne Aimare",
                "Mel Ange"));
        library = new Library(2 * SIZE);
        try {
            for (int i = 0; i < SIZE; i++) {
                library.addDocument(new Book(numbers.get(i), titles.get(i), authors.get(i)));
            }
            for (int i = 0; i < SIZE; i++) {
                library.addDocument(new Document(numbers.get(i + SIZE), titles.get(i + SIZE)));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        LOGGER.log(Level.INFO, "Have added " + 2 * SIZE + " documents to the library");
    }

    @Test
    public void testAddDocumentWithExpectedException() {
        LOGGER.log(Level.INFO, "Document::addDocument(): testing DocumentException");
        Assertions.assertThrows(DocumentException.class, () -> {
            library.addDocument(new Book(numbers.get(10), titles.get(1), authors.get(1)));
        });
        LOGGER.log(Level.INFO, "The DocumentException has been thrown");
    }

}
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
package tp02.exo1;

/**
 * A class that defines a book object that is also a document. The <code>equals</code>
 * method has not been override here.
 *
 * @author Alain Lebret
 * @version 0.2.0
 */
public class Book extends Document {
    /**
     * The author of the book
     */
    private final String author;

    /**
     * Creates a new book with the given number, title and author
     * name.
     *
     * @param number The number of the document (should be strictly positive).
     * @param title  The title of the document.
     * @param author The author of the document.
     */
    public Book(int number, String title, String author) {
        super(number, title);
        this.author = author;
    }

    /**
     * Creates a new book with the same number, title and author than a given one.
     *
     * @param book A book to copy from.
     */
    public Book(Book book) {
        super(book.getNumber(), book.getTitle());
        author = book.author;
    }

    /**
     * Returns the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Tests if this book is equal to the given one.
     *
     * @param o The book to test with.
     * @return true if both books are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Book d = (Book) o;
        return author.equals(d.author);
    }

    @Override
    public int hashCode() {
        int hashcode = super.hashCode();
        hashcode = 31 * hashcode + author.hashCode();
        return hashcode;
    }

    /**
     * Returns the string representation of this document.
     * The string has the following format: [XXXXXX]|author. "title",
     * where XXXXXX is the number of the document. Each of the
     * capital letters represents a single decimal digit.
     * If the number of this document is too small to fill up
     * its field, the field is padded with leading zeros.
     */
    @Override
    public String toString() {
        return String.format("[%06d]|%s. \"%s\"", getNumber(), getAuthor(), getTitle());
    }
}

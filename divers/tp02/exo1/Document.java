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
 * A generic document with a number and a title.
 *
 * @author Alain Lebret
 * @version 0.2.0
 */
public class Document {
    /**
     * The number of the document.
     */
    private int number;

    /**
     * The title of the document.
     */
    private String title;

    /**
     * Creates a new document with a given number and a given title.
     *
     * @param number The number of the document (should be strictly positive).
     * @param title  The title of the document.
     */
    public Document(int number, String title) {
        this.number = number;
        this.title = title;
    }

    /**
     * Creates a new document with the same number and title than a given one.
     *
     * @param document The document
     */
    public Document(Document document) {
        number = document.number;
        title = document.title;
    }

    /* Accessor methods */
    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Tests if this document is equal to the given one.
     *
     * @param o The document to test with.
     * @return true if both documents are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Document)) {
            return false;
        }
        Document d = (Document) o;
        return number == d.number && title.equals(d.title);
    }

    @Override
    public int hashCode() {
        int hashcode = 17;
        hashcode = 31 * hashcode + number;
        hashcode = 31 * hashcode + title.hashCode();
        return hashcode;
    }

    /**
     * Returns the string representation of this document.
     * The string has the following format: "[XXXXXX]|title",
     * where XXXXXX is the number of the document. Each of the
     * capital letters represents a single decimal digit.
     * If the number of this document is too small to fill up
     * its field, the field is padded with leading zeros.
     */
    @Override
    public String toString() {
        return String.format("[%06d]|%s", number, title);
    }
}
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
 * A library that contains various types of documents (documents, books, etc.).
 */
public class Library {
    /**
     * The maximum number of documents in the library.
     */
    private final int _capacity;
    /**
     * The current number of documents in the library.
     */
    private int _nbDocuments;
    /**
     * The documents of the library.
     */
    private final Document[] _documents;

    /**
     * Creates a new library with a given capacity.
     *
     * @param capacity The capacity of the library.
     */
    public Library(int capacity) {
        _capacity = capacity;
        _nbDocuments = 0;
        _documents = new Document[capacity];
    }

    /**
     * Returns the capacity of the library.
     *
     * @return The capacity of the library.
     */
    public int getCapacity() {
        return _capacity;
    }

    /**
     * Returns the current number of documents in the library.
     *
     * @return The number of documents in the library.
     */
    public int getNbDocuments() {
        return _nbDocuments;
    }

    /**
     * Returns the document at the given index in the library.
     *
     * @param index The index of the document.
     * @return The document at the given index in the library.
     */
    public Document getDocument(int index) {
        return _documents[index];
    }

    /**
     * Adds a given document to the library.
     *
     * @param document The document to add.
     * @throws DocumentException Exception thrown when the capacity is exceeded.
     */
    public void addDocument(Document document) throws DocumentException {
        if (_nbDocuments < _capacity) {
            _documents[_nbDocuments] = document;
            _nbDocuments++;
        } else {
            throw new DocumentException("Unable to add a document in the library.");
        }
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder();

        for (Document aDocument : _documents) {
            content.append(aDocument);
            content.append("\n");
        }
        return content.toString();
    }

}
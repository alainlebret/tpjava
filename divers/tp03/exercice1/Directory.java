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
package tp03.exercice1;

import java.io.File;

/**
 * A class that lists and displays files of a directory.
 */
public class Directory {
    /**
     * Pathname of the directory.
     */
    private final String _directory;

    public Directory(String directory) {
        _directory = directory;
    }

    public String[] list() {
        File path = new File(_directory);
        String[] files = null;

        if (path.exists() && path.isDirectory()) {
            files = path.list();
        }
        return files;
    }

    public void display(String[] files) {
        if (files != null) {
            for (String aFile : files) {
                System.out.println(aFile);
            }
        }
    }

    @Override
    public String toString() {
        return "Directory{" +
                "_directory='" + _directory + '\'' +
                '}';
    }
}

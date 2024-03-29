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
package tp03.exercice4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileCopyAfterJava7 {

    private final String source;
    private final String destination;
    private boolean finished;

    public FileCopyAfterJava7(String in, String out) {
        source = in;
        destination = out;
        finished = false;
    }

    private void copyFileUsingJava7Files() throws IOException {
        File theSource = new File(this.source);
        File theDestination = new File(destination);
        Files.copy(theSource.toPath(), theDestination.toPath());
        finished = true;
    }

    public boolean isFinished() {
        return finished;
    }
}

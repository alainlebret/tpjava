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

import java.io.*;

public class FileCopy {

    private final String source;
    private final String destination;
    private int delay;
    private int numberOfBytesCopied;
    private boolean finished;

    public FileCopy(String source, String dest) {
        this.source = source;
        destination = dest;
        delay = 0;
        numberOfBytesCopied = 0;
        finished = false;
    }

    public void duplicateFile() throws IOException {
        InputStream is = new FileInputStream(source);
        OutputStream os = new FileOutputStream(destination);
        int aByte;

        while ((aByte = is.read()) != -1) {
            os.write(aByte);
            numberOfBytesCopied++;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        is.close();
        os.close();
        finished = true;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getNumberOfBytesCopied() {
        return numberOfBytesCopied;
    }

    public boolean isFinished() {
        return finished;
    }
}

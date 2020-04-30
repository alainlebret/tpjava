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

    private final String _source;
    private final String _dest;
    private int _delay;
    private int _numberOfBytesCopied;
    private boolean _finished;

    public FileCopy(String source, String dest) {
        _source = source;
        _dest = dest;
        _delay = 0;
        _numberOfBytesCopied = 0;
        _finished = false;
    }

    public void duplicateFile() throws IOException {
        InputStream is = new FileInputStream(_source);
        OutputStream os = new FileOutputStream(_dest);
        int aByte;

        while ((aByte = is.read()) != -1) {
            os.write(aByte);
            _numberOfBytesCopied++;
            try {
                Thread.sleep(_delay);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        is.close();
        os.close();
        _finished = true;
    }

    public void setDelay(int delay) {
        _delay = delay;
    }

    public int getNumberOfBytesCopied() {
        return _numberOfBytesCopied;
    }

    public boolean isFinished() {
        return _finished;
    }
}

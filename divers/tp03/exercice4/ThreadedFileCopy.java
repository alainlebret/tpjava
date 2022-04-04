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

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadedFileCopy extends Thread {
    static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    FileCopy fc;
    int numberOfBytesCopied;

    public ThreadedFileCopy(String name, FileCopy fc) {
        super(name);
        this.fc = fc;
        numberOfBytesCopied = 0;
    }

    public void displayNumberBytesCopied() {
        int copied = fc.getNumberOfBytesCopied();
        if (numberOfBytesCopied != copied) {
            System.out.println("" + copied + " bytes copied.");
            numberOfBytesCopied = copied;
        }
    }

    @Override
    public void run() {
        LOGGER.log(Level.INFO, "ThreadCopy - START " + Thread.currentThread().getName());
        while (!fc.isFinished()) {
            displayNumberBytesCopied();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        LOGGER.log(Level.INFO, "ThreadCopy - END " + Thread.currentThread().getName());
    }
}

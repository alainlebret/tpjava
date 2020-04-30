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
package tp03.exercice5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {
    final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private String _name;
    private RingBuffer _buffer;

    public Producer(String name, RingBuffer buffer) {
        _name = name;
        _buffer = buffer;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            int value = (int) (Math.random() * 100);
            LOGGER.log(Level.INFO, _name + " dépose " + value);
            _buffer.push(value);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


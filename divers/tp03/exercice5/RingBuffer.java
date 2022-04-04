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

/*
 * This is an old version.
 */
public class RingBuffer {
    private Object[] elements;
    private int nbElements;
    private int inputIndex;
    private int outputIndex;

    public RingBuffer(int capacity) {
        elements = new Object[capacity];
        nbElements = 0;
        inputIndex = 0;
        outputIndex = 0;
    }

    public boolean isEmpty() {
        return nbElements == 0;
    }

    public int size() {
        return nbElements;
    }

    public synchronized void push(Object element) {
        while (nbElements == elements.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        elements[inputIndex] = element;
        inputIndex = (inputIndex + 1) % elements.length;
        nbElements++;
        notifyAll();
    }

    public synchronized Object pop() {
        while (nbElements == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object element = elements[outputIndex];
        outputIndex = (outputIndex + 1) % elements.length;
        nbElements--;
        notifyAll();
        return element;
    }
}

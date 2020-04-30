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
    private Object[] _elements;
    private int _nbElements;
    private int _inputIndex;
    private int _outputIndex;

    public RingBuffer(int capacity) {
        _elements = new Object[capacity];
        _nbElements = 0;
        _inputIndex = 0;
        _outputIndex = 0;
    }

    public boolean isEmpty() {
        return _nbElements == 0;
    }

    public int size() {
        return _nbElements;
    }

    public synchronized void push(Object element) {
        while (_nbElements == _elements.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        _elements[_inputIndex] = element;
        _inputIndex = (_inputIndex + 1) % _elements.length;
        _nbElements++;
        notifyAll();
    }

    public synchronized Object pop() {
        while (_nbElements == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object element = _elements[_outputIndex];
        _outputIndex = (_outputIndex + 1) % _elements.length;
        _nbElements--;
        notifyAll();
        return element;
    }
}

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

public class Main {
    public static void main(String[] args) {
        RingBuffer tampon = new RingBuffer(10);
        Producer[] p = { new Producer("p1", tampon), new Producer("p2", tampon), new Producer("p3", tampon) };
        Consumer[] c = { new Consumer("c1", tampon), new Consumer("c2", tampon), new Consumer("c3", tampon) };
    }
}

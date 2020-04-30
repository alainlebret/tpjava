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
package tp01;

/**
 * A program that adds integers passed as arguments.
 */
public class Sum {
    public static void main(String[] args) {
        int sumOfIntegers = 0;

        for (String digits : args) {
            try {
                sumOfIntegers += Integer.parseInt(digits);
            } catch (NumberFormatException e) {
                String message = String.format("Attention, \"%s\" n'est pas un nombre entier !", digits);
                System.err.println(message);
                System.exit(-1);
            }
        }
        System.out.println("Sum = " + sumOfIntegers);
    }
}

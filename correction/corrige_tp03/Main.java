/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2018 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 14000 Caen, France
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package corrige_tp03;

import java.util.Scanner;

/**
 * A basic calculator program that memorized the <em>n</em>-last operations
 * in a circular buffer.
 *
 * @author Alain Lebret
 * @version 1.3
 */
public class Main {
    public static void main(String[] argument) {
        Calculator calculator;
        Scanner scanner;
        String calculAFaire;
        StringBuilder header;

        calculator = new Calculator(5);
        scanner = new Scanner(System.in);
        header = new StringBuilder();

        header.append("\nCalculator - version 1.2\n");
        header.append("------------------------\n");
        header.append("Entrer une opération sous la forme : operande1 <operateur> operande2 (fin pour quitter)\n");
        header.append(">> ");

        while (true) {
            System.out.print(header);
            calculAFaire = scanner.nextLine();
            if (calculAFaire.equals("fin")) {
                System.exit(0);
            }
            calculator.solve(calculAFaire);
            System.out.println(calculator.toString());
        }
    }
}

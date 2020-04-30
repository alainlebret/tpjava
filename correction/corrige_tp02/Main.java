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
package corrige_tp02;

import java.util.Scanner;

/**
 * A basic calculator program. It analyzes a string that represents a simple
 * binary operation using the format:<br>
 * {@code operand1 operator operand2}<br>
 * , and where {@code operator} takes its value in { {@code '+'}, {@code '-'},
 * {@code '*'}, {@code '/'} }. The number of whitespaces around the operator
 * has no incidence on the calculation. The string "fin" (it means "end" in
 * french) allows to exit from the calculator.
 *
 * @author Alain Lebret
 * @version 1.2
 */
public class Main {

    public static void main(String[] argument) {
        Calculator calculator;
        Scanner scanner;
        String operation;
        StringBuilder header;

        calculator = new Calculator();
        scanner = new Scanner(System.in);
        header = new StringBuilder();

        header.append("\nCalculator - version 1.1\n");
        header.append("------------------------\n");
        header.append("Entrer une opération sous la forme :");
        header.append(" operande1 <operateur> operande2");
        header.append(" (fin pour quitter)\n");
        header.append(">> ");

        while (true) {
            System.out.print(header);
            operation = scanner.nextLine();
            if (operation.equals("fin")) {
                System.exit(0);
            }
            calculator.solve(operation);
            System.out.println(calculator);
        }
    }
}

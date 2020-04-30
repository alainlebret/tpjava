/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2018 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 4000 Caen, France
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
package corrige_tp01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A basic calculator class. It analyzes a string that represents a simple
 * binary operation using the format:<br>
 * {@code operand1 operator operand2}<br>
 * , and where {@code operator} takes its value in { {@code '+'}, {@code '-'},
 * {@code '*'}, {@code '/'} }.
 * <p>
 * The number of whitespaces around the operator has no incidence.
 * <p>
 * Here are some examples of operations strings that are accepted by the
 * calculator: "1+2", "2   - 3", "3.3*4.4", "4.4 / 5.5", "-1.1 * -2.2",
 * "2.2e-2-3.3e-3", "3.3e+2*4.4e+2", "-4.44e-10/5.55e-10 "
 *
 * @author Alain Lebret
 * @version 1.1  (Nov. 2000)
 */
public class Calculator {
    /**
     * 1st operand of the calculator.
     */
    private double operand1_;

    /**
     * 2nd operand of the calculator.
     */
    private double operand2_;

    /**
     * The operator used by the calculator ('+', '-', '*' et '/').
     */
    private char operator_;

    /**
     * The result of the calculation.
     */
    private double result_;

    /**
     * Creates a new calculator. Both operands as the result are set to 0.
     * The default operator is addition ('+').
     */
    public Calculator() {
        operand1_ = operand2_ = result_ = 0.0;
        operator_ = '+';
    }

    /**
     * Splits the operation string using a regex. Operands have to respect the
     * regex: "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?"
     *
     * @param operation A string that represents the operation to solve.
     * @see Pattern
     * @see Matcher
     */
    public void split(String operation) {
        // See: https://www.freeformatter.com/java-regex-tester.html#ad-output
        String operandPattern = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
        String operatorPattern = "[+*/-]";

        operation.replaceAll(" ", "");
        Pattern pattern = Pattern.compile(operandPattern);
        Matcher matcher = pattern.matcher(operation);

        if (!matcher.find()) {
            return;
        }

        String firstOperand = matcher.group().trim();
        operand1_ = Double.parseDouble(firstOperand);

        String operatorAndSecondOperand = operation.substring(firstOperand.length());
        operator_ = operatorAndSecondOperand.trim().charAt(0);

        String secondOperand = operatorAndSecondOperand.replaceFirst(operatorPattern, "");
        operand2_ = Double.parseDouble(secondOperand);
    }

    /**
     * Solves the given operation and updates the result_ attribute.
     *
     * @param operation A string that represents the operation to solve.
     */
    public void solve(String operation) {

        split(operation);

        switch (operator_) {
            case '+':
                result_ = operand1_ + operand2_;
                break;
            case '-':
                result_ = operand1_ - operand2_;
                break;
            case '/':
                result_ = operand1_ / operand2_;
                break;
            case '*':
                result_ = operand1_ * operand2_;
                break;
            default:
                result_ = Double.NaN;
        }
    }

    /**
     * Returns the current result.
     *
     * @return The result.
     */
    public double getResult() {
        return result_;
    }

    /**
     * Returns a string that represents the operation and its result. It
     * respects the following format: <br>
     * {@code operand1 operator operand2 = result}
     *
     * @return A string that represents the operation and its result.
     */
    @Override
    public String toString() {
        return String.format("\n%s %s %s =  %s\n", operand1_, operator_, operand2_, result_);
    }
}

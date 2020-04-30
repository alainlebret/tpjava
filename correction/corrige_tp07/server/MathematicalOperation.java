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
package corrige_tp07.server;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class to manipulate binary mathematical operations that respect the
 * format:<br>
 * {@code operand1 operator operand2}
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class MathematicalOperation extends Operation {
    /**
     * The result of the mathematical operation.
     */
    private double result_;

    /**
     * Creates a new mathematical operation object. The operation string is
     * set to the empty string and the result value is set to 0.
     */
    public MathematicalOperation() {
        super();
        result_ = 0.0;
    }

    /**
     * Solves the given operation defined using the format:
     * {@code operand1 <operation> operand2}.
     * The format using exponent is allowed here!
     *
     * @param operation A string that represents the operation to solve.
     * @see java.util.Scanner
     * @see Pattern
     * @see Matcher
     * @see Double
     */
    public void solve(String operation) throws OperationException {
        if ((operation == null) || "".equals(operation)) {
            return;
        }

        // See: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
        String operandPattern = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
        String operatorPattern = "[+*/-]";

        setOperation(operation.replaceAll(" ", ""));
        Pattern pattern = Pattern.compile(operandPattern);
        Matcher matcher = pattern.matcher(getOperation());

        if (!matcher.find()) {
            reset();
            return;
        }

        String firstOperand = matcher.group().trim();
        double operand1 = Double.parseDouble(firstOperand);

        String operatorAndSecondOperand = operation.substring(firstOperand.length());
        char operator = operatorAndSecondOperand.trim().charAt(0);

        String secondOperand = operatorAndSecondOperand.replaceFirst(operatorPattern, "");
        double operand2 = Double.parseDouble(secondOperand);

        switch (operator) {
            case '+':
                result_ = operand1 + operand2;
                break;
            case '-':
                result_ = operand1 - operand2;
                break;
            case '/':
                result_ = operand1 / operand2;
                break;
            case '*':
                result_ = operand1 * operand2;
                break;
            default:
                result_ = Double.NaN;
                throw new OperationException("Opérateur non reconnu");
        }
    }

    /**
     * Resets the operation and result.
     */
    public void reset() {
        setOperation("");
        result_ = 0;

    }

    /**
     * Returns a string that represents the operation and its result. It
     * respects the format: <br>
     * {@code operand1 operator operand2 = result}
     *
     * @return String that represents the operation.
     */
    @Override
    public String toString() {
        if (getOperation().equals("")) {
            return "Opération invalide";
        }
        return String.format("%s = %s", getOperation(), result_);
    }
}

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

/**
 * A basic calculator class. It analyzes a string that represents a simple
 * binary operation using the format:<br>
 * {@code operand1 operator operand2}<br>
 * , and where {@code operator} takes its value in { {@code '+'}, {@code '-'},
 * {@code '*'}, {@code '/'} }.
 * <p>
 * The number of whitespaces around the operator has no incidence.
 *
 * @author Alain Lebret
 * @version 1.2
 */
public class Calculator {
    /**
     * The current mathematical operation used by the calculator.
     */
    private MathematicalOperation operation_;

    /**
     * Creates a new calculator with a default mathematical operation (an
     * empty string).
     */
    public Calculator() {
        operation_ = new MathematicalOperation();
    }

    /**
     * Solves the given operation defined using the format:
     * * {@code operand1 <operation> operand2}.
     *
     * @param operation A string that represents the operation to solve.
     */
    public void solve(String operation) {
        try {
            operation_.solve(operation);
        } catch (OperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a string that represents the operation and its result. It
     * respects the following format: <br>
     * {@code operand1 operator operand2 = result}
     *
     * @return A string that represents the operation solved by the calculator.
     */
    @Override
    public String toString() {
        return String.format("\n%s\n", operation_);
    }
}

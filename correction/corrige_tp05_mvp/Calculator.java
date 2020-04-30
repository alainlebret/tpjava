/*
 * SVEN is an open source Java library for machine learning, image analysis
 * and computer vision educational projects.
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
package corrige_tp05_mvp;

/**
 * A basic calculator that memorizes the <em>n</em>-last operations in a
 * circular buffer.
 *
 * @author Alain Lebret
 * @version 1.3
 */
public class Calculator {
    /**
     * The circular buffer that stores operations.
     */
    private MathematicalOperation[] operations_;

    /**
     * The index of the current operation.
     */
    private int index_;

    /**
     * Creates a calculator object with a given buffer size.
     *
     * @param memorySize The maximum size of circular buffer.
     */
    public Calculator(int memorySize) {
        operations_ = new MathematicalOperation[memorySize];
        index_ = 0;
    }

    /**
     * Solves the given operation defined using the format:
     * {@code operand1 <operation> operand2}
     * , and then stores it in the circular buffer of the calculator.
     *
     * @param operation A string that represents the operation to solve.
     */
    public void solve(String operation) {
        if (index_ % operations_.length == 0) {
            index_ = 0;
        }
        operations_[index_] = new MathematicalOperation();
        try {
            operations_[index_].solve(operation);
        } catch (OperationException e) {
            e.printStackTrace();
        }
        index_++;
    }

    /**
     * Returns a string that represents the operations and their results.
     * Empty memory elements appear as "Undefined".
     *
     * @return A string that represents operations managed by the calculator.
     */
    @Override
    public String toString() {
        StringBuilder listOfOperations = new StringBuilder();

        for (MathematicalOperation operation : operations_) {
            if (operation != null) {
                listOfOperations.append(operation).append("\n");
            } else {
                listOfOperations.append("Undefined\n");
            }
        }

        return listOfOperations.toString();
    }
}

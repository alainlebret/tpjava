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
 * A class that represents an "operation" which is defined as a string.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class Operation {
    /**
     * The string that represents the operation. It does not allow null values.
     */
    private String operation_;

    /**
     * Creates a new operation object. The default string associated to this
     * operation is the empty one.
     */
    public Operation() {
        operation_ = "";
    }

    /**
     * Gets the corresponding operation string.
     *
     * @return The string that represents the operation.
     */
    public String getOperation() {
        return operation_;
    }

    /**
     * Sets the string that corresponds to the operation.
     *
     * @param operation The string that will represent the operation.
     */
    public void setOperation(String operation) {
        operation_ = operation;
    }
}

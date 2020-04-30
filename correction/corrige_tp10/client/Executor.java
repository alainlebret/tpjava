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
package corrige_tp10.client;

/**
 * A class to run an external process.
 *
 * @author Alain Lebret
 * @version 1.0
 */
public class Executor {

    /**
     * The external process to execute.
     */
    private Process process_;

    /**
     * Executes the external process.
     *
     * @param command The command to execute.
     * @see java.lang.Process
     * @see java.lang.Runtime
     */
    public void execute(String command) {
        try {
            Runtime r = Runtime.getRuntime();
            process_ = r.exec(command);
        } catch (java.io.IOException e) {
            System.err.println("Erreur en E/S : " + e);
        } catch (java.lang.SecurityException e) {
            System.err.println("Atteinte à la sécurité : " + e);
        }
    }

    /**
     * Stops the external process.
     */
    public void terminate() {
        process_.destroy();
    }
}

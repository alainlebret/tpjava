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
package corrige_tp08.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;

/**
 * The Service class opens input and output streams and on the client's socket.
 * It receives the operation to solve and sends it to the calculator. Once the
 * calculation is done, the result is returned by the socket.
 *
 * @author Alain Lebret
 * @version 1.0
 */
class Service {
    /**
     * The communication socket.
     */
    private Socket socket_;

    /**
     * The input stream to get results from the calculator.
     */
    private ObjectInputStream input_ = null;

    /**
     * The output stream to send the request to the calculator.
     */
    private ObjectOutputStream output_ = null;

    /**
     * The associated calculator.
     */
    private BackupCalculator calculator_;

    /**
     * Creates a new service from the given communication socket passed by
     * the server.
     *
     * @param socket The communication socket.
     */
    Service(Socket socket) {
        socket_ = socket;
        calculator_ = new BackupCalculator(5);

        // Establishes the connection with the client using the communication
        // socket
        try {
            input_ = new ObjectInputStream(socket_.getInputStream());
            output_ = new ObjectOutputStream(socket_.getOutputStream());
        } catch (IOException exc) {
            TcpServer.LOGGER.log(Level.WARNING, "TcpServer:provideService() - Problème de connexion");
            try {
                socket_.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides the service.
     *
     * @return True if the request was valid, false if not or if "fin" has
     * been received.
     */
    public boolean provide() {
        try {
            TcpServer.LOGGER.log(Level.INFO, "Service - La calculette attend un calcul");
            String operation = (String) input_.readObject();

            if (operation.equals("fin")) {
                return false;
            }

            TcpServer.LOGGER.log(Level.INFO, "Service - Le calcul à effectuer est : " + operation);
            calculator_.solve(operation);
            TcpServer.LOGGER.log(Level.INFO, "Service - Calcul effectué");
            calculator_.save();
            TcpServer.LOGGER.log(Level.INFO, "Service - Sauvegarde effectuée sur le serveur");
            operation = calculator_.toString();
            output_.writeObject(operation);
            TcpServer.LOGGER.log(Level.INFO, "Service - Résultat transmis au client");
            output_.flush();
        } catch (IOException exc) {
            TcpServer.LOGGER.log(Level.WARNING, "Service:provide() - Le service n'a pu être rendu");
            return false;
        } catch (ClassNotFoundException e) {
            TcpServer.LOGGER.log(Level.WARNING, "ClientTCP:requeter() - Opération non reconnue.");
        }
        return true;
    }

    /**
     * Terminates the service and closes the socket and both streams.
     */
    public void terminate() {
        try {
            socket_.close();
            input_.close();
            output_.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TcpServer.LOGGER.log(Level.INFO, "Service terminé");
    }
}

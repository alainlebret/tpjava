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
package corrige_tp09.server;

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
 * @version 1.1
 */
class Service extends Thread {
    /**
     * The flag to indicate the end of the service.
     */
    private boolean serviceIsFinished_;

    /**
     * The number of the service.
     */
    protected int number_;

    /**
     * The associated server.
     */
    TcpServer server_;

    /**
     * The communication socket.
     */
    Socket socket_;

    /**
     * The input stream to get requests.
     */
    ObjectInputStream input_ = null;

    /**
     * The output stream to send results.
     */
    ObjectOutputStream output_ = null;

    /**
     * The calculator.
     */
    BackupCalculator calculator_;

    /**
     * Creates a new service associated to the given server and with the given
     * number. The communication will use the given socket.
     *
     * @param server The TCP server.
     * @param socket The communication socket.
     * @param number The number to give to the service.
     */
    Service(TcpServer server, Socket socket, int number) {
        server_ = server;
        socket_ = socket;
        number_ = number;
        calculator_ = new BackupCalculator(5);

        try {
            input_ = new ObjectInputStream(socket_.getInputStream());
            output_ = new ObjectOutputStream(socket_.getOutputStream());
        } catch (IOException exc) {
            TcpServer.LOGGER.log(Level.SEVERE, "Service:constructeur() - Ouverture des flots de communication impossible");
            try {
                socket_.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Provides the service to a client.
     */
    private void provideService() {
        TcpServer.LOGGER.log(Level.INFO, "Service - La calculette attend un calcul");
        try {
            String operation = (String) input_.readObject();
            if (operation.equals("fin")) {
                serviceIsFinished_ = true;
            }

            TcpServer.LOGGER.log(Level.INFO, "Service - Le calcul a effectuer est : " + operation);
            calculator_.solve(operation);
            TcpServer.LOGGER.log(Level.INFO, "Service - Calcul effectué");
            calculator_.save("ressources/calculette" + number_ + ".txt");
            TcpServer.LOGGER.log(Level.INFO, "Service - Sauvegarde effectuée sur le serveur");
            operation = calculator_.toString();
            output_.writeObject(operation);
            TcpServer.LOGGER.log(Level.INFO, "Service - Résultat transmis au client");
            output_.flush();
        } catch (IOException exc) {
            TcpServer.LOGGER.log(Level.WARNING, "Service:provide() - Le service n'a pu être rendu");
            serviceIsFinished_ = true;
        } catch (ClassNotFoundException e) {
            TcpServer.LOGGER.log(Level.WARNING, "ClientTCP:requeter() - Opération non reconnue");
        }
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
        TcpServer.LOGGER.log(Level.INFO, "Service - Fin");
    }

    @Override
    public void run() {
        while (!serviceIsFinished_) {
            this.provideService();
        }
        this.terminate();
    }

}
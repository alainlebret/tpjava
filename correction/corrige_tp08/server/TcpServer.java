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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A single-client TCP server.
 *
 * @author Alain Lebret
 * @version 1.0
 */
class TcpServer {

    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * The control socket waiting for connections on the port.
     */
    private ServerSocket receptionist_ = null;

    /**
     * The communication socket between a client the server.
     */
    private Socket socket_ = null;

    /**
     * The service proposed by this server.
     */
    private Service calculatorService_ = null;

    /**
     * Creates a new TCP server using the given port. The server activates the
     * control socket.
     *
     * @param port A communication port on which to connect.
     */
    public TcpServer(int port) {
        // Creation of the control socket
        LOGGER.log(Level.INFO, "TcpServer - Démarrage du serveur");
        try {
            receptionist_ = new ServerSocket(port);
            LOGGER.log(Level.INFO, "TcpServer - Socket de contrôle activée");
        } catch (IOException exc) {
            LOGGER.log(Level.SEVERE, "TcpServer - Impossible de démarrer le serveur");
        }
        LOGGER.log(Level.INFO, "TcpServer - Serveur à l'écoute sur le port n°" + port);

    }

    /**
     * Waits for a client to connect and provides the service.
     */
    public void provideService() {
        try {
            listen();
            serve();
        } catch (IOException exc) {
            LOGGER.log(Level.WARNING, "TcpServer:provideService() - Problème de connexion");
        }
    }

    private void serve() {
        calculatorService_ = new Service(socket_);
        while (true) {
            if (!calculatorService_.provide()) break;
        }
        LOGGER.log(Level.INFO, "TcpServer - Service rendu");
        calculatorService_.terminate();
    }

    private void listen() throws IOException {
        System.out.println("TcpServer - Attente d'un client...");
        LOGGER.log(Level.INFO, "TcpServer - Attente d'un client...");
        socket_ = receptionist_.accept();
        LOGGER.log(Level.INFO, "TcpServer - Client connecté");
    }
}

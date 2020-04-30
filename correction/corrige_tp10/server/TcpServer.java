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
package corrige_tp10.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A multi-clients TCP server.
 *
 * @author Alain Lebret
 * @version 1.1
 */
class TcpServer {

    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    /**
     * The communication port used by the server.
     */
    int port_;

    /**
     * The control socket that listens to clients on the port.
     */
    ServerSocket receptionist_ = null;

    /**
     * The <em>n</em> services proposed to the <em>n</em> clients to solve
     * their operations.
     */
    Service[] services_;

    /**
     * The current service number.
     */
    int currentService_;

    /**
     * Creates a new TCP server using the given port and able to manage up to
     * {@code nbClients}.
     *
     * @param port       The communication port.
     * @param maxClients The max number of clients that can be accepted.
     */
    public TcpServer(int port, int maxClients) {
        port_ = port;
        services_ = new Service[maxClients];
        currentService_ = 0;

        // Creation of the control socket
        LOGGER.log(Level.INFO, "TcpServer - Démarrage du serveur");
        try {
            receptionist_ = new ServerSocket(port_);
            LOGGER.log(Level.INFO, "TcpServer - Socket de contrôle activée");
        } catch (IOException exc) {
            LOGGER.log(Level.SEVERE, "TcpServer - Impossible de démarrer le serveur");
        }
        LOGGER.log(Level.INFO, "TcpServer - Serveur à l'écoute");
    }

    /**
     * Listens for a client and provide service.
     */
    public void listen() {
        LOGGER.log(Level.INFO, "TcpServer - Attente d'un client...");
        try {
            services_[currentService_] = new Service(this, receptionist_.accept(), currentService_);
            LOGGER.log(Level.INFO, "TcpServer - Client connecté");
            services_[currentService_].start();
            LOGGER.log(Level.INFO, "TcpServer - Service démarré");
            currentService_++;
            LOGGER.log(Level.INFO, "TcpServer - Service rendu");
        } catch (IOException exc) {
            LOGGER.log(Level.WARNING, "TcpServer:provideService() - problème de connexion");
        }
    }

    /**
     * Returns the number of the current service.
     *
     * @return The current service number.
     */
    public int getCurrentService() {
        return currentService_;
    }

}

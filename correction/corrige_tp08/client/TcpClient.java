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
package corrige_tp08.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * A TCP client.
 *
 * @author Alain Lebret
 * @version 1.0
 */
class TcpClient {
    /**
     * The port of the TCP connection.
     */
    private int port_;

    /**
     * The communication socket.
     */
    private Socket socket_ = null;

    /**
     * The output stream to send requests.
     */
    private ObjectOutputStream output_ = null;

    /**
     * The input stream to get results of the requests.
     */
    private ObjectInputStream input_ = null;


    /**
     * Creates a new TCP client using a given port.
     *
     * @param port The port on which communicate.
     */
    public TcpClient(int port) {
        port_ = port;
    }

    /**
     * Connects to the distant TCP server. The communication streams and the
     * communication socket are created.
     *
     * @param hostname The name of the distant server.
     */
    public void connect(String hostname) throws IOException {
        System.out.println("TcpClient - Établissement du canal de communication");
        socket_ = new Socket(hostname, port_);
        output_ = new ObjectOutputStream(socket_.getOutputStream());
        input_ = new ObjectInputStream(socket_.getInputStream());
        System.out.println("TcpClient - Connecté au serveur");
    }

    /**
     * Sends the request to the server and gets the answer.
     *
     * @param request The request to send to the server.
     * @return The answer of the server.
     */
    public String send(String request) {
        String answer = null;

        try {
            System.out.println("TcpClient - Envoi de la requête : " + request);
            output_.writeObject(request);
            System.out.println("TcpClient - Requête envoyée");
            output_.flush();
            answer = (String) input_.readObject();
            System.out.println("TcpClient - Réponse reçue du serveur : " + answer);
        } catch (IOException e) {
            System.err.println("TcpClient:requeter() - Connexion au serveur impossible.");
        } catch (ClassNotFoundException e) {
            System.err.println("TcpClient:requeter() - Objet inconnu.");
        }

        return answer;
    }

    /**
     * Disconnects from the server. Both streams are closed as the socket.
     */
    public void disconnect() {
        try {
            System.out.println("TcpClient - Déconnexion...");
            input_.close();
            output_.close();
            socket_.close();
        } catch (IOException e) {
            System.err.println("TcpClient:disconnect() - Connexion au serveur impossible.");
        }
    }
}

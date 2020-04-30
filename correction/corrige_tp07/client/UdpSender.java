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
package corrige_tp07.client;

import java.io.IOException;
import java.net.*;

/**
 * A class to send UDP datagrams. The datagram must end with an {@code \@}
 * character.
 * <p>
 * The {@code UdpSender} uses the following classes:
 * <ul>
 * <li>{@code InetAddress}: an IP address.</li>
 * <li>{@code DatagramPacket}: a data packet send/received on a network.</li>
 * <li>{@code DatagramSocket}: a network connection to send/receive a data packet ({@code DatagramPacket}).</li>
 * <li>{@code SocketException}: an exception occurred when using a network connection.</li>
 * <li>{@code UnknownHostException}: an exception occurred when an IP address is unsolved.</li>
 * <li>{@code IOException}: an exception occurred by any I/O error.</li>
 * </ul>
 *
 * @author Alain Lebret
 * @version 1.0
 */
class UdpSender {
    /**
     * The port used to send datagrams.
     */
    private int port_;

    /**
     * Creates a new UDP sender with a given port.
     *
     * @param port The port on which to send datagrams.
     */
    public UdpSender(int port) {
        port_ = port;
    }

    /**
     * Sends the given string message to a destination host.
     *
     * @param hostname Name of the destination host.
     * @param message  The string to send.
     */
    public void send(String hostname, String message) {
        String s = message + "@"; // The string to send has an "ending" character
        int length = s.length();
        byte[] bytes; // The byte array that will be inserted in the packet

        InetAddress address = null; // Address of the destination host
        DatagramSocket socket; // Communication socket


        try {
            // Search for the destination hostname
            address = InetAddress.getByName(hostname);
        } catch (UnknownHostException exc) {
            System.err.println("UdpSender:send() - Destinataire inconnu");
        }

        bytes = s.getBytes(); // Creates the packet to send

        try {
            DatagramPacket envoi = new DatagramPacket(bytes, length, address, port_);

            socket = new DatagramSocket(); // Opens the communication socket to send to
            socket.send(envoi); // Sends the packet
            socket.close(); // Closes the communication socket
        } catch (SocketException e) {
            System.err.println("UdpSender:send() - Erreur lors de la création de la socket");
        } catch (IOException e) {
            System.err.println("UdpSender:send() - Erreur lors de l'envoi sur la socket");
        }
    }
}

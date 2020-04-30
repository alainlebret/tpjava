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
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.StringTokenizer;

/**
 * A class to receive UDP datagrams. The received datagram must end with an
 * {@code \@} character. The {@code UdpSender} uses the following classes:
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
class UdpReceiver {
    /**
     * The port used to send datagrams.
     */
    private int port_;

    /**
     * Creates a new UDP receiver with a given port.
     *
     * @param port The port on which to receive datagrams.
     */
    public UdpReceiver(int port) {
        port_ = port;
    }

    /**
     * Receives a packet on the port.
     *
     * @return The received packet
     */
    public String receive() {
        byte[] bytes = new byte[1000]; // The byte array used to store the packet
        String message; // The received message
        DatagramSocket socket; // The communication socket
        DatagramPacket reception; // The received datagram packet

        /*
         * Receives the packet.
         */
        try {
            socket = new DatagramSocket(port_); // Opens the socket
            reception = new DatagramPacket(bytes, bytes.length); // Creates a packet to receive the message
            socket.receive(reception); // Waits for a packet
            socket.close(); // Closes the socket
        } catch (SocketException e) {
            System.err.println("UdpReceiver:receive() - Erreur lors de la création de la socket");
        } catch (IOException e) {
            System.err.println("UdpReceiver:receive() - Erreur lors de la réception sur la socket");
        }

        /*
         * Extracts the ending character.
         */
        String trame = new String(bytes);
        StringTokenizer t = new StringTokenizer(trame, "@");
        message = t.nextToken();

        return message;
    }
}

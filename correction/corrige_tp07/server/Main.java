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
package corrige_tp07.server;

/**
 * The distant calculator using the UDP protocol.
 *
 * @author Alain Lebret
 * @version 1.3
 */
public class Main {
    public static void main(String[] argument) {
        BackupCalculator calculator = new BackupCalculator(5);
        UdpSender sender = new UdpSender(4001);
        UdpReceiver receiver = new UdpReceiver(4000);

        while (true) {
            System.out.println("Serveur UDP - Attente d'un calcul");
            String packet = receiver.receive();
            if (packet.equals("fin")) {
                System.exit(0);
            }
            System.out.println("Le calcul recu est : \n" + packet);
            calculator.solve(packet);
            calculator.save();
            packet = calculator.toString();
            System.out.println("Le resultat envoyé est : \n" + packet);
            sender.send("127.0.0.1", packet);
        }
    }
}

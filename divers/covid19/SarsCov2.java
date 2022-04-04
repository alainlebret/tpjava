/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2020 Alain Lebret (alain.lebret@ensicaen.fr)
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
package covid19;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SarsCov2 {
    private String genome;

    public SarsCov2(String filename) {
        try {
            genome = readFile(filename, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filename, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(filename));
        return new String(encoded, encoding).replaceAll("([\\r\\n\\t])", "");
    }

    @Override
    public String toString() {
        return "SarsCov2{" +
                "_genome='" + genome + '\'' +
                '}';
    }

    public static void main(String[] args) {
        SarsCov2 virus = new SarsCov2("divers/covid19/ressources/SARS-CoV-2.txt");
        System.out.println(virus);
    }
}

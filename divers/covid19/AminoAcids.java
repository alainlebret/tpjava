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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AminoAcids {
    private List<AminoAcid> aminoAcids;

    public AminoAcids() {
        aminoAcids = new ArrayList<>();
    }

    public void read(String filename) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        Scanner dataScanner;
        int index = 0;

        while (scanner.hasNextLine()) {
            dataScanner = new Scanner(scanner.nextLine());
            dataScanner.useDelimiter(";");
            AminoAcid aa = new AminoAcid();

            while (dataScanner.hasNext()) {
                String data = dataScanner.next();
                if (index == 0) {
                    aa.setSymbole(data);
                } else if (index == 1) {
                    aa.setCode(data);
                } else if (index == 2) {
                    aa.setName(data);
                } else if (index == 3) {
                    aa.setCodons(data);
                } else if (index == 4) {
                    aa.setIub(data);
                } else {
                    System.out.println("invalid data::" + data);
                }
                index++;
            }
            index = 0;
            aminoAcids.add(aa);
        }

        scanner.close();
    }

    public void display() {
        for (AminoAcid aa : aminoAcids) {
            System.out.println(aa);
        }
    }

    public static void main(String[] args) {
        AminoAcids r = new AminoAcids();
        r.read("divers/covid19/ressources/amino-acids.csv");
        r.display();
    }

}


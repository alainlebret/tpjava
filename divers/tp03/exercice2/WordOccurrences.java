/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2020 Alain Lebret (alain.lebret@ensicaen.fr)
 * ENSICAEN
 * 6 Bd Maréchal Juin
 * 14000 Caen, France
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 *  or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package tp03.exercice2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordOccurrences {
    private HashMap<String, Integer> _wordsAndOccurrences;

    public WordOccurrences() {
        _wordsAndOccurrences = new HashMap<>();
    }

    public void read(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String[] words;
        int occurrences;

        while ((line = br.readLine()) != null) {
            words = line.split("[ ,.;:_\\-+*/\\n\"'{}()=><\\t!?]");
            for (String aWord : words) {
                occurrences = 1;
                if (_wordsAndOccurrences.containsKey(aWord)) {
                    occurrences = _wordsAndOccurrences.get(aWord) + 1;
                }
                _wordsAndOccurrences.put(aWord, occurrences);
            }
        }
        br.close();
    }

    public HashMap<String, Integer> getWordsAndOccurrences() {
        return _wordsAndOccurrences;
    }

    public void display() {
        for (Map.Entry<String, Integer> aWordAndItsOccurrences : _wordsAndOccurrences.entrySet()) {
            if (!aWordAndItsOccurrences.getKey().equals("")) {
                String message = String.format("Le mot \"%s\" figure %d fois.", aWordAndItsOccurrences.getKey(), aWordAndItsOccurrences.getValue());
                System.out.println(message);
            }
        }
    }
}

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
package tp02.exo3;

public class SortableInteger implements Sortable, Comparable<SortableInteger> {
    private final Integer value;

    public SortableInteger(String valeur) {
        value = Integer.valueOf(valeur);
    }

    @Override
    public boolean egal(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SortableInteger anInteger)) {
            return false;
        }
        return value.equals(anInteger.value);
    }

    @Override
    public int compareTo(SortableInteger o) {
        return value.compareTo(o.value);
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return value.toString();
    }
}

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
package tp03.exercice3;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A class that demonstrates the using of a FilterOutputStream.
 */
public class VigenereFilterOutputStream extends FilterOutputStream {

    /**
     * Creates a new filter output stream from a given output stream.
     *
     * @param out The output stream to filter.
     */
    public VigenereFilterOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        out.write(encode(b));
    }

    /**
     * Encodes the given ASCII code of a character using the Caesar cipher. {@code character}
     * must be in the range [65, 97].
     *
     * @param character The given ASCII code of an alphabet character.
     * @return The ASCII code of the encoded character.
     */
    public int encode(int character) {
        int alpha;
        int encoded;

        if (character >= 65 && character <= 90) {
            alpha = 65;
            encoded = (character - alpha + 13) % 26 + alpha;
        } else if (character >= 97 && character <= 122) {
            alpha = 97;
            encoded = (character - alpha + 13) % 26 + alpha;
        } else {
            encoded = character;
        }
        return encoded;
    }


}
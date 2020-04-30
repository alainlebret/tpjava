/*
 * Java programming laboratory work.
 *
 * Copyright (C) 2002-2018 Alain Lebret (alain.lebret@ensicaen.fr)
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
package shm;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMapWriter {

    public static void main(String[] args) throws IOException, InterruptedException {
        File f = new File("./mapped");
        f.delete();

        FileChannel fc = new RandomAccessFile(f, "rw").getChannel();

        long bufferSize = 8 * 1000;
        MappedByteBuffer mem = fc.map(FileChannel.MapMode.READ_WRITE, 0, bufferSize);

        int start = 0;
        long counter = 1;
        long HUNDREDK = 100000;
        long startT = System.currentTimeMillis();
        long noOfMessage = HUNDREDK * 10 * 10;

        while (counter <= noOfMessage) {
            if (!mem.hasRemaining()) {
                start += mem.position();
                mem = fc.map(FileChannel.MapMode.READ_WRITE, start, bufferSize);
            }
            mem.putLong(counter);
            counter++;
        }
        long endT = System.currentTimeMillis();
        long tot = endT - startT;
        System.out.println(String.format("No Of Message %s , Time(ms) %s ", noOfMessage, tot));
    }

}
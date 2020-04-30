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

public class MemoryMapReader {

    public static void main(String[] args) throws IOException {
        FileChannel fc = new RandomAccessFile(new File("./mapped"), "rw").getChannel();
        long bufferSize = 8 * 1000;
        MappedByteBuffer mem = fc.map(FileChannel.MapMode.READ_ONLY, 0, bufferSize);
        long oldSize = fc.size();

        long currentPos = 0;
        long xx = currentPos;


        long startTime = System.currentTimeMillis();
        long lastValue = -1;

        for (; ; ) {

            while (mem.hasRemaining()) {
                lastValue = mem.getLong();
                currentPos += 8;
            }
            if (currentPos < oldSize) {

                xx = xx + mem.position();
                mem = fc.map(FileChannel.MapMode.READ_ONLY, xx, bufferSize);
            } else {
                long end = System.currentTimeMillis();
                long tot = end - startTime;
                System.out.println(String.format("Last Value Read %s , Time(ms) %s ", lastValue, tot));
                System.out.println("Waiting for message");
                while (true) {
                    long newSize = fc.size();
                    if (newSize > oldSize) {
                        oldSize = newSize;
                        xx = xx + mem.position();
                        mem = fc.map(FileChannel.MapMode.READ_ONLY, xx, oldSize - xx);
                        System.out.println("Got some data");
                        break;
                    }
                }
            }


        }

    }

}

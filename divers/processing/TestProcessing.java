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
package processing;

/*
import processing.core.PApplet;

public class TestProcessing extends PApplet {
    int num = 2000;
    int range = 6;

    float[] ax = new float[num];
    float[] ay = new float[num];

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        size(640, 360);
        for (int i = 0; i < num; i++) {
            ax[i] = width / 2;
            ay[i] = height / 2;
        }
        frameRate(30);
    }

    public void draw() {
        background(51);

        // Shift all elements 1 place to the left
        for (int i = 1; i < num; i++) {
            ax[i - 1] = ax[i];
            ay[i - 1] = ay[i];
        }

        // Put a new value at the end of the array
        ax[num - 1] += random(-range, range);
        ay[num - 1] += random(-range, range);

        // Constrain all points to the screen
        ax[num - 1] = constrain(ax[num - 1], 0, width);
        ay[num - 1] = constrain(ay[num - 1], 0, height);

        // Draw a line connecting the points
        for (int i = 1; i < num; i++) {
            float val = (float)(i / num * 204.0 + 51);
            stroke(val);
            line(ax[i - 1], ay[i - 1], ax[i], ay[i]);
        }
    }

    public static void main(String[] args) {
        PApplet.main("processing.TestProcessing", args);
    }
}*/

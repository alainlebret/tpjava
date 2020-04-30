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
package tp01;

import java.math.BigDecimal;
import java.util.StringTokenizer;

/**
 * This class shows how to truncate of a double.
 *
 * @author A. Lebret
 * @version 1.0
 * @since 01/2017
 */
public class Truncation {

    /**
     * Truncates a double given as a string.
     *
     * @param x           The string that represents the double to truncate
     * @param nbDecimales The number of decimales to keep
     * @return The truncated double as a string
     */
    public static String firstTruncate(String x, int nbDecimales) {
        String before;
        String after;

        StringTokenizer st = new StringTokenizer(x, ".");
        before = st.nextToken();

        if (st.hasMoreTokens()) {
            after = st.nextToken();
        } else {
            return before;
        }
        if (after.length() <= nbDecimales) {
            return x;
        }
        return x.substring(0, x.length() - after.length() + nbDecimales);
    }

    /**
     * Truncates using {@code Math.floor} and {@code Math.pow}.
     *
     * @param x           The double to truncate
     * @param nbDecimales The number of decimales to keep
     * @return The truncated double as a string
     * @see java.lang.Math
     */
    public static String secondTruncate(final double x, final int nbDecimales) {
        int multiplicator;
        double result;

        multiplicator = (int) Math.pow(10, nbDecimales);
        if (x >= 0) {
            result = Math.floor(x * multiplicator) / multiplicator;
        } else {
            result = -1 * Math.floor(-x * multiplicator) / multiplicator;
        }
        return String.valueOf(result);
    }

    /**
     * Truncates using {@code BigDecimal}.
     *
     * @param x           The double to truncate
     * @param nbDecimales The number of decimales to keep
     * @return The truncated double as a string
     * @see java.math.BigDecimal
     */
    public static String thirdTruncate(final double x, final int nbDecimales) {
        BigDecimal bd = new BigDecimal(String.valueOf(x)).setScale(nbDecimales,
                BigDecimal.ROUND_DOWN);
        return bd.toPlainString();
    }

    /**
     * Truncates using {@code String} properties.
     *
     * @param x           The double to truncate
     * @param nbDecimales The number of decimales to keep
     * @return The truncated double as a string
     * @see java.lang.String
     */
    public static String fourthTruncate(final double x, final int nbDecimales) {
        String[] parts = (String.valueOf(x)).split("\\.");
        String result = parts[0];

        if (nbDecimales != 0) {
            result = result + "." + parts[1].substring(0, nbDecimales);
        } else {
            if (x < 0 && x > -1)
                result = result.substring(1);
        }
        return result;
    }

    public static void main(String[] args) {
        double number;
        int nbDecimales;

        if (args.length != 2) {
            System.out.println("Deux arguments sont nécessaires");
            System.exit(-1);
        }

        try {
            nbDecimales = Integer.parseInt(args[1]);
            if (nbDecimales < 0) {
                throw new NumberFormatException();
            }
            number = Double.parseDouble(args[0]);
            System.out.println(firstTruncate(args[0], nbDecimales));
            System.out.println(secondTruncate(number, nbDecimales));
            System.out.println(thirdTruncate(number, nbDecimales));
            System.out.println(fourthTruncate(number, nbDecimales));
        } catch (NumberFormatException e) {
            String message = "Erreur d'écriture : le premier argument doit être un double et le deuxième un entier positif ou nul";
            System.err.println(message);
        }
    }
}

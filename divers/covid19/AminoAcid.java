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

public class AminoAcid {
    private String symbol;
    private String code;
    private String name;
    private String codons;
    private String iub;

    public AminoAcid() {
    }

    public String getSymbole() {
        return symbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCodons() {
        return codons;
    }

    public String getIub() {
        return iub;
    }

    public void setSymbole(String symbol) {
        this.symbol = symbol;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCodons(String codons) {
        this.codons = codons;
    }

    public void setIub(String iub) {
        this.iub = iub;
    }

    @Override
    public String toString() {
        return "AminoAcid{" +
                "Symbole='" + symbol + '\'' +
                ", Code='" + code + '\'' +
                ", Nom='" + name + '\'' +
                ", Codons='" + codons + '\'' +
                ", IUB='" + iub + '\'' +
                '}';
    }

}

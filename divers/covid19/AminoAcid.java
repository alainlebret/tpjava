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
    private String _symbole;
    private String _code;
    private String _name;
    private String _codons;
    private String _iub;

    public AminoAcid() {
    }

    public String getSymbole() {
        return _symbole;
    }

    public String getCode() {
        return _code;
    }

    public String getName() {
        return _name;
    }

    public String getCodons() {
        return _codons;
    }

    public String getIub() {
        return _iub;
    }

    public void setSymbole(String _symbole) {
        this._symbole = _symbole;
    }

    public void setCode(String _code) {
        this._code = _code;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setCodons(String _codons) {
        this._codons = _codons;
    }

    public void setIub(String _iub) {
        this._iub = _iub;
    }

    @Override
    public String toString() {
        return "AminoAcid{" +
                "Symbole='" + _symbole + '\'' +
                ", Code='" + _code + '\'' +
                ", Nom='" + _name + '\'' +
                ", Codons='" + _codons + '\'' +
                ", IUB='" + _iub + '\'' +
                '}';
    }

}

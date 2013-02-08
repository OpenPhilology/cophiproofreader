/*
 * This file is part of eu.himeros_CoPhiProofReader_war_1.0-SNAPSHOT
 *
 * Copyright (C) 2013 federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.himeros.cophi.proofreader.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class OcrLine implements Serializable{
    String id;
    OcrCoords coords;
    List<OcrWord> ocrWords;
    Scan<?> scan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OcrCoords getCoords() {
        return coords;
    }

    public List<OcrWord> getOcrWords() {
        return ocrWords;
    }

    
    
    public void setOcrWords(List<OcrWord> ocrWords) {
        this.ocrWords = ocrWords;
    }

    public Scan<?> getScan() {
        return scan;
    }

    public void setScan(Scan<?> scan) {
        this.scan = scan;
    }
}

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
package eu.himeros.cophi.ocr.proofreader.model;

import eu.himeros.cophi.ocr.model.Ocr;
import eu.himeros.cophi.text.model.TextualUnit;
import java.util.List;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class OcrLine implements TextualUnit<List<OcrWord>>, Ocr<PageScan<?>> {

    String id;
    OcrCoords coords;
    List<OcrWord> ocrWords;
    PageScan<?> scan;

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public OcrCoords getCoords() {
        return coords;
    }

    /**
     *
     * @return
     */
    public List<OcrWord> getOcrWords() {
        return ocrWords;
    }

    /**
     *
     * @param ocrWords
     */
    public void setOcrWords(List<OcrWord> ocrWords) {
        this.ocrWords = ocrWords;
    }

    /**
     *
     * @return
     */
    @Override
    public PageScan<?> getScan() {
        return scan;
    }

    /**
     *
     * @param scan
     */
    @Override
    public void setScan(PageScan<?> scan) {
        this.scan = scan;
    }

    @Override
    public List<OcrWord> getText() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setText(List<OcrWord> text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

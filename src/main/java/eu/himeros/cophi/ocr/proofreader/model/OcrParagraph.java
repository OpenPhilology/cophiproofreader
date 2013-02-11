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

import eu.himeros.cophi.image.model.Scan;
import eu.himeros.cophi.ocr.model.Ocr;
import eu.himeros.cophi.text.model.TextualUnit;
import java.util.List;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class OcrParagraph implements TextualUnit<List<TextualUnit<?>>>, Ocr<PageScan<?>> {

    int id;
    List<OcrLine> ocrLines;

    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * 
     * @return 
     */
    public List<OcrLine> getOcrLines() {
        return ocrLines;
    }

    /**
     * 
     * @param ocrLines 
     */
    public void setOcrLines(List<OcrLine> ocrLines) {
        this.ocrLines = ocrLines;
    }

    @Override
    public List<TextualUnit<?>> getText() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setText(List<TextualUnit<?>> text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PageScan<?> getScan() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setScan(PageScan<?> scan) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

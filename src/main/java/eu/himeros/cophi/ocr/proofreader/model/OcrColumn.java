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

import java.util.List;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class OcrColumn{
    int id;
    List<OcrParagraph> ocrParagraphs;
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
    public List<OcrParagraph> getOcrParagraphs() {
        return ocrParagraphs;
    }

    /**
     * 
     * @param ocrParagraphs 
     */
    public void setOcrParagraphs(List<OcrParagraph> ocrParagraphs) {
        this.ocrParagraphs = ocrParagraphs;
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

}

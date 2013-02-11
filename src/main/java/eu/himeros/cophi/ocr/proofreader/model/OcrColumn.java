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

import eu.himeros.cophi.text.model.Column;
import java.util.List;

/**
 * A Component based on textual subunits.
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
 //TODO: This class must be developed ...
public class OcrColumn<T> extends Column{
    int id;
    List<OcrParagraph> ocrParagraphs;
    List<OcrLine> ocrLines;

    /**
     * Get id.
     * @return the id. 
     */
    public int getId() {
        return id;
    }

    /**
     * Set id.
     * @param id the id. 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get the list of paragraphs.
     * @return the list of paragraphs.
     */
    public List<OcrParagraph> getOcrParagraphs() {
        return ocrParagraphs;
    }

    /**
     * Set the list of paragraphs.
     * @param ocrParagraphs the list of paragraphs.
     */
    public void setOcrParagraphs(List<OcrParagraph> ocrParagraphs) {
        this.ocrParagraphs = ocrParagraphs;
    }

    /**
     * Get the list of lines.
     * @return the list of lines.
     */
     //TODO: currently a column can contain either paragraphs or lines. This behaviour must be totally redisigned.
    public List<OcrLine> getOcrLines() {
        return ocrLines;
    }

    /**
     * Set the list of lines.
     * @param ocrLines the list of lines.
     */
    public void setOcrLines(List<OcrLine> ocrLines) {
        this.ocrLines = ocrLines;
    }

}

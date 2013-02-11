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
import eu.himeros.cophi.text.model.Line;
import eu.himeros.cophi.text.model.Page;
import java.util.Collection;
import java.util.List;
import org.jdom2.Document;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class OcrPage extends Page implements Ocr<PageScan<?>> {

    int id;
    String ocrPageId;
    String ocrPageLabel;
    Document hocrDocument;
    PageScan scan;
    List<OcrColumn> ocrColumns;
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
    public String getOcrPageId() {
        return ocrPageId;
    }

    /**
     * 
     * @param ocrPageId 
     */
    public void setOcrPageId(String ocrPageId) {
        this.ocrPageId = ocrPageId;
    }

    /**
     * 
     * @return 
     */
    public String getOcrPageLabel() {
        return ocrPageLabel;
    }

    /**
     * 
     * @param ocrPageLabel 
     */
    public void setOcrPageLabel(String ocrPageLabel) {
        this.ocrPageLabel = ocrPageLabel;
    }
    
    /**
     * 
     * @return 
     */
    public List<OcrColumn> getOcrColumns() {
        return ocrColumns;
    }

    /**
     * 
     * @param ocrColumns 
     */
    public void setOcrColumns(List<OcrColumn> ocrColumns) {
        this.ocrColumns = ocrColumns;
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
    @Override
    public PageScan getScan() {
        return scan;
    }

    /**
     * 
     * @param scan 
     */
    @Override
    public void setScan(PageScan scan) {
        this.scan = scan;
    }

    /**
     * 
     * @return 
     */
    public Document getHocrDocument() {
        return hocrDocument;
    }

    /**
     * 
     * @param hocrDocument 
     */
    public void setHocrDocument(Document hocrDocument) {
        this.hocrDocument = hocrDocument;
    }

}

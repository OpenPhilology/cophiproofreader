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
import org.jdom2.Document;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class OcrPage implements Serializable {
    int id;
    String ocrPageId;
    String ocrPageLabel;
    Document hocrDocument;
    Scan scan;
    List<OcrColumn> ocrColumns;
    List<OcrParagraph> ocrParagraphs;
    List<OcrLine> ocrLines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOcrPageId() {
        return ocrPageId;
    }

    public void setOcrPageId(String ocrPageId) {
        this.ocrPageId = ocrPageId;
    }

    public String getOcrPageLabel() {
        return ocrPageLabel;
    }

    public void setOcrPageLabel(String ocrPageLabel) {
        this.ocrPageLabel = ocrPageLabel;
    }
    
    public List<OcrColumn> getOcrColumns() {
        return ocrColumns;
    }

    public void setOcrColumns(List<OcrColumn> ocrColumns) {
        this.ocrColumns = ocrColumns;
    }

    public List<OcrLine> getOcrLines() {
        return ocrLines;
    }

    public void setOcrLines(List<OcrLine> ocrLines) {
        this.ocrLines = ocrLines;
    }

    public List<OcrParagraph> getOcrParagraphs() {
        return ocrParagraphs;
    }

    public void setOcrParagraphs(List<OcrParagraph> ocrParagraphs) {
        this.ocrParagraphs = ocrParagraphs;
    }

    public Scan getScan() {
        return scan;
    }

    public void setScan(Scan scan) {
        this.scan = scan;
    }

    public Document getHocrDocument() {
        return hocrDocument;
    }

    public void setHocrDocument(Document hocrDocument) {
        this.hocrDocument = hocrDocument;
    }
}

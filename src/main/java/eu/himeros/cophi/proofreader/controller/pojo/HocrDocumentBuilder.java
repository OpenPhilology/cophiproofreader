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
package eu.himeros.cophi.proofreader.controller.pojo;

import eu.himeros.cophi.proofreader.model.Deletion;
import eu.himeros.cophi.proofreader.model.OcrLine;
import eu.himeros.cophi.proofreader.model.OcrPage;
import eu.himeros.cophi.proofreader.model.OcrWord;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class HocrDocumentBuilder {

    OcrPage ocrPage;
    Namespace xmlns;

    public HocrDocumentBuilder() {
    }

    public HocrDocumentBuilder(OcrPage ocrPage) {
        this.ocrPage = ocrPage;
    }

    public OcrPage getOcrPage() {
        return ocrPage;
    }

    public void setOcrPage(OcrPage ocrPage) {
        this.ocrPage = ocrPage;
    }

    public Document build() {
        return build(ocrPage);
    }

    public Document build(OcrPage ocrPage) {
        this.ocrPage = ocrPage;
        Document hocrDocument = ocrPage.getHocrDocument();
        return build(hocrDocument);
    }
    
    public Document build(Document hocrDocument){
        Element root = hocrDocument.getRootElement();
        xmlns = root.getNamespace();
        Element bodyEl = root.getChildren().get(1);
        Element ocrPageEl = bodyEl.getChildren().get(0).detach();
        String pageId = ocrPageEl.getAttributeValue("id");
        ocrPageEl = new Element("div", xmlns);
        ocrPageEl.setAttribute("class", "ocr_page");
        ocrPageEl.setAttribute("id", pageId);
        for (OcrLine ocrLine : ocrPage.getOcrLines()) {
            ocrPageEl.addContent(makeOcrLineEl(ocrLine));
            ocrPageEl.addContent(new Element("br", xmlns));
        }
        bodyEl.addContent(ocrPageEl);
        return hocrDocument;
    }

    private Element makeOcrLineEl(OcrLine ocrLine) {
        Element ocrLineEl = new Element("span", xmlns);
        ocrLineEl.setAttribute("class", "ocr_line");
        ocrLineEl.setAttribute("title", ocrLine.getScan().getCoords().getBbox());
        for (OcrWord ocrWord : ocrLine.getOcrWords()) {
            ocrLineEl.addContent(makeOcrWordEl(ocrWord));
        }
        return ocrLineEl;
    }

    private Element makeOcrWordEl(OcrWord ocrWord) {
        Element ocrWordEl = new Element("span", xmlns);
        String wordId = ocrWord.getId();
        ocrWordEl.setAttribute("id", wordId);
        ocrWordEl.setAttribute("class", "ocr_word");
        ocrWordEl.setAttribute("title", ocrWord.getScan().getCoords().getBbox());
        Element alternativeEl = new Element("span", xmlns);
        alternativeEl.setAttribute("class", "alternatives");
        Element alternativeInsertionEl = new Element("ins",xmlns);
        alternativeInsertionEl.setAttribute("class", "alt");
        alternativeInsertionEl.setAttribute("title", ocrWord.getInsertion().getNlp());
        alternativeInsertionEl.setText(ocrWord.getInsertion().getText());
        alternativeEl.addContent(alternativeInsertionEl);
        for (Deletion alternativeDeletion : ocrWord.getDeletions()) {
            alternativeEl.addContent(makeAlternativeDeletionEl(alternativeDeletion));
        }
        ocrWordEl.addContent(alternativeEl);
        return ocrWordEl;
    }

    private Element makeAlternativeDeletionEl(Deletion alternativeDeletion) {
        Element alternativeDeletionEl = new Element("del",xmlns);
        //alternativeDeletionEl.setAttribute("class", "alt");
        alternativeDeletionEl.setAttribute("title", alternativeDeletion.getNlp());
        alternativeDeletionEl.setText(alternativeDeletion.getText());
        return alternativeDeletionEl;
    }
}

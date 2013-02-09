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

import eu.himeros.cophi.proofreader.model.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class OcrPageParser implements Serializable {
    static final Logger logger=Logger.getLogger(OcrPageParser.class.getName());
    OcrPage ocrPage;
    BufferedImage ocrPageImage;
    static String path;
    ImageFileNameLoader il=new ImageFileNameLoader();

    public OcrPageParser() {
    }
    
    public OcrPageParser(OcrPage ocrPage){
        this.ocrPage=ocrPage;
    }

    public OcrPageParser(Document hocrDocument) {
        ocrPage.setHocrDocument(hocrDocument);
    }

    public OcrPage getOcrPage() {
        return ocrPage;
    }

    public void setOcrPage(OcrPage ocrPage) {
        this.ocrPage = ocrPage;
    }

    
    public void setHocrDocument(Document hocrDocument) {
        ocrPage.setHocrDocument(hocrDocument);
    }

    public Document getHocrDocument() {
        return ocrPage.getHocrDocument();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        OcrPageParser.path = path;
    }

    
    
    public OcrPage parse() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return ocrPage = parse(ocrPage.getHocrDocument());
    }
    
    public OcrPage parse(String hocrFileName) throws JDOMException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        SAXBuilder builder=new SAXBuilder();
        Document hocrDocument=builder.build(new File(hocrFileName));
        return parse(hocrDocument);
    }
    
    public OcrPage parse(String path, Document hocrDocument, OcrPage ocrPage) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        setPath(path);
        setOcrPage(ocrPage);
        return parse(hocrDocument);
    }

    public OcrPage parse(Document hocrDocument) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ocrPage.setHocrDocument(hocrDocument);
        Element root = hocrDocument.getRootElement();
        Namespace xmlns=root.getNamespace();
        String scanId = root.getChildren().get(1).getChildren().get(0).getAttributeValue("id");
        ocrPage.setScan(new Scan<>(scanId));
        List<OcrLine> ocrLines = new ArrayList<>();
        for (Element ocrLineEl : root.getChildren().get(1).getChildren().get(0).getChildren("span",xmlns)) { //cycle on /html/body/span[@class='ocr_page']/span[@class='ocr_line']
            ocrLines.add(parseOcrLine(ocrLineEl));
        }
        ocrPage.setOcrLines(ocrLines);
        return ocrPage;
    }

    private OcrLine parseOcrLine(Element ocrLineEl) {
        OcrLine ocrLine = new OcrLine();       
        OcrCoords ocrLineCoords = new OcrCoords(ocrLineEl.getAttributeValue("title"));
        ocrLine.setScan(new Scan(path+ocrPage.getScan().getImage(),ocrLineCoords));
        List<OcrWord> ocrWords = new ArrayList<>();
        for (Element ocrWordEl : ocrLineEl.getChildren()) {
            ocrWords.add(parseOcrWord(ocrWordEl));
        }
        ocrLine.setOcrWords(ocrWords);
        return ocrLine;
    }

    private OcrWord parseOcrWord(Element ocrWordEl) {
        OcrWord ocrWord = new OcrWord();
        ocrWord.setId(ocrWordEl.getAttributeValue("id"));
        OcrCoords ocrWordCoords = new OcrCoords(ocrWordEl.getAttributeValue("title"));
        ocrWord.setScan(new Scan(ocrWordCoords));
        boolean firstLine = true;
        List<Deletion> alternativeDeletions = new ArrayList<>();
        for (Element ocrAlternativeEl : ocrWordEl.getChildren().get(0).getChildren()) {
            if(firstLine){
                ocrWord.setInsertion(parseAlternativeInsertion(ocrAlternativeEl));
                firstLine=false;
            }else{
                alternativeDeletions.add(parseAlternativeDeletion(ocrAlternativeEl));
            }
        }
        ocrWord.setDeletions(alternativeDeletions);
        return ocrWord;
    }
    
    private Insertion parseAlternativeInsertion(Element ocrAlternativeEl){
        Insertion alternativeInsertion=new Insertion();
        alternativeInsertion.setText(ocrAlternativeEl.getText());
        alternativeInsertion.setNlp(ocrAlternativeEl.getAttributeValue("title"));
        return alternativeInsertion;
    }
    
    private Deletion parseAlternativeDeletion(Element ocrAlternativeEl){
        Deletion alternativeDeletion=new Deletion();
        alternativeDeletion.setText(ocrAlternativeEl.getText());
        alternativeDeletion.setNlp(ocrAlternativeEl.getAttributeValue("title"));
        return alternativeDeletion;
    }
    
}

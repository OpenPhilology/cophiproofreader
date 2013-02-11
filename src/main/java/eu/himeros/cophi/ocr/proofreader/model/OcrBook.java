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

import eu.himeros.cophi.text.model.TextualUnit;
import java.util.List;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
//TODO: generic must be revised, because T ocrBookId is important - OcrBook<T1,T2> is possible
public class OcrBook<T> implements TextualUnit<List<TextualUnit<?>>>{
  
    int id;
    T ocrBookId;
    String ocrBookLabel;
    int currPageReference;
    OcrPage currPage;
    List<OcrPage> ocrPages;
    
    /**
     * 
     */
    public OcrBook(){
        ocrPages=null;
    }

    /**
     * 
     * @return 
     */
    public List<OcrPage> getOcrPages() {
        return ocrPages;
    }

    /**
     * 
     * @param ocrPages 
     */
    public void setOcrPages(List<OcrPage> ocrPages) {
        this.ocrPages = ocrPages;
    }

    /**
     * 
     * @return 
     */
    public OcrPage getCurrPage() {
        return currPage;
    }

    /**
     * 
     * @param currPage 
     */
    public void setCurrPage(OcrPage currPage) {
        currPageReference=currPage.getId();
        this.currPage = currPage;
    }

    /**
     * 
     * @return 
     */
    public int getCurrPageReference() {
        return currPageReference;
    }

    /**
     * 
     * @param currPageReference 
     */
    public void setCurrPageReference(int currPageReference) {
        this.currPageReference = currPageReference;
        currPage=ocrPages.get(currPageReference);
    }

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
    public T getOcrBookId() {
        return ocrBookId;
    }

    /**
     * 
     * @param ocrBookId 
     */
    public void setOcrBookId(T ocrBookId) {
        this.ocrBookId = ocrBookId;
    }

    /**
     * 
     * @return 
     */
    public String getOcrBookLabel() {
        return ocrBookLabel;
    }

    /**
     * 
     * @param ocrBookLabel 
     */
    public void setOcrBookLabel(String ocrBookLabel) {
        this.ocrBookLabel = ocrBookLabel;
    }

    @Override
    public List<TextualUnit<?>> getText() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setText(List<TextualUnit<?>> text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}

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
public class OcrBook<T> implements Serializable{
    int id;
    T ocrBookId;
    String ocrBookLabel;
    int currPageReference;
    OcrPage currPage;
    
    List<OcrPage> ocrPages;
    
    public OcrBook(){
        ocrPages=null;
    }

    public List<OcrPage> getOcrPages() {
        return ocrPages;
    }

    public void setOcrPages(List<OcrPage> ocrPages) {
        this.ocrPages = ocrPages;
    }

    public OcrPage getCurrPage() {
        return currPage;
    }

    public void setCurrPage(OcrPage currPage) {
        currPageReference=currPage.getId();
        this.currPage = currPage;
    }

    public int getCurrPageReference() {
        return currPageReference;
    }

    public void setCurrPageReference(int currPageReference) {
        this.currPageReference = currPageReference;
        currPage=ocrPages.get(currPageReference);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getOcrBookId() {
        return ocrBookId;
    }

    public void setOcrBookId(T ocrBookId) {
        this.ocrBookId = ocrBookId;
    }

    public String getOcrBookLabel() {
        return ocrBookLabel;
    }

    public void setOcrBookLabel(String ocrBookLabel) {
        this.ocrBookLabel = ocrBookLabel;
    }
    
}
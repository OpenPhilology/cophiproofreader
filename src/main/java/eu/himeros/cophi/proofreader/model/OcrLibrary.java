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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class OcrLibrary<T1,T2,T3> implements Serializable{
    int currBookReference;
    OcrBook<T3> currBook;
    T1 root;
    T2 bookFilter;
    T2 pageFilter;
    
    List<OcrBook> ocrBooks;
   
    public OcrLibrary(){
        currBookReference=-1;
        ocrBooks=new ArrayList<>();
    }

    public int getCurrBookReference() {
        return currBookReference;
    }

    public void setCurrBookReference(int currBookReference) {
        this.currBookReference = currBookReference;
        currBook=ocrBooks.get(currBookReference);
    }
    
    public T1 getRoot() {
        return root;
    }

    public void setRoot(T1 root) {
        this.root = root;
    }

    public T2 getBookFilter() {
        return bookFilter;
    }

    public void setBookFilter(T2 bookFilter) {
        this.bookFilter = bookFilter;
    }

    public T2 getPageFilter() {
        return pageFilter;
    }

    public void setPageFilter(T2 pageFilter) {
        this.pageFilter = pageFilter;
    }
    
    
    public List<OcrBook> getOcrBooks() {
        return ocrBooks;
    }

    public void setOcrBooks(List<OcrBook> ocrBooks) {
        this.ocrBooks = ocrBooks;
    }

    public OcrBook<T3> getCurrBook() {
        return currBook;
    }

    public void setCurrBook(OcrBook<T3> currBook) {
        this.currBook = currBook;
    }
    
}

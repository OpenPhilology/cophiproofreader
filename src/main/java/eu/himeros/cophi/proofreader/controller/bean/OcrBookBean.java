/*
 * This file is part of eu.himeros_CoPhiProofReader3_war_1.0-SNAPSHOT
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
package eu.himeros.cophi.proofreader.controller.bean;

import eu.himeros.cophi.proofreader.controller.pojo.BookDirectoryDescriptor;
import eu.himeros.cophi.proofreader.model.OcrBook;
import eu.himeros.cophi.proofreader.model.OcrLibrary;
import eu.himeros.cophi.proofreader.model.OcrPage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
@ManagedBean(name = "bookBean")
@SessionScoped
public class OcrBookBean implements Serializable {
    private static final transient Logger log = Logger.getLogger(InitBean.class.getName());
    int currPageReference;
    List<OcrPage> ocrPages;

    public OcrBookBean() {
        currPageReference = 0;
    }

    public List<OcrPage> getOcrPages() {
        ocrPages = libraryBean.getLibrary().getCurrBook().getOcrPages();
        if (ocrPages == null) {
            initPages();
        }
        return ocrPages;
    }

    public void setOcrPages(List<OcrPage> ocrPages) {
        libraryBean.getLibrary().getCurrBook().setOcrPages(ocrPages);
        this.ocrPages = libraryBean.getLibrary().getCurrBook().getOcrPages();
    }
    @ManagedProperty(value = "#{libraryBean}")
    OcrLibraryBean libraryBean;

    public OcrLibraryBean getLibraryBean() {
        return libraryBean;
    }

    public void setLibraryBean(OcrLibraryBean libraryBean) {
        this.libraryBean = libraryBean;
    }

    public int getCurrPageReference() {
        return currPageReference;
    }

    public void setCurrPageReference(int currPageReference) {
        System.err.println("currPageReference=" + currPageReference);
        this.currPageReference = currPageReference;
    }

    public void init() {
    }

    private void initPages() {
        OcrLibrary<String, String, String> library = libraryBean.getLibrary();
        OcrBook<?> currBook = library.getCurrBook();
        BookDirectoryDescriptor bdd = new BookDirectoryDescriptor();
        bdd.setFilter(library.getPageFilter());
        System.err.println("######"+library.getRoot()+File.separator+currBook.getOcrBookId());
        bdd.setRepository(library.getRoot() + File.separator + currBook.getOcrBookId());
        bdd.initRepository();
        List<String> references = bdd.getReferences();
        ocrPages = new ArrayList<>();
        int i = 0;
        Collections.sort(references);
        for (String pageId : references) {
            OcrPage page = new OcrPage();
            page.setId(i);
            page.setOcrPageId(pageId);
            page.setOcrPageLabel("" + (i + 1));
            i++;
            ocrPages.add(page);
        }
        libraryBean.getLibrary().getCurrBook().setOcrPages(ocrPages);
    }
}

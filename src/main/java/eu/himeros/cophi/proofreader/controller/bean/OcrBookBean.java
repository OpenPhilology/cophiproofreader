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

/**
 * 
 */
public class OcrBookBean implements Serializable {
    private static final transient Logger logger = Logger.getLogger(OcrBookBean.class.getCanonicalName());
    @ManagedProperty(value = "#{libraryBean}")
    OcrLibraryBean libraryBean;

    /**
     * 
     */
    public OcrBookBean() {
    }

    /**
     * 
     * @return 
     */
    public List<OcrPage> getOcrPages() {
        if (libraryBean.getLibrary().getCurrBook().getOcrPages() == null) {
            initPages();
        }
        return libraryBean.getLibrary().getCurrBook().getOcrPages();
    }

    /**
     * 
     * @param ocrPages 
     */
    public void setOcrPages(List<OcrPage> ocrPages) {
        libraryBean.getLibrary().getCurrBook().setOcrPages(ocrPages);
    }

    /**
     * 
     * @return 
     */
    public OcrLibraryBean getLibraryBean() {
        return libraryBean;
    }

    /**
     * 
     * @param libraryBean 
     */
    public void setLibraryBean(OcrLibraryBean libraryBean) {
        this.libraryBean = libraryBean;
    }

    /**
     * 
     * @return 
     */
    public int getCurrPageReference() {
        return libraryBean.getLibrary().getCurrBook().getCurrPageReference();
    }

    /**
     * 
     * @param currPageReference 
     */
    public void setCurrPageReference(int currPageReference) {
        System.err.println("currPageReference=" + currPageReference);
        libraryBean.getLibrary().getCurrBook().setCurrPageReference(currPageReference);
    }

    /**
     * 
     */
    private void initPages() {
        OcrLibrary<String, String, String> library = libraryBean.getLibrary();
        OcrBook<?> currBook = library.getCurrBook();
        BookDirectoryDescriptor bookDirDescriptor = new BookDirectoryDescriptor();
        bookDirDescriptor.setFilter(library.getPageFilter());
        bookDirDescriptor.setRepository(library.getRoot() + File.separator + currBook.getOcrBookId());
        bookDirDescriptor.initRepository();
        List<String> references = bookDirDescriptor.getReferences();
        int i = 0;
        Collections.sort(references);
        libraryBean.getLibrary().getCurrBook().setOcrPages(new ArrayList<OcrPage>());
        for (String pageId : references) {
            OcrPage page = new OcrPage();
            page.setId(i);
            page.setOcrPageId(pageId);
            String label = pageId.replaceAll("[^1-9]*([1-9][0-9]*)" + library.getPageFilter().replaceAll("\\.", "\\."), "$1");
            page.setOcrPageLabel(label);
            i++;
            libraryBean.getLibrary().getCurrBook().getOcrPages().add(page);
        }
        libraryBean.getLibrary().getCurrBook().setCurrPageReference(0);
    }
    
}

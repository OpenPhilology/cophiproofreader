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

import eu.himeros.cophi.proofreader.controller.pojo.Descriptor;
import eu.himeros.cophi.proofreader.controller.pojo.LibraryDirectoryDescriptor;
import eu.himeros.cophi.proofreader.model.OcrBook;
import eu.himeros.cophi.proofreader.model.OcrLibrary;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
@ManagedBean(name = "libraryBean")
@SessionScoped

/**
 * 
 */
public class OcrLibraryBean implements Serializable {
    private static final transient Logger log = Logger.getLogger(InitBean.class.getName());
    @ManagedProperty(value = "#{initBean}")
    InitBean initBean;
    OcrLibrary<String, String, String> library;

    /**
     * 
     */
    public OcrLibraryBean() {
    }

    /**
     * 
     */
    @PostConstruct
    public void init() {
        library = new OcrLibrary();
        library.setRoot(initBean.getRoot());
        library.setBookFilter(initBean.getBookFilter());
        library.setPageFilter(initBean.getPageFilter());
        Descriptor libDirDescriptor = new LibraryDirectoryDescriptor();
        libDirDescriptor.setFilter(library.getBookFilter());
        libDirDescriptor.setRepository(library.getRoot());
        libDirDescriptor.initRepository();
        List<String> bookIds = libDirDescriptor.getReferences();
        int i = 0;
        for (String bookId : bookIds) {
            OcrBook<String> book = new OcrBook<>();
            book.setId(i);
            book.setOcrBookId(bookId);
            String bookLabel = bookId.replaceAll("_", " ").replaceAll("-", ", ").replaceAll("\\..*?$", "");
            book.setOcrBookLabel(bookLabel);
            library.getOcrBooks().add(book);
            i++;
        }
        library.setCurrBookReference(0);
    }

    /**
     * 
     * @return 
     */
    public OcrLibrary<String, String, String> getLibrary() {
        return library;
    }

    /**
     * 
     * @param library 
     */
    public void setLibrary(OcrLibrary<String, String, String> library) {
        this.library = library;
    }

    /**
     * 
     * @return 
     */
    public InitBean getInitBean() {
        return initBean;
    }

    /**
     * 
     * @param initBean 
     */
    public void setInitBean(InitBean initBean) {
        this.initBean = initBean;
    }
    
    /**
     * 
     * @param currBookReferenceStr 
     */
    public void update(String currBookReferenceStr){
        int currBookReference=Integer.parseInt(currBookReferenceStr);
        library.setCurrBookReference(currBookReference);
        library.getCurrBook().setCurrPageReference(0);
    }
}

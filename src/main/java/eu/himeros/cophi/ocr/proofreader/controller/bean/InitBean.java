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

package eu.himeros.cophi.ocr.proofreader.controller.bean;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */

@ManagedBean(name="initBean")
@ApplicationScoped

/**
 * Manages application variables, such as the path root of the entire collection
 * (the library), book, page and image filters to apply to the repository
 * that contains these objects
 */
public class InitBean implements Serializable{

    private final static transient Logger log= Logger.getLogger(InitBean.class.getName());
    private String root="/opt/junk";
    private String bookFilter=".book";
    private String pageFilter=".html";
    private String imageFilter=".png";
    //TODO: properties must be read from a property file or from the main webage
    
    /**
     * Get the bookFilter
     * @return the book filter, evaluated by an .endsWith(bookFilter) test
     */
    public String getBookFilter() {
        return bookFilter;
    }

    /**
     * Set the bookFilter
     * @param bookFilter the book filter, evaluated by an .endsWith(bookFilter) test
     */
    public void setBookFilter(String bookFilter) {
        this.bookFilter = bookFilter;
    }

    /**
     * Get the pageFilter 
     * @return the page filter, evaluated by an .endsWith(pageFilter) test
     */
    public String getPageFilter() {
        return pageFilter;
    }

    /**
     * Set the pageFilter
     * @param pageFilter the page filter, evaluated by an .endsWith(pageFilter) test
     */
    public void setPageFilter(String pageFilter) {
        this.pageFilter = pageFilter;
    }

    /**
     * Get the root of the collection (e.g. the absolute path to the collection
     * in the file system)
     * @return 
     */
    public String getRoot() {
        return root;
    }
 
    /**
     * Set the root of the collection (e.g. the absolute path to the collection
     * in the file system)
     * @param root the path to the collection 
     */
    public void setRoot(String root) {
        this.root = root;
    }

    /**
     * Get the imageFilter 
     * @return the image filter, evaluated by an .endsWith(imageFilter) test
     */ 
    public String getImageFilter() {
        return imageFilter;
    }

    /**
     * Set the imageFilter 
     * the image filter, evaluated by an .endsWith(imageFilter) test
     * @param imageFilter the image filter, evaluated by an .endsWith(imageFilter) test
     */
    public void setImageFilter(String imageFilter) {
        this.imageFilter = imageFilter;
    }
}

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
public class InitBean implements Serializable{
    private final static transient Logger log= Logger.getLogger(InitBean.class.getName());
    String root="/opt/junk";
    String bookFilter=".book";
    String pageFilter=".html";
    String imageFilter=".png";

    public String getBookFilter() {
        return bookFilter;
    }

    public void setBookFilter(String bookFilter) {
        this.bookFilter = bookFilter;
    }

    public String getPageFilter() {
        return pageFilter;
    }

    public void setPageFilter(String pageFilter) {
        this.pageFilter = pageFilter;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getImageFilter() {
        return imageFilter;
    }

    public void setImageFilter(String imageFilter) {
        this.imageFilter = imageFilter;
    }
    
    

}

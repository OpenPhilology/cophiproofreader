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

import eu.himeros.cophi.proofreader.controller.pojo.HocrDocumentBufferedReader;
import eu.himeros.cophi.proofreader.controller.pojo.OcrPageParser;
import eu.himeros.cophi.proofreader.model.OcrBook;
import eu.himeros.cophi.proofreader.model.OcrLibrary;
import eu.himeros.cophi.proofreader.model.OcrPage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.jdom2.Document;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
@ManagedBean(name = "pageBean")
@SessionScoped
public class OcrPageBean implements Serializable {
    private static final transient Logger log= Logger.getLogger(InitBean.class.getName());
    @ManagedProperty(value = "#{bookBean}")
    OcrBookBean bookBean;
    OcrBook book;
    OcrPage page;
    int pageReference;
    int prevPageReference=-1;

    @PostConstruct
    public void init() {
        try {
            pageReference=bookBean.getCurrPageReference();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    public int getPageReference() {
        return pageReference;
    }

    public void setPageReference(int pageReference){
        this.pageReference=pageReference;
    }
    
    private synchronized void makePage() {
        String fileName;
        HocrDocumentBufferedReader hocrDocumentReader=new HocrDocumentBufferedReader();
        try {
            OcrLibrary<String,String,String> library=bookBean.getLibraryBean().getLibrary();
            OcrBook<String> currBook=library.getCurrBook();
            List<OcrPage> ocrPages=bookBean.getOcrPages();
            OcrPage currPage=ocrPages.get(pageReference);
            fileName=library.getRoot()+File.separator+currBook.getOcrBookId()+File.separator+currPage.getOcrPageId(); 
            //fileName=currPage.getOcrPageId();
            //FB6
            Document inHocrDocument = hocrDocumentReader.load(fileName);
            //System.err.println(library.getCurrBook().getOcrBookId());
            //System.err.println("#############"+library.getRoot()+File.separator+library.getCurrBook().getOcrBookId()+File.separator);
            String path=library.getRoot()+File.separator+library.getCurrBook().getOcrBookId()+File.separator;
            OcrPageParser opp=new OcrPageParser();
            page = opp.parse(path,inHocrDocument);
        } catch (FileNotFoundException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public OcrPage getPage() {
        int bookBeanPageReference=bookBean.getCurrPageReference();
        if(bookBeanPageReference==-1) return null;
        if(bookBeanPageReference!=prevPageReference){
            setPageReference(bookBeanPageReference);
            prevPageReference=bookBeanPageReference;
            OcrPage currPage=bookBean.getOcrPages().get(bookBean.getCurrPageReference());
           // if(currPage.getHocrDocument()==null){
                makePage();
           // }else{
              //  page=currPage;
                //bookBean.getLibraryBean().library.getCurrBook().getOcrPages().set(bookBean.getCurrPageReference(),currPage);
            //}
        }
        return page;
    }

    public void setPage(OcrPage page) {
        this.page = page;
    }

    public void updateInsertion(String text, int lineIdx, int wordIdx) {
        text = text.replaceAll("\u261a", "");
        page.getOcrLines().get(lineIdx).getOcrWords().get(wordIdx).getInsertion().setText(text);
    }

    public OcrBookBean getBookBean() {
        return bookBean;
    }

    public void setBookBean(OcrBookBean bookBean) {
        this.bookBean = bookBean;
    }
}

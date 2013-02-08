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

import eu.himeros.cophi.proofreader.model.OcrLine;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.primefaces.model.DefaultStreamedContent;
import sun.awt.image.ToolkitImage;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
@ManagedBean(name = "pageImageBean")
@SessionScoped
public class OcrPageImageBean implements Serializable {

    private static final transient Logger log = Logger.getLogger(OcrPageImageBean.class.getName());
    BufferedImage pageImage;
    @ManagedProperty(value = "#{libraryBean}")
    OcrLibraryBean libraryBean;
    @ManagedProperty(value="#{pageBean}")
    OcrPageBean pageBean;
    static DefaultStreamedContent def;

    public static DefaultStreamedContent getDef() {
        return def;
    }

    public static void setDef(DefaultStreamedContent def) {
        OcrPageImageBean.def = def;
    }

    public OcrPageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(OcrPageBean pageBean) {
        this.pageBean = pageBean;
    }

    public OcrLibraryBean getLibraryBean() {
        return libraryBean;
    }

    public void setLibraryBean(OcrLibraryBean libraryBean) {
        this.libraryBean = libraryBean;
    }

    public synchronized DefaultStreamedContent getImage() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getRenderResponse()) {
            return new DefaultStreamedContent();
        } else {
            /**
            int lineId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("lineId"));
            List<OcrLine> lines=pageBean.getPage().getOcrLines();
            if(lines==null){
                System.err.println("LINES NULL");
            }else{
                System.err.println("LINES NOT NULL");
            }
            OcrLine line=lines.get(lineId);
            System.err.println("line:"+line.getId());
            if(line.getLineScan().getLineScan()==null){
                System.err.println("####NULL");
            }else{
                System.err.println("####NOTNULL:"+line.getLineScan().getLineScan().toString());
            }
            def=line.getLineScan().getLineScan();
            return def;
        */
        int lineId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("lineId"));
        List<OcrLine> lines=pageBean.getPage().getOcrLines();
        OcrLine line=lines.get(lineId);
        int x1=Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("x1"));
        int y1=Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("y1"));
        int x2=Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("x2"));
        int y2=Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("y2"));
        pageImage = null;
        try {
            ImageIcon iic = new ImageIcon((String)line.getScan().getImage());
            pageImage = ((ToolkitImage) iic.getImage()).getBufferedImage();
            BufferedImage bimg = ((BufferedImage)pageImage).getSubimage(x1,y1,x2-x1,y2-y1);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bimg, "png", os);
            def = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");
        } catch (Exception ex) {
            def=null;
            ex.printStackTrace(System.err);
        }
        return def;
            
        }
        
           
            
    }

}

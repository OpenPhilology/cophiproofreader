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
import javax.enterprise.context.RequestScoped;
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
@RequestScoped

/**
 * 
 */
public class OcrPageImageBean implements Serializable {
    private static final transient Logger log = Logger.getLogger(OcrPageImageBean.class.getName());
    BufferedImage pageImage;
    @ManagedProperty(value = "#{libraryBean}")
    OcrLibraryBean libraryBean;
    DefaultStreamedContent defStreamContent;

    /**
     * 
     */
    public OcrPageImageBean() {
    }

    /**
     * 
     * @return 
     */
    public DefaultStreamedContent getDef() {
        return defStreamContent;
    }

    /**
     * 
     * @param def 
     */
    public void setDef(DefaultStreamedContent def) {
        this.defStreamContent = def;
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
    public DefaultStreamedContent getImage() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getRenderResponse()) {
            return new DefaultStreamedContent();
        } else {
            int lineId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("lineId"));
            List<OcrLine> lines = libraryBean.getLibrary().getCurrBook().getCurrPage().getOcrLines();
            OcrLine line = lines.get(lineId);
            int x1 = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("x1"));
            int y1 = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("y1"));
            int x2 = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("x2"));
            int y2 = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("y2"));
            pageImage = null;
            try {
                ImageIcon iic = new ImageIcon((String) line.getScan().getImage());
                pageImage = ((ToolkitImage) iic.getImage()).getBufferedImage();
                BufferedImage bimg = ((BufferedImage) pageImage).getSubimage(x1, y1, x2 - x1, y2 - y1);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(bimg, "png", os);
                defStreamContent = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");
            } catch (Exception ex) {
                defStreamContent = null;
                ex.printStackTrace(System.err);
            }
            return defStreamContent;
        }
    }
    
}

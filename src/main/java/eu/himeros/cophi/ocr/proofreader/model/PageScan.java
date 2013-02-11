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

package eu.himeros.cophi.ocr.proofreader.model;

import eu.himeros.cophi.image.model.Scan;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class PageScan<T> implements Scan<T,OcrCoords> {

    protected T image;
    protected OcrCoords coords;

    /**
     * 
     */
    public PageScan(){}
    
    /**
     * 
     * @param coords 
     */
    public PageScan(OcrCoords coords){
        this.coords=coords;
    }
    
    /**
     * 
     * @param image 
     */
    public PageScan(T image){
        this.image=image;
    }
    
    /**
     * 
     * @param image
     * @param coords 
     */
    public PageScan(T image, OcrCoords coords){
        this.image=image;
        this.coords=coords;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public OcrCoords getCoords() {
        return coords;
    }

    /**
     * 
     * @param coords 
     */
    @Override
    public void setCoords(OcrCoords coords) {
        this.coords = coords;
    }

    /**
     * 
     * @return 
     */
    @Override
    public T getImage() {
        return image;
    }

    /**
     * 
     * @param image 
     */
    @Override
    public void setImage(T image) {
        this.image = image;
    }

}

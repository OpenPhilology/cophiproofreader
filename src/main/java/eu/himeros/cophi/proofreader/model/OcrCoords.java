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

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class OcrCoords implements Serializable{
    String bbox;
    int x1;
    int y1;
    int x2;
    int y2;
    
    public OcrCoords(){}
    
    public OcrCoords(int x1, int y1, int x2, int y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    
    public OcrCoords(String bbox){
        this.bbox=bbox;
        String[] bboxCoords=bbox.split(" ");
        this.x1=Integer.parseInt(bboxCoords[1]);
        this.y1=Integer.parseInt(bboxCoords[2]);
        this.x2=Integer.parseInt(bboxCoords[3]);
        this.y2=Integer.parseInt(bboxCoords[4]);
    }

    public String getBbox() {
        return bbox;
    }

    public void setBbox(String bbox) {
        this.bbox = bbox;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
        bboxUpdate();
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
        bboxUpdate();
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
        bboxUpdate();
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
        bboxUpdate();
    }
    
    
    private void bboxUpdate(){
        StringBuilder sb=new StringBuilder("bbox ");
        bbox=sb.append(x1).append(" ").append(y1).append(" ").append(x2).append(" ").append(y2).toString();
    }
}
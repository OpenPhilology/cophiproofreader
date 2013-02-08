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

package eu.himeros.cophi.proofreader.model;

import java.io.Serializable;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public abstract class Alternative implements Serializable{
    protected String text;
    protected String nlp;
    protected double nlpDbl;
    protected String nlpStyleClass;
    protected String nlpColor;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }    
    
    public void setNlp(String nlp){
        this.nlp=nlp;
        String[] labelValue=nlp.split(" ");
        nlpDbl=Double.parseDouble(labelValue[1]);
        nlpStyleClass=nlp.replaceAll("[ \\.]","");
        switch(nlpStyleClass){
            case "nlp100":
                nlpColor="black";
                break;
            case "nlp099":
                nlpColor="blue";
                break;
            case "nlp098":
                nlpColor="brown";
                break;
            case "nlp097":
                nlpColor="red";
                break;
            default:
                nlpColor="red";
        }
    }
    
    public String getNlp() {
        return nlp;
    }
    
    public double getNlpDbl() {
        return nlpDbl;
    }

    public void setNlpDbl(double nlpDbl) {
        this.nlpDbl = nlpDbl;
    }

    public String getNlpStyleClass() {
        return nlpStyleClass;
    }

    public void setNlpStyleClass(String nlpStyleClass) {
        this.nlpStyleClass = nlpStyleClass;
    }

    public String getNlpColor() {
        return nlpColor;
    }

    public void setNlpColor(String nlpColor) {
        this.nlpColor = nlpColor;
    }
    
    
    
}

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
package eu.himeros.cophi.proofreader.controller.pojo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class HocrDocumentBufferedReader implements HocrDocumentLoader<BufferedReader> {

    @Override
    public Document load(BufferedReader origin){
        try{
            SAXBuilder builder = new SAXBuilder();
            return builder.build(origin);
        }catch(IOException|JDOMException ex){
            ex.printStackTrace(System.err);
            return null;
        }
    }
    
    public Document load(String inFileName) throws FileNotFoundException{
        return load(new BufferedReader(new FileReader(inFileName)));
    }
}

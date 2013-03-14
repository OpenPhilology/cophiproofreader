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

package eu.himeros.cophi.ocr.proofreader.controller.pojo;

import eu.himeros.cophi.ocr.proofreader.model.OcrPage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.exist.xmldb.EXistResource;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.DOMBuilder;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.DOMOutputter;
import org.jdom2.output.XMLOutputter;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class HocrDocumentExistSaver implements HocrDocumentSaver<Map<String,String>> {
    
    public static void main(String[] args) throws Exception{
        HashMap<String,String> pageInfoMap=new HashMap<>();
        pageInfoMap.put("library","xmldb:exist://localhost:8088/xmlrpc/db/perseus-ocr");
        pageInfoMap.put("book","Euclides-Opera1.book");
        pageInfoMap.put("page","p0208.html");
        pageInfoMap.put("login","federico");
        pageInfoMap.put("password","ociredef");
        
        SAXBuilder builder=new SAXBuilder();
        Document doc=builder.build("/opt/junk/Euclides-Opera1.book/p0208.html");
        HocrDocumentExistSaver hdes=new HocrDocumentExistSaver();
        hdes.save(doc,pageInfoMap);        
    }
    @Override
    public void save(Document hocrDocument, Map<String, String> destination) {
        try{
            String library=destination.get("library");
            String book=library+"/"+destination.get("book");
            String page=destination.get("page");
            String login=destination.get("login");
            String password=destination.get("password");
            Database database = (Database)(Class.forName("org.exist.xmldb.DatabaseImpl").newInstance());
            DatabaseManager.registerDatabase(database);
            Collection col = DatabaseManager.getCollection(book,login,password);
            XMLResource res=(XMLResource)col.createResource(page,"XMLResource");
            DOMOutputter domOutputter=new DOMOutputter();
            XMLOutputter xmlOutputter=new XMLOutputter();
            //org.w3c.dom.Document domDoc=domOutputter.output(hocrDocument);
            res.setContent(xmlOutputter.outputString(hocrDocument));
            col.storeResource(res);
            ((EXistResource)res).freeResources();
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | XMLDBException ex){
            Logger.getLogger(HocrDocumentExistSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(OcrPage ocrPage, Map<String, String> destination) {
        Document doc=ocrPage.getHocrDocument();
        save(doc,destination);
    }

}

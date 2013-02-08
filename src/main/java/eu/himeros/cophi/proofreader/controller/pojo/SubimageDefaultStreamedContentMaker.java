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

package eu.himeros.cophi.proofreader.controller.pojo;

import eu.himeros.cophi.proofreader.model.OcrCoords;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import org.primefaces.model.DefaultStreamedContent;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public class SubimageDefaultStreamedContentMaker extends SubimageMaker<DefaultStreamedContent> {
    BufferedImage pageImage;
    
    @Override
    public DefaultStreamedContent makeSubimage(Image pageImage, OcrCoords oc) {
        this.pageImage=(BufferedImage)pageImage;
        DefaultStreamedContent image = null;
        try {
            int[] coords = new int[]{oc.getX1(),oc.getY1(),oc.getX2(),oc.getY2()};
            BufferedImage bimg = ((BufferedImage)pageImage).getSubimage(coords[0], coords[1], coords[2] - coords[0], coords[3] - coords[1]);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bimg, "png", os);
            image = new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        return image;
    }

}

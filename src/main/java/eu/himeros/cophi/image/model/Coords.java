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

package eu.himeros.cophi.image.model;

import java.io.Serializable;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public interface Coords extends Serializable{
    
    /**
     * 
     * @return 
     */
    public int getX1();
    
    /**
     * 
     * @param x1 
     */
    public void setX1(int x1);
    
    /**
     * 
     * @return 
     */
    public int getY1();
    
    /**
     * 
     * @param y1 
     */
    public void setY1(int y1);
    
    /**
     * 
     * @return 
     */
    public int getX2();
    
    /**
     * 
     * @param x2 
     */
    public void setX2(int x2);
    
    /**
     * 
     * @return 
     */
    public int getY2();
    
    /**
     * 
     * @param y2 
     */
    public void setY2(int y2);    
    
}

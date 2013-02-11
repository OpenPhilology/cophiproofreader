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

package eu.himeros.cophi.text.model;

import eu.himeros.cophi.core.model.PhysicalComposite;
import eu.himeros.cophi.core.model.TextualUnit;
import java.util.List;

/**
 * Book is a physical composite of pages.
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public abstract class Book implements TextualUnit, PhysicalComposite<Page, List<Page>> {
    
    protected List<Page> pages;
    
    /**
     * Get the list of pages.
     * @return the list of pages.
     */
    @Override
    public List<Page> getChildren() {
        return pages;
    }

    /**
     * Set the list of pages.
     * @param pages the list of pages. 
     */
    @Override
    public void setChildren(List<Page> pages) {
        this.pages=pages;
    }

    /**
     * Return false.
     * @return false.
     */
    @Override
    public boolean isAtomic() {
        return atomic;
    }
    
}
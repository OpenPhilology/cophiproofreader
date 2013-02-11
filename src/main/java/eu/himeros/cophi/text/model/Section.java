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

import eu.himeros.cophi.core.model.LogicalComponent;
import eu.himeros.cophi.core.model.LogicalComposite;
import eu.himeros.cophi.core.model.TextualUnit;
import java.util.List;

/**
 * Logical partition of a textual unit;
 * Section can contain recoursively (sub)sections.
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public abstract class Section implements TextualUnit, LogicalComposite<LogicalComponent, List<LogicalComponent>> {

    protected List<LogicalComponent> components;
    protected String typeDescription;
    protected int level;
    
    /**
     * Get the list of logical components.
     * @return the list of logical components.
     */
    @Override
    public List<LogicalComponent> getChildren() {
        return components;
    }

    /**
     * Set the list of logical components.
     * @param components the list of logical components.
     */
    @Override
    public void setChildren(List<LogicalComponent> components) {
        this.components=components;
    }
    
    /*
     * Return false.
     */
    @Override
    public boolean isAtomic() {
        return atomic;
    }

    /**
     * Get the nesting level: section 0, subsection 1, subsubsection 2, etc.
     * @return the nesting level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the nesting level.
     * @param level the nesting level.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Get the type description. E.g.: section, or subsection, etc.
     * @return the type description.
     */
    public String getTypeDescription() {
        return typeDescription;
    }

    /**
     * Set the type description.
     * @param typeDescription the type description.
     */
    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }
    
    
    
}

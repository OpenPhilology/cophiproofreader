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

import java.util.Collection;

/**
 * A logical unit is based on one or more physical units.
 * A prototypical logical unit is a word, which is based on one or more tokens
 * (in case of hyphenation or in case of polyrematic lexemes).
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public interface LogicalUnit<T extends PhysicalUnit,C extends Collection<T>> extends Unit {
    
    /**
     * Get the single physical unit on which this logical unit is based.
     * @return the single physical unit on which this logical unit is based.
     */
    public T getPhysicalUnit();
    
    /**
     * Set the single physical unit on which this logical unit is based.
     * @param physicalUnit the physical unit on which this logical unit is based.
     */
    public void setPhysicalUnit(T physicalUnit);

    /**
     * Get the collection of physical units related to this logical unit.
     * @return the collection of physical units related to this logical unit.
     */
    public C getPhysicalUnits();
    
    /**
     * Set the collection of physical units related to this logical unit.
     * @param physicalUnits the collection of physical units related to this physical unit.
     */
    public void setPhysicalUnits(C physicalUnits);
    
    /**
     * Get true if is based on a single physical unit;
     * @return true if is based on a single physical unit (otherwise false).
     */
    public boolean isAtom();
    
    /**
     * Set true if is based on a single physical unit;
     * @param atom true if is based on a single physical unit (otherwise false).
     */
    public void setAtom(boolean atom);
    
}

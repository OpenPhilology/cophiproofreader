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

import eu.himeros.cophi.core.model.LogicalAtom;
import eu.himeros.cophi.core.model.PhysicalComponent;
import eu.himeros.cophi.core.model.TextualUnit;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public abstract class Word<T> implements TextualUnit, LogicalAtom<T> {

    protected PhysicalComponent backingComponent;
    protected T content;
    
    /**
     * Get the physical component this logical component is based on.
     * @return the backing component.
     */
    @Override
    public PhysicalComponent getBackingComponent() {
        return backingComponent;
    }

    /**
     * Set the physical component this logical component is based on.
     * @param backingComponent the backing component.
     */
    @Override
    public void setBackingComponent(PhysicalComponent backingComponent) {
        this.backingComponent=backingComponent;
    }

    /**
     * Get the content of this word. It can be a simple string, but it can be
     * a complex structures with linguistic analyses.
     * @return the content of this word.
     */
    @Override
    public T getContent() {
        return content;
    }

    /**
     * Set the content of this word.
     * @param content the content of this word.
     */
    @Override
    public void setContent(T content) {
        this.content=content;
    }

    /**
     * Return true.
     * @return true.
     */
    @Override
    public boolean isAtomic() {
        return atomic;
    }
    

}

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
import java.util.Collection;
import java.util.List;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public abstract class Line implements TextualUnit, PhysicalComposite<Token, List<Token>>{

    @Override
    public Collection<Token> getChildren() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setChildren(Collection<Token> collection) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isAtomic() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
}

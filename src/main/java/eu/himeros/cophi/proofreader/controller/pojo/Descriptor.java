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

import java.util.List;

/**
 *
 * @author federico[DOT]boschetti[DOT]73[AT]gmail[DOT]com
 */
public abstract class Descriptor<T1, T2, T3> {

    T1 repository;
    T2 filter;
    List<T3> references;

    public T1 getRepository() {
        return repository;
    }

    public void setRepository(T1 repository) {
        this.repository = repository;
    }

    public T2 getFilter() {
        return filter;
    }

    public void setFilter(T2 filter) {
        this.filter = filter;
    }

    public List<T3> getReferences() {
        return references;
    }

    public void setReferences(List<T3> references) {
        this.references = references;
    }
    
    public abstract void initRepository();
}

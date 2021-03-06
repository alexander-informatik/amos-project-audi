// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package de.osramos.ss13.proj1.model;

/*
 * #%L
 * proj1
 * %%
 * Copyright (C) 2013 Amos-Project
 * %%
 * Copyright (c) 2013 by Alexander Schmidt, Sascha Ströbel, Nina Aures, Riehle, http://dirkriehle.com
 * -
 * This file is part of the Amos Project - Productive Games application.
 * -
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * -
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * -
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 * #L%
 */

import de.osramos.ss13.proj1.model.Userdb;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Userdb_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Userdb.entityManager;
    
    public static final EntityManager Userdb.entityManager() {
        EntityManager em = new Userdb().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Userdb.countUserdbs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Userdb o", Long.class).getSingleResult();
    }
    
    public static List<Userdb> Userdb.findAllUserdbs() {
        return entityManager().createQuery("SELECT o FROM Userdb o", Userdb.class).getResultList();
    }
    
    public static Userdb Userdb.findUserdb(Long id) {
        if (id == null) return null;
        return entityManager().find(Userdb.class, id);
    }
    
    public static List<Userdb> Userdb.findUserdbEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Userdb o", Userdb.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Userdb.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Userdb.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Userdb attached = Userdb.findUserdb(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Userdb.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Userdb.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Userdb Userdb.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Userdb merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}

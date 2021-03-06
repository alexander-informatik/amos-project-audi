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

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public aspect Gpscoordinate_Methods {

	
	public static TypedQuery<Gpscoordinate> Gpscoordinate.findGpscoordinatesByRouteOrderedByOrderedPosition(Route route) {
        if (route == null) throw new IllegalArgumentException("The route argument is required");
        EntityManager em = Gpscoordinate.entityManager();
        TypedQuery<Gpscoordinate> q = em.createQuery("SELECT o FROM Gpscoordinate AS o WHERE o.route = :route ORDER BY orderedposition", Gpscoordinate.class);
        q.setParameter("route", route);
        return q;
    }
	
	
	
	public static Gpscoordinate Gpscoordinate.findFirstGpscoordinatesByRoute(Route route) {
        if (route == null) throw new IllegalArgumentException("The route argument is required");
        EntityManager em = Gpscoordinate.entityManager();
        TypedQuery<Gpscoordinate> q = em.createQuery("SELECT o FROM Gpscoordinate AS o WHERE o.route = :route ORDER BY orderedposition", Gpscoordinate.class);
        q.setParameter("route", route);
        q.setMaxResults(1);
        Gpscoordinate r = null;
        try
        {
        r = q.getSingleResult();
        }
        catch(Exception e)
        {
        	
        }
        return r;
    }
	
	public static Gpscoordinate Gpscoordinate.findLastGpscoordinatesByRouteReverseOrdered(Route route) {
        if (route == null) throw new IllegalArgumentException("The route argument is required");
        EntityManager em = Gpscoordinate.entityManager();
        TypedQuery<Gpscoordinate> q = em.createQuery("SELECT o FROM Gpscoordinate AS o WHERE o.route = :route ORDER BY orderedposition DESC", Gpscoordinate.class);
        q.setParameter("route", route);
        q.setMaxResults(1);
        Gpscoordinate r = null;
        try
        {
        r = q.getSingleResult();
        }
        catch(Exception e)
        {
        	
        }
        return r;
    }
	
}

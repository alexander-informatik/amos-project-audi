package de.osramos.ss13.proj1.web;

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

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

import de.osramos.ss13.proj1.model.Route;
import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.UserRole;

public aspect ApplicationConversionServiceFactoryBean_ConversionService {

	  declare @type: ApplicationConversionServiceFactoryBean: @Configurable;
	    
	    public Converter<Route, String> ApplicationConversionServiceFactoryBean.getRouteToStringConverter() {
	        return new org.springframework.core.convert.converter.Converter<de.osramos.ss13.proj1.model.Route, java.lang.String>() {
	            public String convert(Route route) {
	                return new StringBuilder().append(route.getStartpointName()).append(' ').append(route.getEndpointName()).toString();
	            }
	        };
	    }
	    
	    public Converter<Long, Route> ApplicationConversionServiceFactoryBean.getIdToRouteConverter() {
	        return new org.springframework.core.convert.converter.Converter<java.lang.Long, de.osramos.ss13.proj1.model.Route>() {
	            public de.osramos.ss13.proj1.model.Route convert(java.lang.Long id) {
	                return Route.findRoute(id);
	            }
	        };
	    }
	    
	    public Converter<String, Route> ApplicationConversionServiceFactoryBean.getStringToRouteConverter() {
	        return new org.springframework.core.convert.converter.Converter<java.lang.String, de.osramos.ss13.proj1.model.Route>() {
	            public de.osramos.ss13.proj1.model.Route convert(String id) {
	                return getObject().convert(getObject().convert(id, Long.class), Route.class);
	            }
	        };
	    }    

	    public Converter<UserRole, String> ApplicationConversionServiceFactoryBean.getUserRoleToStringConverter() {
	        return new org.springframework.core.convert.converter.Converter<de.osramos.ss13.proj1.model.UserRole, java.lang.String>() {
	            public String convert(UserRole role) {
	                return new StringBuilder().append(role.getRoleName()).toString();
	            }
	        };
	    }
	    
	    public Converter<Long, UserRole> ApplicationConversionServiceFactoryBean.getIdToUserRoleConverter() {
	        return new org.springframework.core.convert.converter.Converter<java.lang.Long, de.osramos.ss13.proj1.model.UserRole>() {
	            public de.osramos.ss13.proj1.model.UserRole convert(java.lang.Long id) {
	                return UserRole.findUserRole(id);
	            }
	        };
	    }
	    
	    public Converter<String, UserRole> ApplicationConversionServiceFactoryBean.getStringToUserRoleConverter() {
	        return new org.springframework.core.convert.converter.Converter<java.lang.String, de.osramos.ss13.proj1.model.UserRole>() {
	            public de.osramos.ss13.proj1.model.UserRole convert(String id) {
	                return getObject().convert(getObject().convert(id, Long.class), UserRole.class);
	            }
	        };
	    }
}



//registry.addConverter(getRouteToStringConverter());
//registry.addConverter(getIdToRouteConverter());
//registry.addConverter(getStringToRouteConverter());
//		registry.addConverter(getTaskdbToStringConverter());
//		registry.addConverter(getIdToTaskdbConverter());
//		registry.addConverter(getStringToTaskdbConverter());
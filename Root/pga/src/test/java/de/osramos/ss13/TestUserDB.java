/*
 * Copyright (c) 2013 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Amos SS13 Project - Productive Games Development (PGA) application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 * 
 * Software Developers in alphabetical order:
 * Nina Aures
 * Alexander Schmidt
 * Sascha Stroebel
 */


package de.osramos.ss13;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.osramos.ss13.Model.UserDB;

/**
 * Tests for {@link TestUserDB}.
 *
 * @author alexander.informatik@googlemail.com (Alexander Schmidt)
 */
@RunWith(JUnit4.class)
public class TestUserDB {

    @Test
    public void createUser() {
    	
    	final String firstname = "junit_Firstname";
    	final String lastname = "junit_Lastname";
    	final String username = "junit_Username";
    	final String password = "junit_Password";
    	
    	UserDB user = new UserDB();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setPassword(password);
        HibernateTools.save(user);
        
        long id = user.getId();
        user = null;
        
        user = HibernateTools.load(id, UserDB.class);

        assertEquals(firstname,user.getFirstname());
        assertEquals(lastname,user.getLastname());
        assertEquals(username,user.getUsername());
        assertEquals(password,user.getPassword());
        
        HibernateTools.delete(user);
    }

}

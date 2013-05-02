/*
 * Copyright (c) 2013 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Amos SS13 Project - Productive Games Development (PGA) rating application.
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

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;


public final class SignInSession extends AuthenticatedWebSession
{
    private String user;


    protected SignInSession(Request request)
    {
        super(request);
    }


    @Override
    public final boolean authenticate(final String username, final String password)
    {
        final String WICKET = "audi";

        if (user == null)
        {
            // Trivial password "db"
            if (WICKET.equalsIgnoreCase(username) && WICKET.equalsIgnoreCase(password))
            {
                user = username;
            }
        }

        return user != null;
    }


    public String getUser()
    {
        return user;
    }


    public void setUser(final String user)
    {
        this.user = user;
    }


    @Override
    public Roles getRoles()
    {
        return null;
    }
}


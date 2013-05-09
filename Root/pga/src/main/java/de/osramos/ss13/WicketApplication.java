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

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.RestartResponseAtInterceptPageException;
import org.apache.wicket.Session;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authorization.IAuthorizationStrategy;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.component.IRequestableComponent;

import de.osramos.ss13.Right.AuthenticatedWebPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see de.osramos.ss13.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.protocol.http.WebApplication#newSession(Request,
	 *      Response)
	 */
	@Override
	public Session newSession(Request request, Response response) {
		return new SignInSession(request);
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		getDebugSettings().setDevelopmentUtilitiesEnabled(true);


		// add your configuration here
		// Register the authorization strategy
		getSecuritySettings().setAuthorizationStrategy(
				new IAuthorizationStrategy() {
					public boolean isActionAuthorized(Component component,
							Action action) {
						// authorize everything
						return true;
					}

					public <T extends IRequestableComponent> boolean isInstantiationAuthorized(
							Class<T> componentClass) {
						// Check if the new Page requires authentication
						// (implements the marker interface)
						if (AuthenticatedWebPage.class
								.isAssignableFrom(componentClass)) {
							// Is user signed in?
							if (((SignInSession) Session.get()).isSignedIn()) {
								// okay to proceed
								return true;
							}

							// Intercept the request, but remember the target
							// for later.
							// Invoke Component.continueToOriginalDestination()
							// after successful logon to
							// continue with the target remembered.

							throw new RestartResponseAtInterceptPageException(
									SignIn.class);
						}

						// okay to proceed
						return true;
					}
				});

	}
}

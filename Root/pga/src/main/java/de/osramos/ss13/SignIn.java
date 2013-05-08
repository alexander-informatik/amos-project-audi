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

import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.util.value.ValueMap;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.ClientSideImageMap;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.link.PopupSettings;
import org.apache.wicket.markup.html.link.ResourceLink;
import org.apache.wicket.markup.html.pages.RedirectPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.parser.filter.RelativePathPrefixHandler;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.SharedResourceReference;
import org.apache.wicket.util.file.Files;
import org.apache.wicket.util.time.Duration;

/**
 * Simple example of a sign in page. Even simpler, as shown in the
 * authentication-2 example, is using the SignInPanel from the auth-role
 * package. Beside that this simple example does not support "rememberMe".
 * 
 * @author Jonathan Locke
 */
public final class SignIn extends WebPage {
	/**
	 * Constructor
	 */
	public SignIn(final PageParameters parameters) {
		// Create feedback panel and add to page
		add(new FeedbackPanel("feedback"));

		// Add sign-in form to page
		add(new SignInForm("signInForm"));
	}

	/**
	 * Sign in form
	 */
	public final class SignInForm extends Form<Void> {
		private static final String USERNAME = "username";
		private static final String PASSWORD = "password";

		// El-cheapo model for form
		private final ValueMap properties = new ValueMap();

		/**
		 * Constructor
		 * 
		 * @param id
		 *            id of the form component
		 */
		public SignInForm(final String id) {
			super(id);

			// Attach textfield components that edit properties map model
			add(new TextField<String>(USERNAME, new PropertyModel<String>(
					properties, USERNAME)));
			add(new PasswordTextField(PASSWORD, new PropertyModel<String>(
					properties, PASSWORD)));
		}

		/**
		 * @see org.apache.wicket.markup.html.form.Form#onSubmit()
		 */
		@Override
		public final void onSubmit() {
			// Get session info
			SignInSession session = getMySession();

			// Sign the user in
			if (session.signIn(getUsername(), getPassword())) {
				if (!continueToOriginalDestination()) {
					setResponsePage(getApplication().getHomePage());
				}
			} else {
				// Get the error message from the properties file associated
				// with the Component
				String errmsg = getString("loginError", null,
						"Unable to sign you in");

				// Register the error message with the feedback panel
				error(errmsg);
			}
		}

		/**
		 * @return
		 */
		private String getPassword() {
			return properties.getString(PASSWORD);
		}

		/**
		 * @return
		 */
		private String getUsername() {
			return properties.getString(USERNAME);
		}

		/**
		 * @return
		 */
		private SignInSession getMySession() {
			return (SignInSession) getSession();
		}
	}
}

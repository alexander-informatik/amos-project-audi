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


package de.osramos.ss13.Admin;
import java.util.Arrays;
import java.util.List;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.util.value.ValueMap;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.wicket.Component;
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

import org.apache.wicket.request.resource.PackageResourceReference;
import org.apache.wicket.request.resource.SharedResourceReference;
import org.apache.wicket.util.file.Files;
import org.apache.wicket.util.time.Duration;

import org.apache.wicket.markup.html.form.DropDownChoice;

import de.osramos.ss13.HibernateTools;
import de.osramos.ss13.Model.UserDB;



public final class RegistrationPage extends WebPage implements de.osramos.ss13.Right.Admin
{
    private static final List<String> ROLES = Arrays.asList(new String[] {"Admin", "Senior", "Trainee" });
 
    //make Google selected by default
    private String selected = "Trainee";
 
    //make Trainee selected by default

    private String message;

    /**
     * Constructor
     */
    public RegistrationPage(final PageParameters parameters) 
    {
        DropDownChoice<String> listSites = new DropDownChoice<String>("roles", new PropertyModel<String>(this, "selected"), ROLES);
        PropertyModel<String> messageModel = new PropertyModel<String>(this, "message");
        add(new FeedbackPanel("feedback"));
        Label label = new Label("message", messageModel);
        label.setEscapeModelStrings(false);
        add(label);

        Form<?> form = new RegisterForm("form");
        add(form);
        form.add(listSites);
    }

    /**
     * Sign in form
     */
    public final class RegisterForm extends Form<Void>
    {
        private static final String FIRSTNAME = "firstname";
        private static final String LASTNAME = "lastname";
        private static final String USERNAME = "username";
        private static final String PASSWORD = "password";
        private static final String PASSWORD2 = "password2";

        // El-cheapo model for form
        private final ValueMap properties = new ValueMap();

        /**
         * Constructor
         * 
         * @param id
         *            id of the form component
         */
        public RegisterForm(final String id)
        {
            super(id);

            // Attach textfield components that edit properties map model
            add(new TextField<String>(FIRSTNAME, new PropertyModel<String>(properties, FIRSTNAME)));
            add(new TextField<String>(LASTNAME, new PropertyModel<String>(properties, LASTNAME)));
            add(new TextField<String>(USERNAME, new PropertyModel<String>(properties, USERNAME)));
            add(new PasswordTextField(PASSWORD, new PropertyModel<String>(properties, PASSWORD)));
            add(new PasswordTextField(PASSWORD2, new PropertyModel<String>(properties, PASSWORD2)));
            
        }

        /**
         * @see org.apache.wicket.markup.html.form.Form#onSubmit()
         */
        @Override
        public final void onSubmit()
        {
            message = "";
            if(getFirstname()==null){
                message = "firstname is missing <br />";
            }
            if(getLastname()==null){
                message = message + "lastname is missing <br />";
            }
            if(getUsername()==null){
                message = message + "username is missing <br />";
            }
            if(getPassword()==null){
                message = message + "password is missing <br />";
            }
            if(getPassword2()==null){
                message = message + "re-type password is missing <br />";
            }
            if(!getPassword().equals(getPassword2())){
                message = message + "passwords not matching";
            }
            if(message ==""){
                UserDB user = new UserDB();
                user.setFirstname(getFirstname());
                user.setLastname(getLastname());
                user.setUsername(getUsername());
                user.setPassword(getPassword());
                user.setRole("test");
                HibernateTools.save(user);
                
                message = "success!";
            }
                
        }

        /**
         * @return
         */
        private String getLastname()
        {
            return properties.getString(LASTNAME);
        }

        /**
         * @return
         */
        private String getFirstname()
        {
            return properties.getString(FIRSTNAME);
        }

        /**
         * @return
         */
        private String getUsername()
        {
            return properties.getString(USERNAME);
        }

        /**
         * @return
         */
        private String getPassword()
        {
            return properties.getString(PASSWORD);
        }/**
         * @return
         */
        private String getPassword2()
        {
            return properties.getString(PASSWORD2);
        }
        
        
        
    }
}


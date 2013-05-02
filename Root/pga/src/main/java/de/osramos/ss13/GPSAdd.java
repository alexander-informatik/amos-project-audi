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

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class GPSAdd extends WebPage {
	private static final long serialVersionUID = 1L;

private String gpscoordinate;

    public GPSAdd(final PageParameters parameters) {
        // TODO Add your page's components here
        
        PropertyModel<String> gpscoordinateModel = new PropertyModel<String>(this, "gpscoordinate");
        add(new Label("lastgpscoordinate", gpscoordinateModel));


        Form<?> form = new Form("form");
        form.add(new TextField<String>("gpscoordinate", gpscoordinateModel));
        add(form);
        
        
    }
    
    
    
     /**
     * @return the message
     */
    public String getGpscoordinate()
    {
        return gpscoordinate;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setGpscoordinate(String gpscoordinate)
    {
        this.gpscoordinate = gpscoordinate;
    }
    
    
}

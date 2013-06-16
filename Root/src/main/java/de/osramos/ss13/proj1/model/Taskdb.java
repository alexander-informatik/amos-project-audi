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

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = {"findTaskdbsByTrainee", "findTaskdbsById",
		"findTaskdbsByPersonEquals"})
public class Taskdb {

	@NotNull
	private String taskname;

	@NotNull
	private String description;

	@NotNull
	private String person;

	@NotNull
	private String personfunction;

	@NotNull
	private String building;

	@NotNull
	private String roomno;

	@ManyToOne
	private Userdb trainee;

	@ManyToOne
	private Userdb senior;

	@ManyToOne
	private Route route;

	@Pattern(regexp = "(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_Start;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_1;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_2;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_3;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_4;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_5;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_6;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_7;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_8;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_9;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_10;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_11;

	@Pattern(regexp = "^$|(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_12;

	@Pattern(regexp = "(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+", message = "Please enter GPS Coordinates in Google Format: two floating point numbers seperated by a comma for longitude and latitude")
	private String gps_End;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date timeslot;
}

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

import org.springframework.roo.addon.dod.RooDataOnDemand;

@RooDataOnDemand(entity = Taskdb.class)
public class TaskdbDataOnDemand {

	public void setGps_1(Taskdb obj, int index) {
		String gps_1 = "1.0," + index + ".1";
		obj.setGps_1(gps_1);
	}

	public void setGps_2(Taskdb obj, int index) {
		String gps_2 = "2.0," + index + ".1";
		obj.setGps_2(gps_2);
	}

	public void setGps_3(Taskdb obj, int index) {
		String gps_3 = "3.0," + index + ".1";
		obj.setGps_3(gps_3);
	}

	public void setGps_4(Taskdb obj, int index) {
		String gps_4 = "4.0," + index + ".1";
		obj.setGps_4(gps_4);
	}

	public void setGps_5(Taskdb obj, int index) {
		String gps_5 = "5.0," + index + ".1";
		obj.setGps_5(gps_5);
	}

	public void setGps_6(Taskdb obj, int index) {
		String gps_6 = "6.0," + index + ".1";
		obj.setGps_6(gps_6);
	}

	public void setGps_7(Taskdb obj, int index) {
		String gps_7 = "7.0," + index + ".1";
		obj.setGps_7(gps_7);
	}

	public void setGps_8(Taskdb obj, int index) {
		String gps_8 = "8.0," + index + ".1";
		obj.setGps_8(gps_8);
	}

	public void setGps_9(Taskdb obj, int index) {
		String gps_9 = "9.0," + index + ".1";
		obj.setGps_9(gps_9);
	}

	public void setGps_10(Taskdb obj, int index) {
		String gps_10 = "10.0," + index + ".1";
		obj.setGps_10(gps_10);
	}

	public void setGps_11(Taskdb obj, int index) {
		String gps_11 = "11.0," + index + ".1";
		obj.setGps_11(gps_11);
	}

	public void setGps_12(Taskdb obj, int index) {
		String gps_12 = "12.0," + index + ".1";
		obj.setGps_12(gps_12);
	}

	public void setGps_End(Taskdb obj, int index) {
		String gps_End = "99.0," + index + ".1";
		obj.setGps_End(gps_End);
	}

	public void setGps_Start(Taskdb obj, int index) {
		String gps_Start = "0.0," + index + ".1";
		obj.setGps_Start(gps_Start);
	}
}

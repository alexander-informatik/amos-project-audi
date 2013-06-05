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

import java.util.HashSet;
import java.util.Set;

import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.Userdb;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class FirstRun implements ApplicationListener<ContextRefreshedEvent> {
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		PopulateDatabase();

	}

	static public void PopulateDatabase() {
		//		Userdb trainee = new Userdb();
		//		trainee.setFirstname("traineefirst");
		//		trainee.setLastname("traineelast");
		//		trainee.setPassword("traineepw");
		//		trainee.setUsername("trainee");
		//		trainee.setUserrole("trainee");
		//		trainee.persist();
		//		
		//		Userdb admin = new Userdb();
		//		admin.setFirstname("adminfirst");
		//		admin.setLastname("adminlast");
		//		admin.setPassword("adminpw");
		//		admin.setUsername("admin");
		//		admin.setUserrole("admin");
		//		admin.persist();
		//		
		//		Userdb senior = new Userdb();
		//		senior.setFirstname("seniorfirst");
		//		senior.setLastname("seniorlast");
		//		senior.setPassword("seniorpw");
		//		senior.setUsername("senior");
		//		senior.setUserrole("senior");
		//		senior.persist();
		//		
		//	
		//		
		//		Taskdb t1 = new Taskdb();
		//		t1.setPerson("Mr. Bond");
		//		t1.setBuilding("Building ??");
		//		t1.setPersonfunction("Function 007");
		//		t1.setRoomno("007");
		//		t1.setTaskname("Your first mission");
		//		t1.setTrainee(trainee);
		//		
		//
		//		t1.persist();
		//		
		//		Taskdb t2 = new Taskdb();
		//		t2.setPerson("Mr. Powers");
		//		t2.setBuilding("Club X");
		//		t2.setPersonfunction("Function uncertain");
		//		t2.setRoomno("no number");
		//		t2.setTaskname("Your punishment");
		//		t2.setTrainee(trainee);
		//		
		//
		//		t2.persist();

	}
}

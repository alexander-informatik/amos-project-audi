package de.osramos.ss13.proj1.services;

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
import org.springframework.context.event.ContextStartedEvent;

public class FirstRun implements ApplicationListener<ContextRefreshedEvent> {
	static boolean first = true;
	public synchronized void onApplicationEvent(ContextRefreshedEvent context) {
		if (first) {
			first = false;
			PopulateDatabase();
		}
	}

	public void PopulateDatabase() {
		// populate with default usernames and passwords
		CreateUsers();

		// create example tasks
		createTasks();

	}

	private void CreateUsers() {
		Userdb user = null;

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("admin")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = new Userdb();
					user.setFirstname("admin");
					user.setLastname("ADMIN");
					user.setUsername("admin");
					user.setUserrole("admin");
					user.setPassword("admin");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("senior")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = new Userdb();
					user.setFirstname("senior");
					user.setLastname("SENIOR");
					user.setUsername("senior");
					user.setUserrole("senior");
					user.setPassword("senior");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("trainee")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("trainee");
					user.setLastname("TRAINEE");
					user.setUsername("trainee");
					user.setUserrole("trainee");
					user.setPassword("trainee");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

	}

	private void createTasks() {
		Userdb trainee = Userdb.findUserdbsByUsernameEquals("trainee")
				.getSingleResult();
		Userdb senior = Userdb.findUserdbsByUsernameEquals("senior")
				.getSingleResult();
		Taskdb t = null;

		t = new Taskdb();
		t.setDescription("description A");
		t.setPerson("Mr. Bond");
		t.setBuilding("Building ??");
		t.setPersonfunction("Function 007");
		t.setRoomno("007");
		t.setTaskname("Your first mission");
		t.setTrainee(trainee);
		t.setSenior(senior);
		t.setGps_Start("51.522416,-0.069551");
		t.setGps_End("51.500194,-0.057192");
		t.persist();

		t = new Taskdb();
		t.setDescription("description B");
		t.setPerson("Mr. Powers");
		t.setBuilding("Club X");
		t.setPersonfunction("Function uncertain");
		t.setRoomno("no number");
		t.setTaskname("Your punishment");
		t.setTrainee(trainee);
		t.setSenior(senior);
		t.setGps_Start("55.841205,-4.232883");
		t.setGps_End("55.815365,-4.242496");
		t.persist();
	}
}

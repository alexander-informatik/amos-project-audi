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

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import de.osramos.ss13.proj1.model.Gpscoordinate;
import de.osramos.ss13.proj1.model.Route;
import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.UserRole;
import de.osramos.ss13.proj1.model.Userdb;

public class FirstRun implements ApplicationListener<ContextRefreshedEvent> {
	static boolean first = true;
	public synchronized void onApplicationEvent(ContextRefreshedEvent context) {
		if (first) {
			first = false;
			PopulateDatabase();
		}
	}

	public void PopulateDatabase() {
		// create userroles
		createUserRoles();

		// populate with default usernames and passwords
		CreateUsers();

		// create sample routes
		createRoutes();

		// create example tasks
		createTasks();

		// only for demo day
		//createDemoDayData1();
		createDemoDayData();

	}

	private void createUserRoles() {
		UserRole role = null;

		try {
			role = null;
			role = UserRole.findUserRolesByRoleNameEquals("admin")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == role) {
					role = new UserRole();
					role.setRoleName("admin");
					role.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			role = null;
			role = UserRole.findUserRolesByRoleNameEquals("senior")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == role) {
					role = new UserRole();
					role.setRoleName("senior");
					role.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			role = null;
			role = UserRole.findUserRolesByRoleNameEquals("trainee")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == role) {
					role = new UserRole();
					role.setRoleName("trainee");
					role.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			role = null;
			role = UserRole.findUserRolesByRoleNameEquals("developer")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == role) {
					role = new UserRole();
					role.setRoleName("developer");
					role.persist();
				}
			} catch (Exception e) {
			}
		}

	}

	private void CreateUsers() {
		Userdb user = null;
		UserRole roleAdmin = UserRole.findUserRolesByRoleNameEquals("admin")
				.getSingleResult();
		UserRole roleSenior = UserRole.findUserRolesByRoleNameEquals("senior")
				.getSingleResult();
		UserRole roleTrainee = UserRole
				.findUserRolesByRoleNameEquals("trainee").getSingleResult();
		UserRole roleDeveloper = UserRole.findUserRolesByRoleNameEquals(
				"developer").getSingleResult();

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("all").getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = new Userdb();
					user.setFirstname("Developer");
					user.setLastname("DEVELOPER");
					user.setUsername("all");
					user.setUserrole(roleDeveloper);
					user.setPassword("all");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

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
					user.setUserrole(roleAdmin);
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
					user.setUserrole(roleSenior);
					user.setPassword("senior");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("testsenior")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = new Userdb();
					user.setFirstname("testsenior");
					user.setLastname("TESTSENIOR");
					user.setUsername("testsenior");
					user.setUserrole(roleSenior);
					user.setPassword("testsenior");
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
					user.setUserrole(roleTrainee);
					user.setPassword("trainee");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("maxmus")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("Max");
					user.setLastname("MUSTERMANN");
					user.setUsername("maxmus");
					user.setUserrole(roleTrainee);
					user.setPassword("maxmus");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("tobsch")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("Tobias");
					user.setLastname("SCHULZ");
					user.setUsername("tobsch");
					user.setUserrole(roleSenior);
					user.setPassword("tobsch");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("manmei")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("Manuel");
					user.setLastname("MEIER");
					user.setUsername("manmei");
					user.setUserrole(roleAdmin);
					user.setPassword("manmei");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("axesch")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("Axel");
					user.setLastname("SCHULZ");
					user.setUsername("axesch");
					user.setUserrole(roleTrainee);
					user.setPassword("axesch");
					user.persist();
				}
			} catch (Exception e) {
			}
		}

	}

	private void createTasks() {
		Userdb all = Userdb.findUserdbsByUsernameEquals("all")
				.getSingleResult();
		Userdb trainee = Userdb.findUserdbsByUsernameEquals("trainee")
				.getSingleResult();
		Userdb senior = Userdb.findUserdbsByUsernameEquals("senior")
				.getSingleResult();
		Userdb testsenior = Userdb.findUserdbsByUsernameEquals("testsenior")
				.getSingleResult();
		Userdb maxmus = Userdb.findUserdbsByUsernameEquals("maxmus")
				.getSingleResult();
		Userdb tobsch = Userdb.findUserdbsByUsernameEquals("tobsch")
				.getSingleResult();
		Route route = Route.findAllRoutes().get(0);
		Route route1 = Route.findAllRoutes().get(1);
		System.out.println("route" + route.getStartpointName());
		Taskdb t = null;

		t = new Taskdb();
		t.setDescription("description A");
		t.setPerson("Mr. Bond");
		t.setBuilding("Building ??");
		t.setPersonfunction("Function 007");
		t.setRoomno("007");
		t.setTaskname("Your first mission");
		t.setTrainee(all);
		t.setSenior(all);
		t.setMap(route);
		t.setQuestionForcompletionPassword("secret question");
		t.setCompletionPassword("secret");
		t.persist();

		t = new Taskdb();
		t.setDescription("description B");
		t.setPerson("Mr. Powers");
		t.setBuilding("Club X");
		t.setPersonfunction("Function uncertain");
		t.setRoomno("no number");
		t.setTaskname("Your punishment");
		t.setTrainee(all);
		t.setSenior(all);
		t.setMap(route1);
		t.setQuestionForcompletionPassword("secret question");
		t.setCompletionPassword("secret");
		t.persist();

		t = new Taskdb();
		t.setDescription("description C");
		t.setPerson("Mr. C");
		t.setBuilding("Building C");
		t.setPersonfunction("Function C");
		t.setRoomno("Room C");
		t.setTaskname("Task C");
		t.setTrainee(trainee);
		t.setSenior(testsenior);
		t.setQuestionForcompletionPassword("secret question");
		t.setCompletionPassword("secret");
		t.persist();

		t = new Taskdb();
		t.setDescription("Find the Cafeteria");
		t.setPerson("-");
		t.setBuilding("Building D1");
		t.setPersonfunction("-");
		t.setRoomno("-");
		t.setTaskname("What is the main dish of today?");
		t.setTrainee(maxmus);
		t.setSenior(senior);
		t.setQuestionForcompletionPassword("name of main dish?");
		t.setCompletionPassword("fish");
		t.persist();

		t = new Taskdb();
		t.setDescription("Get to know the HR department");
		t.setPerson("Manuel Meier");
		t.setBuilding("Building C2");
		t.setPersonfunction("Recruiter");
		t.setRoomno("01.231");
		t.setTaskname("Ask Manuel Meier for his favorite color");
		t.setTrainee(maxmus);
		t.setSenior(tobsch);
		t.setQuestionForcompletionPassword("favourite color?");
		t.setCompletionPassword("red");
		t.persist();

		t = new Taskdb();
		t.setDescription("Use the bus shuttle");
		t.setPerson("-");
		t.setBuilding("-");
		t.setPersonfunction("-");
		t.setRoomno("-");
		t
				.setTaskname("Take the bus shuttle from A to B. Ask the driver for his name when you get out.");
		t.setTrainee(maxmus);
		t.setSenior(tobsch);
		t.setQuestionForcompletionPassword("driver's name?");
		t.setCompletionPassword("Dorothy Harris");
		t.persist();

	}

	private void createRoutes() {
		Route r = null;

		r = new Route();
		r.setStartpointName("Building A1");
		r.setEndpointName("Building B2");
		r.persist();

		r = new Route();
		r.setStartpointName("Building X");
		r.setEndpointName("Building Z");
		r.persist();
	}

	private void createDemoDayData1() {
		Userdb user = null;
		Taskdb t = null;
		Route r = null;
		Gpscoordinate gps = null;

		Userdb userAlex = null;
		Userdb userAlexSenior = null;
		Route routeH6 = null;
		Route routeMensa = null;
		Route routeTower = null;
		UserRole roleAdmin = UserRole.findUserRolesByRoleNameEquals("admin")
				.getSingleResult();
		UserRole roleSenior = UserRole.findUserRolesByRoleNameEquals("senior")
				.getSingleResult();
		UserRole roleTrainee = UserRole
				.findUserRolesByRoleNameEquals("trainee").getSingleResult();

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("alex").getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("Alexander");
					user.setLastname("Schmidt");
					user.setUsername("alex");
					user.setUserrole(roleTrainee);
					user.setPassword("alex");
					user.persist();
				}
			} catch (Exception e) {
			}
		}
		userAlex = user;

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("cipadmin")
					.getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("cip");
					user.setLastname("admin");
					user.setUsername("cip");
					user.setUserrole(roleSenior);
					user.setPassword("cip");
					user.persist();
				}
			} catch (Exception e) {
			}
		}
		userAlexSenior = user;

		r = new Route();
		r.setStartpointName("Lecture Hall 6");
		r.setEndpointName("Lecture Hall 6");
		r.persist();
		gps = new Gpscoordinate();
		gps.setLatitude("49.573168");
		gps.setLongitude("11.028511");
		gps.setOrderedposition(0);
		gps.setRoute(r);
		gps.persist();

		gps = new Gpscoordinate();
		gps.setLatitude("49.573152");
		gps.setLongitude("11.028981");
		gps.setOrderedposition(1);
		gps.setRoute(r);
		gps.persist();
		routeH6 = r;

		r = new Route();
		r.setStartpointName("Mensa South");
		r.setEndpointName("Mensa South");
		r.persist();
		gps = new Gpscoordinate();
		gps.setLatitude("49.574363");
		gps.setLongitude("11.029381");
		gps.setOrderedposition(0);
		gps.setRoute(r);
		gps.persist();

		gps = new Gpscoordinate();
		gps.setLatitude("49.575103");
		gps.setLongitude("11.030055");
		gps.setOrderedposition(1);
		gps.setRoute(r);
		gps.persist();
		routeMensa = r;

		r = new Route();
		r.setStartpointName("Computer Science Tower");
		r.setEndpointName("Computer Science Tower");
		r.persist();
		gps = new Gpscoordinate();
		gps.setLatitude("49.573168");
		gps.setLongitude("11.028511");
		gps.setOrderedposition(0);
		gps.setRoute(r);
		gps.persist();

		gps = new Gpscoordinate();
		gps.setLatitude("49.573152");
		gps.setLongitude("11.028981");
		gps.setOrderedposition(1);
		gps.setRoute(r);
		gps.persist();
		routeTower = r;

		t = new Taskdb();
		t
				.setDescription("Attend the welcome ceremony on your first day (Wednesday17th July) in lecture hall H6.");
		t.setPerson("Prof.Dr. Dirk Riehle");
		t
				.setBuilding("Electrical Engineering Building, Cauerstraße 7/9, 91058 Erlangen");
		t.setPersonfunction("Lecturer");
		t.setRoomno("Lecture hall H6");
		t.setTaskname("My First Day 1 of 3");
		t.setTrainee(userAlex);
		t.setSenior(userAlexSenior);
		t.setQuestionForcompletionPassword("number of seats?");
		t.setCompletionPassword("42");
		t.setMap(routeH6);
		t.persist();

		t = new Taskdb();
		t.setDescription("Enjoy lunch in the south canteen.");
		t.setBuilding("Mensa South at the Red Square, 91058 Erlangen");
		t.setTaskname("My First Day 2 of 3");
		t.setTrainee(userAlex);
		t.setSenior(userAlexSenior);
		t.setQuestionForcompletionPassword("main dish?");
		t.setCompletionPassword("fish");
		t.setMap(routeMensa);
		t.persist();

		t = new Taskdb();
		t
				.setDescription("To bring the day to a successful end, visit the computer science CIP admin in his room and register for a login.");
		t.setPerson("Mr. Cip-Admin");
		t
				.setBuilding("Computer Science Tower, Martensstraße 3, 91058 Erlangen");
		t.setPersonfunction("cipadmin");
		t.setRoomno("cip 1");
		t.setTaskname("My First Day 3 of 3");
		t.setTrainee(userAlex);
		t.setSenior(userAlexSenior);
		t.setQuestionForcompletionPassword("number of personal computers");
		t.setCompletionPassword("42");
		t.setMap(routeTower);
		t.persist();

	}

	private void createDemoDayData() {
		Userdb user = null;
		Taskdb t = null;
		Route r = null;
		Gpscoordinate gps = null;

		Userdb userAlex = null;
		Userdb userAlexSenior = null;
		Route routeAudimax = null;
		Route routeMensa = null;
		Route routeTower = null;
		UserRole roleAdmin = UserRole.findUserRolesByRoleNameEquals("admin")
				.getSingleResult();
		UserRole roleSenior = UserRole.findUserRolesByRoleNameEquals("senior")
				.getSingleResult();
		UserRole roleTrainee = UserRole
				.findUserRolesByRoleNameEquals("trainee").getSingleResult();

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("alex").getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("Alexander");
					user.setLastname("Schmidt");
					user.setUsername("alex");
					user.setUserrole(roleTrainee);
					user.setPassword("alex");
					user.persist();
				}
			} catch (Exception e) {
			}
		}
		userAlex = user;

		try {
			user = null;
			user = Userdb.findUserdbsByUsernameEquals("cip").getSingleResult();
		} catch (Exception e) {
		} finally {
			try {
				if (null == user) {
					user = null;
					user = new Userdb();
					user.setFirstname("Rolf");
					user.setLastname("Weber");
					user.setUsername("cip");
					user.setUserrole(roleSenior);
					user.setPassword("cip");
					user.persist();
				}
			} catch (Exception e) {
			}
		}
		userAlexSenior = user;

		r = new Route();
		r.setStartpointName("Hugenottenplatz");
		r.setEndpointName("Auditorium Maximum (Audimax)");
		r.persist();
		addGps("49.596573,11.004223", r, 0);
		addGps("49.598266,11.015354", r, 1);
		addGps("49.598527,11.01551", r, 2);
		addGps("49.600294,11.014818", r, 3);
		addGps("49.600377,11.01507", r, 4);
		addGps("49.600262,11.015799", r, 5);
		addGps("49.600503,11.015864", r, 6);
		addGps("49.60066,11.015638", r, 7); // finish
		routeAudimax = r;

		r = new Route();
		r.setStartpointName("Auditorium Maximum (Audimax)");
		r.setEndpointName("Canteen at Langemarckplatz");
		r.persist();
		addGps("49.600239,11.015927", r, 0);
		addGps("49.600357,11.015112", r, 1);
		addGps("49.598549,11.015616", r, 2);
		addGps("49.598327,11.016056", r, 3);
		addGps("49.598069,11.015766", r, 4);
		addGps("49.596887,11.015841", r, 5);
		addGps("49.596602,11.013309", r, 6);
		addGps("49.595823,11.013524", r, 7);
		addGps("49.595615,11.012236", r, 8);
		addGps("49.594259,11.011185", r, 9);
		addGps("49.594099,11.010745", r, 10);
		addGps("49.59347, 11.01028", r, 11); // finish
		routeMensa = r;

		r = new Route();
		r.setStartpointName("Canteen at Langemarckplatz");
		r.setEndpointName("Computer Science Tower Room 00.157-113");
		r.persist();
		addGps("49.592888,11.010194", r, 0);
		addGps("49.590382,11.011486", r, 1);
		addGps("49.589698,11.012237", r, 2);
		addGps("49.58915,11.012463", r, 3);
		addGps("49.584366,11.01308", r, 4);
		addGps("49.581897,11.012779", r, 5);
		addGps("49.581704,11.01735", r, 6);
		addGps("49.577816,11.01626", r, 7);
		addGps("49.577802,11.016786", r, 8);
		addGps("49.577788,11.018019", r, 9);
		addGps("49.576953,11.018395", r, 10);
		addGps("49.57632,11.019157", r, 11);
		addGps("49.57609,11.019983", r, 12);
		addGps("49.576146,11.02082", r, 13);
		addGps("49.573461,11.024103", r, 14);
		addGps("49.572974,11.02495", r, 15);
		addGps("49.573843,11.026538", r, 16);
		addGps("49.573674,11.02685", r, 17);
		addGps("49.573851,11.027068", r, 18);
		routeTower = r;

		t = new Taskdb();
		t
				.setDescription("Attend the welcome ceremony on your first day (Wednesday17th July) in the Audimax.");
		t.setPerson("Prorektorin Prof. Haberer");
		t
				.setBuilding("Auditorium Maximum (Audimax), Bismarckstraße 1, 92054 Erlangen");
		t.setPersonfunction("Lecturer");
		t.setRoomno("");
		t.setTaskname("My First Day 1 of 3");
		t.setTrainee(userAlex);
		t.setSenior(userAlexSenior);
		t.setQuestionForcompletionPassword("number of seats?");
		t.setCompletionPassword("42");
		t.setMap(routeAudimax);
		t.setTaskDone(false);
		t.persist();

		t = new Taskdb();
		t.setDescription("Enjoy lunch in the Canteen at Langemarckplatz.");
		t.setBuilding("Canteen at Langemarckplatz, 91054 Erlangen");
		t.setTaskname("My First Day 2 of 3");
		t.setTrainee(userAlex);
		t.setSenior(userAlexSenior);
		t.setQuestionForcompletionPassword("main dish?");
		t.setCompletionPassword("fish");
		t.setMap(routeMensa);
		t.setTaskDone(false);
		t.persist();

		t = new Taskdb();
		t
				.setDescription("To bring the day to a successful end, visit the computer science CIP admin in his room and register for a login.");
		t.setPerson("Rolf Weber");
		t
				.setBuilding("Computer Science Tower, Martensstraße 3, 91058 Erlangen");
		t.setPersonfunction("CIP Pool Admin");
		t.setRoomno("Room 00.157-113");
		t.setTaskname("My First Day 3 of 3");
		t.setTrainee(userAlex);
		t.setSenior(userAlexSenior);
		t.setQuestionForcompletionPassword("number of personal computers");
		t.setCompletionPassword("42");
		t.setMap(routeTower);
		t.setTaskDone(false);
		t.persist();

	}

	private void addGps(String LatLong, Route r, int order) {
		String ll[] = LatLong.split(",");

		if (ll.length == 2) {
			Gpscoordinate gps = new Gpscoordinate();
			gps.setLatitude(ll[0]);
			gps.setLongitude(ll[1]);
			gps.setOrderedposition(order);
			gps.setRoute(r);
			gps.persist();
		} else {
			System.out.println("addGps(): cannot parse: " + LatLong);
		}
	}
}

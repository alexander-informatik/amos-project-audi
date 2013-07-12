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
}

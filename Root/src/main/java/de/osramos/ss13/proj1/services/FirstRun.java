package de.osramos.ss13.proj1.services;

import java.util.HashSet;
import java.util.Set;

import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.Userdb;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;

public class FirstRun implements ApplicationListener<ContextRefreshedEvent>{
	static boolean first = true;
    public synchronized void onApplicationEvent(ContextRefreshedEvent context ) {
    	if(first)
    	{
    		first= false;
    		PopulateDatabase();
    	}
    }

	
    
    

	public void PopulateDatabase()
	{
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
		Userdb trainee = Userdb.findUserdbsByUsernameEquals("trainee").getSingleResult();

		Taskdb t = null;
		
		t = new Taskdb();
		t.setPerson("Mr. Bond");
		t.setBuilding("Building ??");
		t.setPersonfunction("Function 007");
		t.setRoomno("007");
		t.setTaskname("Your first mission");
		t.setTrainee(trainee);
		t.setGps_Start("51.522416,-0.069551");
		t.setGps_End("51.500194,-0.057192");
		t.persist();
		
		t = new Taskdb();
		t.setPerson("Mr. Powers");
		t.setBuilding("Club X");
		t.setPersonfunction("Function uncertain");
		t.setRoomno("no number");
		t.setTaskname("Your punishment");
		t.setTrainee(trainee);
		t.setGps_Start("55.841205,-4.232883");
		t.setGps_End("55.815365,-4.242496");
		t.persist();
	}
}

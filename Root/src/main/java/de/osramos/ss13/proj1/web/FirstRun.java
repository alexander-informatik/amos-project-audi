package de.osramos.ss13.proj1.web;

import java.util.HashSet;
import java.util.Set;

import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.Userdb;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class FirstRun implements ApplicationListener<ContextRefreshedEvent>{
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent ) {
    	PopulateDatabase();

    }

	

	static public void PopulateDatabase()
	{
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

package de.osramos.ss13.proj1.web;

import java.util.HashSet;
import java.util.Set;

import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.Taskdbgps;
import de.osramos.ss13.proj1.model.Userdb;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class FirstRun implements ApplicationListener<ContextRefreshedEvent>{
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent ) {
    	PopulateDatabase();

    }

	

	static public void PopulateDatabase()
	{
		Userdb trainee = new Userdb();
		trainee.setFirstname("traineefirst");
		trainee.setLastname("traineelast");
		trainee.setPassword("traineepw");
		trainee.setUsername("trainee");
		trainee.setUserrole("trainee");
		
		Userdb admin = new Userdb();
		admin.setFirstname("adminfirst");
		admin.setLastname("adminlast");
		admin.setPassword("adminpw");
		admin.setUsername("admin");
		admin.setUserrole("admin");
		
		Userdb senior = new Userdb();
		senior.setFirstname("seniorfirst");
		senior.setLastname("seniorlast");
		senior.setPassword("seniorpw");
		senior.setUsername("senior");
		senior.setUserrole("senior");
		
		Taskdbgps gps = null;
		
		Taskdb t1 = new Taskdb();
		t1.setPerson("Mr. Bond");
		t1.setBuilding("Building ??");
		t1.setPersonfunction("Function 007");
		t1.setRoomno("007");
		t1.setTaskname("Your first mission");
		t1.setTrainee(trainee);
		
			Set<Taskdbgps> t1gps = new HashSet<Taskdbgps>();
			gps = new Taskdbgps();
			gps.setTask(t1);
			gps.setPos(1L);
			gps.setGpscoordinate("0.7,0.7");
			t1gps.add(gps);
			gps = new Taskdbgps();
			gps.setTask(t1);
			gps.setPos(2L);
			gps.setGpscoordinate("0.8,0.8");
			t1gps.add(gps);
			
			t1.setTaskdbgps(t1gps);
		
		
		Taskdb t2 = new Taskdb();
		t2.setPerson("Mr. Powers");
		t2.setBuilding("Club X");
		t2.setPersonfunction("Function uncertain");
		t2.setRoomno("no number");
		t2.setTaskname("Your punishment");
		t2.setTrainee(trainee);
		
			Set<Taskdbgps> t2gps = new HashSet<Taskdbgps>();
			gps = new Taskdbgps();
			gps.setTask(t1);
			gps.setPos(1L);
			gps.setGpscoordinate("0.1,0.1");
			t1gps.add(gps);
			gps = new Taskdbgps();
			gps.setTask(t1);
			gps.setPos(2L);
			gps.setGpscoordinate("0.2,0.2");
			t1gps.add(gps);
			
			t1.setTaskdbgps(t2gps);
		
		
	}
}

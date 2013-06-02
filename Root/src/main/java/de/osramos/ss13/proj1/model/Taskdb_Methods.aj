package de.osramos.ss13.proj1.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public aspect Taskdb_Methods {

	 public static List<Taskdb> Taskdb.findTaskdbsByTraineeUsername(String usernameTrainee) {
	        if (usernameTrainee == null) throw new IllegalArgumentException("The usernameTrainee argument is required");
	        EntityManager em = Taskdb.entityManager();
	        TypedQuery<Taskdb> q = em.createQuery("SELECT o FROM Taskdb AS o WHERE o.trainee.username = :usernameTrainee", Taskdb.class);
	        q.setParameter("usernameTrainee", usernameTrainee);
	        return q.getResultList();
	    }
}

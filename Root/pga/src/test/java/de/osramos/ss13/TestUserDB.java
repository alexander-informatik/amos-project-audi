package de.osramos.ss13;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link TestUserDB}.
 *
 * @author alexander.informatik@googlemail.com (Alexander Schmidt)
 */
@RunWith(JUnit4.class)
public class TestUserDB {

    @Test
    public void createUser() {
    	
    	final String firstname = "junit_Firstname";
    	final String lastname = "junit_Lastname";
    	final String username = "junit_Username";
    	final String password = "junit_Password";
    	
    	UserDB user = new UserDB();
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setUsername(username);
        user.setPassword(password);
        HibernateTools.save(user);
        
        long id = user.getId();
        user = null;
        
        user = HibernateTools.load(id, UserDB.class);

        assertEquals(firstname,user.getFirstname());
        assertEquals(lastname,user.getLastname());
        assertEquals(username,user.getUsername());
        assertEquals(password,user.getPassword());
        
        HibernateTools.delete(user);
    }

}
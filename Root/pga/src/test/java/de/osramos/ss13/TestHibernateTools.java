package de.osramos.ss13;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link TestHibernateTools}.
 *
 * @author alexander.informatik@googlemail.com (Alexander Schmidt)
 */
@RunWith(JUnit4.class)
public class TestHibernateTools {

    @Test
    public void TestConnection() {
        SessionFactory sf = HibernateTools.getSessionFactory();
        try
        {
        	Session s = sf.openSession();
        }
        catch(HibernateException ex)
        {
        	assertTrue(false);
        }
    }

}
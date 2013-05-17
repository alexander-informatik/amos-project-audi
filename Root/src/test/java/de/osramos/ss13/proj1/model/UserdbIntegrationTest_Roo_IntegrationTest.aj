// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package de.osramos.ss13.proj1.model;

import de.osramos.ss13.proj1.model.Userdb;
import de.osramos.ss13.proj1.model.UserdbDataOnDemand;
import de.osramos.ss13.proj1.model.UserdbIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect UserdbIntegrationTest_Roo_IntegrationTest {
    
    declare @type: UserdbIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: UserdbIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: UserdbIntegrationTest: @Transactional;
    
    @Autowired
    UserdbDataOnDemand UserdbIntegrationTest.dod;
    
    @Test
    public void UserdbIntegrationTest.testCountUserdbs() {
        Assert.assertNotNull("Data on demand for 'Userdb' failed to initialize correctly", dod.getRandomUserdb());
        long count = Userdb.countUserdbs();
        Assert.assertTrue("Counter for 'Userdb' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void UserdbIntegrationTest.testFindUserdb() {
        Userdb obj = dod.getRandomUserdb();
        Assert.assertNotNull("Data on demand for 'Userdb' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Userdb' failed to provide an identifier", id);
        obj = Userdb.findUserdb(id);
        Assert.assertNotNull("Find method for 'Userdb' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Userdb' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void UserdbIntegrationTest.testFindAllUserdbs() {
        Assert.assertNotNull("Data on demand for 'Userdb' failed to initialize correctly", dod.getRandomUserdb());
        long count = Userdb.countUserdbs();
        Assert.assertTrue("Too expensive to perform a find all test for 'Userdb', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Userdb> result = Userdb.findAllUserdbs();
        Assert.assertNotNull("Find all method for 'Userdb' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Userdb' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void UserdbIntegrationTest.testFindUserdbEntries() {
        Assert.assertNotNull("Data on demand for 'Userdb' failed to initialize correctly", dod.getRandomUserdb());
        long count = Userdb.countUserdbs();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Userdb> result = Userdb.findUserdbEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Userdb' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Userdb' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void UserdbIntegrationTest.testFlush() {
        Userdb obj = dod.getRandomUserdb();
        Assert.assertNotNull("Data on demand for 'Userdb' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Userdb' failed to provide an identifier", id);
        obj = Userdb.findUserdb(id);
        Assert.assertNotNull("Find method for 'Userdb' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyUserdb(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Userdb' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void UserdbIntegrationTest.testMergeUpdate() {
        Userdb obj = dod.getRandomUserdb();
        Assert.assertNotNull("Data on demand for 'Userdb' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Userdb' failed to provide an identifier", id);
        obj = Userdb.findUserdb(id);
        boolean modified =  dod.modifyUserdb(obj);
        Integer currentVersion = obj.getVersion();
        Userdb merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Userdb' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void UserdbIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Userdb' failed to initialize correctly", dod.getRandomUserdb());
        Userdb obj = dod.getNewTransientUserdb(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Userdb' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Userdb' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Userdb' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void UserdbIntegrationTest.testRemove() {
        Userdb obj = dod.getRandomUserdb();
        Assert.assertNotNull("Data on demand for 'Userdb' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Userdb' failed to provide an identifier", id);
        obj = Userdb.findUserdb(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Userdb' with identifier '" + id + "'", Userdb.findUserdb(id));
    }
    
}
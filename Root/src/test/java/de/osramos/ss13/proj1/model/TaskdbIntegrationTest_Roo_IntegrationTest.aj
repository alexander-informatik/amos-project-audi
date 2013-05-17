// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package de.osramos.ss13.proj1.model;

import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.TaskdbDataOnDemand;
import de.osramos.ss13.proj1.model.TaskdbIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TaskdbIntegrationTest_Roo_IntegrationTest {
    
    declare @type: TaskdbIntegrationTest: @RunWith(SpringJUnit4ClassRunner.class);
    
    declare @type: TaskdbIntegrationTest: @ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext*.xml");
    
    declare @type: TaskdbIntegrationTest: @Transactional;
    
    @Autowired
    TaskdbDataOnDemand TaskdbIntegrationTest.dod;
    
    @Test
    public void TaskdbIntegrationTest.testCountTaskdbs() {
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to initialize correctly", dod.getRandomTaskdb());
        long count = Taskdb.countTaskdbs();
        Assert.assertTrue("Counter for 'Taskdb' incorrectly reported there were no entries", count > 0);
    }
    
    @Test
    public void TaskdbIntegrationTest.testFindTaskdb() {
        Taskdb obj = dod.getRandomTaskdb();
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to provide an identifier", id);
        obj = Taskdb.findTaskdb(id);
        Assert.assertNotNull("Find method for 'Taskdb' illegally returned null for id '" + id + "'", obj);
        Assert.assertEquals("Find method for 'Taskdb' returned the incorrect identifier", id, obj.getId());
    }
    
    @Test
    public void TaskdbIntegrationTest.testFindAllTaskdbs() {
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to initialize correctly", dod.getRandomTaskdb());
        long count = Taskdb.countTaskdbs();
        Assert.assertTrue("Too expensive to perform a find all test for 'Taskdb', as there are " + count + " entries; set the findAllMaximum to exceed this value or set findAll=false on the integration test annotation to disable the test", count < 250);
        List<Taskdb> result = Taskdb.findAllTaskdbs();
        Assert.assertNotNull("Find all method for 'Taskdb' illegally returned null", result);
        Assert.assertTrue("Find all method for 'Taskdb' failed to return any data", result.size() > 0);
    }
    
    @Test
    public void TaskdbIntegrationTest.testFindTaskdbEntries() {
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to initialize correctly", dod.getRandomTaskdb());
        long count = Taskdb.countTaskdbs();
        if (count > 20) count = 20;
        int firstResult = 0;
        int maxResults = (int) count;
        List<Taskdb> result = Taskdb.findTaskdbEntries(firstResult, maxResults);
        Assert.assertNotNull("Find entries method for 'Taskdb' illegally returned null", result);
        Assert.assertEquals("Find entries method for 'Taskdb' returned an incorrect number of entries", count, result.size());
    }
    
    @Test
    public void TaskdbIntegrationTest.testFlush() {
        Taskdb obj = dod.getRandomTaskdb();
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to provide an identifier", id);
        obj = Taskdb.findTaskdb(id);
        Assert.assertNotNull("Find method for 'Taskdb' illegally returned null for id '" + id + "'", obj);
        boolean modified =  dod.modifyTaskdb(obj);
        Integer currentVersion = obj.getVersion();
        obj.flush();
        Assert.assertTrue("Version for 'Taskdb' failed to increment on flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void TaskdbIntegrationTest.testMergeUpdate() {
        Taskdb obj = dod.getRandomTaskdb();
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to provide an identifier", id);
        obj = Taskdb.findTaskdb(id);
        boolean modified =  dod.modifyTaskdb(obj);
        Integer currentVersion = obj.getVersion();
        Taskdb merged = obj.merge();
        obj.flush();
        Assert.assertEquals("Identifier of merged object not the same as identifier of original object", merged.getId(), id);
        Assert.assertTrue("Version for 'Taskdb' failed to increment on merge and flush directive", (currentVersion != null && obj.getVersion() > currentVersion) || !modified);
    }
    
    @Test
    public void TaskdbIntegrationTest.testPersist() {
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to initialize correctly", dod.getRandomTaskdb());
        Taskdb obj = dod.getNewTransientTaskdb(Integer.MAX_VALUE);
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to provide a new transient entity", obj);
        Assert.assertNull("Expected 'Taskdb' identifier to be null", obj.getId());
        obj.persist();
        obj.flush();
        Assert.assertNotNull("Expected 'Taskdb' identifier to no longer be null", obj.getId());
    }
    
    @Test
    public void TaskdbIntegrationTest.testRemove() {
        Taskdb obj = dod.getRandomTaskdb();
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to initialize correctly", obj);
        Long id = obj.getId();
        Assert.assertNotNull("Data on demand for 'Taskdb' failed to provide an identifier", id);
        obj = Taskdb.findTaskdb(id);
        obj.remove();
        obj.flush();
        Assert.assertNull("Failed to remove 'Taskdb' with identifier '" + id + "'", Taskdb.findTaskdb(id));
    }
    
}
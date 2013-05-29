package de.osramos.ss13.proj1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.osramos.ss13.proj1.model.Taskdb;

@RequestMapping("/trainee/taskdb/showmap")
@Controller
public class TaskdbShowMapController {

//  return "trainee/taskdb/showmap/index";
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getMap(@PathVariable Long id, ModelMap model) {
 
    	model.addAttribute("taskid", id);
    	
    	try
    	{
	    	Taskdb o = (Taskdb) Taskdb.findTaskdbsById(id).getSingleResult();
	    	if(o != null)
	    	{
	    		
	    		model.addAttribute("taskname", o.getTaskname());
	    		model.addAttribute("gpsstart", o.getGps_Start());
	    		model.addAttribute("gpsend", o.getGps_End());
	    	}
	    	else
	    	{
	    		model.addAttribute("taskid", "taskid not found");
	    	}
    	}
    	catch(Exception e)
    	{}
    	
		return "trainee/taskdb/showmap/index";
 
	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDefaultPage(ModelMap model) {
 
		model.addAttribute("taskid", "no task selected");
		return "trainee/taskdb/showmap/index";
 
	}
}




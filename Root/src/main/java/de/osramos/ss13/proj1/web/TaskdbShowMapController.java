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
	    		String start = o.getGps_Start();
	    		String end = o.getGps_End();
	    		
	    		//String[] s = start.split(",");
	    		//String s1 = s[0];
	    		//String s2 = s[1];
	    		
	    		//String[] e = start.split(",");
	    		//String e1 = e[0];
	    		//String e2 = e[1];
	    		
	    		model.addAttribute("gpsstart", start);
	    		model.addAttribute("gpsend", end);
	    		
	    		//model.addAttribute("gpsstartlatitude", s1);
	    		//model.addAttribute("gpsstartlongitude", s2);
	    		//model.addAttribute("gpsendlatitude", e1);
	    		//model.addAttribute("gpsendlongitude", e2);
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




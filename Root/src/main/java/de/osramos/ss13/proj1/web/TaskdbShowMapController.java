package de.osramos.ss13.proj1.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/trainee/taskdb/showmap")
@Controller
public class TaskdbShowMapController {

//  return "trainee/taskdb/showmap/index";
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getMap(@PathVariable Long id, ModelMap model) {
 
		model.addAttribute("taskid", id);
		return "trainee/taskdb/showmap/index";
 
	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDefaultPage(ModelMap model) {
 
		model.addAttribute("taskid", "no task selected");
		return "trainee/taskdb/showmap/index";
 
	}
}




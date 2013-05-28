package de.osramos.ss13.proj1.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/trainee/taskdb/**")
@Controller
public class TaskPageController {
/*
    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        return "trainee/taskdb/index";
    }
*/    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTask(@PathVariable Long id, ModelMap model) {
		model.addAttribute("taskid", id);
		return "trainee/taskdb/index";
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefaultTask(ModelMap model) {
		model.addAttribute("taskid", "invalid taskid");
		return "trainee/taskdb/index";
    }
}

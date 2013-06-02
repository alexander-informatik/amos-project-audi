package de.osramos.ss13.proj1.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.osramos.ss13.proj1.model.Taskdb;

@RequestMapping("/trainee/task/**")
@Controller
public class TraineeTask {

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String index(@PathVariable("id") Long id, Model uiModel) {
        Taskdb task =  Taskdb.findTaskdb(id);
        
        String authorizedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        
        if(task.getTrainee().getUsername().equals(authorizedUsername))
        {
			uiModel.addAttribute("taskid", id);
			uiModel.addAttribute("taskname", task.getTaskname());
			uiModel.addAttribute("person", task.getPerson());
			uiModel.addAttribute("personfunction", task.getPersonfunction());
			uiModel.addAttribute("building", task.getBuilding());
			uiModel.addAttribute("roomno", task.getRoomno());
        }
        else
        {
        	uiModel.addAttribute("taskname", "This task is not assigned to you!");
        }
        
        
        return "trainee/task/index";
    }
}

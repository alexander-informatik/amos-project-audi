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
import org.springframework.web.bind.annotation.RequestParam;

import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.Userdb;

@RequestMapping("/trainee/tasklist/**")
@Controller
public class TraineeTasklist {

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

//    @RequestMapping
//    public String index() {
//        return "trainee/tasklist/index";
//    }
    
    
    @RequestMapping(produces = "text/html")
    public String index(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
    	
    	String authorizedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        
    	
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("tasklist", Taskdb.findTaskdbEntries(firstResult, sizeNo));
            float nrOfPages = (float) Taskdb.countTaskdbs() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("tasklist", Taskdb.findTaskdbsByTraineeUsername(authorizedUsername));
        }
        return "trainee/tasklist/index";
    }
    
}

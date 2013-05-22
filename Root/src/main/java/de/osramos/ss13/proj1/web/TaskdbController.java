package de.osramos.ss13.proj1.web;

import java.util.List;

import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.Userdb;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/taskdbs")
@Controller
@RooWebScaffold(path = "taskdbs", formBackingObject = Taskdb.class)
public class TaskdbController {
	

	void populateEditForm(Model uiModel, Taskdb taskdb) {
        uiModel.addAttribute("taskdb", taskdb);
        uiModel.addAttribute("userdbs", Userdb.findUserdbsByUserroleEquals("trainne").getResultList());
    }
}

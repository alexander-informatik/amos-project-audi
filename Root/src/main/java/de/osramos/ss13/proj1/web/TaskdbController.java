package de.osramos.ss13.proj1.web;

import de.osramos.ss13.proj1.model.Taskdb;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/taskdbs")
@Controller
@RooWebScaffold(path = "taskdbs", formBackingObject = Taskdb.class)
public class TaskdbController {
}

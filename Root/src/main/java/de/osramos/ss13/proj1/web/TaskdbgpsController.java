package de.osramos.ss13.proj1.web;

import de.osramos.ss13.proj1.model.Taskdbgps;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/taskdbgpses")
@Controller
@RooWebScaffold(path = "taskdbgpses", formBackingObject = Taskdbgps.class)
public class TaskdbgpsController {
}

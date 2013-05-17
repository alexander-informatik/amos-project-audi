package de.osramos.ss13.proj1.web;

import de.osramos.ss13.proj1.model.Userdb;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/userdbs")
@Controller
@RooWebScaffold(path = "userdbs", formBackingObject = Userdb.class)
public class UserdbController {
}

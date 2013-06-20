package de.osramos.ss13.proj1.web;

/*
 * #%L
 * proj1
 * %%
 * Copyright (C) 2013 Amos-Project
 * %%
 * Copyright (c) 2013 by Alexander Schmidt, Sascha Ströbel, Nina Aures, Riehle, http://dirkriehle.com
 * -
 * This file is part of the Amos Project - Productive Games application.
 * -
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * -
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * -
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 * #L%
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.osramos.ss13.proj1.model.Gpscoordinate;
import de.osramos.ss13.proj1.model.Route;
import de.osramos.ss13.proj1.model.Taskdb;

@RequestMapping("/trainee/task/showmap")
@Controller
public class TaskdbShowMapController {

	//  return "trainee/taskdb/showmap/index";

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getMap(@PathVariable Long id, ModelMap model) {

		model.addAttribute("taskid", id);

		try {
			Taskdb o = (Taskdb) Taskdb.findTaskdbsById(id).getSingleResult();
			if (o != null) {

				model.addAttribute("taskname", o.getTaskname());
				Route route = o.getMap();
				String start = "no route found";
				String end = "no route found";

				if (route != null) {
					System.out.println("route not null");
					Gpscoordinate s = Gpscoordinate
							.findFirstGpscoordinatesByRoute(route);
					Gpscoordinate e = Gpscoordinate
							.findLastGpscoordinatesByRouteReverseOrdered(route);

					if (s != null && e != null) {
						start = s.getLatitude() + "," + s.getLongitude();
						end = e.getLatitude() + "," + e.getLongitude();
					}

					System.out.println(start + " " + end);
				}
				System.out.println("route done");
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
			} else {
				model.addAttribute("taskname", "taskid not found");
			}
		} catch (Exception e) {
		}

		return "trainee/task/showmap/index";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getDefaultPage(ModelMap model) {

		model.addAttribute("taskname", "no task selected");
		return "trainee/task/showmap/index";

	}
}

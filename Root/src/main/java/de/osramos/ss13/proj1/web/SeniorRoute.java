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

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import de.osramos.ss13.proj1.model.Gpscoordinate;
import de.osramos.ss13.proj1.model.Route;
import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.Userdb;

@RequestMapping("/senior/route")
@Controller
public class SeniorRoute {

	// INDEX
	@RequestMapping(produces = "text/html")
	public String index(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "size", required = false) Integer size,
			Model uiModel) {

		//		String authorizedUsername = SecurityContextHolder.getContext()
		//				.getAuthentication().getName();

		if (page != null || size != null) {
			int sizeNo = size == null ? 10 : size.intValue();
			final int firstResult = page == null ? 0 : (page.intValue() - 1)
					* sizeNo;
			uiModel.addAttribute("routelist", Route.findRouteEntries(
					firstResult, sizeNo));
			float nrOfPages = (float) Route.countRoutes() / sizeNo;
			uiModel.addAttribute("maxPages",
					(int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0)
							? nrOfPages + 1
							: nrOfPages));
		} else {
			uiModel.addAttribute("routelist", Route.findAllRoutes());
		}
		return "senior/route/index";
	}

	// CREATE

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String create(@Valid Route route, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, route);
			return "senior/route/create";
		}
		uiModel.asMap().clear();
		route.persist();
		return "redirect:/senior/route/";
		//+ encodeUrlPathSegment(route.getId().toString(),	httpServletRequest); // implement later if really needed
	}

	// CREATE
	@RequestMapping(params = "create", produces = "text/html", method = RequestMethod.GET)
	public String create(Model uiModel) {
		populateEditForm(uiModel, new Route());
		return "senior/route/create";
	}

	// UPDATE
	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
	public String update(@Valid Route route, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, route);
			return "senior/route/update";
		}
		uiModel.asMap().clear();
		route.merge();
		return "redirect:/senior/route/"
				+ encodeUrlPathSegment(route.getId().toString(),
						httpServletRequest);
	}

	// UPDATE
	@RequestMapping(value = "/{id}", params = "update", produces = "text/html")
	public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		populateEditForm(uiModel, Route.findRoute(id));
		return "senior/route/update";
	}

	// AJAX POST 1GPS=Coordinate
	@RequestMapping(value = "/{id}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> createFromJson(@PathVariable("id") Long id,
			@RequestBody String json) {

		Route route = Route.findRoute(id);

		// findGpscoordinatesByRouteOrderedByOrderedPosition
		List<Gpscoordinate> gpscoordinates = Gpscoordinate
				.findGpscoordinatesByRoute(route).getResultList();

		Gpscoordinate gpscoordinate = Gpscoordinate
				.fromJsonToGpscoordinate(json);
		gpscoordinate.setRoute(route);
		gpscoordinate.setOrderedposition(gpscoordinates.size());

		gpscoordinate.persist();
		//System.out.println("AJAX POST 1 GPS " + gpscoordinate.toJson());

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		return new ResponseEntity<String>(gpscoordinate.toJson(), headers,
				HttpStatus.OK);

	}

	// AJAX GET All GPS-Coordinates
	@RequestMapping(value = "/{id}", params = "gpscoordinates", headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> listJson(@PathVariable("id") Long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");

		Route route = Route.findRoute(id);
		List<Gpscoordinate> result = Gpscoordinate
				.findGpscoordinatesByRouteOrderedByOrderedPosition(route)
				.getResultList();

		//System.out.println("AJAX GET ALL GPS " + Gpscoordinate.toJsonArray(result));

		return new ResponseEntity<String>(Gpscoordinate.toJsonArray(result),
				headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", params = "gpscoordinate", headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
		Gpscoordinate gpscoordinate = Gpscoordinate.findGpscoordinate(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if (gpscoordinate == null) {
			//System.out.println("AJAX GET 1 GPS " + "not found");
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}

		//System.out.println("AJAX GET 1 GPS " + gpscoordinate.toJson());
		return new ResponseEntity<String>(gpscoordinate.toJson(), headers,
				HttpStatus.OK);
	}

	// AJAX PUT 1 GPS
	@RequestMapping(params = "updategpscoordinate", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> updateFromJson(@RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		Gpscoordinate gpscoordinateUpdate = Gpscoordinate
				.fromJsonToGpscoordinate(json);

		if (gpscoordinateUpdate.getId() == null) {
			//System.out.println("AJAX PUT 1 GPS " + "not found ID");
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		// Update only longitude and latitude and keep everything else from database
		Gpscoordinate gpscoordinate = Gpscoordinate
				.findGpscoordinate(gpscoordinateUpdate.getId());
		gpscoordinate.setLatitude(gpscoordinateUpdate.getLatitude());
		gpscoordinate.setLongitude(gpscoordinateUpdate.getLongitude());

		if (gpscoordinate.merge() == null) {
			//System.out.println("AJAX PUT 1 GPS " + "not found when merging");
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}

		//System.out.println("AJAX PUT 1 GPS " + gpscoordinate.toJson());

		return new ResponseEntity<String>(gpscoordinate.toJson(), headers,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
		Gpscoordinate gpscoordinate = Gpscoordinate.findGpscoordinate(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		if (gpscoordinate == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		gpscoordinate.remove();
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}

	void populateEditForm(Model uiModel, Route route) {
		uiModel.addAttribute("route", route);
	}

	String encodeUrlPathSegment(String pathSegment,
			HttpServletRequest httpServletRequest) {
		String enc = httpServletRequest.getCharacterEncoding();
		if (enc == null) {
			enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
		}
		try {
			pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
		} catch (UnsupportedEncodingException uee) {
		}
		return pathSegment;
	}

}

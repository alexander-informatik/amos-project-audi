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

import de.osramos.ss13.proj1.model.MediaUpload;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.File;

@RequestMapping("/mediauploads")
@Controller
@RooWebScaffold(path = "mediauploads", formBackingObject = MediaUpload.class)
public class SeniorMediaupload {
	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String create(@Valid MediaUpload mediaUpload,
			BindingResult bindingResult, Model uiModel,
			@RequestParam("content") CommonsMultipartFile content,
			HttpServletRequest httpServletRequest) {
		File dest = new File("/tmp/" + content.getOriginalFilename());
		try {
			content.transferTo(dest);
			mediaUpload.setFilesize(content.getSize());
			mediaUpload.setFilepath(dest.getAbsolutePath());
			mediaUpload.setContentType(content.getContentType());
		} catch (Exception e) {
			e.printStackTrace();
			return "mediauploads/create";
		}

		uiModel.asMap().clear();
		mediaUpload.persist();
		return "redirect:/mediauploads/"
				+ encodeUrlPathSegment(mediaUpload.getId().toString(),
						httpServletRequest);
	}
}

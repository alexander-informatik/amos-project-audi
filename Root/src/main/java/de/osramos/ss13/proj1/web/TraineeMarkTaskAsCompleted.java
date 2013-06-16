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

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import de.osramos.ss13.proj1.form.TaskCompletionPasswordForm;
import de.osramos.ss13.proj1.model.Taskdb;
import de.osramos.ss13.proj1.model.Userdb;

@RequestMapping("/trainee/markascompleted/task/**")
@Controller
@SessionAttributes({"command"})
public class TraineeMarkTaskAsCompleted {

	@RequestMapping(method = RequestMethod.POST)
	public String changePw(
			@ModelAttribute("command") TaskCompletionPasswordForm current,
			BindingResult result, Model uiModel) {

		String authorizedUsername = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		if (current.getCompletionPassword() != null) {

			Taskdb task = Taskdb.findTaskdb(current.getTaskid());

			if (task.getTrainee().getUsername().equals(authorizedUsername)
					&& current.getCompletionPassword().trim().equals(
							task.getCompletionPassword())) {
				task.setTaskDone(true);
				task.persist();

				uiModel.addAttribute("success", true);
			}
		}

		uiModel.addAttribute("sent", true);

		return "trainee/markascompleted/task/index";
	}

	@RequestMapping(produces = "text/html", value = "/{id}", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable Long id) {

		TaskCompletionPasswordForm form = new TaskCompletionPasswordForm();
		form.setTaskid(id);

		return new ModelAndView("trainee/markascompleted/task/index",
				"command", form);
	}

}

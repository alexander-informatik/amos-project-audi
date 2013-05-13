/*
 * Copyright (c) 2013 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Amos SS13 Project - Productive Games Development (PGA) application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 * 
 * Software Developers in alphabetical order:
 * Nina Aures
 * Alexander Schmidt
 * Sascha Stroebel
 */

package de.osramos.ss13.Senior;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.IClusterable;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.value.ValueMap;
import org.hibernate.Session;
import org.hibernate.Transaction;

import de.osramos.ss13.HibernateTools;
import de.osramos.ss13.Model.TaskDB;
import de.osramos.ss13.Model.Taskdb__GpsEntry;

public class TaskPage extends WebPage implements de.osramos.ss13.Right.Senior {
	private static final long serialVersionUID = 1L;

	private final ValueMap properties = new ValueMap();
	private WebMarkupContainer showItems = null;
	private feedbackerrorajax feedbackerrorajax = null;
	final List<GpsEntry> items = new ArrayList<GpsEntry>();

	public TaskPage(final PageParameters parameters) {

		add(new Label("feedbacksuccess", new PropertyModel<String>(properties,
				"feedbacksuccess")));
		add(new Label("feedbackerror", new PropertyModel<String>(properties,
				"feedbackerror")));
		add(new SeniorTaskPageForm("form"));

	}

	public final class SeniorTaskPageForm extends Form<Void> {

		public SeniorTaskPageForm(String id) {
			super(id);

			List<String> trainees = HibernateTools
					.GetStringList("select firstname || ' ' || lastname AS fullname from userdb where role LIKE 'trainee' ");
			add(new TextField<String>("taskname", new PropertyModel<String>(
					properties, "taskname")));
			add(new DropDownChoice<String>("trainee",
					new PropertyModel<String>(properties, "trainee"), trainees));
			add(new TextField<String>("person", new PropertyModel<String>(
					properties, "person")));
			add(new TextField<String>("building", new PropertyModel<String>(
					properties, "building")));
			add(new TextField<String>("function", new PropertyModel<String>(
					properties, "function")));
			add(new TextField<String>("roomno", new PropertyModel<String>(
					properties, "roomno")));

			showItems = new GpsEntryContainer("showItems");
			add(showItems);
			// add the add container for the todo items.
			add(new AddGpsEntryContainer("addItems"));
			
			feedbackerrorajax = new feedbackerrorajax("feedbackerrorajax");
			add(feedbackerrorajax);

		}

		@Override
		public final void onSubmit() {
			try
			{
				String errors = "";
				properties.remove("feedbacksuccess");
				properties.remove("feedbackerror");
	
				if (null == properties.getString("trainee"))
					errors += " Please select a Trainee";
				if (null == properties.getString("taskname"))
					errors += " Please enter Taskname";
				
	
				if (errors.length() > 0) {
					properties.put("feedbackerror", errors);
					return;
				}
	
				
				
				TaskDB t = new TaskDB();
				t.setTaskname(properties.getString("taskname"));
				t.setTrainee(properties.getString("trainee"));
				t.setPerson(properties.getString("person"));
				t.setFunction(properties.getString("function"));
				t.setBuilding(properties.getString("building"));
				t.setRoomno(properties.getString("roomno"));
				//t.setGpscoordinate(properties.getString("gpscoordinate"));
				t.setDescription("");
				HibernateTools.save(t);			
				
				Session session = HibernateTools.getSessionFactory().openSession();
				Transaction tx = session.beginTransaction();
				for(GpsEntry e : items)
				{
	
					Taskdb__GpsEntry a = new Taskdb__GpsEntry();
					a.setFid_TaskDB(t.getId());
					a.setGpscoordinate(e.getGpsCoordinate());
					session.save(a);
				}
			    session.save(t);
				tx.commit();
			}
			catch(Exception ex)
			{
				// spontaneous postgresql error, db needs bugfix
			}
			finally
			{
				properties.put("feedbacksuccess", "Success!");
				properties.remove("taskname");
				properties.remove("trainee");
				properties.remove("person");
				properties.remove("function");
				properties.remove("building");
				properties.remove("roomno");
				items.clear();
			}

		}
	}

	public static class GpsEntry implements IClusterable {
		private static final long serialVersionUID = 1L;

		private boolean checked;
		private int position;
		private String gpscoordinate;

		public GpsEntry() {
		}

		public GpsEntry(GpsEntry entry) {
			gpscoordinate = entry.gpscoordinate;
		}

		public boolean isChecked() {
			return checked;
		}

		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		public String getGpsCoordinate() {
			return gpscoordinate;
		}

		public void setGpsCoordinate(String gpscoordinate) {
			this.gpscoordinate = gpscoordinate;
		}

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}
	}

	public class GpsEntryContainer extends WebMarkupContainer {

		private static final long serialVersionUID = -1745154437188561981L;

		public GpsEntryContainer(String id) {
			super(id);

			// generate markup-id for AJAX
			setOutputMarkupId(true);

			add(new ListView<GpsEntry>("item", items) {
				@Override
				protected void populateItem(ListItem<GpsEntry> item) {
					// add an AJAX checkbox and Label

					item.add(new AjaxCheckBox("check",
							new PropertyModel<Boolean>(item.getDefaultModel(),
									"checked")) {
						@Override
						protected void onUpdate(AjaxRequestTarget target) {
						}
					});
					item.add(new Label("gpscoordinate", new PropertyModel<String>(item
							.getDefaultModel(), "gpscoordinate")));
				}
			});
		}
	}

	public class feedbackerrorajax extends WebMarkupContainer {
		private static final long serialVersionUID = 3784645685480448585L;

		public final ValueMap properties = new ValueMap();
		
		public feedbackerrorajax(String id) {
			super(id);
			// let wicket generate a markup-id so the contents can be
			// updated through an AJAX call.
			setOutputMarkupId(true);
			//add(new Label("feedbackerrorajax1", new PropertyModel<String>(properties,"feedbackerrorajax1")));
		}
		
		public void setFeedback(String errors)
		{
			properties.put("feedbackerrorajax1", errors);
		}
	}
		
	public class AddGpsEntryContainer extends WebMarkupContainer {
		private static final long serialVersionUID = 3784645685890448585L;

		public AddGpsEntryContainer(String id) {
			super(id);
			// let wicket generate a markup-id so the contents can be
			// updated through an AJAX call.
			setOutputMarkupId(true);
			add(new RemoveLink("remove"));
			add(new AddGpsForm("form"));
		}

		

		private final class RemoveLink extends AjaxFallbackLink {

			public RemoveLink(String id) {
				super(id);
			}

			@Override
			public void onClick(AjaxRequestTarget target) {
				List<GpsEntry> ready = new ArrayList<GpsEntry>();
				for (GpsEntry entry : items) {
					if (entry.isChecked()) {
						ready.add(entry);
					}
				}
				items.removeAll(ready);

				target.add(this);
				target.add(showItems);
				target.add(feedbackerrorajax);
			}
		}

		private final class AddGpsForm extends Form<GpsEntry> {

			private static final long serialVersionUID = -1577889255146527825L;
			
			public AddGpsForm(String id) {
				super(id, new CompoundPropertyModel<GpsEntry>(new GpsEntry()));
				setOutputMarkupId(true);
				
				add(new TextField<String>("gpscoordinate"));
				add(new AjaxButton("add", this) {
					@Override
					protected void onSubmit(AjaxRequestTarget target,
							Form<?> form) {
						
						properties.remove("feedbacksuccess");
						properties.remove("feedbackerror");
						
						if(items.size() < 12)
						{
							GpsEntry item = (GpsEntry) getParent()
									.getDefaultModelObject();
							
							String errors = "";
							if (null == item.getGpsCoordinate())
								errors += " Please enter a GPS-Coordinate";
							else if (false == item.getGpsCoordinate().matches(
									"(-+)?\\d+\\.\\d+,(-+)?\\d+\\.\\d+")) {
								errors += " Please enter VALID GPS-Coordinate";
							}
							if (errors.length() > 0) {
								properties.put("feedbackerror", errors);
								feedbackerrorajax.setFeedback(errors);
								return;
							}
							
							
							items.add(new GpsEntry(item));
	
							// reset the model
							item.setChecked(false);
							item.setGpsCoordinate("");
	
							target.add(this);
							target.add(showItems);
							target.add(feedbackerrorajax);
							
						}
					}

					@Override
					protected void onError(AjaxRequestTarget target,
							Form<?> form) {
					}
				});

				
			}

		}

	}

}

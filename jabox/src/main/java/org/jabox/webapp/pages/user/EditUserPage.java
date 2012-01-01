/*
 * Jabox Open Source Version
 * Copyright (C) 2009-2010 Dimitris Kapanidis                                                                                                                          
 * 
 * This file is part of Jabox
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package org.jabox.webapp.pages.user;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormValidatingBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;
import org.jabox.model.Project;
import org.jabox.model.User;
import org.jabox.webapp.pages.BasePage;
import org.jabox.webapp.validation.ShinyForm;

@AuthorizeInstantiation("ADMIN")
public abstract class EditUserPage extends BasePage {

	public EditUserPage(final IModel<User> user) {
		Form<User> form = new ShinyForm("form",
				new CompoundPropertyModel<User>(user.getObject())) {
			private static final long serialVersionUID = -8262391690702864764L;

			@Override
			protected void onSubmit() {
				onSave(getModelObject());
			}
		};
		form.setOutputMarkupId(true);

		add(form);

		form.add(new RequiredTextField<Project>("login"));
		form.add(new RequiredTextField<Project>("firstName"));
		form.add(new RequiredTextField<Project>("lastName"));
		form.add(new PasswordTextField("password"));
	}

	protected abstract void onSave(User article);

	protected abstract void onCancel();
}

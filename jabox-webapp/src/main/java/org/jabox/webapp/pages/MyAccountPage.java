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
package org.jabox.webapp.pages;

import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.persistence.provider.GeneralDao;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.jabox.apis.Connector;
import org.jabox.apis.Manager;
import org.jabox.model.Project;
import org.jabox.model.User;
import org.jabox.webapp.borders.MiddlePanel;
import org.jabox.webapp.utils.TransactionalForm;

@AuthorizeInstantiation("ADMIN")
public class MyAccountPage extends MiddlePanel {
	@SpringBean(name = "GeneralDao")
	protected GeneralDao _generalDao;

	@SpringBean
	protected Manager<Connector> _manager;

	public MyAccountPage() {
		IModel<User> user = getUser();
		add(new FeedbackPanel("feedback"));
		Form<User> form = new TransactionalForm<User>("form",
				new CompoundPropertyModel<User>(user.getObject())) {
			private static final long serialVersionUID = -8262391690702864764L;

			@Override
			protected void onSubmit() {
				onSave(getModelObject());
			}
		};

		add(form);

		form.add(new RequiredTextField<Project>("login"));
		form.add(new RequiredTextField<Project>("firstName"));
		form.add(new RequiredTextField<Project>("lastName"));
		form.add(new PasswordTextField("password"));

		form.add(new Link<Void>("cancel") {
			private static final long serialVersionUID = -6975617962156076540L;

			@Override
			public void onClick() {
				onCancel();
			}
		});
	}

	private IModel<User> getUser() {
		JaboxAuthenticatedWebSession session = (JaboxAuthenticatedWebSession) getSession();
		Long userId = session.getUserId();
		return new Model<User>(_generalDao.findEntity(userId, User.class));
	}

	protected void onSave(User user) {
		_generalDao.persist(user);
		setResponsePage(ManageUsers.class);
	}

	protected void onCancel() {
		setResponsePage(ManageUsers.class);
	}
}

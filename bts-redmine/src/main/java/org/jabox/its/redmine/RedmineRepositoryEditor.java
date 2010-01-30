package org.jabox.its.redmine;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.jabox.model.Server;

public class RedmineRepositoryEditor extends Panel {
	private static final long serialVersionUID = 3000405193458816252L;

	public RedmineRepositoryEditor(String id, IModel<Server> model) {
		super(id, new CompoundPropertyModel<String>(model));
		add(new TextField<String>("server.url"));
	}

}
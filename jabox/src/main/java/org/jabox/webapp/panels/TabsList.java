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
package org.jabox.webapp.panels;

import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.Model;
import org.jabox.webapp.modifiers.TooltipModifier;

public class TabsList extends PropertyListView<Tab> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2877438240039632971L;

	public TabsList(final String id, final List<Tab> projects) {
		super(id, projects);
	}

	@Override
	public void populateItem(final ListItem<Tab> listItem) {
		final Tab tab = listItem.getModelObject();

		if (tab.isSelected()) {
			listItem.add(new AttributeModifier("class", new Model<String>(
					"selected")));
		}
		listItem.add(new TooltipModifier(tab.getTooltip()));

		BookmarkablePageLink<WebPage> externalLink = new BookmarkablePageLink<WebPage>(
				"url", tab.getPageClass());
		externalLink.add(new Label("title", tab.getTitle()));

		listItem.add(externalLink);
	}
}

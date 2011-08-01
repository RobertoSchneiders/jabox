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
package org.jabox.webapp.menubuttons;

import org.apache.wicket.ResourceReference;
import org.apache.wicket.markup.html.form.ImageButton;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.persistence.domain.BaseEntity;
import org.apache.wicket.persistence.domain.BaseEntityDetachableModel;
import org.apache.wicket.persistence.provider.GeneralDao;
import org.apache.wicket.persistence.provider.UserXstreamDao;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.jabox.model.User;
import org.jabox.webapp.modifiers.TooltipModifier;
import org.jabox.webapp.pages.EditUserPage;
import org.jabox.webapp.pages.ManageUsers;

public final class EditEntityButton<T extends BaseEntity> extends ImageButton {

	private static final TooltipModifier TOOLTIP_MODIFIER = new TooltipModifier(
			"Edit Connector");

	private static final ResourceReference EDIT_IMG = new ResourceReference(
			EditEntityButton.class, "preferences-system.png");

	private static final long serialVersionUID = 1L;
	private final T _item;

	public EditEntityButton(final String id, final T item) {
		super(id, EDIT_IMG);
		_item = item;
		add(TOOLTIP_MODIFIER);
	}

	public EditEntityButton(final String id, final ListItem<T> item) {
		this(id, item.getModelObject());
	}

	@SpringBean(name = "GeneralDao")
	protected GeneralDao _generalDao;

	/**
	 * Delete from persistent storage, commit transaction.
	 */
	@Override
	public void onSubmit() {
		IModel<T> model = new BaseEntityDetachableModel<T>(_item);
		setResponsePage(new EditUserPage(new CompoundPropertyModel<User>(model)) {

			@Override
			protected void onCancel() {
				setResponsePage(ManageUsers.class);
			}

			@Override
			protected void onSave(final User user) {
				UserXstreamDao.persist(user);
				setResponsePage(ManageUsers.class);
			}
		});
	}
}

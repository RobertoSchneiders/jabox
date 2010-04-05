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
package org.jabox.mrm.nexus;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jabox.apis.rms.RMSConnectorConfig;
import org.jabox.model.DeployerConfig;

@Entity
@DiscriminatorValue(NexusConnector.ID)
public class NexusConnectorConfig extends DeployerConfig implements
		RMSConnectorConfig {
	private static final long serialVersionUID = 7792258345940117969L;

	public NexusConnectorConfig() {
		pluginId = NexusConnector.ID;
	}

	public String getReleaseRepositoryURL() {
		return getServer().getUrl() + "content/repositories/releases/";
	}

	public String getSnapshotsRepositoryURL() {
		return getServer().getUrl() + "content/repositories/snapshots/";
	}
}

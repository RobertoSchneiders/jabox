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
package org.jabox.cis.jenkins;

import org.jabox.apis.cis.CISConnectorConfig;
import org.jabox.model.DeployerConfig;
import org.jabox.model.Project;

public class JenkinsConnectorConfig extends DeployerConfig implements
        CISConnectorConfig {
    private static final String SLASH = "/";

    private static final long serialVersionUID = -6696934779273872749L;

    public String username;

    public String password;

    public JenkinsConnectorConfig() {
        pluginId = JenkinsConnector.ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSystem() {
        return "jenkins";
    }

    public String getJobUrl(Project project) {
        StringBuffer sb = new StringBuffer();
        sb.append(getServer().getUrl());
        if (!getServer().getUrl().endsWith(SLASH)) {
            sb.append(SLASH);
        }
        sb.append("job/");
        sb.append(project.getName());
        sb.append(SLASH);
        return sb.toString();
    }
}

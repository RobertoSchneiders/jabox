/*
 * The MIT License
 *
 * Copyright (c) 2009 Dimitris Kapanidis
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jabox.model;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.jabox.apis.Connector;
import org.springframework.stereotype.Service;

@Service
public class FtpDeployerPlugin implements Connector {

	public static final String ID = "plugin.deployer.ftp";

	public String getName() {
		return "Ftp Site";
	}

	public String getId() {
		return ID;
	}

	public Component newEditor(String id, IModel<Server> model) {
		return new FtpDeployerEditor(id, model);
	}

	public DeployerConfig newConfig() {
		return new FtpDeployerConfig();
	}

	public String deploy(Server article) {
		FtpDeployerConfig config = (FtpDeployerConfig) article.deployerConfig;
		return "Deploying article: " + article.getName()
				+ " to ftp://" + config.host + ":" + config.port;
	}

}

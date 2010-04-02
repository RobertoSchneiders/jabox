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
package org.jabox.cis.hudson;

import org.jabox.apis.embedded.AbstractEmbeddedServer;
import org.jabox.maven.helper.MavenDownloader;

public class HudsonServer extends AbstractEmbeddedServer {

	private static final String GROUP_ID = "org.jvnet.hudson.main";
	private static final String ARTIFACT_ID = "hudson-war";
	private static final String VERSION = "1.352";
	private static final String TYPE = "war";

	@Override
	public String getServerName() {
		return "hudson";
	}

	@Override
	public String getWarPath() {
		return MavenDownloader.downloadArtifact(GROUP_ID, ARTIFACT_ID, VERSION,
				TYPE).getAbsolutePath();
	}
}

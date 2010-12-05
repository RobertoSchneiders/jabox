package org.jabox.scm.git;

import java.io.File;

import junit.framework.TestCase;

import org.jabox.model.Project;

public class GITFacadeTest extends TestCase {

	public void testValidate() {
		fail("Not yet implemented");
	}

	public void testCheckoutBaseDir() {
		IGITConnectorConfig gitc = new GITConnectorConfig();

		File storePath = new File("target/foo");
		storePath.mkdirs();
		new GITFacade().checkoutBaseDir(storePath, gitc);
	}

	public void testCommitProject() {
		GITFacade facade = new GITFacade();
		Project project = new Project();
		project.setName("test7");
		File tmpDir = new File("target/foo2");
		File projectDir = new File(tmpDir, "foo");
		projectDir.mkdirs();
		IGITConnectorConfig svnc = new GITConnectorConfig();
		facade.commitProject(project, tmpDir, svnc);
	}

}

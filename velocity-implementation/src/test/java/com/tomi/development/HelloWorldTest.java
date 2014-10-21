package com.tomi.development;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeConstants;
import org.junit.Test;

public class HelloWorldTest {
	
	@Test
	public void testHelloWorld() throws ResourceNotFoundException, ParseErrorException, IOException {			
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
		ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, this.getClass().getClassLoader().getResource("").getFile() + "../../src/test/resources/");
		ve.init();
				
		Template template = ve.getTemplate("helloworld.vm");

		String result = HelloWorld.getContent(template);
		assertTrue(result.length() > 0);
	}
	
	@Test
	public void testPetEmail() throws ResourceNotFoundException, ParseErrorException, IOException {			
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
		ve.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, this.getClass().getClassLoader().getResource("").getFile() + "../../src/test/resources/");
		ve.init();
				
		Template template = ve.getTemplate("petstoreemail_html.vm");

		String result = HelloWorld.getPetEmailStore(template);
		assertTrue(result.length() > 0);
	}
	
	@Test
	public void testVelocityRunTime() throws Exception {
		String result = HelloWorld.getGeneratedValue("Abrakadabra");
		assertTrue(result.length() > 0);
	}

}

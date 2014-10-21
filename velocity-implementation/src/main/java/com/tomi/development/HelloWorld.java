package com.tomi.development;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.ParseException;
import org.apache.velocity.runtime.parser.node.SimpleNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HelloWorld {
	
	private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);
	
	public static String getContent(Template template) {
		
		VelocityContext context = new VelocityContext();
		context.put("name", "Tomi");
		
		StringWriter writer = new StringWriter();		
		template.merge(context, writer);
		log.info("Implementation hello \n "+ writer.toString());
		return writer.toString();
	}
	
	public static String getPetEmailStore(Template template) {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "horse");
        map.put("price", "$100.00");
        list.add( map );
 
        map = new HashMap<String, String>();
        map.put("name", "dog");
        map.put("price", "$59.99");
        list.add( map );

        map = new HashMap<String, String>();
        map.put("name", "bear");
        map.put("price", "$3.99");
        list.add( map );
		
		VelocityContext context = new VelocityContext();
		context.put("petList", list);
		
		StringWriter writer = new StringWriter();		
		template.merge(context, writer);
		log.info("Implementation html \n "+ writer.toString());
		return writer.toString();		
	}
	
	public static String getGeneratedValue(String parameter) throws ParseException {
		RuntimeServices runtimeServices = RuntimeSingleton.getRuntimeServices();
		StringReader reader = new StringReader("  Hello $name!  Welcome to Velocity!");
		SimpleNode node = runtimeServices.parse(reader, "Template name");
		
		Template template = new Template();
		template.setRuntimeServices(runtimeServices);
		template.setData(node);
		template.initDocument();
		
		VelocityContext context = new VelocityContext();
		context.put("name", parameter);
		
		StringWriter writer = new StringWriter();	
		template.merge(context, writer);
		log.info("Implementation generated value\n "+ writer.toString());
		return writer.toString();
	}

}

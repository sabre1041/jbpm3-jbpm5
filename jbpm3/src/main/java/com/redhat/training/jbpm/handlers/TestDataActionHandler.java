package com.redhat.training.jbpm.handlers;

import java.util.Random;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generates random values for a user and amount which can be used for testing in the jBPM console if none
 * are provided
 * @author Andrew Block
 *
 */
public class TestDataActionHandler implements ActionHandler {

	static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TestDataActionHandler.class);
	
	public void execute(ExecutionContext executionContext) throws Exception {
		
		try
		{
		if(executionContext.getVariable("user") == null)
		{
			LOGGER.info("Values Not Found. Setting Random Values");
			
			int high = 150;
			int low = 50;
			
			
			Random rand = new Random();
			
			String user = "User"+rand.nextInt(10);
			String amount = String.valueOf(rand.nextInt(high-low)+low);
			
			executionContext.setVariable("user", user);
			executionContext.setVariable("amount", amount);
		}
		}
		catch(Exception e)
		{
			LOGGER.error("An Exception Occurred", e);
		}
		finally
		{
			executionContext.leaveNode();
		}
		
	}

}

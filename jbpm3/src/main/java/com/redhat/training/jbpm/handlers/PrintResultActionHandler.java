package com.redhat.training.jbpm.handlers;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Prints out debug information from the Workflow Excution
 * @author Andrew Block
 *
 */
public class PrintResultActionHandler implements ActionHandler {


	private static final long serialVersionUID = 6972048772034732206L;
	
	private static final String LINE_BREAK = "\n";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrintResultActionHandler.class);

	public void execute(ExecutionContext executionContext) throws Exception {
		
		try
		{
			String user = (String) executionContext.getVariable("user");
			String amount = (String) executionContext.getVariable("amount");
			String result = (String) executionContext.getVariable("result");
			
			StringBuilder sb = new StringBuilder();
			sb.append("***** BEGIN WORKFLOW TRACE *****");
			sb.append(LINE_BREAK);
			sb.append("User: " + user);
			sb.append(LINE_BREAK);
			sb.append("Amount: $" + amount);
			sb.append(LINE_BREAK);
			sb.append("Result: " + result);
			sb.append(LINE_BREAK);
			sb.append("***** END WORKFLOW TRACE *****");
			
			LOGGER.info(sb.toString());
			
			
		}
		catch(Exception e)
		{
			LOGGER.error("Error Occurred Printing Result", e);
		}
		finally
		{
			executionContext.leaveNode();
		}
		
		
	}

}

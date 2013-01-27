package com.redhat.training.jbpm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jbpm.graph.def.ProcessDefinition;
import org.jbpm.graph.exe.ProcessInstance;
import org.junit.Test;

public class Jbpm3WorkflowTestIT {
	
	@Test
	public void testApprovalWorkflow()
	{
		// Load Process Definition File
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource("processdefinition.xml");

		
		assertNotNull(processDefinition);
		
		ProcessInstance processInstance = new ProcessInstance(processDefinition);
		processInstance.getContextInstance().setVariable("user", "sabre1041");
		processInstance.getContextInstance().setVariable("amount", "100.00");
		
		assertEquals("Instance is at the Start State", 	processInstance.getRootToken().getNode().getName(), "start-state");
		
		
		processInstance.signal();
		
		assertTrue("Root Token has Ended", processInstance.getRootToken().hasEnded());
		
		
	}
	
	@Test
	public void testDeniedWorkflow()
	{
		// Load Process Definition File
		ProcessDefinition processDefinition = ProcessDefinition.parseXmlResource("processdefinition.xml");
		
		assertNotNull(processDefinition);
		
		ProcessInstance processInstance = new ProcessInstance(processDefinition);
		processInstance.getContextInstance().setVariable("user", "sabre1041");
		processInstance.getContextInstance().setVariable("amount", "50.00");
		
		assertEquals("Instance is at the Start State", 	processInstance.getRootToken().getNode().getName(), "start-state");
		
		
		processInstance.signal();
		
		assertTrue("Root Token has Ended", processInstance.getRootToken().hasEnded());
		
		
	}


}

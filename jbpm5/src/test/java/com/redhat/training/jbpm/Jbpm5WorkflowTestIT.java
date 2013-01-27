package com.redhat.training.jbpm;

import java.util.HashMap;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.ProcessInstance;
import org.jbpm.test.JbpmJUnitTestCase;
import org.junit.Test;


public class Jbpm5WorkflowTestIT extends JbpmJUnitTestCase  {
	
	@Test
	public void testJbpm5Approved()
	{
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("SampleWorkflow.bpmn"), ResourceType.BPMN2);
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		
//		EmailWorkItemHandler handler = new EmailWorkItemHandler("smtp.redhat.com", "25", "username", "password");
//		handler.getConnection().setStartTls(true);
//		ksession.getWorkItemManager().registerWorkItemHandler("Email", handler);

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("user", "testuser");
		params.put("amount", "120.00");
		
		
		 	
		ProcessInstance processInstance = ksession.startProcess("com.redhat.training.jbpm.jbpm5.SampleWorkflow", params);
		assertProcessInstanceCompleted(processInstance.getId(), ksession);
		

	}

}

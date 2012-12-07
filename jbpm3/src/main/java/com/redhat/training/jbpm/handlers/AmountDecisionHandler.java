package com.redhat.training.jbpm.handlers;

import java.math.BigDecimal;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.node.DecisionHandler;


/**
 * Decision Handler which determines whether to set the result to approved or denied based on the amount 
 * meeting the threshold value of 100 and take the approval or denial transition
 * @author Andrew Block
 *
 */
public class AmountDecisionHandler implements DecisionHandler {

	
	private static final long serialVersionUID = 4843616362227490130L;

	private static final String AMOUNT_PROP = "amount";
	private static final String RESULT_PROP = "result";
	
	private static final String APPROVAL_TRANSITION = "to-approval";
	private static final String DENIAL_TRANSITION = "to-denial";
	private static final BigDecimal AMOUNT_THRESHOLD = new BigDecimal(100.00);
	
	public String decide(ExecutionContext executionContext) throws Exception {
		
		String amountString = (String) executionContext.getVariable(AMOUNT_PROP);
		
		
		if(amountString == null)
		{	
			executionContext.setVariable(RESULT_PROP, "Denied");
			return DENIAL_TRANSITION;
		}
		
		BigDecimal amount = new BigDecimal(amountString);
		
		if(amount.compareTo(AMOUNT_THRESHOLD) >= 0)
		{
			executionContext.setVariable(RESULT_PROP, "Approved");
			return APPROVAL_TRANSITION;
		}
		else
		{
			executionContext.setVariable(RESULT_PROP, "Denied");
			return DENIAL_TRANSITION;
		}
		
		
		
	}

}

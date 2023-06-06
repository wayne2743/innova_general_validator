package com.wayne.general.validate.criteria;

import org.springframework.stereotype.Component;

@Component
public class ImmediatelyContainsSameSequenceCriteria extends Criteria {
	

	public ImmediatelyContainsSameSequenceCriteria() {
		super("immediatelyContainsSameSequence", 
				1, 
				"Must not contain any sequence of characters immediately followed by the same sequence.", 
				-1001);
	}

	@Override
	protected boolean checkCriteria(String input) {
		char verification = '\u0000';
		for(int i=0; i < input.length(); i++) {
			if(input.charAt(i) == verification) {
				return false;
			};
			verification = input.charAt(i);
		}
		return true;
	}

}

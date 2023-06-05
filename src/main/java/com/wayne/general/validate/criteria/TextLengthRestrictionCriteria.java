package com.wayne.general.validate.criteria;

import org.springframework.stereotype.Component;

@Component
public class TextLengthRestrictionCriteria extends Criteria {


	public TextLengthRestrictionCriteria() {
		super("textLengthRestriction", 
				3, 
				"Must be between 5 and 12 characters in length", 
				-1003);
	}

	@Override
	public boolean check(String input) {
		return input.length() >= 5 && input.length() <=12;
	}

}

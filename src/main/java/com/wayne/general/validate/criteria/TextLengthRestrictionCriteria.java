package com.wayne.general.validate.criteria;

import org.springframework.stereotype.Component;

import com.wayne.general.validate.exception.ExceptionEnum;
import com.wayne.general.validate.model.CriteriaException;

@Component
public class TextLengthRestrictionCriteria extends Criteria {


	public TextLengthRestrictionCriteria() {
		super("textLengthRestriction", 
				3, 
				"Must be between 5 and 12 characters in length", 
				-1003);
	}

	@Override
	protected boolean checkCriteria(String input) throws CriteriaException {
		if(!(input.length() >= 5 && input.length() <=12)){
			throw ExceptionEnum.TEXT_LENGTH_EXCEED_THE_RESTRICTION.toException();
		}
		return true;
	}



}

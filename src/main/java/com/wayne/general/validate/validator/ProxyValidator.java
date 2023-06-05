package com.wayne.general.validate.validator;

import javax.naming.ContextNotEmptyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wayne.general.validate.criteria.Criteria;
import com.wayne.general.validate.criteria.ImmediatelyContainsSameSequenceCriteria;
import com.wayne.general.validate.criteria.LowerCaseAndDigitContainsCriteria;
import com.wayne.general.validate.criteria.TextLengthRestrictionCriteria;
import com.wayne.general.validate.validator.interf.PasswordValidate;

@Component
public class ProxyValidator implements PasswordValidate{
	
	@Autowired
	Validator validator;
	

	private void checkIsInputNullOrNone(String input, Criteria... criterias) throws Exception {
		
		if(input == null || input.equals("")) {
			throw new ContextNotEmptyException("Input text for password validator is empty, please check!");
		}
	}

	@Override
	public boolean checkPassword(String input,
			ImmediatelyContainsSameSequenceCriteria immediatelyContainsSameSequenceCriteria,
			LowerCaseAndDigitContainsCriteria lowerCaseAndDigitContainsCriteria,
			TextLengthRestrictionCriteria textLengthRestricionCriteria) throws Exception {
		boolean result = false;
		// Could add more logic here... if you want
		checkIsInputNullOrNone(input);
		result = validator.checkPassword(input, immediatelyContainsSameSequenceCriteria, lowerCaseAndDigitContainsCriteria, textLengthRestricionCriteria);
		
		
		return result;
	}


	
}

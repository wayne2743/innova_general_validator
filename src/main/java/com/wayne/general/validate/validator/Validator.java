package com.wayne.general.validate.validator;

import org.springframework.stereotype.Component;

import com.wayne.general.validate.criteria.ImmediatelyContainsSameSequenceCriteria;
import com.wayne.general.validate.criteria.LowerCaseAndDigitContainsCriteria;
import com.wayne.general.validate.criteria.TextLengthRestrictionCriteria;
import com.wayne.general.validate.validator.interf.PasswordValidate;

@Component
public class Validator implements PasswordValidate{ // You can put every interface you want to enhance the function.
	

	@Override
	public boolean checkPassword(String input,
			ImmediatelyContainsSameSequenceCriteria immediatelyContainsSameSequenceCriteria,
			LowerCaseAndDigitContainsCriteria lowerCaseAndDigitContainsCriteria,
			TextLengthRestrictionCriteria textLengthRestricionCriteria) throws Exception {
		
		return textLengthRestricionCriteria.check(input) &&
				lowerCaseAndDigitContainsCriteria.check(input) &&
				immediatelyContainsSameSequenceCriteria.check(input);
	}
}

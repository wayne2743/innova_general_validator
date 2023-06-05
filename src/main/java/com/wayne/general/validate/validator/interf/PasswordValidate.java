package com.wayne.general.validate.validator.interf;

import com.wayne.general.validate.criteria.ImmediatelyContainsSameSequenceCriteria;
import com.wayne.general.validate.criteria.LowerCaseAndDigitContainsCriteria;
import com.wayne.general.validate.criteria.TextLengthRestrictionCriteria;

public interface PasswordValidate {

	boolean checkPassword(String input,
			ImmediatelyContainsSameSequenceCriteria immediatelyContainsSameSequenceCriteria,
			LowerCaseAndDigitContainsCriteria lowerCaseAndDigitContainsCriteria,
			TextLengthRestrictionCriteria textLengthRestricionCriteria) throws Exception;
}

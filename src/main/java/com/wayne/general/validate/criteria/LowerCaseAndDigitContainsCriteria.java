package com.wayne.general.validate.criteria;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.wayne.general.validate.exception.ExceptionEnum;
import com.wayne.general.validate.model.CriteriaException;

@Component
public class LowerCaseAndDigitContainsCriteria extends Criteria {

	private static final String LOWER_CASE_AND_DIGIT_CONTAINS_REGEX = "^(?=.*[a-z])(?=.*[0-9]).*$";

	public LowerCaseAndDigitContainsCriteria() {
		super("lowerCaseAndDigitContains",
				2,
				"Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each",
				-1002);
	}

	@Override
	protected boolean checkCriteria(String input) throws CriteriaException {
		Pattern pattern = Pattern.compile(LOWER_CASE_AND_DIGIT_CONTAINS_REGEX);
		if(!pattern.matcher(input).matches()){
			throw ExceptionEnum.LOWER_CASE_AND_DIGIT_NOT_CONTAINS.toException();
		}
		return true;
	}

}

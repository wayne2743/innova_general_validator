package com.wayne.general.validate.criteria;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

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
	protected boolean checkCriteria(String input) {
		Pattern pattern = Pattern.compile(LOWER_CASE_AND_DIGIT_CONTAINS_REGEX);
		return pattern.matcher(input).matches();
	}

}

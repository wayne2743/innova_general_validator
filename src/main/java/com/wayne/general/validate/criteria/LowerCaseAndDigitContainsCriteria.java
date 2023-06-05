package com.wayne.general.validate.criteria;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;



@Component
public class LowerCaseAndDigitContainsCriteria extends Criteria {

	public LowerCaseAndDigitContainsCriteria() {
		super("lowerCaseAndDigitContains", 
				2,
				"Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each",
				-1002);
	}

	@Override
	public boolean check(String input) {
		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[0-9]).*$");
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

}

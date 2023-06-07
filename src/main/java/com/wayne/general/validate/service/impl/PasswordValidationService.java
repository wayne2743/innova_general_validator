package com.wayne.general.validate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wayne.general.validate.criteria.ImmediatelyContainsSameSequenceCriteria;
import com.wayne.general.validate.criteria.LowerCaseAndDigitContainsCriteria;
import com.wayne.general.validate.criteria.TextLengthRestrictionCriteria;
import com.wayne.general.validate.service.ValidationService;
import com.wayne.general.validate.validator.ProxyValidator;

@Service
public class PasswordValidationService implements ValidationService {

	@Autowired
	ProxyValidator proxyValidator;

	@Override
	public boolean validate(String input) throws Exception {
		return proxyValidator.checkPassword(input, new ImmediatelyContainsSameSequenceCriteria(),
				new LowerCaseAndDigitContainsCriteria(), new TextLengthRestrictionCriteria());
	}

}

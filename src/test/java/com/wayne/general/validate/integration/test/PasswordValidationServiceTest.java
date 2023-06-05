package com.wayne.general.validate.integration.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.wayne.general.validate.criteria.ImmediatelyContainsSameSequenceCriteria;
import com.wayne.general.validate.criteria.LowerCaseAndDigitContainsCriteria;
import com.wayne.general.validate.criteria.TextLengthRestrictionCriteria;
import com.wayne.general.validate.service.ValidationService;
import com.wayne.general.validate.validator.ProxyValidator;

@SpringBootTest
class PasswordValidationServiceTest {
	
	@Autowired
	@Qualifier(value = "passwordValidationService")
	ValidationService passwordValidationService;
	
	
	@Test
	public void whenProxyValidatorCheckPasswordReturnTrue_thenPasswordValidationReturnTrue() throws Exception {
		
		String validString = "test123";
		assertThat(passwordValidationService.validate(validString)).isTrue();
	}
	
	@Test
	public void whenProxyValidatorCheckPasswordReturnFalse_thenPasswordValidationReturnTrue() throws Exception {
		
		String validString = "tes";
		assertThat(passwordValidationService.validate(validString)).isFalse();
	}	

}

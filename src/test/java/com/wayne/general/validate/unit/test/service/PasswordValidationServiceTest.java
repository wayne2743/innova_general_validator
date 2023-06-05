package com.wayne.general.validate.unit.test.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

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
	
	
	
	@MockBean
	ProxyValidator proxyValidator;
	
	@Test
	public void whenProxyValidatorCheckPasswordReturnTrue_thenPasswordValidationReturnTrue() throws Exception {
		Mockito.when(proxyValidator.checkPassword(Mockito.anyString(), 
												  Mockito.any(ImmediatelyContainsSameSequenceCriteria.class), 
												  Mockito.any(LowerCaseAndDigitContainsCriteria.class), 
												  Mockito.any(TextLengthRestrictionCriteria.class)))
									.thenReturn(Boolean.TRUE);
		
		assertThat(passwordValidationService.validate(UUID.randomUUID().toString())).isTrue();
	}
	
	@Test
	public void whenProxyValidatorCheckPasswordReturnFalse_thenPasswordValidationReturnTrue() throws Exception {
		Mockito.when(proxyValidator.checkPassword(Mockito.anyString(), 
												  Mockito.any(ImmediatelyContainsSameSequenceCriteria.class), 
												  Mockito.any(LowerCaseAndDigitContainsCriteria.class), 
												  Mockito.any(TextLengthRestrictionCriteria.class)))
									.thenReturn(Boolean.FALSE);
		
		assertThat(passwordValidationService.validate(UUID.randomUUID().toString())).isFalse();
	}	

}

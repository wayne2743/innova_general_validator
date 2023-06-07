package com.wayne.general.validate.integration.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.wayne.general.validate.exception.ExceptionEnum;
import com.wayne.general.validate.model.CriteriaException;
import com.wayne.general.validate.service.ValidationService;

@SpringBootTest
public class PasswordValidationServiceIntegrationTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier(value = "passwordValidationService")
	ValidationService passwordValidationService;
	
	
	@Test
	public void whenValidStringInput_thenPasswordValidationReturnTrue() throws Exception {
		
		String validString = "test123";
		assertThat(passwordValidationService.validate(validString)).isTrue();
	}
	
	@Test
	public void whenInvalidTextLengthStringInput_thenPasswordValidationServiceThrowTextLengthExceedTheRestrictionException() throws Exception {
		
		String invalidTextLengthString = "tes";

		CriteriaException exception = assertThrows(CriteriaException.class, ()->{
			passwordValidationService.validate(invalidTextLengthString);
		});
		logger.info(exception.toString());
		assertEquals(ExceptionEnum.TEXT_LENGTH_EXCEED_THE_RESTRICTION.getErrorMsg(), exception.getErrorMsg());
	}	 

	@Test
	public void whenInvalidOnlyLowerCaseStringInput_thenPasswordValidationServiceThrowTextLengthExceedTheRestrictionException() throws Exception {
		
		String invalidOnlyLowerCaseString = "testest";

		CriteriaException exception = assertThrows(CriteriaException.class, ()->{
			passwordValidationService.validate(invalidOnlyLowerCaseString);
		});
		logger.info(exception.toString());
		assertEquals(ExceptionEnum.LOWER_CASE_AND_DIGIT_NOT_CONTAINS.getErrorMsg(), exception.getErrorMsg());
	}	 

	@Test
	public void whenInvalidSameSequenceStringInput_thenPasswordValidationServiceThrowTextLengthExceedTheRestrictionException() throws Exception {
		
		String invalidSameSequenceString = "testt123";

		CriteriaException exception = assertThrows(CriteriaException.class, ()->{
			passwordValidationService.validate(invalidSameSequenceString);
		});
		logger.info(exception.toString());
		assertEquals(ExceptionEnum.IMMEDIATELY_CONTAINS_SAME_SEQUENCE.getErrorMsg(), exception.getErrorMsg());
	}	 
}

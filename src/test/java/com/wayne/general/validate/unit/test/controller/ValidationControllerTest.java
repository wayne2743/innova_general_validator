
package com.wayne.general.validate.unit.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.wayne.general.validate.controller.ValidationController;
import com.wayne.general.validate.exception.ExceptionEnum;
import com.wayne.general.validate.model.ValidatorResponse;
import com.wayne.general.validate.service.ValidationService;

@SpringBootTest
class ValidationControllerTest {

	@Autowired
	private ValidationController validationController;

	@MockBean
	private ValidationService validationService;

	@Test
	public void whenValidInput_thenValidControllerPasswordCheckReturnTrue() throws Exception {
		Mockito.when(validationService.validate(Mockito.anyString())).thenReturn(Boolean.TRUE);

		String validInput = UUID.randomUUID().toString();
		System.out.println(validationController.passwordCheck(validInput));
		assertEquals(validationController.passwordCheck(validInput), 
														new ValidatorResponse(HttpStatus.OK.value(), 
																			"Success", 
																				ExceptionEnum.SUCCESS.toException().getErrorCode(), 
																				ExceptionEnum.SUCCESS.toException().getErrorMsg()) 
														);

	}
}

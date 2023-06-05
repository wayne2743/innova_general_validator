
package com.wayne.general.validate.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
		assertThat(validationController.passwordCheck(validInput)).isTrue();

	}
}

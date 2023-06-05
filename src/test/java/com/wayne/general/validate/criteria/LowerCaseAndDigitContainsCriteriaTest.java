package com.wayne.general.validate.criteria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LowerCaseAndDigitContainsCriteriaTest {

	@Autowired
	LowerCaseAndDigitContainsCriteria lowerCaseAndDigitContainsCriteria;

	@Test
	void whenValidInput_thenLowerCaseAndDigitConstainsShouldReturnTrue() {
		String validText = "test123";
		assertThat(lowerCaseAndDigitContainsCriteria.check(validText)).isTrue();
	}

	@Test
	void whenOnlyContainsLowercaseInput_thenLowerCaseAndDigitConstainsShouldReturnFalse() {
		String inValidTest = "test";
		assertThat(lowerCaseAndDigitContainsCriteria.check(inValidTest)).isFalse();

	}

	@Test
	void whenOnlyContainsDigitInput_thenLowerCaseAndDigitConstainsShouldReturnFalse() {
		String inValidTest = "123";
		assertThat(lowerCaseAndDigitContainsCriteria.check(inValidTest)).isFalse();

	}

}
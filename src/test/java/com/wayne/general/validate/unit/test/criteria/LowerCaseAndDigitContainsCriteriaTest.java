package com.wayne.general.validate.unit.test.criteria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.wayne.general.validate.criteria.Criteria;
import com.wayne.general.validate.criteria.LowerCaseAndDigitContainsCriteria;

@SpringBootTest
class LowerCaseAndDigitContainsCriteriaTest extends BasedCriteriaTest {

	public LowerCaseAndDigitContainsCriteriaTest(
			@Autowired @Qualifier(value = "lowerCaseAndDigitContainsCriteria") Criteria criteria) {
		super(criteria);
	}

	@Test
	void whenValidInput_thenLowerCaseAndDigitConstainsShouldReturnTrue() {
		String validText = "test123";
		assertThat(criteria.check(validText)).isTrue();
	}

	@Test
	void whenOnlyContainsLowercaseInput_thenLowerCaseAndDigitConstainsShouldReturnFalse() {
		String inValidTest = "test";
		assertThat(criteria.check(inValidTest)).isFalse();

	}

	@Test
	void whenOnlyContainsDigitInput_thenLowerCaseAndDigitConstainsShouldReturnFalse() {
		String inValidTest = "123";
		assertThat(criteria.check(inValidTest)).isFalse();

	}

}

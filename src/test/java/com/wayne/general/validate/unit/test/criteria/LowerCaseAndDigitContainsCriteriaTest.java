package com.wayne.general.validate.unit.test.criteria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.wayne.general.validate.criteria.Criteria;
import com.wayne.general.validate.exception.ExceptionEnum;
import com.wayne.general.validate.model.CriteriaException;

@SpringBootTest
class LowerCaseAndDigitContainsCriteriaTest extends BasedCriteriaTest {

	public LowerCaseAndDigitContainsCriteriaTest(
			@Autowired @Qualifier(value = "lowerCaseAndDigitContainsCriteria") Criteria criteria) {
		super(criteria);
	}

	@Test
	void whenValidInput_thenLowerCaseAndDigitConstainsShouldReturnTrue() throws CriteriaException {
		String validText = "test123";
		assertThat(criteria.check(validText)).isTrue();
	}

	@Test
	void whenOnlyContainsLowercaseInput_thenLowerCaseAndDigitConstainsShouldThrowCriteriaException() throws CriteriaException {
		String invalidInput = "test";
		assertThrows(CriteriaException.class, ()->{
			criteria.check(invalidInput);
		}, ExceptionEnum.LOWER_CASE_AND_DIGIT_NOT_CONTAINS.getErrorMsg());
	}

	@Test
	void whenOnlyContainsDigitInput_thenLowerCaseAndDigitConstainsShouldThrowCriteriaException() throws CriteriaException {
		String invalidInput = "123";
		assertThrows(CriteriaException.class, ()->{
			criteria.check(invalidInput);
		}, ExceptionEnum.LOWER_CASE_AND_DIGIT_NOT_CONTAINS.getErrorMsg());
	}

}

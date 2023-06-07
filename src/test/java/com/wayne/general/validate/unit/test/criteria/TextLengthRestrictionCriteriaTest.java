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
class TextLengthRestrictionCriteriaTest extends BasedCriteriaTest{
	
	public TextLengthRestrictionCriteriaTest(@Autowired @Qualifier(value = "textLengthRestrictionCriteria") Criteria criteria) {
		super(criteria);
	}

	@Test
	void whenValidInput_thenTextLengthRestrictionCriteriaReturnTrue() throws CriteriaException {
		String validInput = "test123";
		assertThat(criteria.check(validInput)).isTrue();
	}
	
	@Test
	void whenLowerBoundaryCharacterInput_thenTextLengthRestrictionCriteriaThrowCriteriaException() throws CriteriaException {
		String  lowerBondaryCharacterInput = "123";
		assertThrows(CriteriaException.class, ()->{
			criteria.check(lowerBondaryCharacterInput);
		}, ExceptionEnum.LOWER_CASE_AND_DIGIT_NOT_CONTAINS.getErrorMsg());
	}

	@Test
	void whenUpperBondaryCharacterInput_thenTextLengthRestrictionCriteriaThrowCriteriaException() throws CriteriaException {
		String  upperBoundaryCharacterInput = "test123123test";
		assertThrows(CriteriaException.class, ()->{
			criteria.check(upperBoundaryCharacterInput);
		}, ExceptionEnum.LOWER_CASE_AND_DIGIT_NOT_CONTAINS.getErrorMsg());
	}

}

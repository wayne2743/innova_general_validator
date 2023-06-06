package com.wayne.general.validate.unit.test.criteria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.wayne.general.validate.criteria.Criteria;
import com.wayne.general.validate.criteria.TextLengthRestrictionCriteria;

@SpringBootTest
class TextLengthRestrictionCriteriaTest extends BasedCriteriaTest{
	
	public TextLengthRestrictionCriteriaTest(@Autowired @Qualifier(value = "textLengthRestrictionCriteria") Criteria criteria) {
		super(criteria);
		// TODO Auto-generated constructor stub
	}

	@Test
	void whenValidInput_thenTextLengthRestrictionCriteriaReturnTrue() {
		String validInput = "test123";
		assertThat(criteria.check(validInput)).isTrue();
	}
	
	@Test
	void whenLowerBoundaryCharacterInput_thenTextLengthRestrictionCriteriaReturnFalse() {
		String  lowerBondaryCharacterInput = "123";
		assertThat(criteria.check(lowerBondaryCharacterInput)).isFalse();
	}

	@Test
	void whenUpperBondaryCharacterInput_thenTextLengthRestrictionCriteriaReturnFalse() {
		String  upperBoundaryCharacterInput = "test123123test";
		assertThat(criteria.check(upperBoundaryCharacterInput)).isFalse();
	}

}

package com.wayne.general.validate.unit.test.criteria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wayne.general.validate.criteria.TextLengthRestrictionCriteria;

@SpringBootTest
class TextLengthRestrictionCriteriaTest {
	
	@Autowired
	TextLengthRestrictionCriteria textLengthRestrictionCriteria;
	
	@Test
	void whenValidInput_thenTextLengthRestrictionCriteriaReturnTrue() {
		String validInput = "test123";
		assertThat(textLengthRestrictionCriteria.check(validInput)).isTrue();
	}
	
	@Test
	void whenLowerBoundaryCharacterInput_thenTextLengthRestrictionCriteriaReturnFalse() {
		String  lowerBondaryCharacterInput = "123";
		assertThat(textLengthRestrictionCriteria.check(lowerBondaryCharacterInput)).isFalse();
	}

	@Test
	void whenUpperBondaryCharacterInput_thenTextLengthRestrictionCriteriaReturnFalse() {
		String  upperBoundaryCharacterInput = "test123123test";
		assertThat(textLengthRestrictionCriteria.check(upperBoundaryCharacterInput)).isFalse();
	}

}

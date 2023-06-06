package com.wayne.general.validate.unit.test.criteria;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.wayne.general.validate.criteria.Criteria;

public abstract class BasedCriteriaTest {
	
	Criteria criteria;
	
	
	
	public BasedCriteriaTest(Criteria criteria) {
		this.criteria = criteria;
	}

	@Test
	void whenNullInput_thenCriteriaShouldThrowNullPointException() {
		String validInput = null;
		assertThrows(NullPointerException.class, () -> {
			criteria.check(validInput);
		});
	}
	
	@Test
	void whenEmptyInput_thenCriteriaShouldThrowNullPointException() {
		String validInput = "";
		assertThrows(NullPointerException.class, () -> {
			criteria.check(validInput);
		});
	}
	

}

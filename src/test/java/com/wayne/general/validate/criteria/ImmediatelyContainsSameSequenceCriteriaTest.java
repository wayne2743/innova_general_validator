package com.wayne.general.validate.criteria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImmediatelyContainsSameSequenceCriteriaTest {

	@Autowired
	ImmediatelyContainsSameSequenceCriteria immediatelyContainsSameSequenceCriteria;

	@Test
	void whenValidInput_thenImmediatelyContainsSameSequenceShouldReturnTrue() {
		String validInput = "test";
		assertThat(immediatelyContainsSameSequenceCriteria.check(validInput)).isTrue();
	}

	@Test
	void whenInvalidInput_thenImmediatelyContainsSameSequenceShouldReturnFalse() {
		String invalidInput = "ttst";
		assertThat(immediatelyContainsSameSequenceCriteria.check(invalidInput)).isFalse();
	}

}

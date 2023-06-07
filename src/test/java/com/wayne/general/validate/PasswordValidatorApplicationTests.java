package com.wayne.general.validate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wayne.general.validate.criteria.ImmediatelyContainsSameSequenceCriteria;

@SpringBootTest
class PasswordValidatorApplicationTests {

	@Autowired
	ImmediatelyContainsSameSequenceCriteria immediatelyContainsSameSequenceCriteria;

	@Test
	void contextLoads() {
	}

}

package com.wayne.general.validate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wayne.general.validate.criteria.ImmediatelyContainsSameSequenceCriteria;
import com.wayne.general.validate.criteria.LowerCaseAndDigitContainsCriteria;

@SpringBootTest
class PasswordValidatorApplicationTests {
	
	
	@Autowired
	ImmediatelyContainsSameSequenceCriteria immediatelyContainsSameSequenceCriteria;
	
	
	
	@Test
	void contextLoads() {
	}
	
	
	@Test
	void testImmediatelyContainsSameSequenceCriteria() {
		System.out.println(immediatelyContainsSameSequenceCriteria.check("test123"));
	}
	
	
}

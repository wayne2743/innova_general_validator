package com.wayne.general.validate.unit.test.validator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.wayne.general.validate.criteria.ImmediatelyContainsSameSequenceCriteria;
import com.wayne.general.validate.criteria.LowerCaseAndDigitContainsCriteria;
import com.wayne.general.validate.criteria.TextLengthRestrictionCriteria;
import com.wayne.general.validate.validator.Validator;

@SpringBootTest
class ValidatorTest {

	@Autowired
	private Validator validator;
	
	@MockBean
	ImmediatelyContainsSameSequenceCriteria immediatelyContainsSameSequenceCriteria;
	
	@MockBean
	LowerCaseAndDigitContainsCriteria lowerCaseAndDigitContainsCriteria;
	
	@MockBean
	TextLengthRestrictionCriteria textLengthRestrictionCriteria;
	
	@Test
	void whenTextRestrictionCheckReturnTrueAndLowerDigitContainsReturnTrueAndImmediatelyContainsSameSequenceReturnTrue_thenValidatorCheckPasswordReturnTrue() throws Exception {
		Mockito.when(immediatelyContainsSameSequenceCriteria.check(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(lowerCaseAndDigitContainsCriteria.check(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(textLengthRestrictionCriteria.check(Mockito.anyString())).thenReturn(Boolean.TRUE);

		
		assertThat(validator.checkPassword(UUID.randomUUID().toString(), immediatelyContainsSameSequenceCriteria, lowerCaseAndDigitContainsCriteria, textLengthRestrictionCriteria)).isTrue();
		
	}
}

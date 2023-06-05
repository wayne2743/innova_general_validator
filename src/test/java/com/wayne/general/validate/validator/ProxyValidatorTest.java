package com.wayne.general.validate.validator;

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

@SpringBootTest
class ProxyValidatorTest {

	@Autowired
	ProxyValidator proxyValidator;
	
	@MockBean
	Validator validator;
	
	@Test
	void whenValidatorCheckPasswordReturnTrue_thenProxyValidatorCheckPasswordReturnTrue() throws Exception {
		Mockito.when(validator.checkPassword(Mockito.anyString(), 
											 Mockito.any(ImmediatelyContainsSameSequenceCriteria.class), 
											 Mockito.any(LowerCaseAndDigitContainsCriteria.class), 
											 Mockito.any(TextLengthRestrictionCriteria.class)))
							  .thenReturn(Boolean.TRUE);
		
		assertThat(proxyValidator.checkPassword(UUID.randomUUID().toString(), new ImmediatelyContainsSameSequenceCriteria(), new LowerCaseAndDigitContainsCriteria(), new TextLengthRestrictionCriteria())).isTrue();
	}
	

}

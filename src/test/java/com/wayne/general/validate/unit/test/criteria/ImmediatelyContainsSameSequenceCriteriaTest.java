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
class ImmediatelyContainsSameSequenceCriteriaTest extends BasedCriteriaTest {

	public ImmediatelyContainsSameSequenceCriteriaTest(
			@Autowired @Qualifier(value = "immediatelyContainsSameSequenceCriteria") Criteria criteria) {
		super(criteria);
	}

	@Test
	void whenValidInput_thenImmediatelyContainsSameSequenceShouldReturnTrue() throws CriteriaException {
		String validInput = "test";
		assertThat(criteria.check(validInput)).isTrue();
	}

	@Test
	void whenInvalidInput_thenImmediatelyContainsSameSequenceShouldThrowCriteriaException() throws CriteriaException {
		String invalidInput = "ttst";
		assertThrows(CriteriaException.class, ()->{
			criteria.check(invalidInput);
		}, ExceptionEnum.IMMEDIATELY_CONTAINS_SAME_SEQUENCE.getErrorMsg());
	}
	
	@Test
	void whenVeryLongStrInput_thenImmediatelyContainsSameSequenceShouldThrowCriteriaException() throws CriteriaException {
		String longInputString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed posuere metus in diam sagittis, quis facilisis est venenatis. Pellentesque sed lacinia turpis, ac tincidunt mauris. Integer dapibus ligula ut tellus laoreet, in eleifend mauris bibendum. Aliquam tincidunt justo a finibus congue. Fusce id lorem justo. Proin vulputate massa sit amet pellentesque pellentesque. Etiam at volutpat nulla, non condimentum metus. Suspendisse laoreet arcu a eros bibendum, at malesuada elit pulvinar. Suspendisse ac bibendum ipsum. Fusce non malesuada neque. Aenean eget luctus est. Phasellus dapibus augue at eros feugiat, in tempor leo dignissim. Donec pharetra, quam eu ultrices tincidunt, enim velit maximus sem, at eleifend arcu nisi vitae neque. Integer et commodo lacus.";
		assertThrows(CriteriaException.class, ()->{
			criteria.check(longInputString);
		}, ExceptionEnum.IMMEDIATELY_CONTAINS_SAME_SEQUENCE.getErrorMsg());
	}
}

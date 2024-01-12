package com.fox.task13;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class CalculatorTest {

	Calculator calculator = new Calculator();

	@Test
	void testCalculatorResult() {
		int a = 7123;
		int b = 7;
		boolean isStepEqual = true;
		DivisionResult actual = calculator.divide(a, b);
		DivisionResult expected = new DivisionResult(7123, 7, 1017, 4, Arrays.asList(new Step(7, 7, 0, 1),
				new Step(1, 0, 1, 0), new Step(12, 7, 5, 1), new Step(53, 49, 4, 7)));
		Assertions.assertEquals(expected.getDividend(), actual.getDividend());
		Assertions.assertEquals(expected.getDivisor(), actual.getDivisor());
		Assertions.assertEquals(expected.getQuotient(), actual.getQuotient());
		Assertions.assertEquals(expected.getReminder(), actual.getReminder());
		for (int i = 0; i < expected.getSteps().size(); i++) {
			if (!(expected.getSteps().get(i).getDifference() == actual.getSteps().get(i).getDifference())) {
				isStepEqual = false;
			}
		}
		Assertions.assertTrue(isStepEqual);
	}
}
//
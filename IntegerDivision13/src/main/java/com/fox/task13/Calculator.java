package com.fox.task13;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	public DivisionResult divide(int dividend, int divisor) {
		int quotient;
		int reminder;
		int currentMinuend; // зменьшуване
		int currentSubtrahend; // відʼємник
		int currentDifference = 0; // різниця
		int currentQuotient;
		int[] dividendArr;
		List<Step> steps = new ArrayList<Step>();
		quotient = dividend / divisor;
		reminder = dividend % divisor;
		dividendArr = MathUtils.toDigits(dividend);

		for (int i = 0; i < String.valueOf(dividend).length(); i++) {
			currentMinuend = dividendArr[i];
			if (i > 0 && currentDifference > 0) {
				currentMinuend = MathUtils.joinNumbers(steps.get(i - 1).getDifference(), dividendArr[i]);
			}
			if (currentMinuend >= divisor) {
				currentQuotient = currentMinuend / divisor;
				currentSubtrahend = currentQuotient * divisor;
				currentDifference = currentMinuend - currentSubtrahend;
				steps.add(new Step(currentMinuend, currentSubtrahend, currentDifference, currentQuotient));
			} else {
				if (i > 0) {
					currentMinuend = MathUtils.joinNumbers(steps.get(i - 1).getDifference(), dividendArr[i]);
				}
				currentSubtrahend = 0;
				currentDifference = currentMinuend;
				currentQuotient = 0;
				steps.add(new Step(currentMinuend, currentSubtrahend, currentDifference, currentQuotient));
			}
		}
		return new DivisionResult(dividend, divisor, quotient, reminder, steps);
	}

}

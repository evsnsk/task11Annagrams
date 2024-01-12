package com.fox.task13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DivisionResult {
	private final int dividend;
	private final int divisor;
	private final int quotient;
	private final int reminder;
	private final List<Step> steps;

	public DivisionResult(int dividend, int divisor, int quotient, int reminder, List<Step> steps) {
		this.dividend = dividend;
		this.divisor = divisor;
		this.quotient = quotient;
		this.reminder = reminder;
		this.steps = Collections.unmodifiableList(steps);
	}

	public int getDividend() {
		return dividend;
	}

	public int getDivisor() {
		return divisor;
	}

	public int getQuotient() {
		return quotient;
	}

	public int getReminder() {
		return reminder;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void stepsView() {
		for (int i = 0; i < steps.size(); i++) {
			System.out.println(i + " step:");
			System.out.println("(" + steps.get(i).getMinuend() + ", " + steps.get(i).getSubtrahend() + ", "
					+ steps.get(i).getDifference() + ", " + steps.get(i).getQuotient() + ")");
		}

	}
}

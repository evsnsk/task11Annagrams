package com.fox.task13;

public class Step {
	private final int minuend; // зменьшуване
	private final int subtrahend; // відʼємник
	private final int difference; // різниця
	private final int quotient; // цифра результату

	public Step(int minuend, int subtrahend, int difference, int quotient) {
		this.minuend = minuend;
		this.subtrahend = subtrahend;
		this.difference = difference;
		this.quotient = quotient;

	}

	public int getMinuend() {
		return minuend;
	}

	public int getSubtrahend() {
		return subtrahend;
	}

	public int getDifference() {
		return difference;
	}

	public int getQuotient() {
		return quotient;
	}

}
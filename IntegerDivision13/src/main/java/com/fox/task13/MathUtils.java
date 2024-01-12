package com.fox.task13;

public class MathUtils {

	public static int joinNumbers(int value1, int value2) {
		return value1 * 10 + value2;
	}

	public static int[] toDigits(int num) {
		if (num < 0) {
			return toDigits(-num);
		} else {
			int numLength = length(num);
			int[] digits = new int[numLength];
			int current = num;
			for (int i = numLength - 1; i >= 0; i--) {
				digits[i] = current % 10;
				current /= 10;
			}
			return digits;
		}
	}

	public static int length(int num) {
		if (num < 0) {
			return length(-num) + 1;
		} else {
			return (num < 10) ? 1 : (int) (Math.log10(num) + 1);
		}
	}

}

package com.fox.task13;

import java.util.Arrays;

public class StringUtils {

	public static final char SPACE = ' ';
	public static final char DASH = '-';

	public static CharSequence repeatedChar(char c, int length) {
		char[] chars = new char[length];
		Arrays.fill(chars, c);
		return new StringBuilder().append(chars);
	}

	public static CharSequence spacer(int length) {
		return repeatedChar(SPACE, length);
	}

	public static CharSequence dashLine(int length) {
		return repeatedChar(DASH, length);
	}

}

package com.fox.task13;

public class Main {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		DivisionResult result = calculator.divide(7123, 7);
		Formatter classic = new ClassicFormatter();
		String output = classic.format(result);
		System.out.println(output);

	}
}
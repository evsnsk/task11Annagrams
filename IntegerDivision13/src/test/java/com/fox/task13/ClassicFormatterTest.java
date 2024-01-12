package com.fox.task13;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClassicFormatterTest {

	DivisionResult result = new DivisionResult(72172, 72, 1002, 28, Arrays.asList(new Step(7, 0, 7, 0),
			new Step(72, 72, 0, 1), new Step(1, 0, 1, 0), new Step(17, 0, 17, 0), new Step(172, 144, 28, 2)));
	Formatter classic = new ClassicFormatter();

	@Test
	void testClassicFormatter() {
		String actual = classic.format(result);
		String expected = """
				_72172|72
				 72   |----
				 --   |1002
				  _172
				   144
				   ---
				    28""";

		Assertions.assertEquals(expected, actual);
	}

}

package org.alex.Test;

import org.alex.StringUtils.JaroWinkler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JaroWinklerTest {
	/*
	Input space conditions:
	stringA == stringB

	Special/Boundary conditions:
	stringA || stringB is ""
	stringA || stringB is null
	stringA || stringB contain special characters (non-alpha ex. !, $, ... or language ex. ö, ä)
	lengthPrefix > 4
	lengthPrefix < 0
	scalingFactor > 0.25
	scalingFactor < 0
	 */

	@Test
	public void matchingStringsJaroTest() {
		String stringA = "hello world";
		String stringB = "hello world";
		double expectedOutput = 1;

		assertEquals(expectedOutput, JaroWinkler.getJaroDistance(stringA, stringB), 0);
	}
}

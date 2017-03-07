package org.alex.Test;

import org.alex.StringUtils.BagOfWords;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BagOfWordsTest {
	/*
	Input space conditions:
	stringA == stringB

	Special/Boundary conditions:
	stringA || stringB is ""
	stringA || stringB is null
	stringA || stringB contain special characters (non-alpha ex. !, $, ... or language ex. ö, ä)
	 */

	@Test
	public void matchingStringsBagOfWordsTest() {
		String stringA = "hello world";
		String stringB = "hello world";
		double expectedOutput = 1;

		assertEquals(expectedOutput, BagOfWords.getBagOfWordsDistance(stringA, stringB), 0);
	}
}

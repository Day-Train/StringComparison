package org.alex.Test;

import org.alex.StringUtils.NGram;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NGramTest {
	/*
	Input space conditions:
	stringA == stringB

	Special/Boundary conditions:
	stringA || stringB is ""
	stringA || stringB is null
	stringA || stringB contain special characters (non-alpha ex. !, $, ... or language ex. ö, ä)
	 */

	@Test
	public void matchingStringsNGramTest() {
		String stringA = "hello world";
		String stringB = "hello world";
		int gramSize = 2;
		double expectedOutput = 1;

		assertEquals(expectedOutput, NGram.getNGramDistance(stringA, stringB, gramSize), 0);
	}
}

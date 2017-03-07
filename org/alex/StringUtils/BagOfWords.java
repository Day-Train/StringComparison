package org.alex.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class BagOfWords {

	private BagOfWords() {}

	private static BagOfWords INSTANCE = new BagOfWords();

	public static BagOfWords getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * Find the Bag of Words distance between two Strings.
	 * @param stringA a String of words; requires words be space delimited.
	 * @param stringB a String of words; requires words be space delimited.
	 * @return the Bag of Words distance between two stringA and stringB normalized between 0 and 1.
	 */
	public static double getBagOfWordsDistance(String stringA, String stringB) {
		
		double result = 0;
		String[] arrayA = stringA.split(" ");
		String[] arrayB = stringB.split(" ");
		
		//Generate unique set of elements from corpus of words in input
		Set<String> setAB = new HashSet<String>(Arrays.asList(arrayA));
		setAB.addAll(Arrays.asList(arrayB));
		
		int mySetCount = setAB.size();
		
		String[] arrayC = setAB.toArray(new String[mySetCount]);
		
		//Declare input as arrays to match format of corpus of elements
		int[] arrayAPrime = new int[mySetCount];
		int[] arrayBPrime = new int[mySetCount];
		 
		//Transcribe frequency of elements in input strings to corpus element vector
		for (int i = 0; i<arrayA.length; i++) {
			for (int j = 0; j<arrayC.length; j++) {
				if (arrayA[i].equalsIgnoreCase(arrayC[j])) {
					arrayAPrime[j]++;
				}
			}
		} 
		
		for (int i = 0; i<arrayB.length; i++) {
			for (int j = 0; j<arrayC.length; j++) {
				if (arrayB[i].equalsIgnoreCase(arrayC[j])) {
					arrayBPrime[j]++;
				}
			}
		} 
		
		//Compute normalized distance
		double[] arrayDiff = new double[mySetCount];
		
		//Compute sum of squares of differences
		for (int i = 0; i<arrayC.length; i++) {
			arrayDiff[i] = Math.pow((arrayAPrime[i] - arrayBPrime[i]),2);
		}
		
		double arraySum = 0;
		for (double i : arrayDiff) arraySum += i;
		
		//Compute sqrt of sum of squares of differences
		
		double arraySumSquareRoot = 0;
		arraySumSquareRoot = Math.pow(arraySum, 0.5);
		
		int[] arrayAPrimeElementsSquared = new int[mySetCount];
		double arrayAPrimeMagnitude = 0;
		double arrayAPrimeSumOfSquares = 0;
		
		for (int i = 0; i<arrayAPrime.length; i++ ) {
			arrayAPrimeElementsSquared[i] = (int) Math.pow(arrayAPrime[i],2);
		}
		
		for (double i : arrayAPrimeElementsSquared) arrayAPrimeSumOfSquares += i;
		
		arrayAPrimeMagnitude = Math.pow(arrayAPrimeSumOfSquares, 0.5);
		
		int[] arrayBPrimeElementsSquared = new int[mySetCount];
		double arrayBPrimeMagnitude = 0;
		double arrayBPrimeSumOfSquares = 0;
		
		for (int i = 0; i<arrayBPrime.length; i++ ) {
			arrayBPrimeElementsSquared[i] = (int) Math.pow(arrayBPrime[i],2);
		}
		
		for (double i : arrayBPrimeElementsSquared) arrayBPrimeSumOfSquares += i;
		
		arrayBPrimeMagnitude = Math.pow(arrayBPrimeSumOfSquares, 0.5);

		double productOfMagnitudes = 0;
		productOfMagnitudes = arrayAPrimeMagnitude * arrayBPrimeMagnitude;

		double normalizedDotProduct = 0;
		normalizedDotProduct = arraySumSquareRoot / productOfMagnitudes;
		
		result = 1 - normalizedDotProduct / Math.pow(2, 0.5); //TODO debug constant
		return result;
	}

}

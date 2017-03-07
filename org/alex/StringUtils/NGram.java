package org.alex.StringUtils;

public final class NGram {

	private NGram() {};

	private static NGram INSTANCE = new NGram();

	public static NGram getInstance() {
	    return INSTANCE;
    }

	/**
	 * Find the nGram distance between two strings.
	 * @param stringA a string to compare.
	 * @param stringB a string to compare.
	 * @param gramSize a integer which expresses the number of contiguous characters to evaluate for matching
	 *                 purposes.
	 * @return the nGram distance between two stringA and stringB normalized between 0 and 1.
	 */
	public static double getNGramDistance(String stringA, String stringB, int gramSize) {
		
		double result = 0;
		String[] arrayA = new String[stringA.length() - gramSize + 1];
		String[] arrayB = new String[stringB.length() - gramSize + 1];
		
		for (int i = 0; i < (stringA.length() - gramSize + 1); i++) {
			arrayA[i] = stringA.substring(i, i + gramSize);
		}
		
		for (int i = 0; i < (stringB.length() - gramSize + 1); i++) {
			arrayB[i] = stringB.substring(i, i + gramSize);
		}
		
		int[] arrayC = new int[Math.max(arrayA.length,arrayB.length)];
		
		for (int i = 0; i < Math.min(arrayA.length,arrayB.length); i++) {
			if (arrayA[i].equalsIgnoreCase(arrayB[i])) {
				arrayC[i] = 1;
			}else{
				arrayC[i] = 0;
			}
		}
		
		double sumArrayC = 0;
		for( int i : arrayC) {
			sumArrayC += i;
		}
		
		result = Math.pow((sumArrayC / arrayC.length),0.5);
		return result;
	}
}

package org.alex.StringUtils;

public final class JaroWinkler {
	
	private JaroWinkler() {}

	private static JaroWinkler INSTANCE = new JaroWinkler();

	public static JaroWinkler getInstance() {
		return INSTANCE;
	}
	
    public static double getJaroDistance(String stringA, String stringB) {
    	return getJaroWinklerDistance(stringA, stringB, 0, 0);
	}
    
    public static double getJaroWinklerDistance(String stringA, String stringB, int lengthPrefix, double scalingFactor) {
    	
    	double jaroDistance = 0;
    	double result = 0;

    	String[] arrayA = new String[stringA.length()];
    	String[] arrayB = new String[stringB.length()];
    		
    	for (int i = 0; i < stringA.length(); i++) {
    		arrayA[i] = Character.toString(stringA.charAt(i));
    	}
    	
    	for (int j = 0; j < stringB.length(); j++) {
    		arrayB[j] = Character.toString(stringB.charAt(j));
    	}
    	
    	int matchChar = 0;
    	int transpositionChar = 0;
    	
    	for (int k = 0; k < Math.min(arrayA.length, arrayB.length); k++) {
    		int x = 1;
    		int y = 1;
    		String compareSubStringB = stringB.substring(Math.max(0, k - (Math.max(stringA.length(), stringB.length()) / 2)-1),
    				Math.min(k + (Math.max(stringA.length(), stringB.length()) / 2)-1, stringB.length()));
    		if (compareSubStringB.contains(arrayA[k].toString())) {
    			matchChar += x;
    			if (!(arrayA[k].toString().equalsIgnoreCase(arrayB[k].toString()))) {
    				transpositionChar += y;
    			}
    		}
    	}

    		jaroDistance = 1/3d * (matchChar / stringA.length() + matchChar / stringB.length() + 
    			(matchChar - transpositionChar/2d) / matchChar);
    		result = jaroDistance + (lengthPrefix * scalingFactor * (1-jaroDistance));
    		return result;
    	}
}

package Compare;

public class JaroWinkler {
	
	private String stringA;
	private String stringB;
	private double lengthPrefix;
	private double scalingFactor;
	
	public JaroWinkler() {	
	}
	
	// Constructor that accepts string inputs
    public JaroWinkler(String stringA, String stringB){
        this.stringA = stringA;
        this.stringB = stringB;
    }
	
	// Constructor that gets length prefix and scaling factor parameters as well
    public JaroWinkler(String stringA, String stringB, double lPrefix, double sFactor){
        this.stringA = stringA;
        this.stringB = stringB;
        this.lengthPrefix = lPrefix;
        this.scalingFactor = sFactor;
    }
    
    public double getLengthPrefix() {
        return lengthPrefix;
    }
    
    public double getScalingFactor() {
        return scalingFactor;
    }
	
    public void setStringA(String stringA) {
        this.stringA = stringA;
    }
    
    public void setStringB(String stringB) {
        this.stringB = stringB;
    }
    
    public void setLengthPrefix(double lengthPrefix) {
        this.lengthPrefix = lengthPrefix;
    }
    
    public void setScalingFactor(double scalingFactor) {
        this.scalingFactor = scalingFactor;
    }
	
    public double getJaroDistance() {
    	
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
			//System.out.println("The " + k + "th compareSubString from String B is: " + compareSubStringB);
			if (compareSubStringB.contains(arrayA[k].toString())) {
				matchChar += x;
				if (!(arrayA[k].toString().equalsIgnoreCase(arrayB[k].toString()))) {
					transpositionChar += y;
				}
			}
		}
		
	
			result = 1/3d * (matchChar / stringA.length() + matchChar / stringB.length() + 
				(matchChar - transpositionChar/2d) / matchChar);
			return result;
	}
    
    public double getJaroWinklerDistance() {
    	
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
    		//System.out.println("The " + k + "th compareSubString from String B is: " + compareSubStringB);
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

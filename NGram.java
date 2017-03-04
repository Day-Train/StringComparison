package StringCompare;

public class NGram {
	
	int gramSize = 2;
	private String stringA;
	private String stringB;
	
	public NGram(){
	}
	
	public NGram(String stringA, String stringB){
        this.stringA = stringA;
        this.stringB = stringB;
	}
	
    public NGram(String stringA, String stringB, int gSize){
        this.stringA = stringA;
        this.stringB = stringB;
        this.gramSize = gSize;
    }
	
	public void setGramSize(int gramSize) {
		this.gramSize = gramSize;
	}
	
	public int getGramSize() {
		return gramSize;
	}
	
	public double getNGramDistance() {
		
		double result = 0;
		String[] arrayA = new String[stringA.length() - gramSize + 1];
		String[] arrayB = new String[stringB.length() - gramSize + 1];
		
		for (int i = 0; i < (stringA.length() - gramSize + 1); i++) {
			arrayA[i] = stringA.substring(i, i + gramSize);
		}
		
		for (int i = 0; i < (stringB.length() - gramSize + 1); i++) {
			arrayB[i] = stringB.substring(i, i + gramSize);
		}
		
		/*
		for (int i = 0; i < arrayA.length; i++) {
			System.out.println("The " + i + "th element of arrayA is: " + arrayA[i]);
		}
		
		for (int i = 0; i < arrayB.length; i++) {
			System.out.println("The " + i + "th element of arrayB is: " + arrayB[i]);
		}
		*/
		
		int[] arrayC = new int[Math.max(arrayA.length,arrayB.length)];
		
		for (int i = 0; i < Math.min(arrayA.length,arrayB.length); i++) {
			if (arrayA[i].equalsIgnoreCase(arrayB[i])) {
				arrayC[i] = 1;
			}else{
				arrayC[i] = 0;
			}
		}
		
		/*
		for (int i = 0; i<arrayC.length; i++) {
			System.out.println("The " + i + "the element of arrayC is: " + arrayC[i]);
		}
		*/
		
		double sumArrayC = 0;
		for( int i : arrayC) {
			sumArrayC += i;
		}
		//System.out.println(sumArrayC);
		
		result = Math.pow((sumArrayC / arrayC.length),0.5);
		return result;
	}
}

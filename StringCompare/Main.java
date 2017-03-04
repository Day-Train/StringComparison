package StringCompare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		
		String stringA = "";
		String stringB = "";
		double lengthPrefix = 0;
		double scalingFactor = 0;
		int gramSize = 2;
		
		BufferedReader dataIn = new BufferedReader(new
                InputStreamReader( System.in) );
       
        // Prompt a user to enter the first string
        System.out.println("Please enter the first string you'd like to compare:");
        try{
            stringA = dataIn.readLine();
        }catch( IOException e ){
            System.out.println("Error!");
        }
        
        // Prompt a user to enter the second string
        System.out.println("Please enter the second string you'd like to compare:");
        try{
            stringB = dataIn.readLine();
        }catch( IOException e ){
            System.out.println("Error!");
        }
        
        // Prompt a user to enter the NGram size
        System.out.println("Please enter the gram size you'd like to use for NGram comparison (must be integer value):");
        try{
            gramSize = Integer.parseInt(dataIn.readLine());
        }catch( IOException e ){
            System.out.println("Error!");
        }
        
        // Prompt a user to enter the Jaro-Winkler lengthPrefix size
        System.out.println("Please enter the prefix length you'd like to use for Jaro-Winkler comparison (must be integer value between 0 and 4 inclusive):");
        try{
        	lengthPrefix = Integer.parseInt(dataIn.readLine());
        }catch( IOException e ){
            System.out.println("Error!");
        }
		
     	// Prompt a user to enter the Jaro-Winkler scalingFactor size
        System.out.println("Please enter the scaling factor you'd like to use for Jaro-Winkler comparison (must be double value between 0 and 0.25 inclusive):");
        try{
        	scalingFactor = Double.parseDouble(dataIn.readLine());
        }catch( IOException e ){
            System.out.println("Error!");
        }
        
		JaroWinkler inputStrings1 = new JaroWinkler(stringA,stringB,lengthPrefix,scalingFactor);
		NGram inputStrings2 = new NGram(stringA,stringB,gramSize);
		BagOfWords inputStrings3 = new BagOfWords(stringA,stringB);
        
        
		//JaroWinkler inputStrings1 = new JaroWinkler("James","Jamie",2,.125);
		System.out.println("The evaluated Jaro distance between the two strings is: " + inputStrings1.getJaroDistance());
		System.out.println("The evaluated Jaro-Winkler distance between the two strings is: " + inputStrings1.getJaroWinklerDistance());
		
		//NGram inputStrings2 = new NGram("James","Jamie",2);
		System.out.println("The evaluated NGram similarity between the two strings is: " + inputStrings2.getNGramDistance());
		
		//BagOfWords inputStrings3 = new BagOfWords("James","Jamie");
		System.out.println("The evaluated Bag of Words similarity between the two strings is: " + inputStrings3.getBagOfWordsDistance());
	}

}

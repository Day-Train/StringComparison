package Compare;

import org.alex.StringUtils.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		
		String stringA = "";
		String stringB = "";
		int lengthPrefix = 0;
		double scalingFactor = 0;
		
		BufferedReader dataIn = new BufferedReader(new InputStreamReader( System.in) );
       
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

		System.out.println("The evaluated Jaro Winkler distance between the two strings is: " + JaroWinkler.getJaroWinklerDistance(stringA, stringB, lengthPrefix, scalingFactor));
		System.out.println("The evaluated Bag of Words distance between the two strings is: " + BagOfWords.getBagOfWordsDistance(stringA, stringB));
		System.out.println("The evaluated NGram distance between the two strings is: " + NGram.getNGramDistance(stringA, stringB, 2));

	}

}

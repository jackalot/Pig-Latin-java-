import javax.swing.JOptionPane;
import java.util.ArrayList;
public class main {
	public static String SuffixRule(String OurConstants)
	{
		//EX: pig-igpay, lack-acklay, wack-ackpay
		String ConstRule = "ay"; 
		//EX:, smack-acksmay smile-ilesmay
		String ConstClustRule = "ay";
		// Just add these suffixes
		String[] VowelRule = {"hay", "way", "yay"};
		String newSuffix = "";
		switch(OurConstants.length())
		{
		//Starts with a vowel.
		case 0:
			int randomNumber = (int)(Math.random()*(-0+VowelRule.length)+0); 
			if(randomNumber <= VowelRule.length - 1)
			{
				newSuffix = VowelRule[randomNumber];
			}
			else
			{
				newSuffix = VowelRule[0];
			}
			break;
		case 1:
			newSuffix = OurConstants + ConstRule;
			break;
		case 2:
			newSuffix = OurConstants + ConstClustRule;
			break;
		}
		
		return newSuffix;
	}
	public static String FindTheRestOfTheWord(String Constants, String input) {
		//Check how many characters are similar(just a double check)
		int similarChars = 0;
		for(int i = 0; i < Constants.length(); i++)
		{
			//Find the character at this index for both strings
			char InputChar = input.charAt(i);
			char ConstantChar = Constants.charAt(i);
			//Compare them, they should be the same
			if(InputChar == ConstantChar)
			{
				similarChars++;
			}
		}
		String LeftOverWord = input.substring(similarChars);
		return LeftOverWord;
	}
	public static String FindConstant(String input) {
		String OurConstants = "bcdfghjklmnpqrstvwxyz";
		// this is the first few constants,
		// like the P in pig
		// or the SM in smile
		String firstConstants = "";
		int count = 0;
		boolean FoundVowel = false;
		while (FoundVowel == false && count < input.length()) {
			int result = OurConstants.indexOf(input.charAt(count));
			if (result > -1) {
				firstConstants += input.charAt(count);
			} else {
				FoundVowel = true;
			}
			count++;
		}
		return firstConstants;
	}
	public static ArrayList<String> FindWords(String input)
	{
		String newString = "";
		ArrayList<String> FindWords = new ArrayList<String>();
		for(int i = 0; i < input.length(); i++)
		{
			//Found a space, a new word begins
			if(input.charAt(i) == ' ')
			{
				FindWords.add(newString);
				newString = "";
			}
			else //Add the current letter, no new word found
			{
				newString += input.charAt(i);
			}
		}
		return FindWords;
	}
	public static void main(String[] args) {
		/**
		 * CONSTANT RULE move the constant to the end of the word, add -ay
		 * Example: pig-igpay, lack-acklay, wack-ackpay 
		 * CONSTANT CLUSTER RULE move the cluster of constants
		 * to the end, add -ay smack-acksmay smile-ilesmay
		 *  VOWEL RULE just add hay, way,
		 * or yay https://en.wikipedia.org/wiki/Pig_Latin
		 */
		String input = JOptionPane.showInputDialog(null, "What message would you like converted to pig latin?");
		ArrayList<String> Words = FindWords(input);
		String OurConstants = FindConstant(input); //Stores the first 1-2 constants
		String LeftOverWord = FindTheRestOfTheWord(OurConstants, input);
		String OurSuffix = SuffixRule(OurConstants);
		JOptionPane.showMessageDialog(null, LeftOverWord + OurSuffix);
		
	}
}

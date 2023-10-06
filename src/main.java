import javax.swing.JOptionPane;

public class main {
	public static String FindTheRestOfTheWord(String Constants, String input) {
		return input;
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

	public static void main(String[] args) {
		/**
		 * CONSTANT RULE move the constant to the end of the word, add -ay
		 * Example: pig-igpay, lack-acklay, wack-ackpay 
		 * CONSTANT CLUSTER RULE move the cluster of constants
		 * to the end, add -ay smack-acksmay smile-ilesmay VOWEL RULE just add hay, way,
		 * or yay https://en.wikipedia.org/wiki/Pig_Latin
		 */
		String input = JOptionPane.showInputDialog(null, "What message would you like converted to pig latin?");
		String OurConstants = FindConstant(input); //Stores the first 1-2 constants
		String TheRest = FindTheRestOfTheWord(OurConstants, input);
		JOptionPane.showMessageDialog(null, input);

	}
}

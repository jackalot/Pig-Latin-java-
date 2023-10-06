import javax.swing.JOptionPane;
public class main {
	public static String FindConstant(String input)
	{
		return input;
	}
	public static void main(String[] args) {
	/**
	 * CONSTANT RULE
	 * move the constant to the end of the word, add -ay
	 * pig-igpay
	 * lack-acklay
	 * wack-ackpay
	 * CONSTANT CLUSTER RULE
	 * move the cluster of constants to the end, add -ay
	 * smack-acksmay
	 * smile-ilesmay
	 * VOWEL RULE
	 * just add hay, way, or yay
	 * https://en.wikipedia.org/wiki/Pig_Latin
	 */
		String input = JOptionPane.showInputDialog(null, "What message would you like converted to pig latin?");
		JOptionPane.showMessageDialog(null, input);
	}
}

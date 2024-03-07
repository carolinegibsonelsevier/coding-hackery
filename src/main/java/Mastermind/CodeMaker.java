package Mastermind;

import java.util.Random;

public class CodeMaker {
	//random generating 4 colours out of list of colours
	//include repeated colours (and possibly blanks? - blanks are now represented with grey circle, may change this to be clearer)

	public static       Random    random     = new Random();
	public static       CodePeg[] codePeg    = CodePeg.values();
	public static       CodePeg[] secretCode = new CodePeg[4];
	public static final String    RESET      = "\u001B[0m";
	public static final String    CODEPEG_BLANK      = "\u001B[37m\u25CB";
	public static final String    CODEPEG_RED        = "\u001B[91m\u25CF";
	public static final String    CODEPEG_GREEN      = "\u001B[92m\u25CF";
	public static final String    CODEPEG_YELLOW     = "\u001B[93m\u25CF";
	public static final String    CODEPEG_BLUE       = "\u001B[96m\u25CF";
	public static final String    CODEPEG_ORANGE     = "\u001B[38;5;208m\u25CF";
	public static final String    CODEPEG_PURPLE     = "\u001B[95m\u25CF";
	public static final String    CODEPEG_WHITE      = "\u001B[97m\u25CF";


	public static CodePeg[] getSecretCode() {
		return secretCode;
	}

	public static void setSecretCode(CodePeg[] secretCode) {
		CodeMaker.secretCode = secretCode;
	}


	// Enum representing code pegs/ colour options
	enum CodePeg {
		RED(CODEPEG_RED),
		GREEN(CODEPEG_GREEN),
		YELLOW(CODEPEG_YELLOW),
		BLUE(CODEPEG_BLUE),
		ORANGE(CODEPEG_ORANGE),
		PURPLE(CODEPEG_PURPLE),
		WHITE(CODEPEG_WHITE),
		BLANK(CODEPEG_BLANK);

		private final String codePegColour;

		// Constructor to associate a string with each enum constant
		CodePeg(String codePegColour) {
			this.codePegColour = codePegColour;
		}

		// Getter method to retrieve the associated string
		public String getCodePegColour() {
			return codePegColour;
		}

	}

	// Method to generate a random secret code of 4 colours
	public static void generateSecretCode() {

		for (int i = 0; i < 4; i++) {
			getSecretCode()[i] = codePeg[random.nextInt(codePeg.length)];
		}

		// Print the secret code to the terminal (can eventually remove this until the end?)
		System.out.print("Secret Code: ");
		for (CodePeg colour : getSecretCode()) {
				System.out.print(colour.getCodePegColour() + RESET + " ");
		}
		System.out.println();
	}
}

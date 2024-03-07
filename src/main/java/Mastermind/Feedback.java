package Mastermind;

import static Mastermind.CodeMaker.secretCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Feedback {

	public static final String RED  = "\u001B[91m\u25CB";
	public static final String WHITE  = "\u001B[97m\u25CB";
	public static final String BLANK  = "\u001B[37m\u25CB";
	public static final String RESET = "\u001B[0m";

	enum KeyPeg {
		KEYPEG_RED(RED),
		KEYPEG_WHITE(WHITE),
		KEYPEG_BLANK(BLANK);


		private final String keyPegColour;

		KeyPeg(String keyPegColour) {
			this.keyPegColour = keyPegColour;
		}

		public String getKeyPegColour() {
			return keyPegColour;
		}
	}

	public static void keyPegFeedback(CodeMaker.CodePeg[] userGuess) {

		System.out.print("Feedback: ");


//		for (int i = 0; i < 4; i++) {
//			if (userGuess[i] == secretCode[i]) {
//				System.out.print(Feedback.KeyPeg.KEYPEG_RED.getKeyPegColour() + RESET + " ");
//			} else if (containsColour(userGuess[i])) {
//				System.out.print(Feedback.KeyPeg.KEYPEG_WHITE.getKeyPegColour() + RESET + " ");
//			} else {
//				System.out.print(Feedback.KeyPeg.KEYPEG_BLANK.getKeyPegColour() + RESET + " ");
//			}
//		}
//		System.out.println();
//						for (int i = 0; i < 4; i++) {
//						if (userGuess[i] == secretCode[i]) {
//							results.add(Feedback.KeyPeg.KEYPEG_RED.getKeyPegColour() + " ");
//						} else if (containsColour(userGuess[i])) {
//							results.add(Feedback.KeyPeg.KEYPEG_WHITE.getKeyPegColour() + " ");
//						} else {
//							results.add(Feedback.KeyPeg.KEYPEG_BLANK.getKeyPegColour() + " ");
//						}
//					}

		List<String> results = new ArrayList<>();
		List<CodeMaker.CodePeg> remainingColours = new ArrayList<>(List.of(secretCode));

//		for (int i = 0; i < 4; i++) {
//			if (userGuess[i] == secretCode[i]) {
//				results.add(Feedback.KeyPeg.KEYPEG_RED.getKeyPegColour() + " ");
//				remainingColours.remove(userGuess[i]);
//			} else if (remainingColours.contains(userGuess[i])) {
//				results.add(Feedback.KeyPeg.KEYPEG_WHITE.getKeyPegColour() + " ");
//				remainingColours.remove(userGuess[i]);
//			} else {
//				results.add(Feedback.KeyPeg.KEYPEG_BLANK.getKeyPegColour() + " ");
//			}
//		}

		for (int i = 0; i < 4; i++) {
			if (userGuess[i] == secretCode[i]) {
				results.add(Feedback.KeyPeg.KEYPEG_RED.getKeyPegColour() + " ");
				remainingColours.remove(userGuess[i]);
			}
		}

		for (int i = 0; i < 4; i++) {
			if (userGuess[i] != secretCode[i] && remainingColours.contains(userGuess[i])) {
				results.add(Feedback.KeyPeg.KEYPEG_WHITE.getKeyPegColour() + " ");
				remainingColours.remove(userGuess[i]);
			}
		}

		for (int i = results.size(); i < 4; i++) {
			results.add(Feedback.KeyPeg.KEYPEG_BLANK.getKeyPegColour() + " ");
		}

		// Shuffle the results
		Collections.shuffle(results);

		for (String result : results) {
			System.out.print(result + RESET);
		}
		System.out.println();
	}

		private static boolean containsColour (CodeMaker.CodePeg colour){
			for (CodeMaker.CodePeg peg : secretCode) {
				if (peg == colour) {
					return true;
				}
			}
			return false;
		}
}

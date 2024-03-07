package Mastermind;

import static Mastermind.CodeMaker.RESET;
import java.util.Scanner;


/*this would be the player, although I want to eventually change this/ make it swap for rounds
input here and error message outputs?
 */



public class CodeBreaker {

	static CodeMaker.CodePeg[] getUserGuess(Scanner scanner) {
		CodeMaker.CodePeg[] userGuess = new CodeMaker.CodePeg[4];
		System.out.println("Enter your guess of any 4 colours (RED GREEN YELLOW BLUE WHITE ORANGE PURPLE BLANK):");
		for (int i = 0; i < 4; i++) {
			String input = scanner.next().toUpperCase();
			userGuess[i] = CodeMaker.CodePeg.valueOf(input);
			System.out.print(userGuess[i].getCodePegColour() + RESET + " ");
		}
		System.out.println();
		return userGuess;
	}


	static <CodePeg> boolean checkGuess(CodePeg[] userGuess) {
		CodePeg[] secretCode = (CodePeg[]) CodeMaker.getSecretCode();
		for (int i = 0; i < 4; i++) {
			if (userGuess[i] != secretCode[i]) {
				return false;
			}
		}
		return true;
	}

	static void attempts(Scanner scanner) {
		CodeMaker.CodePeg[] userGuess = new CodeMaker.CodePeg[0];

		for (int attempt = 1; attempt <= 12; attempt++) {
			System.out.println("Guess " + attempt + ": ");
			userGuess = getUserGuess(scanner);
			Feedback.keyPegFeedback(userGuess);
			if (checkGuess(userGuess)) {
//				System.out.println("We have a winner!");
				System.out.println();
				String mastermindWinner =
						"\u001B[95m                                             ,---. \n" +
								"\u001B[95m,--.   ,--.,--.                              |   | \n" +
								"\u001B[95m|  |   |  |`--',--,--, ,--,--,  ,---. ,--.--.|  .' \n" +
								"\u001B[95m|  |.'.|  |,--.|      \\|      \\| .-. :|  .--'|  |  \n" +
								"\u001B[95m|   ,'.   ||  ||  ||  ||  ||  |\\   --.|  |   `--'  \n" +
								"\u001B[95m'--'   '--'`--'`--''--'`--''--' `----'`--'   .--.  \n" +
								"\u001B[95m                                             '--'  \u001B[0m "+ RESET + " ";

				System.out.println(mastermindWinner);
				break;
			} else {
				if (attempt < 12) {
					System.out.println("Incorrect guess. Try again.");
				}
			}
		}
		if (!checkGuess(userGuess)) {
			String mastermindLoser =
					"\u001B[92m,--.                                \n" +
							"|  |    ,---.  ,---.  ,---. ,--.--. \n" +
							"|  |   | .-. |(  .-' | .-. :|  .--' \n" +
							"|  '--.' '-' '.-'  `)\\   --.|  |    \n" +
							"`-----' `---' `----'  `----'`--'    " + RESET + " ";

			System.out.println(mastermindLoser);
			System.out.println("Sorry pal the correct code was: ");
			for (CodeMaker.CodePeg colour : CodeMaker.getSecretCode()) {
				System.out.print(colour.getCodePegColour() + RESET + " ");
			}
		}
	}

	public static void playAgain() {
		Scanner userInput = new Scanner(System.in);

		do {
			playGame();
			System.out.println();
			System.out.println("Do you want to play again? (Y/N)");

		} while (userInput.next().equalsIgnoreCase("Y"));
	}
	public static void playGame() {
		CodeMaker.generateSecretCode();
		Scanner scanner = new Scanner(System.in);
		attempts(scanner);
	}
}





//			I want to try and add this later and include a catch for invalid input
//			switch () {
//			case "R":
//				return RED;
//			case "G":
//				return GREEN;
//			case "Y":
//				return YELLOW;
//			case "B":
//				return BLUE;
//			case "O":
//				return ORANGE;
//			case "P":
//				return PURPLE;
//			case "W":
//				return WHITE;
//			case "E":
//				return BLANK;
//			default:
//				throw new IllegalArgumentException("Colour not found. Please enter a valid colour (RED/GREEN/YELLOW/BLUE/ORANGE/PURPLE/WHITE or 'E' for blank.");
//			}
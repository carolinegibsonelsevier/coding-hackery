package Mastermind;

import static Mastermind.CodeBreaker.playAgain;
import static Mastermind.CodeMaker.RESET;


/*
Initial game 12 guesses, if player guesses before 12 they win otherwise they lose

If able to swap roles, 3 rounds (can always make this a ??)
12 guesses, each incorrect guess gives the codemaker a point
end of rounds winner has most points

Each guess, input colours
If colour is not in list output error message
If not enough colours are input, output error message

for each guess use KeyPegs
	red and white, white if correct colour but wrong position,
	red if correct position and colour and none if both are wrong
	for each guess, go through and assign a key peg according to this but make it random as part of the game
	if 4 red pegs are placed, game is won by
*/

	public class Gameplay {

		public static void main(String[] args) {

			String mastermindLogo =
					"\u001B[36m,--.   ,--.                ,--.                          ,--.           ,--.\n" +
							"|   `.'   | ,--,--. ,---.,-'  '-. ,---. ,--.--.,--,--,--.`--',--,--,  ,-|  |\n" +
							"|  |'.'|  |' ,-.  |(  .-''-.  .-'| .-. :|  .--'|        |,--.|      \\` .-. |\n" +
							"|  |   |  |\\ '-'  |.-'  `) |  |  \\   --.|  |   |  |  |  ||  ||  ||  |\\ `-' |\n" +
							"`--'   `--' `--`--'`----'  `--'   `----'`--'   `--`--`--'`--'`--''--' `---'  " + RESET;

			System.out.println(mastermindLogo);

			System.out.println("Let's play Mastermind!");
			//Number of attempts allowed (12 default but want to eventually customise this and the role named)
			System.out.println("You have 12 attempts CodeBreaker, good luck!");

			playAgain();
			String goodbyeCodeBreaker =
					"\u001B[96m                                                                                                                                              \n" +
							" ,----.                    ,--.,--.                      ,-----.          ,--.       ,--.                         ,--.                  \n" +
							"'  .-./    ,---.  ,---.  ,-|  ||  |-.,--. ,--.,---.     '  .--./ ,---.  ,-|  | ,---. |  |-. ,--.--. ,---.  ,--,--.|  |,-. ,---. ,--.--. \n" +
							"|  | .---.| .-. || .-. |' .-. || .-. '\\  '  /| .-. :    |  |    | .-. |' .-. || .-. :| .-. '|  .--'| .-. :' ,-.  ||     /| .-. :|  .--' \n" +
							"'  '--'  |' '-' '' '-' '\\ `-' || `-' | \\   ' \\   --.    '  '--'\\ '-' '\\ `-' |\\   --.| `-' ||  |   \\   --.\\ '-'  ||  \\  \\\\   --.|  |    \n" +
							" `------'  `---'  `---'  `---'  `---'.-'  /   `----'     `-----' `---'  `---'  `----' `---' `--'    `----' `--`--'`--'`--'`----'`--'    \n" +
							"                                     `---'                                                                                               \u001B[0m";

			System.out.println(goodbyeCodeBreaker);

		}
	}

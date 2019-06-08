package roulette;

import java.util.*;

/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
	// name of the game
	private static final String DEFAULT_NAME = "Roulette";

	private Wheel myWheel;
	private Bet[] myPossibleBets = {
			new Bet("Red or Black", 1),
			new Bet("Odd or Even", 1),
			new Bet("Three in a Row", 11)
	};

	/**
	 * Construct the game.
	 */
	public Game() {
		myWheel = new Wheel();
	}

	/**
	 * @return name of the game
	 */
	public String getName() {
		return DEFAULT_NAME;
	}

	/**
	 * Play a round of this game.
	 * 
	 * For Roulette, this means prompting the player to make a bet, spinning the
	 * roulette wheel, and then verifying that the bet is won or lost.
	 * 
	 * @param player
	 *            one that wants to play a round of the game
	 */
	public void play(Gambler player) {
		int amount = ConsoleReader.promptRange("How much do you want to bet",
				0, player.getBankroll());
		int whichBet = promptForBet();
		String betChoice = placeBet(whichBet);

		System.out.print("Spinning ...");
		myWheel.spin();
		System.out.println("Dropped into " + myWheel.getColor() + " "
				+ myWheel.getNumber());

		if (betIsMade(whichBet, betChoice)) {
			System.out.println("*** Congratulations :) You win ***");
			amount *= myPossibleBets[whichBet].getPayout();
		} else {
			System.out.println("*** Sorry :( You lose ***");
			amount *= -1;
		}
		player.updateBankroll(amount);
	}

	/**
	 * Prompt the user to make a bet from a menu of choices.
	 */
	private int promptForBet() {
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < myPossibleBets.length; k++) {
			System.out.println((k + 1) + ") "
					+ myPossibleBets[k].getDescription());
		}

		return ConsoleReader.promptRange("Please make a choice", 1,
				myPossibleBets.length) - 1;
	}

	/**
	 * Place the given bet by prompting the user for the specific information
	 * need to complete the given bet.
	 * 
	 * @param whichBet
	 *            specific bet chosen by the user
	 */
	private String placeBet(int whichBet) {
		String result = "";

		if (whichBet == 0) {
			Set<String> choices = new TreeSet<String>();
			choices.add(Wheel.BLACK);
			choices.add(Wheel.RED);
			result = ConsoleReader.promptOneOf("Please bet", choices);
		} else if (whichBet == 1) {
			Set<String> choices = new TreeSet<String>();
			choices.add("even");
			choices.add("odd");
			result = ConsoleReader.promptOneOf("Please bet", choices);
		} else if (whichBet == 2) {
			result = ""
					+ ConsoleReader.promptRange(
							"Enter first of three consecutive numbers", 1, 34);
		}
		System.out.println();

		return result;
	}

	/**
	 * Checks if the given bet is won or lost given the user's choice and the
	 * result of spinning the wheel.
	 * 
	 * @param whichBet
	 *            specific bet chosen by the user
	 * @param betChoice
	 *            specific value user chose to try to win the bet
	 */
	private boolean betIsMade(int whichBet, String betChoice) {
		if (whichBet == 0) {
			return myWheel.getColor().equals(betChoice);
		} else if (whichBet == 1) {
			return (myWheel.getNumber() % 2 == 0 && betChoice.equals("even"))
					|| (myWheel.getNumber() % 2 == 1 && betChoice.equals("odd"));
		} else if (whichBet == 2) {
			int start = Integer.parseInt(betChoice);
			return (start <= myWheel.getNumber() && myWheel.getNumber() < start + 3);
		} else {
			return false;
		}
	}
}

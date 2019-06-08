package roulette;

import java.util.Random;

/**
 * Represents a roulette wheel that can be spun to get a color, either red,
 * black, or green, and a number, between 0 and 37. The numbers 0 and 37
 * represent the roulette values 0 and 00, respectively.
 * 
 * @author Robert C. Duvall
 */
public class Wheel {
	// constants
	public static final String RED = "red";
	public static final String BLACK = "black";
	public static final String GREEN = "green";

	// wheel values --- not quite every other one :(
	private static final String[] OUR_SPOTS = { GREEN, RED, BLACK, RED, BLACK,
			RED, BLACK, RED, BLACK, RED, BLACK, BLACK, RED, BLACK, RED, BLACK,
			RED, BLACK, RED, RED, BLACK, RED, BLACK, RED, BLACK, RED, BLACK,
			RED, BLACK, BLACK, RED, BLACK, RED, BLACK, RED, BLACK, RED, GREEN };

	public static final int MAX = OUR_SPOTS.length -1;

	private int myNumSpins;
	private int myValue;
	private Random myRoller;

	/**
	 * Construct the wheel.
	 */
	public Wheel() {
		myNumSpins = 0;
		myValue = 0;
		myRoller = new Random();
	}

	/**
	 * @return color of the current spot on the wheel
	 */
	public String getColor() {
		return OUR_SPOTS[myValue];
	}

	/**
	 * @return number of the current spot on the wheel
	 */
	public int getNumber() {
		return myValue;
	}

	/**
	 * @return number of times the wheel has been spun
	 */
	public int getNumSpins() {
		return myNumSpins;
	}

	/**
	 * Spins the wheel, choosing a new spot.
	 */
	public void spin() {
		myNumSpins++;
		myValue = myRoller.nextInt(OUR_SPOTS.length);
	}

}

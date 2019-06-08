package roulette;

/**
 * Represents a Gambler simply as an amount of money to be spent.
 * 
 * @author Robert C. Duvall
 */
public class Gambler {
	
	private String myName;
	private int myMoney;

	/**
	 * Constructs a gambler with the given name and an initial bank roll.
	 * 
	 * @param name
	 *            used to refer to the gambler
	 * @param money
	 *            initial amount of the money the gambler has to spend
	 */
	public Gambler(String name, int money) {
		myName = name;
		myMoney = money;
	}

	/**
	 * @return name of the gambler
	 */
	public String getName() {
		return myName;
	}

	/**
	 * @return amount of money the gambler has left
	 */
	public int getBankroll() {
		return myMoney;
	}

	/**
	 * @return true if the gambler has money left to spend, false otherwise
	 */
	public boolean isSolvent() {
		return (myMoney > 0);
	}

	/**
	 * Changes the gambler's bank roll to reflect the given amount won or lost.
	 * 
	 * @param amount
	 *            money won (positive) or lost (negative) by the gambler
	 */
	public void updateBankroll(int amount) {
		myMoney += amount;
	}
}

package test;

import Betting.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test the Bet class.
 * 
 * @author Robert C. Duvall
 */
public class BetTest {
	
	@Test
	public void testHighLow() {
		Bet b = new HighLowBet();
		assertEquals(b.getDescription(), "High Or Low");
		assertEquals(b.getPayout(), 1);
	}

	@Test
	public void testOddEven() {
		Bet b = new OddEvenBet();
		assertEquals(b.getDescription(), "Odd Or Even");
		assertEquals(b.getPayout(), 1);
	}

	@Test
	public void testRedBlack() {
		Bet b = new RedBlackBet();
		assertEquals(b.getDescription(), "Red Or Black");
		assertEquals(b.getPayout(), 1);
	}

	@Test
	public void testThreeInRowBet() {
		Bet b = new NumInRowBet();
		assertEquals(b.getDescription(), "Three In a Row");
		assertEquals(b.getPayout(), 11);
	}

}

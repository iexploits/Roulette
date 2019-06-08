package test;

import static org.junit.Assert.*;

import org.junit.Test;

import roulette.Bet;

/**
 * Test the Bet class.
 * 
 * @author Robert C. Duvall
 */
public class BetTest {
	
	@Test
	public void testCreation() {
		Bet b = new Bet("Bet", 13);
		assertEquals(b.getDescription(), "Bet");
		assertEquals(b.getPayout(), 13);
	}
}

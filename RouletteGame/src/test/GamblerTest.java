package test;

import static org.junit.Assert.*;

import org.junit.Test;

import roulette.Gambler;

/**
 * Test the Gambler class.
 * 
 * @author Robert C. Duvall
 */
public class GamblerTest {
	
	@Test
	public void testCreation() {
		Gambler g = new Gambler("Robert", 1001);
		assertEquals(g.getName(), "Robert");
		assertEquals(g.getBankroll(), 1001);
	}

	@Test
	public void testSolvent() {
		Gambler g;

		g = new Gambler("Robert", 0);
		assertTrue(!g.isSolvent());

		g = new Gambler("Robert", -1);
		assertTrue(!g.isSolvent());

		g = new Gambler("Robert", 1);
		assertTrue(g.isSolvent());
	}

	@Test
	public void testUpdate() {
		Gambler g = new Gambler("Robert", 1);

		g.updateBankroll(0);
		assertEquals(g.getBankroll(), 1);
		g.updateBankroll(-1);
		assertEquals(g.getBankroll(), 0);
		g.updateBankroll(2);
		assertEquals(g.getBankroll(), 2);
		g.updateBankroll(13);
		assertEquals(g.getBankroll(), 15);
	}

}

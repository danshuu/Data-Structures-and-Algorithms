/**
* JUnit tests for Card class
* @author Daniel Shu
* @version Project 1 cpe 103
*/

import org.junit.*;
import static org.junit.Assert.*;

public class CardTests {
	
	@Test(expected = IllegalArgumentException.class) 
	public void testWildCard() {
		Card card = new Card(1,10);
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testWildCardAgain() {
		Card card = new Card(17,0);
	}

	@Test
	public void testRank() {
		Card card = new Card(1,4);
		assertEquals(card.getRank(), "Ace");
	}

	@Test
	public void testRankNumber() {
		Card card = new Card(3,4);
		assertEquals(card.getRank(), "3");
	}

	@Test
	public void testSuit() {
		Card card = new Card(3,4);
		assertEquals(card.getSuit(), "Clubs");
	}

	@Test
	public void testName1() {
		Card card = new Card(3,2);
		assertEquals(card.toString(), "3 of Hearts");
	}

	@Test
	public void testName2() {
		Card card = new Card(13,4);
		assertEquals(card.toString(), "King of Clubs");
	}

	@Test
	public void testName3() {
		Card card = new Card(1,1);
		assertEquals(card.toString(), "Ace of Spades");
	}
}
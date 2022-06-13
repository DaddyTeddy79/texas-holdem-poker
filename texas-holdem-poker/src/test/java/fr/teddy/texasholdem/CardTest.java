package fr.teddy.texasholdem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardTest {

	@Test
	public void testValidCardConstruction() {
		Card card1 = new Card(CardFaces.KING, CardSuits.CLUBS);
		Card card2 = new Card(CardFaces.QUEEN, CardSuits.DIAMONDS);
		Card card3 = new Card(CardFaces.JACK, CardSuits.SPADES);
		Card card4 = new Card(CardFaces.TEN, CardSuits.HEARTS);
		assertEquals("Kc", card1.toString());
		assertEquals("Qd", card2.toString());
		assertEquals("Js", card3.toString());
		assertEquals("Th", card4.toString());
	}

}

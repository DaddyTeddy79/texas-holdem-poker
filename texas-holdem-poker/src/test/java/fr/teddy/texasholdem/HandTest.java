package fr.teddy.texasholdem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HandTest {

	@Test
	public void testValidHand() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.ACE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		assertEquals("As Qs 9s 5s 2s", hand.toString());
	}

	@Test
	public void shouldNotAddDuplicate() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.ACE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.HEARTS));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.HEARTS));
		assertEquals("As Qc 9s 5h", hand.toString());

	}

	@Test
	public void shouldReturnFiveDifferentFaces() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.ACE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		hand.buildCardFacesMap();
		assertEquals(5, hand.getCardFacesMap().size());
	}

	@Test
	public void shouldReturnTwoDifferentFaces() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.ACE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.HEARTS));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		hand.buildCardFacesMap();
		assertEquals(2, hand.getCardFacesMap().size());
	}
}

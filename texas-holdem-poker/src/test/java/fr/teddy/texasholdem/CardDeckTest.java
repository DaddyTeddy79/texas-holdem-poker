package fr.teddy.texasholdem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CardDeckTest {

	@Test
	public void deckShouldHaveFiftyTwoCards() {
		CardDeck deck = new CardDeck();
		deck.shuffle();
		assertEquals(52, deck.getCards().size());
	}

	@Test
	public void shouldReturnFiveCardsHand() {
		CardDeck deck = new CardDeck();
		deck.shuffle();
		Hand randomHand = deck.dealRandomHand();
	}

}

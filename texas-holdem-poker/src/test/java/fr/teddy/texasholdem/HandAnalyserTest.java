package fr.teddy.texasholdem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HandAnalyserTest {

	private HandAnalyser handAnalyser;

	@Before
	public void setUp() throws Exception {
		handAnalyser = new HandAnalyser();
	}

	@Test
	public void shouldFindFourOfAKind() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.ACE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.HEARTS));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		handAnalyser.findHandRanking(hand);
		assertEquals(HandRankings.FOUR_OF_A_KIND, hand.getRanking());
	}

	@Test
	public void shouldFindThreeOfAKind() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.ACE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.KING, CardSuits.HEARTS));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		handAnalyser.findHandRanking(hand);
		assertEquals(HandRankings.THREE_OF_A_KIND, hand.getRanking());
	}

	@Test
	public void shouldFindFullHouse() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.ACE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.ACE, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.HEARTS));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		handAnalyser.findHandRanking(hand);
		assertEquals(HandRankings.FULL_HOUSE, hand.getRanking());
	}

	@Test
	public void shouldFindFlush() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.ACE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		handAnalyser.findHandRanking(hand);
		assertEquals(HandRankings.FLUSH, hand.getRanking());
	}

	@Test
	public void shouldFindTwoPairs() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.SPADES));
		handAnalyser.findHandRanking(hand);
		assertEquals(HandRankings.TWO_PAIRS, hand.getRanking());
	}

	@Test
	public void shouldFindHighCard() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.ACE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.HEARTS));
		handAnalyser.findHandRanking(hand);
		assertEquals(HandRankings.HIGH_CARD, hand.getRanking());
	}

	@Test
	public void shouldFindOnePair() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.HEARTS));
		handAnalyser.findHandRanking(hand);
		assertEquals(HandRankings.ONE_PAIR, hand.getRanking());
	}

	@Test
	public void shouldFindStraight() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.SEVEN, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.EIGHT, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.SIX, CardSuits.HEARTS));
		handAnalyser.findHandRanking(hand);
		assertEquals(HandRankings.STRAIGHT, hand.getRanking());
	}

	@Test
	public void shouldFindStraightFlush() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.SEVEN, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.EIGHT, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.SIX, CardSuits.DIAMONDS));
		handAnalyser.findHandRanking(hand);
		assertEquals(HandRankings.STRAIGHT_FLUSH, hand.getRanking());
	}

	@Test
	public void testHighCardHandKicker() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.KING, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.NINE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.HEARTS));
		assertTrue(handAnalyser.getKicker(hand).getFace() == CardFaces.KING);
	}

	@Test
	public void testOnePairHandKicker() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.TEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TEN, CardSuits.HEARTS));
		hand.addCard(new Card(CardFaces.FIVE, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TWO, CardSuits.HEARTS));
		assertTrue(handAnalyser.getKicker(hand).getFace() == CardFaces.QUEEN);
	}

	@Test
	public void testTwoPairsHandKicker() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.TEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TEN, CardSuits.HEARTS));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.KING, CardSuits.HEARTS));
		assertTrue(handAnalyser.getKicker(hand).getFace() == CardFaces.KING);
	}

	@Test
	public void testThreeOfAKindHandKicker() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.TEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TEN, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.TEN, CardSuits.HEARTS));
		hand.addCard(new Card(CardFaces.QUEEN, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.SIX, CardSuits.HEARTS));
		assertTrue(handAnalyser.getKicker(hand).getFace() == CardFaces.QUEEN);
	}

	@Test
	public void testFourOfAKindHandKicker() {
		Hand hand = new Hand();
		hand.addCard(new Card(CardFaces.TEN, CardSuits.SPADES));
		hand.addCard(new Card(CardFaces.TEN, CardSuits.DIAMONDS));
		hand.addCard(new Card(CardFaces.TEN, CardSuits.HEARTS));
		hand.addCard(new Card(CardFaces.TEN, CardSuits.CLUBS));
		hand.addCard(new Card(CardFaces.SIX, CardSuits.HEARTS));
		assertTrue(handAnalyser.getKicker(hand).getFace() == CardFaces.SIX);
	}

	@Test
	public void betterHandRankingShouldWin() {
		Player john = new Player("John");
		Hand hand1 = new Hand();
		hand1.addCard(new Card(CardFaces.TEN, CardSuits.SPADES));
		hand1.addCard(new Card(CardFaces.TEN, CardSuits.DIAMONDS));
		hand1.addCard(new Card(CardFaces.TEN, CardSuits.HEARTS));
		hand1.addCard(new Card(CardFaces.TEN, CardSuits.CLUBS));
		hand1.addCard(new Card(CardFaces.SIX, CardSuits.HEARTS));
		john.setHand(hand1);

		Player scott = new Player("Scott");
		Hand hand2 = new Hand();
		hand2.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		hand2.addCard(new Card(CardFaces.TWO, CardSuits.DIAMONDS));
		hand2.addCard(new Card(CardFaces.TWO, CardSuits.HEARTS));
		hand2.addCard(new Card(CardFaces.QUEEN, CardSuits.CLUBS));
		hand2.addCard(new Card(CardFaces.SIX, CardSuits.HEARTS));
		scott.setHand(hand2);
		assertEquals("John", handAnalyser.findWinner(john, scott).getName());
	}

	@Test
	public void betterOnePairShouldWin() {
		Player john = new Player("John");
		Hand hand1 = new Hand();
		hand1.addCard(new Card(CardFaces.TEN, CardSuits.SPADES));
		hand1.addCard(new Card(CardFaces.TEN, CardSuits.DIAMONDS));
		hand1.addCard(new Card(CardFaces.EIGHT, CardSuits.HEARTS));
		hand1.addCard(new Card(CardFaces.JACK, CardSuits.CLUBS));
		hand1.addCard(new Card(CardFaces.SIX, CardSuits.HEARTS));
		john.setHand(hand1);

		Player scott = new Player("Scott");
		Hand hand2 = new Hand();
		hand2.addCard(new Card(CardFaces.TWO, CardSuits.SPADES));
		hand2.addCard(new Card(CardFaces.TWO, CardSuits.DIAMONDS));
		hand2.addCard(new Card(CardFaces.ACE, CardSuits.HEARTS));
		hand2.addCard(new Card(CardFaces.QUEEN, CardSuits.CLUBS));
		hand2.addCard(new Card(CardFaces.SIX, CardSuits.HEARTS));
		scott.setHand(hand2);
		assertEquals("John", handAnalyser.findWinner(john, scott).getName());
	}
}

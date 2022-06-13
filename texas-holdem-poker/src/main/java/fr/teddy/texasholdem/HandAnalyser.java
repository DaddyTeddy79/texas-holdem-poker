package fr.teddy.texasholdem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class HandAnalyser {

	public void findHandRanking(Hand hand) {
		if (hand.getSize() != 5)
			throw new IllegalArgumentException("A hand must be constituted of five cards");

		// to avoid multiple loop in card list and to analyse hand more easily
		hand.buildCardFacesMap();

		int numberOfDifferentFaces = hand.getCardFacesMap().size();
		switch (numberOfDifferentFaces) {

		case 1:
			throw new RuntimeException("Someone is cheating ! There cannot more than four different card faces.");

		case 2:
			if (isAFourOfAKind(hand))
				hand.setRanking(HandRankings.FOUR_OF_A_KIND);
			else
				hand.setRanking(HandRankings.FULL_HOUSE);
			break;

		case 3:
			if (isAThreeOfAKind(hand))
				hand.setRanking(HandRankings.THREE_OF_A_KIND);
			else
				hand.setRanking(HandRankings.TWO_PAIRS);
			break;

		case 4:
			hand.setRanking(HandRankings.ONE_PAIR);
			break;

		case 5:
			if (isAFlush(hand) && isAStraight(hand))
				hand.setRanking(HandRankings.STRAIGHT_FLUSH);
			else if (isAFlush(hand))
				hand.setRanking(HandRankings.FLUSH);
			else if (isAStraight(hand))
				hand.setRanking(HandRankings.STRAIGHT);
			else
				hand.setRanking(HandRankings.HIGH_CARD);
		}
	}

	private boolean isAStraight(Hand hand) {
		ArrayList<Card> cards = new ArrayList<Card>(hand.getCards());
		for (int i = 0; i < cards.size(); i++) {
			// must not be the last card of the list
			if (i + 1 < cards.size()) {
				Card currentCard = cards.get(i);
				Card nextCard = cards.get(i + 1);
				if (currentCard.getFace().rank != (nextCard.getFace().rank - 1))
					return false;
			}
		}
		return true;
	}

	private boolean isAFlush(Hand hand) {
		CardSuits firstCardSuit = hand.getCards().first().getSuit();
		for (Card card : hand.getCards()) {
			if (card.getSuit() != firstCardSuit)
				return false;
		}
		return true;
	}

	private boolean isAThreeOfAKind(Hand hand) {
		if (hand.getCardFacesMap().containsValue(3))
			return true;
		return false;
	}

	private boolean isAFourOfAKind(Hand hand) {
		if (hand.getCardFacesMap().containsValue(4))
			return true;
		return false;
	}

	public Card getKicker(Hand hand) {

		Card kicker = null;

		if (hand.getRanking() == null)
			findHandRanking(hand);

		switch (hand.getRanking()) {
		case HIGH_CARD:
			kicker = hand.getCards().first();
			break;
		case ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, FOUR_OF_A_KIND:
			kicker = getKickerFromSameCardRanking(hand);
			break;
		default:
		}
		return kicker;
	}

	private Card getKickerFromSameCardRanking(Hand hand) {

		HashMap<CardFaces, Integer> cardFacesMap = hand.getCardFacesMap();
		TreeSet<Card> handCards = hand.getCards();
		TreeSet<Card> nonWinningCards = new TreeSet<Card>();

		for (Card currentCard : handCards) {
			if (cardFacesMap.get(currentCard.getFace()) == 1)
				nonWinningCards.add(currentCard);
		}

		return nonWinningCards.first();
	}

	public Player findWinner(Player player1, Player player2) {

		if (player1.getHand().getRanking() == null)
			findHandRanking(player1.getHand());
		if (player2.getHand().getRanking() == null)
			findHandRanking(player2.getHand());

		int rank1 = player1.getHand().getRanking().rank;
		int rank2 = player2.getHand().getRanking().rank;

		if (rank1 < rank2)
			return player1;
		else if (rank2 > rank1)
			return player2;

		// The two players have the same hand ranking
		switch (player1.getHand().getRanking()) {
		case HIGH_CARD:
			return findHighCardHandWinner(player1, player2);
		case ONE_PAIR:
			return findOnePairHandWinner(player1, player2);
		case TWO_PAIRS:
			return findTwoPairsHandWinner(player1, player2);
		case THREE_OF_A_KIND:
			return findThreeOfAKindHandWinner(player1, player2);
		case STRAIGHT:
			return findStraightHandWinner(player1, player2);
		case FLUSH:
			return findFlushHandWinner(player1, player2);
		case FULL_HOUSE:
			return findFullHouseHandWinner(player1, player2);
		case FOUR_OF_A_KIND:
			return findFourOfAKindHandWinner(player1, player2);
		case STRAIGHT_FLUSH:
			return findStraightFlushHandWinner(player1, player2);
		default:
			return null;
		}
	}

	private Player findHighCardHandWinner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Player findOnePairHandWinner(Player player1, Player player2) {
		Card pairedCard1 = null;
		return null;
	}

	private Player findTwoPairsHandWinner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Player findThreeOfAKindHandWinner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Player findStraightHandWinner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Player findFlushHandWinner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Player findFullHouseHandWinner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Player findFourOfAKindHandWinner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return null;
	}

	private Player findStraightFlushHandWinner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		return null;
	}
}

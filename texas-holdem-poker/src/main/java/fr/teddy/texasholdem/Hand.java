package fr.teddy.texasholdem;

import java.util.HashMap;
import java.util.TreeSet;

public class Hand {

	private TreeSet<Card> cards;
	private HashMap<CardFaces, Integer> cardFacesMap = null;
	private HandRankings ranking = null;

	public HashMap<CardFaces, Integer> getCardFacesMap() {
		return cardFacesMap;
	}

	public Hand() {
		cards = new TreeSet<Card>();
	}

	public TreeSet<Card> getCards() {
		return cards;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public HandRankings getRanking() {
		return ranking;
	}

	public void setRanking(HandRankings ranking) {
		this.ranking = ranking;
	}

	public int getSize() {
		return cards.size();
	}

	@Override
	public String toString() {
		String displayedHand = "";
		for (Card card : cards) {
			displayedHand = displayedHand + card.toString() + " ";
		}
		return displayedHand.trim();
	}

	public void buildCardFacesMap() {
		cardFacesMap = new HashMap<CardFaces, Integer>();
		for (Card card : cards) {
			CardFaces face = card.getFace();
			if (cardFacesMap.containsKey(face)) {
				int numberOfFaces = cardFacesMap.get(face).intValue();
				cardFacesMap.replace(face, ++numberOfFaces);
			} else {
				cardFacesMap.put(face, 1);
			}
		}
	}

}

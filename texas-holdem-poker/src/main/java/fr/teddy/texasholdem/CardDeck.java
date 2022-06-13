package fr.teddy.texasholdem;

import java.util.ArrayList;
import java.util.Random;

public class CardDeck {

	private ArrayList<Card> cards;

	public void shuffle() {
		cards = new ArrayList<Card>();
		for (CardFaces face : CardFaces.values()) {
			for (CardSuits suit : CardSuits.values()) {
				Card card = new Card(face, suit);
				cards.add(card);
			}
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public Hand dealRandomHand() {
		Random random = new Random();
		Hand hand = new Hand();
		int randomCardNumber;
		for (int i = 0; i < 5; i++) {
			randomCardNumber = random.nextInt(cards.size());
			hand.addCard(cards.get(randomCardNumber));
			cards.remove(randomCardNumber);
		}
		return hand;
	}
}

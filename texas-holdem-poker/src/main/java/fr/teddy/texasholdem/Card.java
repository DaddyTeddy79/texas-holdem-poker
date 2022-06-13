package fr.teddy.texasholdem;

public class Card implements Comparable<Card> {

	private CardFaces face;
	private CardSuits suit;

	public Card(CardFaces face, CardSuits suit) {
		this.face = face;
		this.suit = suit;
	}

	@Override
	public String toString() {
		return String.valueOf(face.character) + String.valueOf(suit.character);
	}

	public int compareTo(Card o) {
		if (face.rank == o.face.rank)
			return suit.ordinal() - o.suit.ordinal();
		return face.rank - o.face.rank;
	}

	public CardFaces getFace() {
		return face;
	}

	public CardSuits getSuit() {
		return suit;
	}

}

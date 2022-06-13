package fr.teddy.texasholdem;

public enum CardFaces {
	TWO('2', 13), THREE('3', 12), FOUR('4', 11), FIVE('5', 10), SIX('6', 9), SEVEN('7', 8), EIGHT('8', 7), NINE('9', 6),
	TEN('T', 5), JACK('J', 4), QUEEN('Q', 3), KING('K', 2), ACE('A', 1);

	final char character;
	final int rank;

	CardFaces(char character, int rank) {
		this.character = character;
		this.rank = rank;
	}
}

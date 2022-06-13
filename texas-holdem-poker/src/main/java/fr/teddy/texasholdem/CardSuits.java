package fr.teddy.texasholdem;

public enum CardSuits {
	CLUBS('c'), DIAMONDS('d'), HEARTS('h'), SPADES('s');

	final char character;

	CardSuits(char character) {
		this.character = character;
	}
}

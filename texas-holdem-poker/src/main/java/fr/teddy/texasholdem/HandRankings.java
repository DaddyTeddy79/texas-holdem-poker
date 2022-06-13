package fr.teddy.texasholdem;

public enum HandRankings {
	HIGH_CARD(9), ONE_PAIR(8), TWO_PAIRS(7), THREE_OF_A_KIND(6), STRAIGHT(5), FLUSH(4), FULL_HOUSE(3),
	FOUR_OF_A_KIND(2), STRAIGHT_FLUSH(1);

	final int rank;

	HandRankings(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return name().replace('_', ' ').toLowerCase();
	}
}

package fr.teddy.texasholdem;

public class Player {

	private String name;
	private Hand hand;

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

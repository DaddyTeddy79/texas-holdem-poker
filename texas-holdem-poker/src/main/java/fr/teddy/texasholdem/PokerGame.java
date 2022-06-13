package fr.teddy.texasholdem;

public class PokerGame {

	private static CardDeck deck;

	public static void main(String[] args) {
		Player player1 = new Player("John");
		Player player2 = new Player("Scott");

		deck = new CardDeck();
		deck.shuffle();

		player1.setHand(deck.dealRandomHand());
		player2.setHand(deck.dealRandomHand());
		System.out.println(player1.getName() + " : " + player1.getHand().toString());
		System.out.println(player2.getName() + " : " + player2.getHand().toString());

		HandAnalyser handAnalyser = new HandAnalyser();
		handAnalyser.findHandRanking(player1.getHand());
		handAnalyser.findHandRanking(player2.getHand());
		System.out.println(player1.getName() + " has " + player1.getHand().getRanking().toString());
		System.out.println(player2.getName() + " has " + player2.getHand().getRanking().toString());
	}

}

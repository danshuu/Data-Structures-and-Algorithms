/**
* Test driver for Deck
* 
* @Author Daniel Shu
* @version Project 1 CPE103
*/

public class DeckDriver {
	
	public static void main(String[] args) {

		 Deck deck = new Deck(false);
		 System.out.println(deck.size());

		 deck.shuffle();

		 for (int card = 0; card < 52; card++) {
	         Card c = deck.draw();
	         System.out.println(c.toString());
	         deck.enqueue(c);
	      }
	      System.out.println();

		 for (int i=0;i<52;i++) {
		 	System.out.println(deck.draw());
		 }

	}

}
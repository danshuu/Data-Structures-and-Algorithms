/**
* A representation of a card in a standard 52 card deck. The ranks are "Ace", "2-10", "Jack", "Queen", "King"
* The suits are "Spades", "Hearts", "Diamonds", and "Clubs".
* @author Daniel Shu
* @version Project 1 cpe 103
*/

public class Card {

	private String rank;
	private String suit;
	
	//constructor
	public Card(int rank, int suit) {
		//ranks range from 1 - 13
		if (rank == 1) {
			this.rank = "Ace";
		} else if (rank >= 2 && 10 >= rank) {
			this.rank = String.valueOf(rank);
		} else if (rank == 11) {
			this.rank = "Jack";
		} else if (rank == 12) {
			this.rank = "Queen";
		} else if (rank == 13) {
			this.rank = "King";
		} else {
			throw new IllegalArgumentException();
		}

		//suits range from 1 - 4
		if (suit == 1) {
			this.suit = "Spades";
		} else if (suit == 2) {
			this.suit = "Hearts";
		} else if (suit == 3) {
			this.suit = "Diamonds";
		} else if (suit == 4) {
			this.suit = "Clubs";
		} else {
			throw new IllegalArgumentException();
		}
	} //constructs a card with specified rank and suit

	//Methods
	public String getRank() {
		return rank;
	} //returns the rank of this card as a String
	// will be one of "ace" -> "king"

	public String getSuit() {
		return suit;
	} //returns the suit of this card as a String. 
	//will be one of "spades, hearts, diamonds, or clubs"

	public String toString() {
		return (rank + " of " + suit);
	} //returns the name of this card "<RANK> of <SUIT>" (Ace of Spades, ie)
	//overides toString in class Object


}
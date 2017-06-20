/**
* A representation of a hand of playing cards to be used in a game. 
* Cards will remain in the order they were added to the hand.
* 
* @author Daniel Shu
* @version Project 1 cpe 103
*/

import java.util.NoSuchElementException;
import java.util.ArrayList;

public class Hand {

	private Deck deck;
	private int handSize;
	private ArrayList<Card> cardArray;

	public Hand(Deck deck, int handSize) {
		if (handSize <= 0) {
			throw new IllegalArgumentException();
		}
		if (deck.size() < handSize) {
			throw new NoSuchElementException();
		}
		if (deck == null) {
			throw new NullPointerException();
		}

		this.deck = deck;
		this.handSize = handSize;
		cardArray = new ArrayList<Card>(handSize);

		for (int i = 0; i < handSize; i++) {
			draw();
		} //draw the specified amount of cards to your hand

	} //constructs a hand of cards of the specified size by repeatedly drawing cards from the specified deck

	public void draw() {
		if (deck.size() == 0) {
			throw new NoSuchElementException();
		}
		cardArray.add(deck.dequeue());
	} //draws a card from the deck specified in the constructor and adds it to this hand

	public Card getCard(int cardNumber) {
		return cardArray.get(cardNumber);
	} //returns the card at the specified position in this hand

	public Card play(int cardNumber) {
		Card tempCard = cardArray.get(cardNumber);
		cardArray.remove(cardNumber);
		return tempCard;
	} //Removes and returns the card at the specified position in this hand

	public int size() {
		return cardArray.size();
	} //returns the number of cards in this hand



}
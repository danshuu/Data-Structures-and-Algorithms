/**
* A representation of 52 cards
* 
* @author Daniel Shu
* @version Project 1 cpe 103
*/

import java.util.Random;

public class Deck extends CircularQueue<Card> {
	//nested class CircularQueue.MyException is inherited

	//INITIAL_LENGTH field inherited from CircularQueue as well; NO other fields

	//Constructors
	public Deck(boolean shuffle) {
		super(52); //creates a circularQueue with 52 as initial capacity

		//fill up the list (it doesn't matter if the card objects override each other's names, 
		//as long as they have different values in that each one is unique)

		//adds Spades first
		for (int i = 1; i < 14; i++) {
			Card card = new Card(i,1);
			enqueue(card); //super(52) creates a circularqueue in this class that allows us to enqueue to it
		}

		//adds Hearts second
		for (int i = 1; i < 14; i++) {
			Card card = new Card(i,2);
			enqueue(card);
		}

		//adds Diamonds third
		for (int i = 1; i < 14; i++) {
			Card card = new Card(i,3);
			enqueue(card);
		}

		//adds Clubs fourth
		for (int i = 1; i < 14; i++) {
			Card card = new Card(i,4);
			enqueue(card);
		}

		if (shuffle) {
			shuffle();
		}
		// System.out.println(size());

	} //constructs a standard deck of 52 playing cards. If the deck is not to be shuffled,
	// the cards should be in order Ace -> King of Spades, Ace -> King of Hearts, Ace -> King of Diamonds, Ace -> King of Clubs

	//Methods
	public Card draw() {
		Card cardDrawn = dequeue(); //removes and returns the card
		return cardDrawn;
	} //removes and returns top card of this deck
	//throws NoSuchElementException if deck is empty

	public void shuffle() {
		Random rdm = new Random();
		int sizeDeck = size();
		Card[] tempDeck = new Card[size()];

		//empty the current Queue and add it to the temporary array
		for (int i = 0; i < sizeDeck; i++) {
			tempDeck[i] = dequeue(); //removes and returns the element
		}

		//enqueue random indexes
		while (sizeDeck != 0) {
			int randomIndex = rdm.nextInt(sizeDeck); //first returns an int between 0-51
			enqueue(tempDeck[randomIndex]); //adds a random card to the original deck
			tempDeck[randomIndex] = tempDeck[sizeDeck - 1]; //set the enqueued card as the last card
			sizeDeck--; //decrement size of deck variable
		}

	} //shuffles this deck
	//may not change contents of deck; only the order
	//may not be deterministic (use randomness in some way)
	//may not use anything from java API except for Random
}


		// CircularQueue firstHalf = new CircularQueue(size()/2); //first half of deck (26 cards)
		// CircularQueue secondHalf = new CircularQueue(size()/2); //second half of deck (26 cards)
		// Card[] tempDeck = new Card[size()]; //creates a temporary deck for storage

		// for (int i = 0; i < size()/2; i++) {
		// 	firstHalf.enqueue(arr[i]);
		// 	secondHalf.enqueue(arr[i+26]);
		// } //creates the first half of the deck (0-25 index), and the second half of the deck (26-51 index)

		// int order = rdm.nextInt(2); //gives 0 or 1 (indicates which one to start dequeueing first)

		// if (order == 0) {
		// 	int iterator = 0;
		// 	while (firstHalf.size() != 0 || secondHalf.size() != 0) {
		// 		int firstNumberCards = rdm.nextInt(3); //gives 0-2
		// 		for (int i = 0; i < firstNumberCards+1; i++) {
		// 			if (iterator == size() || firstHalf.size() == 0) { //if iterator = 52 or first half has been dequeued empty
		// 				break;
		// 			}
		// 			tempDeck[iterator] = firstHalf.dequeue();
		// 			iterator++;
		// 		}

		// 		int secondNumberCards = rdm.nextInt(3); //gives 0-2
		// 		for (int j = 0; j < secondNumberCards+1; j++) {
		// 			if (iterator == size() || secondHalf.size() == 0) { //if iterator = 52 or second half has been dequeued empty
		// 				break;
		// 			}
		// 			tempDeck[iterator] = secondHalf.dequeue();
		// 			iterator++;
		// 		} //end of for
		// 	} //end of while
		// } else {
		// 	//same as above but flipped
		// 	int iterator = 0;
		// 	while (firstHalf.size() != 0 || secondHalf.size() != 0) {

		// 		int secondNumberCards = rdm.nextInt(3); //gives 0-2
		// 		for (int j = 0; j < secondNumberCards+1; j++) {
		// 			if (iterator == size() || secondHalf.size() == 0) { //if iterator = 52 or second half has been dequeued empty
		// 				break;
		// 			}
		// 			tempDeck[iterator] = secondHalf.dequeue();
		// 			iterator++;
		// 		}

		// 		int firstNumberCards = rdm.nextInt(3); //gives 0-2
		// 		for (int i = 0; i < firstNumberCards+1; i++) {
		// 			if (iterator == size() || firstHalf.size() == 0) { //if iterator = 52 or first half has been dequeued empty
		// 				break;
		// 			}
		// 			tempDeck[iterator] = firstHalf.dequeue();
		// 			iterator++;
		// 		} //end of for

		// 	} //end of while

		// } //end of else	



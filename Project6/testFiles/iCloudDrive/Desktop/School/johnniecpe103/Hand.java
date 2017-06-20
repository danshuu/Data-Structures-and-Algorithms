import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Hand extends Object{
   
   private Deck deck;
   private int handSize;
   private ArrayList<Card> handArrayList; //make this to an array list
   
   public Hand(Deck deck, int handSize){
      if(handSize <= 0){
         throw new IllegalArgumentException();
      }
      //if the initial hand size is non-positive
      if(deck.size() < handSize){
        throw new NoSuchElementException(); 
      }
      //if the specified deck has fewer than the number of cards requested
      
      if(deck.size() == 0){
         throw new NullPointerException();
      }
      //if the specified deck is null
      
      this.deck = deck;
      this.handSize = handSize;
      handArrayList = new ArrayList<Card>();
      for(int i=0; i<handSize; i++){
        handArrayList.add(deck.draw());
      }
   }
  // Constructs a hand of cards of the specified size by repeatedly drawing cards from the specified deck.
   
   public void draw(){
      if(deck.size()==0){
         throw new NoSuchElementException();
      }
      handArrayList.add(deck.draw());
      handSize++;
   }
   //Draws a card from the deck specified in the constructor and adds it to this hand.
   
   public Card getCard(int cardNumber){
      if(cardNumber< 0 || cardNumber >= this.size()){
         throw new IndexOutOfBoundsException();
      }
      return handArrayList.get(cardNumber);
   }
   //Returns the card at the specified position in this hand.
   
   public Card play(int cardNumber){
      if(cardNumber< 0 || cardNumber >= this.size()){
         throw new IndexOutOfBoundsException();
      }
      Card valueHolder = handArrayList.get(cardNumber);
      handArrayList.remove(cardNumber); //change this to be like an actual hand maybe use a for loop to shift the cards back and remove the desired card
      handSize--;
      return valueHolder;
   }
   //Removes and returns the card at the specified position in this hand.
   
   public int size(){
      return handArrayList.size();
   }
   //Returns the number of cards in this hand.

}

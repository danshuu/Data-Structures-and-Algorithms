import java.util.NoSuchElementException;
import java.util.Random;

public class Deck extends CircularQueue<Card>{
   
   public Deck(boolean shuffle){
      super(52);
      for(int i = 1; i<=13; i ++){
         //creates a new card with rank i and suit 1
         Card c = new Card(i, 1);
         this.enqueue(c);
      }
      for(int i = 1; i<=13; i++){
         Card c = new Card(i , 2);
         this.enqueue(c);
      }
      for(int i = 1; i<=13 ; i++){
         Card c = new Card(i, 3);
         this.enqueue(c);
      }
      for(int i = 1; i<=13 ; i++){
         Card c = new Card(i, 4);
         this.enqueue(c);
      }
      
      if(shuffle == true){
         this.shuffle();
      }
   }
   
   //Constructs a standard deck of 52 playing cards.
   
   
   public Card draw(){
      if(this.size()==0){
         throw new NoSuchElementException(); 
      }
      Card drawnCard = this.dequeue();
      return drawnCard;
   }
   //Removes and returns the top card of this deck.

   public void shuffle(){
      int init_size = this.size();
      int arr_size = this.size();
      Random rand = new Random();
      
      Card[] arr = new Card[this.size()];
      
      int i = 0;
      while(this.size() > 0){
         arr[i] = this.dequeue();
         i++;
      }
      
      while(this.size() != init_size){
         
         int rand_ndx = rand.nextInt(arr_size);
         Card random = arr[rand_ndx];
         this.enqueue(random);
         
         //swap random index with last index in array.
         if(rand_ndx != arr_size - 1){
            arr[rand_ndx] = arr[arr_size -1];
         }
         arr_size--;
      }
   }
   //shuffles the deck

}

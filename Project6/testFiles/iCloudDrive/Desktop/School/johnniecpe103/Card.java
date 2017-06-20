
public class Card extends Object{
  
   private int rank;
   
   private int suit;
   
   public Card(int rank, int suit){
      if(rank < 1  || rank > 13){
         throw new IllegalArgumentException();    
      } 
      if(suit < 1 || suit > 4){
         throw new IllegalArgumentException();
      }
      //if the specified rank or the specified suit are invalid

      this.rank = rank;
      this.suit = suit;
      
   }
   //Constructs a card with the specified rank and suit.
   
   public String getRank(){
      String rankString = "";
      if(rank== 1){
         rankString += "Ace";
      }else if(rank==11){
         rankString += "Jack";
      }else if(rank == 12){
         rankString += "Queen";
      }else if(rank == 13){
         rankString += "King";
      }else{
         rankString += rank;
      }
      return rankString;
   }
   //Returns the rank of this card as a String.
   
   public String getSuit(){
      String suiter = "";
      if(suit==1){
         suiter+= "Spades";
      }
      if(suit==2){
         suiter += "Hearts";
      }
      if(suit==3){
         suiter+= "Diamonds";
      }
      if(suit==4){
         suiter+= "Clubs";
      }
      String suitString = "" + suiter;
      return suitString;
   }
   //Returns the suit of this card as a String.
   
   
   public String toString(){
      String s = this.getRank() + " of " + this.getSuit();
      return s;
   }
   //Returns the name of this card.


}

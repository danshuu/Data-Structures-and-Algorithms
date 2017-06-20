import org.junit.*;

import static org.junit.Assert.*;


public class CardTests {
   
   @Test
   public void makeSingleCard(){
      Card c = new Card(1,1);
      assertEquals("Ace of Spades", c.toString());
      Card c1 = new Card(1,2);
      assertEquals("Ace of Hearts", c1.toString());
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void makeSingleCardAgain(){
      Card c = new Card(21,5);
   }
   

   

}

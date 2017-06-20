//Johnnie Baba
//CPE 103-07
//Lab 09

import org.junit.*;

import static org.junit.Assert.*;
public class MyHashTests {
   
   @Test
   public void myHash_aa(){
      MyHash m = new MyHash();
      assertEquals(2037, m.hash("aa"));
   }
   
   @Test
   public void myHash_baba(){
      MyHash m = new MyHash();
      assertEquals(948277, m.hash("baba"));
   }
   
   @Test
   public void myHash_life(){
      MyHash m = new MyHash();
      assertEquals(1148606, m.hash("life"));
   }

}

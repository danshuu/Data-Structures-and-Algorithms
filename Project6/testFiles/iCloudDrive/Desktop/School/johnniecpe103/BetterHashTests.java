//Johnnie Baba
//CPE 103-07
//Lab 09

import org.junit.*;

import static org.junit.Assert.*;
public class BetterHashTests {
   
   @Test
   public void hash_aa(){
      BetterHash b = new BetterHash();
      assertEquals( 9506, b.hash("aa"));
   }
   
   @Test
   public void hash_johnnie(){
      BetterHash b = new BetterHash();
      assertEquals(-474569941, b.hash("johnnie"));
   }
   
   @Test
   public void hash_baba(){
      BetterHash b = new BetterHash();
      assertEquals(90364230, b.hash("baba"));
   }
   
   
}

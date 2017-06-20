import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringHashTests {
   @Test
   public void hash_aa(){
      StringHash s = new StringHash();
      assertEquals(3104,s.hash("aa") );
   }
   
   @Test
   public void hash_b(){
      StringHash s = new StringHash();
      assertEquals(98, s.hash("b"));
   }
   
   @Test
   public void hash_hi(){
      StringHash s = new StringHash();
      assertEquals(3329, s.hash("hi"));
   }
   
   @Test
   public void hash_leedle(){
      StringHash s = new StringHash();
      assertEquals(-1106634927, s.hash("leedle"));
   }
}

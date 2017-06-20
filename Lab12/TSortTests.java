/**
* Junit tests for TSort Class
* 
* @author Daniel Shu
* @version Lab12 CPE103
*/
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TSortTests {
  
   @Test
   public void emptyExceptionTest() {
      try {
         TSort.tsort("");
         fail(); //immediately fails the test if the code reaches here (see note below)
      } catch(IllegalArgumentException e) {
         assertEquals("input contains no edges", e.getMessage());
      }
   }

   @Test
   public void oddExceptionTest() {
      try {
         TSort.tsort("101 102 103");
         fail(); //immediately fails the test if the code reaches here (see note below)
      } catch(IllegalArgumentException e) {
         assertEquals("input contains an odd number of tokens", e.getMessage());
      }
   }
//(expected = IllegalArgumentException.class) 
   @Test
   public void cycleExceptionTest1() {
      try {
         TSort.tsort("101 102 102 101");
         fail(); //immediately fails the test if the code reaches here (see note below)
      } catch(IllegalArgumentException e) {
         assertEquals("input contains a loop", e.getMessage());
      }
      
   }

   @Test
   public void cycleExceptionTest2() {
      try {
         TSort.tsort("101 102 102 103 103 357 225 101 357 101");
         fail(); //immediately fails the test if the code reaches here (see note below)
      } catch(IllegalArgumentException e) {
         assertEquals("input contains a loop", e.getMessage());
      }
      
   }
   @Test
   public void topSortTest1() {
      String actual = TSort.tsort("101 102 102 103");
      String expected = "101\n102\n103\n";
      assertEquals(expected,actual);
   }

   @Test
   public void topSortTest2(){
      assertEquals(TSort.tsort("101 102 102 103 102 225 103 348 348 349 103 357 225 357 349 430 357 430 430 431 348 445"), "101\n102\n225\n103\n357\n348\n445\n349\n430\n431\n");
   }
   
}

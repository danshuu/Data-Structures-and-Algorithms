import org.junit.*;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
public class BSCTests {
   
   @Test
   public void testBSCBlank(){
      assertTrue(BSC.isBalanced(""));
   }
   
   @Test
   public void testBSCOnePair(){
      assertFalse(BSC.isBalanced("}"));
   }
   
   @Test
   public void testFalseBSC(){
      assertFalse(BSC.isBalanced("{]"));
   }
   
   @Test
   public void testSampleStringOne(){
      assertTrue(BSC.isBalanced("{}"));
   }
   
   @Test
   public void testSampleStringTwo(){
      assertTrue(BSC.isBalanced("(( ))"));
   }
   
   @Test
   public void testSampleStringThree(){
      assertTrue(BSC.isBalanced("[]{}"));
   }
   
   @Test
   public void testSampleStringFour(){
      assertTrue(BSC.isBalanced("( [ { < ( ) <( ){}>> } ] )"));
   }
   
   @Test
   public void testSampleStringFive(){
      assertTrue(BSC.isBalanced("[(Hello) {W}orld!]"));
   }
   
   @Test
   public void test01_false_sampleString(){
      assertFalse(BSC.isBalanced("{"));
   }
   
   @Test
   public void test02_false_sampleString(){
      assertFalse(BSC.isBalanced("(( )"));
   }
   
   @Test
   public void test02_p2_false_sampleString(){
      assertFalse(BSC.isBalanced("(( )))"));
   }
   @Test
   public void test03_false_sampleString(){
      assertFalse(BSC.isBalanced("( [ { < ( ) <( ){}> } ] )"));
   }
   
   @Test
   public void test03_p2_false_sampleString(){
      assertFalse(BSC.isBalanced("( [ { < (  <( ){}>>> }  )"));
   }
   @Test
   public void test04_false_sampleString(){
      assertFalse(BSC.isBalanced("[(Hello) {Wd!]"));
   }

}

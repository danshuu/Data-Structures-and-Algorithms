/**
* Junit tests for BSC
*
* @author Daniel Shu
* @version Lab3 cpe103
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;
public class BSCTests {
   
   @Test
   public void testEmptyString(){
      assertTrue(BSC.isBalanced(""));
   }
   
   @Test
   public void testClosedSymbol(){
      assertFalse(BSC.isBalanced("}"));
   }

   @Test
   public void testOpenSymbol2(){
      assertFalse(BSC.isBalanced("{"));
   }
   
   @Test
   public void testDifferentSymbols(){
      assertFalse(BSC.isBalanced("{]"));
   }
   
   @Test
   public void testExample1Simple(){
      assertTrue(BSC.isBalanced("{}"));
   }
   
   @Test
   public void testExample2BalancedWithinBalanced(){
      assertTrue(BSC.isBalanced("(( ))"));
   }
   
   @Test
   public void testExample3SimpleDoubleBalanced(){
      assertTrue(BSC.isBalanced("[]{}"));
   }
   
   @Test
   public void testExample4LongStringOfSymbols(){
      assertTrue(BSC.isBalanced("( [ { < ( ) <( ){}>> } ] )"));
   }
   
   @Test
   public void testExample5CharsInMiddle(){
      assertTrue(BSC.isBalanced("[(Hello) {W}orld!]"));
   }

   @Test
   public void testOpenUnevenSymbols(){
      assertFalse(BSC.isBalanced("{ { }"));
   }
   
   @Test
   public void testOpenUnevenSymbols2(){
      assertFalse(BSC.isBalanced("{ { ] }"));
   }
   
   @Test
   public void testOpenUnevenSymbols3(){
      assertFalse(BSC.isBalanced("{ { } } }"));
   }

   @Test
   public void testLongUnevenSymbols(){
      assertFalse(BSC.isBalanced("{ < { } > { (( )<>)} ]"));
   }
   
   @Test
   public void testLongEvenSymbols(){
      assertTrue(BSC.isBalanced("{ < { } > { (( )<>)} }"));
   }
   
   @Test
   public void testLongSymbolsWithLetters(){
      assertTrue(BSC.isBalanced("{ < {sdgg } > { (sdfgdgdfgfdgsdfkgjsdo;igsdgj;sojgr( )<>)} }"));
   }
   
   @Test
   public void testMessedUpLettersWithSymbols(){
      assertFalse(BSC.isBalanced("[(Hello) {Wd!]"));
   }

}

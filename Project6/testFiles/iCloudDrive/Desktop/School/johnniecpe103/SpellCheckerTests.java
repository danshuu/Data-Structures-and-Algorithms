//Johnnie Baba
//CPE 103-07
//Assignment 5
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.*;

import org.junit.*;
public class SpellCheckerTests {
  

   @Test
   public void isWordTest01() throws FileNotFoundException{
      SpellChecker sc = new SpellChecker();
      assertTrue(sc.isWord("hello"));
      assertTrue(sc.isWord("bye"));
   }
   
   @Test
   public void isWordTest02() throws FileNotFoundException{
      SpellChecker sc = new SpellChecker();
      assertTrue(sc.isWord("robot"));
      assertTrue(sc.isWord("boy"));
      assertFalse(sc.isWord("arigatou"));
      assertFalse(sc.isWord("salamat"));
   }
   @Test
   public void myWords() throws FileNotFoundException{
      SpellChecker sc = new SpellChecker("testingTexting.txt");
      assertTrue(sc.isWord("Pho"));
      assertTrue(sc.isWord("World"));
      assertTrue(sc.isWord("Of"));
      assertTrue(sc.isWord("Warcraft"));
      assertTrue(sc.isWord("Basketball"));
      assertTrue(sc.isWord("Honey"));
      assertTrue(sc.isWord("Ramen"));
      assertTrue(sc.isWord("Johnnie"));
      assertTrue(sc.isWord("Baba"));

   }
   
   @Test
   public void processTests01() throws FileNotFoundException{
      SpellChecker sc = new SpellChecker();
      assertTrue(sc.processFile("dictionary.txt") != null);
   }

   
}

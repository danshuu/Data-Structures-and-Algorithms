/**
* Junit tests for SpellChecker Class
* 
* @author Daniel Shu
* @version Project 5 CPE103
*/
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

public class SpellCheckerTests {
  
   @Test
   public void isWordTest() throws FileNotFoundException{
      SpellChecker sc = new SpellChecker();
      assertTrue(sc.isWord("A"));
      assertTrue(sc.isWord("a"));
      assertTrue(sc.isWord("AA"));
      assertTrue(sc.isWord("aa"));
      assertTrue(sc.isWord("A-flat"));
      assertTrue(sc.isWord("Aaron"));
      assertTrue(sc.isWord("Daniel"));
   }
   
   @Test
   public void indexFileTest() throws FileNotFoundException{
      SpellChecker sc = new SpellChecker();
      assertTrue(sc.indexFile("dictionary.txt") != null);
   }

   
}

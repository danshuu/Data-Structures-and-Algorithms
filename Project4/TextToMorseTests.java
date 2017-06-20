/**
* JUnit tests for TextToMorse
*
* @author Daniel Shu
* @version Project4 CPE103
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class TextToMorseTests {
   
   @Test
   public void translateTest(){
      TextToMorse ttm = new TextToMorse();
      assertEquals(".-", ttm.translate("a"));
      assertEquals("", ttm.translate(""));
   }
   
   @Test
   public void translateTest2(){
      TextToMorse ttm = new TextToMorse();
      assertEquals("-...", ttm.translate("b"));
      assertEquals(".- -... -.-. -.. .", ttm.translate("abcde"));
      assertEquals(".- ....-..-.-", ttm.translate("a@"));
      assertEquals("---- ---- ---- .....-.-.- ---- ---- ....-..-.- ----", ttm.translate("   .  @ "));
   }

}

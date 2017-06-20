/**
* JUnit tests for MorseToText
*
* @author Daniel Shu
* @version Project4 CPE103
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.*;

public class MorseToTextTests {
   
   @Test
   public void translateTest(){
      MorseToText mtt = new MorseToText();
      assertEquals("a", mtt.translate(".-"));
      assertEquals("", mtt.translate(""));
   }
   
   @Test
   public void translateTest2(){
      MorseToText mtt = new MorseToText();
      assertEquals("b", mtt.translate("-..."));
      assertEquals("b  u", mtt.translate("---- ---- -... ---- ---- ..- ----.- ---- "));
      assertEquals("E j", mtt.translate("---- ---- ---- ..... ---- .---"));
      assertEquals("aa", mtt.translate(".-  ......--.-.-  .-"));
   }

}

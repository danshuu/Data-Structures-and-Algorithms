import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;
public class MorseToTextTests {
   
   @Test
   public void translate_01(){
      MorseToText m = new MorseToText();
      assertEquals("A", m.translate(".-"));
   }
   
   @Test
   public void translate_02(){
      MorseToText m = new MorseToText();
      assertEquals("B", m.translate("-..."));

   }

}

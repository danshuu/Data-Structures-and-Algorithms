import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;
public class TextToMorseTests {
   
   @Test
   public void translate_01(){
      TextToMorse t = new TextToMorse();
      assertEquals(".-", t.translate("A"));
   }
   
   @Test
   public void translate_02(){
      TextToMorse t = new TextToMorse();
      assertEquals(".-  -...", t.translate("A B"));
      
   }

}

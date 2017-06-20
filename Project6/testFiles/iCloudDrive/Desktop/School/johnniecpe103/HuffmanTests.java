import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import org.junit.Test;

public class HuffmanTests {

   @Test
   public void toStringTest01() throws FileNotFoundException, IOException {
      Huffman huffts = new Huffman("toStringTest1");
      assertTrue(huffts.toString().equals("|acb|") );

   }
   
   @Test
   public void compressTest01()throws FileNotFoundException, IOException{
      Huffman h = new Huffman("test1");
      h.compress("test1", "compressOut.txt");
      FileReader fr1 = new FileReader(new File("compressOut.txt"));
      BufferedReader br1 = new BufferedReader(fr1);
      FileReader fr2 = new FileReader(new File("compressExpected.txt"));
      BufferedReader br2 = new BufferedReader(fr2);
      int keep = 0;
      keep  = br1.read();
      int going = 0;
      going = br2.read();
      while(keep != -1 && going != -1){
         assertEquals((char)keep ,(char) going );
         keep  = br1.read();
         going = br2.read();


      }

      
   }
   
   @Test
   public void decompressTest01()throws FileNotFoundException, IOException{
      Huffman h = new Huffman("test2");
      h.decompress("test1", "decompressOut.txt");
      FileReader fr1 = new FileReader(new File("decompressOut.txt"));
      BufferedReader br1 = new BufferedReader(fr1);
      FileReader fr2 = new FileReader(new File("decompressExpected.txt"));
      BufferedReader br2 = new BufferedReader(fr2);
      int keep = 0;
      keep  = br1.read();
      int going = 0;
      going = br2.read();
      while(keep != -1 && going != -1){
         assertEquals((char)keep ,(char) going );
         keep  = br1.read();
         going = br2.read();
      }
   }

}

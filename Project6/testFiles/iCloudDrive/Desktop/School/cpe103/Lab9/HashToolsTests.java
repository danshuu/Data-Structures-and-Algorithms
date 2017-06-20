/**
* Junit tests for PrimeTools
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class HashToolsTests {

  @Test
   public void collisionsTests() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashSH = new StringHash();
      BetterHash hashBH = new BetterHash();
      MyHash hashMH = new MyHash();
      int tableSize = 10;
      
      assertEquals(178678, HashTools.collisions(ls, tableSize, hashSH));
      assertEquals(178678, HashTools.collisions(ls, tableSize, hashBH));
      assertEquals(178678, HashTools.collisions(ls, tableSize, hashMH));
   }
   
   @Test
   public void maxCollisionsTest() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashSH = new StringHash();
      BetterHash hashBH = new BetterHash();
      MyHash hashMH = new MyHash();
      int tableSize = 10;
      
      assertEquals(16399, HashTools.maxCollisions(ls, tableSize, hashSH));
      assertEquals(16435, HashTools.maxCollisions(ls, tableSize, hashBH));
      assertEquals(16405, HashTools.maxCollisions(ls, tableSize, hashMH));

   }
   
   @Test
   public void avgChainLengthTest() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashSH = new StringHash();
      BetterHash hashBH = new BetterHash();
      MyHash hashMH = new MyHash();
      int tableSize = 10;
      
      assertEquals(16244.455, HashTools.avgChainLength(ls, tableSize, hashSH) , .001);
      assertEquals(16244.455, HashTools.avgChainLength(ls, tableSize, hashBH) , .001);
      assertEquals(16244.455, HashTools.avgChainLength(ls, tableSize, hashMH) , .001);


   }
   
   @Test
   public void unusedTest() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashSH = new StringHash();
      BetterHash hashBH = new BetterHash();
      MyHash hashMH = new MyHash();
      int tableSize = 10;
      
      assertEquals(0, HashTools.unused(ls, tableSize, hashSH));
      assertEquals(0, HashTools.unused(ls, tableSize, hashBH));
      assertEquals(0, HashTools.unused(ls, tableSize, hashMH));
   }
   
   @Test
   public void unusedTest2() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashSH = new StringHash();
      BetterHash hashBH = new BetterHash();
      MyHash hashMH = new MyHash();
      int tableSize = 25;
      
      assertEquals(0, HashTools.unused(ls, tableSize, hashSH));
      assertEquals(0, HashTools.unused(ls, tableSize, hashBH));
      assertEquals(0, HashTools.unused(ls, tableSize, hashMH));
   }
   
   @Test
   public void everythingTest() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashSH = new StringHash();
      BetterHash hashBH = new BetterHash();
      MyHash hashMH = new MyHash();
      int tableSize = 200000;
      
      assertEquals(60736, HashTools.collisions(ls, tableSize, hashSH));
      assertEquals(60472, HashTools.collisions(ls, tableSize, hashBH));
      assertEquals(60514, HashTools.collisions(ls, tableSize, hashMH));
      
      assertEquals(8, HashTools.maxCollisions(ls, tableSize, hashSH));
      assertEquals(8, HashTools.maxCollisions(ls, tableSize, hashBH));
      assertEquals(8, HashTools.maxCollisions(ls, tableSize, hashMH));
      
      assertEquals(1.515, HashTools.avgChainLength(ls, tableSize, hashSH) , .001);
      assertEquals(1.512, HashTools.avgChainLength(ls, tableSize, hashBH) , .001);
      assertEquals(1.512, HashTools.avgChainLength(ls, tableSize, hashMH) , .001);
      
      assertEquals(82050, HashTools.unused(ls, tableSize, hashSH));
      assertEquals(81786, HashTools.unused(ls, tableSize, hashBH));
      assertEquals(81828, HashTools.unused(ls, tableSize, hashMH));
   }

}
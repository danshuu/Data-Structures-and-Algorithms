//Johnnie Baba
//CPE 103-07
//Lab 09

import org.junit.*;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class HashToolsTests {
   
   @Test
   public void collisionsTests() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashOne = new StringHash();
      BetterHash hashTwo = new BetterHash();
      MyHash hashThree = new MyHash();
      int tableSize = 10;
      
      assertEquals(178678, HashTools.collisions(ls, tableSize, hashOne));
      assertEquals(178678, HashTools.collisions(ls, tableSize, hashTwo));
      assertEquals(178678, HashTools.collisions(ls, tableSize, hashThree));
   }
   
   @Test
   public void maxCollisionsTest() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashOne = new StringHash();
      BetterHash hashTwo = new BetterHash();
      MyHash hashThree = new MyHash();
      int tableSize = 10;
      
      assertEquals(16399, HashTools.maxCollisions(ls, tableSize, hashOne));
      assertEquals(16435, HashTools.maxCollisions(ls, tableSize, hashTwo));
      assertEquals(16384, HashTools.maxCollisions(ls, tableSize, hashThree));

   }
   
   @Test
   public void avgCollisionsTest() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashOne = new StringHash();
      BetterHash hashTwo = new BetterHash();
      MyHash hashThree = new MyHash();
      int tableSize = 10;
      
      assertEquals(16244.455, HashTools.avgCollisions(ls, tableSize, hashOne) , .001);
      assertEquals(16244.455, HashTools.avgCollisions(ls, tableSize, hashTwo) , .001);
      assertEquals(16244.455, HashTools.avgCollisions(ls, tableSize, hashThree) , .001);


   }
   
   @Test
   public void unusedTest() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashOne = new StringHash();
      BetterHash hashTwo = new BetterHash();
      MyHash hashThree = new MyHash();
      int tableSize = 10;
      
      assertEquals(0, HashTools.unused(ls, tableSize, hashOne));
      assertEquals(0, HashTools.unused(ls, tableSize, hashTwo));
      assertEquals(0, HashTools.unused(ls, tableSize, hashThree));
   }
   
   @Test
   public void unusedTest02() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashOne = new StringHash();
      BetterHash hashTwo = new BetterHash();
      MyHash hashThree = new MyHash();
      int tableSize = 15;
      
      assertEquals(0, HashTools.unused(ls, tableSize, hashOne));
      assertEquals(0, HashTools.unused(ls, tableSize, hashTwo));
      assertEquals(0, HashTools.unused(ls, tableSize, hashThree));
   }
   
   @Test
   public void allMethods() throws FileNotFoundException{
      Scanner s = new Scanner(new File("dictionary.txt"));
      ArrayList<String> ls = new ArrayList<String>();
      while(s.hasNext()){
         ls.add(s.next());
      }
      StringHash hashOne = new StringHash();
      BetterHash hashTwo = new BetterHash();
      MyHash hashThree = new MyHash();
      int tableSize = 200000;
      
      assertEquals(60736, HashTools.collisions(ls, tableSize, hashOne));
      assertEquals(60472, HashTools.collisions(ls, tableSize, hashTwo));
      assertEquals(60261, HashTools.collisions(ls, tableSize, hashThree));
      
      assertEquals(8, HashTools.maxCollisions(ls, tableSize, hashOne));
      assertEquals(8, HashTools.maxCollisions(ls, tableSize, hashTwo));
      assertEquals(8, HashTools.maxCollisions(ls, tableSize, hashThree));
      
      assertEquals(1.515, HashTools.avgCollisions(ls, tableSize, hashOne) , .001);
      assertEquals(1.512, HashTools.avgCollisions(ls, tableSize, hashTwo) , .001);
      assertEquals(1.509, HashTools.avgCollisions(ls, tableSize, hashThree) , .001);
      
      assertEquals(82050, HashTools.unused(ls, tableSize, hashOne));
      assertEquals(81786, HashTools.unused(ls, tableSize, hashTwo));
      assertEquals(81575, HashTools.unused(ls, tableSize, hashThree));
   }

}

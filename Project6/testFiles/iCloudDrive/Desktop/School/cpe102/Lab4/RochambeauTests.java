/**
 * A sample JUnit test class to test the Lab 03 RochambeauPlayer.java
 * and Rochambeau.java classes.
 *
 * Note: This class is incomplete!  Your code will be tested
 *       with much more rigorous tests. 
 *
 * @author Julie Workman
 * @version 4/6/2016 (Written to JUnit-4.12)
 */

import static org.junit.Assert.*;
import org.junit.*;

public class RochambeauTests
{   
   /* RochambeauPlayer default constructor test */
   @Test public void defaultRochambeauPlayerTest()
   {
      RochambeauPlayer rp = new RochambeauPlayer("Alex");

      assertEquals("Alex", rp.getName());
      assertEquals(0, rp.getWins());
      assertEquals("Alex has 0 wins.", rp.toString());
      assertEquals("No Throw", rp.lastThrow());
   }   
   
   /* RochambeauPlayer constructor test with seed for Random number generator */
   @Test public void seededRochambeauPlayerTest()
   {
      RochambeauPlayer rp = new RochambeauPlayer("Jackie", 0);

      assertEquals("Jackie", rp.getName());
      assertEquals(0, rp.getWins());
      assertEquals("Jackie has 0 wins.", rp.toString());
      assertEquals("No Throw", rp.lastThrow());
   }  

   /* RochambeauPlayer make throw test 1 - random throw */
   @Test public void makeThrowTest1()
   {
      RochambeauPlayer rp = new RochambeauPlayer("Alex");
      int curThrow;

      curThrow = rp.makeThrow();
      assertTrue(curThrow >= 0 && curThrow <= 2);
   } 

   /* RochambeauPlayer make throw test 2 - specified throw */
   @Test public void makeThrowTest2()
   {
      RochambeauPlayer rp = new RochambeauPlayer("Alex");
      int curThrow;

      curThrow = rp.makeThrow(Rochambeau.ROCK);
      assertEquals(Rochambeau.ROCK, curThrow);
   }  

   /* RochambeauPlayer make throw test 3 - a seeded constructor */
   @Test public void makeThrowTest3()
   {
      RochambeauPlayer rp = new RochambeauPlayer("Alex", 72);
      int curThrow;

      curThrow = rp.makeThrow(Rochambeau.ROCK);
      assertEquals(Rochambeau.ROCK, curThrow);
   }  

   /* RochambeauPlayer incrementWins test */
   @Test public void incrementWinsTest()
   {
      RochambeauPlayer rp = new RochambeauPlayer("Alex");

      assertEquals(0, rp.getWins());
      rp.incrementWins();
      assertEquals(1, rp.getWins());
   }  

   /* RochambeauPlayer lastThrow test */
   @Test public void lastThrowTest()
   {
      RochambeauPlayer rp = new RochambeauPlayer("Alex");
      int curThrow;

      curThrow = rp.makeThrow();
      
      if (curThrow == Rochambeau.ROCK)
         assertEquals("Rock", rp.lastThrow());
      else if (curThrow == Rochambeau.PAPER)
         assertEquals("Paper", rp.lastThrow());
      else 
         assertEquals("Scissors", rp.lastThrow());
   }  
   
   /* Rochambeau getWinner test */
   @Test public void rochambeauGetWinnerTest()
   {
      assertEquals(0, Rochambeau.getWinner(Rochambeau.SCISSORS, Rochambeau.SCISSORS));
   }
}
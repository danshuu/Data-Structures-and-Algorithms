/**
 * A simple JUnit test class to test the Project 3 Maze Game.
 *
 * @author Julie Workman
 * @version 4/25/2016 (Written to JUnit-4.12)
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class P3Tests
{   
   @Rule
   public TestRule watcher = new TestWatcher() {
      protected void starting(Description description) {
         System.out.print("Starting: " + description.getMethodName() + "...");
      }
   };
   
   @Rule
   public Stopwatch sw = new Stopwatch() {
      protected void finished(long nanos, Description description) {
         System.out.println(" (" + runtime(TimeUnit.MILLISECONDS) + " ms)");
      }
      protected void succeeded(long nanos, Description description) {
         System.out.print("Passed");
      }
      protected void failed(long nanos, Throwable e, Description description) {
         System.out.print("Failed");
      }
   };
   
   /* ------------------------------ Basic Maze Tests ---------------------------*/
   
   /* Maze test */
   @Test (timeout = 5000)
   public void mazeTest()
   {
      Square[][] mazeSquares = new Square[3][3];
      Maze maze;
      Explorer ex;
      
      /*     -------------
       *     |       |   |
       *     |       |   |
       *     -----   -   |
       *     |   |       |
       *     |   |       |
       *     |   -   -   |
       *     |       |   |
       *     |       |   |
       *     -------------
       */
    
      mazeSquares[0][0] = new Square(true, false, true, true, 0, 0);
      mazeSquares[0][1] = new Square(true, true, false, false, 0, 1);
      mazeSquares[0][2] = new Square(true, true, false, true, 0, 2);
      mazeSquares[1][0] = new Square(true, true, false, true, 1, 0);
      mazeSquares[1][1] = new Square(false, false, false, true, 1, 1);
      mazeSquares[1][2] = new Square(false, true, false, false, 1, 2);
      mazeSquares[2][0] = new Square(false, false, true, true, 2, 0);
      mazeSquares[2][1] = new Square(false, true, true, false, 2, 1);
      mazeSquares[2][2] = new Square(false, true, true, true, 2, 2);
      
      maze = new Maze(mazeSquares, 3, 3);
      ex = new Explorer(mazeSquares[0][0], maze, "Super Chris");
      
      assertEquals(mazeSquares[0][0], ex.location());
      assertEquals("Super Chris", ex.name());
      assertTrue(mazeSquares[0][0].inView());
      assertTrue(mazeSquares[0][1].inView());
      assertFalse(mazeSquares[0][2].inView());
      assertFalse(mazeSquares[1][0].inView());
      assertTrue(mazeSquares[1][1].inView());
      assertFalse(mazeSquares[1][2].inView());
      assertFalse(mazeSquares[2][0].inView());
      assertFalse(mazeSquares[2][1].inView());
      assertFalse(mazeSquares[2][2].inView());
   }
}
/**
 * A minimal JUnit test class to test the Lab 09 RecursionLab.java.
 *
 * This class doesn't actually test anything other than that I can
 * call the methods and it will compile/run without crashing.
 *
 * @author Julie Workman
 * @version 5/26/2016 (Written to JUnit-4.12)
 */

import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class PartATests
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
   
   private static int countModifiers(Field[] fields, int modifier)
   {
      int count = 0;
      
      for (Field f : fields)
      {
         if (f.getModifiers() == modifier)
         {
            count++;
         }
      }
      
      return count;
   }
   
   private static int countModifiers(Method[] methods, int modifier)
   {
      int count = 0;
      
      for (Method m : methods)
      {
         if (m.getModifiers() == modifier)
         {
            count++;
         }
      }
      
      return count;
   }
   
   // ---------------------------- Functionality Tests --------------------------------
   @Test (timeout = 5000)
   public void findMaxTest()
   {
      int[] nums = {3, 4, 5};
      RecursionLab.findMax(nums, 0);
   }	
   
   @Test (timeout = 5000)
   public void countSpacesTest()
   {
      RecursionLab.countSpaces("I am a sentence.");
   }
   
   @Test (timeout = 5000)
   public void isPalindromeTest()
   {
      RecursionLab.isPalindrome("racecar");
   }		
}

/**
 * Sample JUnit tests for BinaryHeapUtilities class.
 *
 * @author Paul Hatalsky
 * @version 02/02/2017 Developed for CPE 103 Lab 5 
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.util.NoSuchElementException;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.io.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinaryHeapUtilitiesSampleTests 
{
   @Rule
   public TestRule watcher = new TestWatcher() {
      protected void starting(Description description) {
         System.out.printf("\b\bStarting: %-60s", description.getMethodName());
      }
   };
   
   @Rule
   public Stopwatch sw = new Stopwatch() {
      String s;
      protected void finished(long nanos, Description description) {
         System.out.println(s);
      }
      protected void succeeded(long nanos, Description description) {
         s = " Passed" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
      protected void failed(long nanos, Throwable e, Description description) {
         s = " FAILED" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
   };

   // Some trivial tests below!   
   @Test
   public void test06_heightNormalValues() {
      assertEquals(0, BinaryHeapUtilities.height(1));
   }

   @Test(expected = IllegalArgumentException.class)
   public void test05_heightNegative99() {
      BinaryHeapUtilities.height(-99);
   }

   @Test
   public void test07_isHeapGood() {
      Integer[] heap = new Integer[] {9999, -5, -9999, -9999};
      assertTrue(BinaryHeapUtilities.isHeap(heap, 1));
   }
   
   @Test
   public void test52_parentOfGoodTest() {
      Integer[] heap = new Integer[] {9999, -5, 3, -2, 7, 4, 9, -1, 8, -9999, -9999};

      assertEquals((Integer)(-5), BinaryHeapUtilities.parentOf(2, heap, 8));
   }

   @Test
   public void test53_leftChildOfGoodTest() {
      // Note: Extra two at end to verify student is not using .length!
      Integer[] heap = new Integer[] {9999, -5, 3, -2, 7, 4, 9, -1, 8};

      assertEquals((Integer) 9, BinaryHeapUtilities.leftChildOf(3, heap, 8));
   }

   @Test
   public void test54_rightChildOfGoodTest() {
      // Note: Extra two at end to verify student is not using .length!
      Integer[] heap = new Integer[] {9999, -5, 3, -2, 7, 4, 9, -1, 8};

      assertEquals((Integer)(-1), BinaryHeapUtilities.rightChildOf(3, heap, 8));
   }
}
//Johnnie Baba
//CPE 103-07
//Lab 02
//Description:

import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class SimpleLinkedQueueTests {
   
   @Test
   public void testEmpty(){
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<Integer>();
      assertTrue(list.size() == 0);
   }
   
   @Test(expected= NoSuchElementException.class)
   public void testEmptyBlankList(){
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<Integer>();
      list.peek();
   }
   
   @Test
   public void testEnqueueTwice(){
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<Integer>();
      list.enqueue(21);
      list.enqueue(41);
      assertTrue(listEquals(list,new int[] {21,41}));

   }
   
   @Test
   public void TestSizeAdded(){
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<Integer>();
      list.enqueue(21);
      list.enqueue(99);
      list.enqueue(1235);
      assertTrue(list.size()== 3);
   }
   
   @Test
   public void testEnqueueTwiceRemoveOne(){
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<Integer>();
      list.enqueue(69);
      list.enqueue(21);
      list.enqueue(56);
      list.dequeue();
      assertTrue(listEquals(list,new int[] {21,56}));
   }
   
   @Test
   public void testEnqueue(){
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<Integer>();
      list.enqueue(1);
      
      assertTrue(listEquals(list,new int[] {1}));

   }
   
   @Test
   public void testDequeue(){
      SimpleLinkedQueue<Integer> list = new SimpleLinkedQueue<Integer>();
      list.enqueue(21);
      list.enqueue(69);
      list.dequeue();
      assertTrue(listEquals(list,new int[]{69}));
      
   }
   
   private boolean listEquals(SimpleLinkedQueue<Integer> list, int[] a) {
      if (list.peek() != a[0]) {
            return false;
      }
      if(list.size() != a.length){
         return false;
      }
      return true;
   }

}

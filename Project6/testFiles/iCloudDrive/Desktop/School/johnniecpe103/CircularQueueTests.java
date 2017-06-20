import org.junit.*;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class CircularQueueTests {
   
   private boolean listEquals(CircularQueue<Integer> list, int[] a) {
      if (list.size() != a.length) {
        return false;
      }
      if (list.peek() != a[0]) {
        return false;
      }
      
      return true;
   }
   
   @Test
   public void testSize_empty() {
      CircularQueue<Integer> list = new CircularQueue<Integer>();
      assertTrue(list.size() == 0);
   }
   
   
   
   @Test
   public void testFillEnqueue(){
      CircularQueue<Integer> list = new CircularQueue<Integer>();
      list.enqueue(1);
      list.enqueue(3);
      list.enqueue(4);
      list.enqueue(2);
      list.enqueue(5);
      list.dequeue();
      list.dequeue();
      list.enqueue(7);
      list.enqueue(6);
      list.enqueue(8);
      list.enqueue(9);
      list.enqueue(10);
      list.enqueue(11);
      list.enqueue(12);
      list.enqueue(13);
      
      assertEquals(list.size(), 11);
      assertTrue(listEquals(list, new int[] {4,2,5,7,6,8,9,10,11,12,13} ) );
      
   }
   
   @Test
   public void testPrint(){
      CircularQueue<Integer> list = new CircularQueue<Integer>(3);
      list.enqueue(21);
      list.enqueue(1);
      list.enqueue(7);
      
      assertTrue(list.peek()== 21);
      
      list.enqueue(13);
      
      

   }
   
   @Test
   public void testEnqueue(){
      CircularQueue<Integer> list = new CircularQueue<Integer>();
      list.enqueue(2);
      list.enqueue(21);
      list.enqueue(22);
      assertTrue(list.size() == 3);
      //assertTrue(listEquals(list,new int[] {2,21,22}));
      
   }
   
   @Test
   public void testDequeue(){
      CircularQueue<Integer> list = new CircularQueue<Integer>();
      list.enqueue(21);
      list.enqueue(33);
      list.dequeue();
      assertTrue(list.size() == 1);
      assertTrue(listEquals(list, new int[] {33} ) );
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testDequeueEmpty(){
      CircularQueue<Integer> list = new CircularQueue<Integer>();
      list.dequeue();
   }
   
   @Test(expected = CircularQueue.MyException.class)
   public void testInitialCapacityMyException(){
      CircularQueue<Integer> list = new CircularQueue<Integer>(-1);
   }
   
   @Test(expected = NoSuchElementException.class)
   public void testPeekException(){
      CircularQueue<Integer> list = new CircularQueue<Integer>();
      list.peek();
   }
   
}

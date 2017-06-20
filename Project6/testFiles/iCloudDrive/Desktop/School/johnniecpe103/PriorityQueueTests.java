//Johnnie Baba
//CPE 103-07
//Program 3
//Description: This program will test the PriorityQueue program to make sure the elements are sorted similar
//to a binary heap as well as enqueueing and dequeueing like a queue
import org.junit.*;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
public class PriorityQueueTests {
   
   @Test(expected =NoSuchElementException.class)
   public void dequeue_error(){
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.dequeue();

   }
   @Test(expected = NoSuchElementException.class)
   public void peek_error(){
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.peek();
   }
   
   @Test
   public void max_enqueue_01(){ //enqueue 1 element 1
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.enqueue(1);
      assertEquals((Integer)1, pq.peek());
      
   }
   
   @Test
   public void max_enqueue_02(){ //enqueue 3 elements 1 2 3
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.enqueue(1);
      assertEquals((Integer)1,pq.peek());
      pq.enqueue(2);
      assertEquals((Integer)2, pq.peek());
      pq.enqueue(3);
      assertEquals((Integer)3, pq.peek());
      
   }
   @Test
   public void max_enqueue_03(){//enqueue 5 elements 1 2 3 4 5
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.enqueue(1);
      assertEquals((Integer)1,pq.peek());
      pq.enqueue(2);
      assertEquals((Integer)2, pq.peek());
      pq.enqueue(3);
      assertEquals((Integer)3, pq.peek());
      pq.enqueue(4);
      assertEquals((Integer)4, pq.peek());
      pq.enqueue(5);
      assertEquals((Integer)5, pq.peek());
      pq.enqueue(5);
      assertEquals(6, pq.size());
   }
   
   @Test 
   public void max_enqueue_04(){//enqueue 5 random elements
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.enqueue(21);
      assertEquals((Integer)21,pq.peek());
      pq.enqueue(69);
      assertEquals((Integer)69, pq.peek());
      pq.enqueue(11);
      assertEquals((Integer)69, pq.peek());
      pq.enqueue(2);
      assertEquals((Integer)69, pq.peek());
      pq.enqueue(42);
      assertEquals((Integer)69, pq.peek());
      pq.enqueue(42);
      assertEquals((Integer)69,pq.peek());
      assertEquals(6, pq.size() );
   }
   
   @Test
   public void min_enqueue_01(){//enqueue 1 element 1 
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      pq.enqueue(1);
      assertEquals((Integer)1, pq.peek());
   }
   
   @Test
   public void min_enqueue_02(){ //enqueue 3 elements 3 2 1
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      pq.enqueue(3);
      assertEquals((Integer)3, pq.peek());
      pq.enqueue(2);
      assertEquals((Integer)2, pq.peek());
      pq.enqueue(1);
      assertEquals((Integer)1, pq.peek());
      
   }
   
   @Test
   public void min_enqueue_03(){//enqueue 5 elements 5 4 3 2 1
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      pq.enqueue(5);
      assertEquals((Integer)5,pq.peek());
      pq.enqueue(4);
      assertEquals((Integer)4, pq.peek());
      pq.enqueue(3);
      assertEquals((Integer)3, pq.peek());
      pq.enqueue(2);
      assertEquals((Integer)2, pq.peek());
      pq.enqueue(1);
      assertEquals((Integer)1, pq.peek());
      assertEquals(5, pq.size());
   }
   
   @Test
   public void min_enqueue_04(){//enqueue 6 random elements
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      pq.enqueue(21);
      assertEquals((Integer)21,pq.peek());
      pq.enqueue(69);
      assertEquals((Integer)21, pq.peek());
      pq.enqueue(11);
      assertEquals((Integer)11, pq.peek());
      pq.enqueue(2);
      assertEquals((Integer)2, pq.peek());
      pq.enqueue(42);
      assertEquals((Integer)2, pq.peek());
      pq.enqueue(42);
      assertEquals((Integer)2,pq.peek());
      pq.enqueue(2);
      assertEquals(7, pq.size());
     

   }
   
   @Test
   public void max_dequeue_01(){//dequeue 1 element
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.enqueue(1);
      assertEquals((Integer)1, pq.dequeue());
      assertEquals(0, pq.size());
   }
   
   @Test
   public void max_dequeue_02(){//dequeue the top
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.enqueue(1);
      pq.enqueue(2);
      assertEquals((Integer)2, pq.dequeue());
      assertEquals(1,pq.size());
      pq.enqueue(2);
      pq.enqueue(21);
      assertEquals((Integer)21, pq.dequeue());
      assertEquals(2, pq.size());

   }
   
   @Test
   public void min_dequeue_01(){
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      pq.enqueue(1);
      pq.enqueue(2);
      assertEquals((Integer)1, pq.dequeue());
      pq.enqueue(21);
      pq.enqueue(2);
      assertEquals((Integer)2, pq.dequeue());
      assertEquals(2,pq.size());
   }
   @Test
   public void min_dequeue_02(){
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      pq.enqueue(1);
      pq.enqueue(2);
      assertEquals((Integer)1, pq.dequeue());
      pq.enqueue(21);
      pq.enqueue(2);
      assertEquals((Integer)2, pq.dequeue());
      assertEquals(2,pq.size());
      pq.enqueue(21);
      pq.enqueue(2);
      pq.enqueue(1);
      pq.enqueue(2);
      assertEquals((Integer)1, pq.peek());
   }

}

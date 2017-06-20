/**
* Junit tests for PriorityQueue
*
* @author Daniel Shu
* @version Project 3 CPE103
*/

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*; //nosuchelementexception

public class PriorityQueueTests {

	@Test(expected = NoSuchElementException.class) 
	public void peekEmptyTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.peek();
	}

	@Test(expected = NoSuchElementException.class) 
	public void dequeueEmptyTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.dequeue();
	}

	@Test(expected = NoSuchElementException.class) 
	public void enqueueDequeueEmptyTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 100; i < 110; i++) {
			pq.enqueue(i);
		}	

		for (int i = 0; i < 11; i++) {
			pq.dequeue();
		}
	}

	@Test(expected = NoSuchElementException.class) 
	public void enqueuePeekSizeDequeueTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.enqueue(9);
		assertEquals((Integer) 9, pq.peek());
		assertEquals(1, pq.size());
		pq.enqueue(8);
		assertEquals((Integer) 8, pq.peek());
		assertEquals(2, pq.size());
		pq.enqueue(7);
		assertEquals((Integer) 7, pq.peek());
		pq.enqueue(6);
		assertEquals((Integer) 6, pq.peek());
		pq.enqueue(5);
		assertEquals((Integer) 5, pq.peek());
		pq.enqueue(4);
		assertEquals((Integer) 4, pq.peek());
		pq.enqueue(3);
		assertEquals((Integer) 3, pq.peek());
		pq.enqueue(2);
		assertEquals((Integer) 2, pq.peek());
		assertEquals(8, pq.size());
		assertEquals((Integer) 2, pq.dequeue());
		assertEquals(7, pq.size());
		pq.dequeue();
		pq.dequeue();
		pq.dequeue();
		pq.dequeue();
		pq.dequeue();
		pq.dequeue();
		pq.dequeue();
		pq.dequeue();

	}

	@Test
	public void enqueueDequeueTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.enqueue(9);
		assertEquals((Integer) 9, pq.peek());
		pq.dequeue();
		assertEquals(0, pq.size());
	}

	@Test
	public void enqueuePeekSizeTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.enqueue(9);
		assertEquals((Integer) 9, pq.peek());
		assertEquals(1, pq.size());
		pq.enqueue(8);
		assertEquals((Integer) 8, pq.peek());
		assertEquals(2, pq.size());
		pq.enqueue(7);
		assertEquals((Integer) 7, pq.peek());
		pq.enqueue(6);
		assertEquals((Integer) 6, pq.peek());
		pq.enqueue(5);
		assertEquals((Integer) 5, pq.peek());
		pq.enqueue(4);
		assertEquals((Integer) 4, pq.peek());
		pq.enqueue(3);
		assertEquals((Integer) 3, pq.peek());
		pq.enqueue(2);
		assertEquals((Integer) 2, pq.peek());
		assertEquals(8, pq.size());
		assertEquals((Integer) 2, pq.dequeue());
		assertEquals(7, pq.size());

	}

	@Test
	public void maxEnqueueDequeuePeekSizeTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
		pq.enqueue(50);
		assertEquals((Integer) 50, pq.peek());
		assertEquals(1, pq.size());
		pq.enqueue(500);
		assertEquals((Integer) 500, pq.peek());
		assertEquals(2, pq.size());
		pq.enqueue(480);
		pq.enqueue(25);
		pq.enqueue(28);
		pq.enqueue(27);
		pq.enqueue(27);
		pq.enqueue(30);
		pq.enqueue(3);
		pq.enqueue(40);
		assertEquals(10, pq.size());
		assertEquals((Integer) 500, pq.dequeue());
		assertEquals(9, pq.size());

	}

	
	@Test
	public void minSortSizeTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Integer[] intArray = {123,34,567,12,10,100,10000};

		pq.sort(intArray, 7);
		Integer[] sortedArray = {10, 12, 34, 100, 123, 567, 10000};

		for (int i = 0; i < 7; i++) {
			assertEquals(intArray[i], sortedArray[i]);
		}
	}

	@Test
	public void minKthEnqueueDequeueSizeTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Integer[] intArray = {123,34,567,12,10,100,10000};
		Integer[] sortedArray = {10, 12, 34, 100, 123, 567, 10000};

		assertEquals((Integer) 123, (Integer)pq.kth(intArray, 7,3));

	}

	@Test
	public void minSortEnqueueDequeueSizeTest() {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Integer[] intArray = new Integer[10];
		for (int i = 10; i > 0; i--) { //10->1
			intArray[10-i] = i;
		}
		pq.sort(intArray, 10);
		Integer[] sortedArray = {1,2,3,4,5,6,7,8,9,10};

		for (int i = 0; i < 10; i++) {
			pq.enqueue(intArray[i]);
			assertEquals(intArray[i], sortedArray[i]);
		}

		assertEquals((Integer) 1, pq.peek());
		assertEquals((Integer) 1, pq.dequeue());
		assertEquals(9, pq.size());

	}

   @Test(expected = NoSuchElementException.class)
   public void maxDequeueEmptyTest(){
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.dequeue();
   }

   @Test(expected = NoSuchElementException.class)
   public void maxPeekEmptyTest(){
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.peek();
   }
   
   @Test
   public void maxEnqueue1(){ //enqueue 1 element 1
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.enqueue(1);
      assertEquals((Integer)1, pq.peek());
   }
   
   @Test
   public void maxEnqueue2(){ //enqueue 3 elements 1 2 3
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.enqueue(1);
      assertEquals((Integer)1,pq.peek());
      pq.enqueue(2);
      assertEquals((Integer)2, pq.peek());
      pq.enqueue(3);
      assertEquals((Integer)3, pq.peek()); 
   }
   @Test
   public void maxEnqueue3(){//enqueue 5 elements 1 2 3 4 5
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
   public void maxEnqueue4(){//enqueue 5 random elements
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
   public void minEnqueue2(){ //enqueue 3 elements 3 2 1
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
      pq.enqueue(3);
      assertEquals((Integer)3, pq.peek());
      pq.enqueue(2);
      assertEquals((Integer)2, pq.peek());
      pq.enqueue(1);
      assertEquals((Integer)1, pq.peek());
   }
   
   @Test
   public void minEnqueue3(){//enqueue 5 elements 5 4 3 2 1
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
   public void minEnqueue4(){//enqueue 6 random elements
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
   public void maxDequeue1(){//dequeue 1 element
      PriorityQueue<Integer> pq = new PriorityQueue<Integer>(true);
      pq.enqueue(1);
      assertEquals((Integer)1, pq.dequeue());
      assertEquals(0, pq.size());
   }
   
   @Test
   public void maxDequeue2(){//dequeue the top
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
   public void minDequeue1(){
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
   public void minDequeue2(){
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
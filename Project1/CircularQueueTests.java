/**
* Junit tests for CircularQueue
*
* @author Daniel Shu
* @version Project 1 CircularQueueTests
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class CircularQueueTests {
	
	@Test(expected = NoSuchElementException.class) 
	public void emptyRemove() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.dequeue();
	}

	@Test(expected = NoSuchElementException.class) 
	public void emptyPeek() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.peek();
	}

	@Test(expected = CircularQueue.MyException.class) 
	public void myException() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>(-1);
	}

	@Test(expected = NoSuchElementException.class) 
	public void emptyAddRemove3() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(20);
		queue.enqueue(222);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

	}

	@Test(expected = NoSuchElementException.class) 
	public void emptyAddRemovePeek() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(20);
		queue.enqueue(222);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.peek();

	}

	@Test
	public void testAdd() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		queue.enqueue(200);
		assertEquals(queue.peek(), (Integer)2);
	}

	@Test
	public void testDequeue() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		assertEquals(queue.dequeue(), (Integer)2);
	}

	@Test
	public void testAddSize() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);
		assertEquals(queue.size(), 4);
	}

	@Test
	public void testAddRemoveSize() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.dequeue();
		queue.dequeue();
		assertEquals(queue.size(), 2);
	}

	@Test
	public void testAddOverCapacity() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);		
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);		
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);
		assertEquals(queue.size(), 15);
	}

	@Test
	public void testAddOverCapacityRemove() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);		
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);		
		queue.enqueue(200);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertEquals(queue.size(), 8);
	}

	@Test
	public void testAddOverCapacityRemovePeek() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(2004);
		queue.enqueue(2050);
		queue.enqueue(212);
		queue.enqueue(949);
		queue.enqueue(20460);
		queue.enqueue(2080);		
		queue.enqueue(28);
		queue.enqueue(29700);
		queue.enqueue(20800);
		queue.enqueue(2070);		
		queue.enqueue(27700);
		queue.enqueue(200);
		queue.enqueue(200);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertEquals(queue.peek(), (Integer)2080);
	}

	@Test
	public void testDoubleSize() {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();
		queue.enqueue(2);
		queue.enqueue(200);
		queue.enqueue(2004);
		queue.enqueue(2050);
		queue.enqueue(2050);
		queue.enqueue(212);
		queue.enqueue(949);
		queue.enqueue(20460);
		queue.enqueue(2080); //9 enqueues
		assertEquals(queue.unusualMethodForTestingPurposesOnly().length, 10);
	}

}
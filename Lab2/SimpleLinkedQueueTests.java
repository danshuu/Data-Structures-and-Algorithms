/**
* JUnit tests for SimpleLinkedQueue
*
* @Author Daniel Shu
* @version Lab2 CPE103
*/

import org.junit.*;	//allows us to use the @Test annotation without having to type org.junit.Test
import static org.junit.Assert.*; //allows us to call the static assertion methods without needing to specify the Assert class

import java.util.NoSuchElementException;

public class SimpleLinkedQueueTests {

	@Test(expected = NoSuchElementException.class)
	public void testEmptyPeek() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.peek();
	}

	@Test(expected = NoSuchElementException.class)
	public void testEmptyRemove() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.dequeue();
	}

	@Test(expected = NoSuchElementException.class)
	public void testAddRemove3() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(6);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}

	@Test
	public void testEmptySize() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		assertEquals(queue.size(), 0); //cast as an integer to avoid ambiguity or assertTrue(queue.size()==0)
	}

	@Test
	public void testAdd() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(6);
		assertEquals(queue.peek(),(Integer)5);
	}

	@Test
	public void testAddRemove() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(6);
		queue.dequeue();
		assertEquals(queue.peek(),(Integer)6);
	}

	@Test
	public void testAddNullRemove() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(null);
		queue.dequeue();
		assertEquals(queue.peek(),null);
	}

	@Test
	public void testAddNullRemoveNull() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(null);
		queue.dequeue();
		queue.dequeue();
		assertEquals(queue.size(),0);
	}

	@Test
	public void testAddSize() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(6);
		assertEquals(queue.size(),2); //all sizes return int (primitives) so no need to cast 
	}

	@Test
	public void testAddSize2() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(5);
		queue.enqueue(6);
		assertEquals(queue.size(),6);
	}

	@Test
	public void testAddRemoveSize() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(6);
		queue.dequeue();
		assertEquals(queue.size(),2);
	}

	@Test
	public void testAddRemoveSizeEmpty() {
		SimpleLinkedQueue<Integer> queue = new SimpleLinkedQueue<Integer>();
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(6);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		assertEquals(queue.size(),0);
	}


}
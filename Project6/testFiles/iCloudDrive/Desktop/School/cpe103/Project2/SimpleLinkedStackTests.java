/**
* junit tests for SimpleLinkedTests
*
* @author Daniel Shu
* @version Project 2 CPE103
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class SimpleLinkedStackTests {
	
	@Test(expected = NoSuchElementException.class)
	public void testEmptyPeek() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		stack.peek();
	}

	@Test(expected = NoSuchElementException.class)
	public void testEmptyPop() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		stack.pop();
	}

	@Test(expected = NoSuchElementException.class)
	public void testPushPopEmptyPop() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		stack.push(2);
		stack.pop();
		stack.pop();
	}

	@Test(expected = NoSuchElementException.class)
	public void testPushPopEmptyPeek() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		stack.push(2);
		stack.pop();
		stack.peek();
	}

	@Test(expected = NoSuchElementException.class)
	public void testPushPopSizePeekEmpty() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		for (int i = 0; i < 20; i++) {
			stack.push(i);
		}
		assertEquals(stack.size(), 20);
		for (int i = 0; i < 20; i++) {
			stack.pop();
		}
		stack.peek();
	}

	@Test
	public void testPushSize0() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		assertEquals(stack.size(), 0);
	}

	@Test
	public void testPushSize1() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		stack.push(2);
		assertEquals(stack.size(), 1);
	}

	@Test
	public void testPushPopPeekSize() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		assertEquals(stack.size(), 10);
		assertEquals(stack.peek(),(Integer)9);
		assertEquals(stack.pop(), (Integer)9);
		assertEquals(stack.size(),9);
	}

	@Test
	public void testPushPopSizePeek() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		for (int i = 0; i < 20; i++) {
			stack.push(i);
		}
		assertEquals(stack.size(), 20);
		for (int i = 0; i < 10; i++) {
			stack.pop();
		}
		assertEquals(stack.size(),10);
		assertEquals(stack.pop(), (Integer)9);
		assertEquals(stack.size(),9);
		assertEquals(stack.peek(),(Integer)8);
	}

	@Test
	public void testPushPopSizeEmpty() {
		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();
		for (int i = 0; i < 20; i++) {
			stack.push(i);
		}
		assertEquals(stack.size(), 20);
		for (int i = 0; i < 20; i++) {
			stack.pop();
		}
		assertEquals(stack.size(),0);
	}

}
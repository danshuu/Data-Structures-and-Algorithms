/**
* JUnit tests for BadStack
*
* @author Daniel Shu
* @version Lab3 cpe103
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class BadStackTests {

	@Test(expected = NoSuchElementException.class)
	public void testEmptyPeek() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.peek();
	}

	@Test(expected = NoSuchElementException.class)
	public void testEmptyPop() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.pop();
	}

	@Test(expected = NoSuchElementException.class)
	public void testPushPopEmptyPop() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.pop();
		stack.pop();
	}

	@Test(expected = NoSuchElementException.class)
	public void testPushPopEmptyPeek() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.pop();
		stack.peek();
	}

	@Test
	public void testPushPeek() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		assertEquals(stack.peek(), (Integer)10);
	}

	@Test
	public void testPushPop() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		assertEquals(stack.pop(), (Integer)100);
	}

	@Test
	public void testPushSize0() {
		BadStack<Integer> stack = new BadStack<Integer>();
		assertEquals(stack.size(), 0);
	}

	@Test
	public void testPushSize1() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		assertEquals(stack.size(), 1);
	}

	@Test
	public void testPushSize2() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.pop();
		assertEquals(stack.size(), 3);
	}

	@Test
	public void testPushSize3() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		assertEquals(stack.size(), 12);
	}

	@Test
	public void testPushPopSize0() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(stack.size(), 0);
	}

	@Test
	public void testPushPeek2() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		assertEquals(stack.peek(), (Integer)1000);
	}

	@Test
	public void testPushPop2() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		assertEquals(stack.pop(), (Integer)1000);
		assertEquals(stack.peek(),(Integer)100);
		assertEquals(stack.size(),11);
	}

	@Test
	public void testArrayLength() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		assertEquals(stack.capacity(), 10);
	}

	@Test
	public void testDoubleArrayLength() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(2); //11 integers
		assertEquals(stack.capacity(), 20);
	}

	@Test
	public void testDoubleArrayLengthAgain() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(2); //21 integers
		assertEquals(stack.capacity(), 40);
	}

	@Test
	public void testDoubleArrayLengthThenPeek() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(2); //11 integers
		assertEquals(stack.peek(), (Integer)2);
	}

	@Test
	public void testDoubleArrayLengthThenPop() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(2); //11 integers
		assertEquals(stack.pop(), (Integer)2);
	}

	@Test
	public void testDoubleArrayPushPopAlot() {
		BadStack<Integer> stack = new BadStack<Integer>();
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(2);
		stack.push(10);
		stack.push(2); //11 integers
		stack.pop();
		stack.pop();
		stack.pop();
		stack.push(2);
		stack.push(50);
		stack.push(100);
		assertEquals(stack.peek(), (Integer)100);
		assertEquals(stack.size(), 11);
		assertEquals(stack.pop(),(Integer)100);
		assertEquals(stack.size(),10);
		assertEquals(stack.capacity(),20);
	}

}
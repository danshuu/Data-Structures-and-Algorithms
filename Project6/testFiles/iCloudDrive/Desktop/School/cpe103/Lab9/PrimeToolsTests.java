/**
* J unit tests for PrimeTools
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class PrimeToolsTests {

	@Test
	public void isPrimeTest() {
		PrimeTools pt = new PrimeTools();
		assertTrue(pt.isPrime(2));
		assertTrue(pt.isPrime(3));
		assertFalse(pt.isPrime(0));
		assertTrue(pt.isPrime(5));
		assertFalse(pt.isPrime(1));
		assertFalse(pt.isPrime(-1));
		assertFalse(pt.isPrime(-101));
		assertFalse(pt.isPrime(100));
		assertFalse(pt.isPrime(5000000));
		assertTrue(pt.isPrime(11));
		assertTrue(pt.isPrime(59));
		assertTrue(pt.isPrime(857));
		assertTrue(pt.isPrime(997));
		assertTrue(pt.isPrime(131));
		assertTrue(pt.isPrime(641));
	}

	@Test
	public void nextPrimeTest() {
		PrimeTools pt = new PrimeTools();
		assertEquals(pt.nextPrime(0),2);
		assertEquals(pt.nextPrime(1),2);
		assertEquals(pt.nextPrime(2),2);
		assertEquals(pt.nextPrime(3),3);
		assertEquals(pt.nextPrime(4),5);
		assertEquals(pt.nextPrime(5),5);
		assertEquals(pt.nextPrime(7),7);
		assertEquals(pt.nextPrime(8),11);
		assertEquals(pt.nextPrime(9),11);
		assertEquals(pt.nextPrime(10),11);
		assertEquals(pt.nextPrime(81),83);
		assertEquals(pt.nextPrime(15),17);
		assertEquals(pt.nextPrime(912),919);
		assertEquals(pt.nextPrime(100),101);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nextPrimeExceptionTest() {
		PrimeTools pt = new PrimeTools();
		pt.nextPrime(-1);

	}

	@Test(expected = IllegalArgumentException.class)
	public void nextPrimeExceptionTest2() {
		PrimeTools pt = new PrimeTools();
		pt.nextPrime(-10000);

	}

	// @Test(expected = NoSuchElementException.class)
	// public void nextPrimeExceptionTest3() {
	// 	PrimeTools pt = new PrimeTools();
	// 	pt.nextPrime(2147483647);

	// }


}
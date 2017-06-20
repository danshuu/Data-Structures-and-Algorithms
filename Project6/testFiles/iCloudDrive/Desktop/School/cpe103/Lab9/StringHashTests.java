/**
* j unit tests for StringHash
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

import org.junit.*;

import static org.junit.Assert.*;
// import java.util.NoSuchElementException;

public class StringHashTests {

	@Test
	public void hashTesta() {
		StringHash sh = new StringHash();
		assertEquals(sh.hash("a"), 97);
	}

	@Test
	public void hashTestb() {
		StringHash sh = new StringHash();
		assertEquals(sh.hash("b"), 98);
	}

	@Test
	public void hashTesthi() {
		StringHash sh = new StringHash();
		assertEquals(sh.hash("hi"), 3329);
	}

	@Test
	public void hashTestDANIEL() {
		StringHash sh = new StringHash();
		assertEquals(sh.hash("DANIEL"), 2009207199);
	}
}
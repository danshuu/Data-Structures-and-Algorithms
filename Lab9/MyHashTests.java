/**
* j unit tests for MyHash
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

import org.junit.*;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class MyHashTests {

	@Test
	public void hashTesta() {
		MyHash mh = new MyHash();
		assertEquals(mh.hash("a"), 97);
	}

	@Test
	public void hashTestb() {
		MyHash mh = new MyHash();
		assertEquals(mh.hash("z"), 122);
	}

	@Test
	public void hashTesthi() {
		MyHash mh = new MyHash();
		assertEquals(mh.hash("hi"), 65625);
	}
	
	@Test
	public void hashTestDANIEL() {
		MyHash mh = new MyHash();
		assertEquals(mh.hash("DANIEL"), -1597845660);
	}
}
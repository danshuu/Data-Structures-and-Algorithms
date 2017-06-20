/**
* j unit tests for BetterHash
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

import org.junit.*;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class BetterHashTests {

	@Test
	public void hashTesta() {
		BetterHash bh = new BetterHash();
		assertEquals(bh.hash("a"), 97);
	}

	@Test
	public void hashTestb() {
		BetterHash bh = new BetterHash();
		assertEquals(bh.hash("b"), 98);
	}

	@Test
	public void hashTesthi() {
		BetterHash bh = new BetterHash();
		assertEquals(bh.hash("hi"), 10193);
	}

	@Test
	public void hashTestDANIEL() {
		BetterHash bh = new BetterHash();
		assertEquals(bh.hash("DANIEL"), 1354903309);
	}
}
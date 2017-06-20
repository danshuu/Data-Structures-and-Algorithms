/**
* Driver for Lab9
*
* @author Daniel Shu
* @version Lab9 CPE103
*/
import java.util.*;
import java.io.*;

public class Lab9Driver {
	public static void main(String[] args) throws FileNotFoundException {
		// PrimeTools trying = new PrimeTools();
		// System.out.println(trying.nextPrime(10000));

		// StringHash sh = new StringHash();
		// System.out.println(sh.hash("This")%5);
		// System.out.println(sh.hash("is")%5);
		// System.out.println(sh.hash("a")%5);
		// System.out.println(sh.hash("small")%5);
		// System.out.println(sh.hash("Sample")%5);
		// System.out.println(sh.hash("test")%5);
		// System.out.println(sh.hash("file")%5);
		// System.out.println(sh.hash("for")%5);
		// System.out.println(sh.hash("Lab9")%5);

		// BetterHash bh = new BetterHash();
		// System.out.println(bh.hash("daniel"));

		// MyHash mh = new MyHash();
		// System.out.println(mh.hash("daniel"));
		// ArrayList<String> al = new ArrayList<String>();
		// al.add("daniel");
		// al.add("shu");
		// al.add("hi");
		// HashTools ht = new HashTools();
		// System.out.println();

		Scanner s = new Scanner(new File("dictionary.txt"));
		ArrayList<String> ls = new ArrayList<String>();
		while(s.hasNext()){
		 ls.add(s.next());
		}

		StringHash hashSH = new StringHash();
		BetterHash hashBH = new BetterHash();
		MyHash hashMH = new MyHash();
		int tableSize = 25;

		System.out.println(HashTools.collisions(ls, tableSize, hashSH));
		System.out.println(HashTools.collisions(ls, tableSize, hashBH));
		System.out.println(HashTools.collisions(ls, tableSize, hashMH));

		System.out.println(HashTools.maxCollisions(ls, tableSize, hashSH));
		System.out.println(HashTools.maxCollisions(ls, tableSize, hashBH));
		System.out.println(HashTools.maxCollisions(ls, tableSize, hashMH));

		System.out.println(HashTools.avgChainLength(ls, tableSize, hashSH));
		System.out.println(HashTools.avgChainLength(ls, tableSize, hashBH));
		System.out.println(HashTools.avgChainLength(ls, tableSize, hashMH));

		System.out.println(HashTools.unused(ls, tableSize, hashSH));
		System.out.println(HashTools.unused(ls, tableSize, hashBH));
		System.out.println(HashTools.unused(ls, tableSize, hashMH));

		System.out.println(HashTools.unused(ls, 16, hashSH));
		System.out.println(HashTools.unused(ls, 16, hashBH));
		System.out.println(HashTools.unused(ls, 16, hashMH));

		// System.out.println(HashTools.collisions(ls, 200000, hashSH));
		// System.out.println(HashTools.collisions(ls, 200000, hashBH));
		// System.out.println(HashTools.collisions(ls, 200000, hashMH));

		// System.out.println(HashTools.maxCollisions(ls, 200000, hashSH));
		// System.out.println(HashTools.maxCollisions(ls, 200000, hashBH));
		// System.out.println(HashTools.maxCollisions(ls, 200000, hashMH));

		// System.out.println(HashTools.avgChainLength(ls, 200000, hashSH));
		// System.out.println(HashTools.avgChainLength(ls, 200000, hashBH));
		// System.out.println(HashTools.avgChainLength(ls, 200000, hashMH));

		// System.out.println(HashTools.unused(ls, 200000, hashSH));
		// System.out.println(HashTools.unused(ls, 200000, hashBH));
		// System.out.println(HashTools.unused(ls, 200000, hashMH));
	}
}
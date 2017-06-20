/**
* A driver for HashTableQuadratic
* 
* @author Daniel Shu
* @version Project 5 CPE103
*/

public class HashTableQuadraticDriver {
	public static void main(String[] args) {
		HashTableQuadratic<String> table = new HashTableQuadratic<String>(50, .75);
		String[] strings = new String[] {"Hello", "these", "are", "some", "random", "strings.", "If", "this", 
		                               "test", "fails", "it's", "likely", "because", "well", "I", "don't", "really", "know",
		                               "why", "this", "test", "would", "fail", "if", "all", "other", "tests", "are", "passing.",
		                               "Good", "Luck!"};

		for (int i = 0; i < strings.length; i++) {
			table.add(strings[i]);
		}
		// for (int i = 0; i < table.tableSize(); i++) {
		// 	System.out.println(table.get(i));
		// }
		System.out.println(table.size());
		System.out.println(table.tableSize());
		System.out.println(table.loadFactor());
		System.out.println(table.collisions());
		// assertEquals(28.0/53, table.loadFactor(), .000001);
		// assertEquals(9, table.collisions());
		// assertEquals(2, table.maxCollisions());
		// assertTrue(table.contains("this"));
		// assertTrue(table.remove("this"));
		// assertEquals(27.0/53, table.loadFactor(), .000001);
		// assertFalse(table.remove("this"));
		// assertFalse(table.contains("this"));
		// table.add("this");
		// assertEquals(28.0/53, table.loadFactor(), .000001);
		// assertTrue(table.contains("this"));
		// HashTableQuadratic<Integer> ht = new HashTableQuadratic<Integer>(10);
		// System.out.println("The table size is " + ht.tableSize());
		// ht.add(68);
		// ht.add(73);
		// ht.add(7);
		// ht.add(84);
		// ht.add(119);
		// ht.add(195);
		// ht.add(172);
		// System.out.println(ht.remove(68));
		// // System.out.println("The size of the hash table is " + ht.size());
		// // System.out.println("The 10th element is " + ht.get(9));
		// // System.out.println("The 11th element is " + ht.get(10));
		// for (int i = 0; i < ht.tableSize(); i++) {
		// 	System.out.println(ht.get(i));

		// 	// System.out.println(ht.contains(i));
		// }

		// for (int i = 11; i < 101; i++) {
  //       	System.out.println(ht.add(i)); //should all be null
		// }   

		// for (int i = 0; i < ht.tableSize(); i++) {
		// 	System.out.println(ht.get(i));

		// 	// System.out.println(ht.contains(i));
		// }
		// System.out.println("The table size is " + ht.tableSize());
		// System.out.println("The number of collisions is " + ht.collisions());
		// System.out.println("The maximum number of collisions is " + ht.maxCollisions());
		// System.out.println(ht.contains(5));
		// System.out.println(ht.contains(17));
		// System.out.println(ht.contains(16));
		
		// System.out.println(ht.contains(6));
		// System.out.println(ht.contains(0));
		// System.out.println(ht.contains(11));
		// System.out.println(ht.contains(-1));
	}

}
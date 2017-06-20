/**
* Driver for SpellChecker Class
* 
* @author Daniel Shu
* @version Project 5 CPE103
*/
import java.util.*;

public class SpellCheckerDriver {

	private static SpellChecker dict;
	public static void main(String[] args) throws java.io.FileNotFoundException{
		// SpellChecker checker = new SpellChecker();
		// boolean b1 = checker.isWord("hello");
		// // System.out.println(b1);
		// HashTableQuadratic<String> table = checker.getDictionary();
		// HashMap<String, SpellChecker.MyStats> map = checker.indexFile("dictionary.txt");
		// // System.out.println(map.get("Hello"));
		// SpellChecker.MyStats stats = map.get("hello");
		// List<Integer> l = stats.getLineNumbers();
		// int i = stats.getOccurrences();
		// boolean b2 = stats.isWord();
		dict = new SpellChecker();
	// 	HashMap<String, SpellChecker.MyStats> map =
 //         dict.indexFile("processFileTest1.txt");
	// }
		HashMap<String, SpellChecker.MyStats> map = dict.indexFile("processFileTest2.txt");
		System.out.println(map.size());
	}
}
/**
* BetterHash class
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

public class BetterHash implements Hashable<String> {

	//default constructor

	public int hash(String s) {

		int hash = 0;
		int len = s.length();

		for (int i = 0; i < len; i++) {
			// There are 95 displayable ASCII characters, 97 is the next prime
			hash = hash * 97 + s.charAt(i);
		}

		return hash;

	} //returns a hash code for the specified string
	//must calculate the hash code for the specified string with this algorithm
}
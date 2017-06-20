/**
* MyHash class
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

public class MyHash implements Hashable<String> {

	//default constructor
	
	public int hash(String s) {

		int myHash = 0;
		int len = s.length();

		for (int i = 0; i < len; i++) {
			// There are 95 displayable ASCII characters, 97 is the next prime
			myHash = (myHash * 6) * (s.charAt(i)) + s.charAt(i);
		}

		return myHash;

	} //returns a hash code for the specified string
	//must develop own unique algorithm for this hash method
	//must not be the same as StringHash or BetterHash
}
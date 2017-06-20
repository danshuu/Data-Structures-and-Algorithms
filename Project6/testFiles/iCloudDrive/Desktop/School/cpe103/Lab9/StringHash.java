/**
* Hashable is an interface; do it before StringHash, BetterHash, and MyHash
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

public class StringHash implements Hashable<String> {

	//default constructor

	//method
	public int hash(String s) {

		return s.hashCode(); //s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]

	} //returns a hash code for the specified string. 
	//Must return the hash code that the String class produces

}
/**
* Hashable is an interface; do it before StringHash, BetterHash, and MyHash
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

public interface Hashable<T> {

	int hash(T input); //returns a hash code value for the specified object
	//input is the object for which you will calculate a hash code

}

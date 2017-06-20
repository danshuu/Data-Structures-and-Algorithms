/**
 * A subclass of MorseCode whose natural ordering will be based on the Morse Code Strings.
 * MorseOrder has no fields of its own.
 * MorseOrder may have as many constructors as you wish
 * MorseOrder does not have any non-private methods other than those specified
 * 
 * @author Daniel Shu
 * @version Project 4 CPE103
 */

public class MorseOrder extends MorseCode implements Comparable<MorseOrder> {

	//constructor(s)
	public MorseOrder(MorseCode other) {
		super(other);
	}

	public MorseOrder(Character character, String code) {
		super(character, code);
	}
	
	public int compareTo(MorseOrder other) {

		return this.getCode().compareTo(other.getCode());

	} //returns the result of comparing the MorseCode strings of the context object and the explicit parameter
	//You can get Morse Code strings from the parent class
	//returns a value 0 if the Morse Code string of this MorseOrder is equal to the MorseCode string of the argument MorseOrder
	//returns a value less than 0 if the Morse Code string of this MorseOrder is less than the MorseCode string of the argument MorseOrder
	//returns a value greater than 0 if the Morse Code string of this MorseOrder is less than the MorseCode string of the argument MorseOrder


}
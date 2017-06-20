/**
 * A subclass of MorseCode whose natural ordering will be based on the Character values.
 * CharacterOrder has no fields of its own.
 * CharacterOrder may have as many constructors as you wish
 * CharacterOrder does not have any non-private methods other than those specified
 *
 * @author Daniel Shu
 * @version Project 4 CPE103
 */

public class CharacterOrder extends MorseCode implements Comparable<CharacterOrder> {

	//constructor(s)
	public CharacterOrder(MorseCode other) {
		super(other);
	}

	public CharacterOrder(Character character, String code) {
		super(character, code);
	}
	
	public int compareTo(CharacterOrder other) {

		return this.getCharacter().compareTo(other.getCharacter());

	}

}
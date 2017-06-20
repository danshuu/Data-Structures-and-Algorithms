/**
 * A class for converting text into Morse Code
 * 
 * @author Daniel Shu
 * @version Project 4 CPE103
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class TextToMorse implements BSTTranslator<CharacterOrder> {

	private BST<CharacterOrder> characterBST; 

	//Constructor
	public TextToMorse() {
		characterBST = new BST<CharacterOrder>();
		CharacterOrder[] characterArr = new CharacterOrder[MorseCode.size()]; //constructs an morse Array of given size
		for (int i = 0; i < MorseCode.size(); i++) {
			characterArr[i] = new CharacterOrder(MorseCode.get(i)); //transfers everything from morseCode into characterArr.
		}
		Arrays.sort(characterArr); //array is now sorted with CharacterOrder objects
		buildTree(characterArr, 0, characterArr.length);
	} //constructs a TextToMorse object

	//methods
	public BST<CharacterOrder> getBST() {
		return characterBST;
	} //returns a complete binary tree of CharacterOrder Objects
	//COMPLETE meaning that all rows will be filled with the possible exception of the last row
	//but last row does not have to be filled in from left-to-right
	//this is the tree you should be using to efficiently translate Morse Code to text
	//build this tree from the codes you found in the provided MorseCode class

	public String translate(String s) {
		StringBuilder newString = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			try {
				//when you create a characterorder object and compare it to another characterorder object, you are only comparing the codes of each object
				//therefore, it would make sense to use the get() method to "traverse" through the list in O(logn) time 

				CharacterOrder charObj = new CharacterOrder(s.charAt(i), null);
				String associatedCode = characterBST.get(charObj).getCode();
				newString.append(associatedCode);
				newString.append(" ");
			} catch (NoSuchElementException e) {
				newString.append("");
			}
		}

		return newString.toString().trim();
	} //translates a string containing Morse Code to its equivalent text string in O(Nlog n) time where 
	//N is the number of codes in the string to translate and n is the number of possible codes. 
	//In order to get the desired efficiency, you must have the required tree structure talked about in getBST 
	//	-unsupported codes are skipped with nothing output to the text string in their place
	//	-all Morse Codes will be separated by one or more spaces
	//	-leading and trailing spaces in the output string are to be removed
	//	-this method MUST use a StringBuilder object to construct the string of characters that will be returned
	//	 This is much, much more efficient than using a String because String objects are immutable
	//	 Each time a String is modified, an entirely new String object is created, and all characters are copied into the new String
	//	 StringBuilder Objects are mutable.

	private void buildTree(CharacterOrder[] arr, int startIndex, int endIndex) {	
		if (startIndex < endIndex) {
			characterBST.insert(arr[(startIndex + endIndex)/2]); //inserts middle element (take the floor)
			buildTree(arr, startIndex, (startIndex+endIndex)/2); //inserts all elements of the left side
			buildTree(arr, ((startIndex + endIndex)/2) + 1, endIndex);
		}

	}
}
/**
 * A class for converting Morse Code into test
 * 
 * @author Daniel Shu
 * @version Project 4 CPE103
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class MorseToText implements BSTTranslator<MorseOrder> {

	private BST<MorseOrder> morseBST; 

	//Constructor
	public MorseToText() {
		morseBST = new BST<MorseOrder>();
		MorseOrder[] morseArr = new MorseOrder[MorseCode.size()]; //constructs an morse Array of given size
		for (int i = 0; i < MorseCode.size(); i++) {
			morseArr[i] = new MorseOrder(MorseCode.get(i)); //transfers everything from morseCode into morseArr.
		}
		Arrays.sort(morseArr); //array is now sorted with morseOrder objects
		buildTree(morseArr, 0, morseArr.length);
	} //constructs a MorseToText object

	//methods
	public BST<MorseOrder> getBST() {
		return morseBST;
	} //returns a complete binary tree of MorseOrder Objects
	//COMPLETE meaning that all rows will be filled with the possible exception of the last row
	//but last row does not have to be filled in from left-to-right
	//this is the tree you should be using to efficiently translate Morse Code to text
	//build this tree from the codes you found in the provided MorseCode class

	public String translate(String s) {
		// if (s.equals(".........")) {
		// 	return "5";
		// }
		//FIXED because of morse.arr.length-1 -> needed to be changed to length
		StringBuilder newString = new StringBuilder();
		Scanner sc = new Scanner(s); //scans the string argument
		//all codes are separated by a space
		while(sc.hasNext()) {
			try {
				//when you create a morse order object and compare it to another morse order object, you are only comparing the codes of each object
				//therefore, it would make sense to use the get() method to "traverse" through the list in O(logn) time 
				//more importantly, the morseorder's character is irrelevant at this point because the compare only considers the codes at hand
				MorseOrder morseObj = new MorseOrder(null, sc.next()); //turn the morse code string into a MorseOrder object
	            char associatedChar = morseBST.get(morseObj).getCharacter(); //get will automatically compare each node's characters
	            // System.out.println(associatedChar);
	            newString.append(associatedChar);
			} catch (NoSuchElementException e) {
				newString.append("");
			}
		} //end of while

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

	private void buildTree(MorseOrder[] arr, int startIndex, int endIndex) {	
		if (startIndex < endIndex) {
			morseBST.insert(arr[(startIndex + endIndex)/2]); //inserts middle element (take the floor)
			buildTree(arr, startIndex, (startIndex+endIndex)/2); //inserts all elements of the left side
			buildTree(arr, ((startIndex + endIndex)/2) + 1, endIndex);
		}

	}
}
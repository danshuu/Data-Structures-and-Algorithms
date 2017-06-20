/**
* SpellChecker Class
* 
* @author Daniel Shu
* @version Project 5 CPE103
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class SpellChecker {

	private HashTableQuadratic<String> dictionary; //declares a HTQ

	//Constructors
	public SpellChecker() throws FileNotFoundException {
		Scanner scDict = new Scanner(new File("dictionary.txt"));
		dictionary = new HashTableQuadratic<String>(267119); //The size of your hash table should be appropriate based on the size of the dictionary.
		while (scDict.hasNext()) {
			dictionary.add(scDict.next()); //add all words to the hash table
		}
	} //creates and initialises a HashTableQuadratic to contain all words from the provided dictionary

	public SpellChecker(String fileName) throws FileNotFoundException {
		Scanner scDict = new Scanner(new File(fileName));
		dictionary = new HashTableQuadratic<String>(267119); //The size of your hash table should be appropriate based on the size of the dictionary that you have access to.
		while (scDict.hasNext()) {
			dictionary.add(scDict.next()); //add all words to the hash table
		}
	} //creates and initialises a HashTableQuadratic to contain all words from the specified file

	//Methods
	public HashTableQuadratic<String> getDictionary() {
		return dictionary;
	} //returns the hash table of words begin used as a dictionary

	@SuppressWarnings("unchecked")
	public HashMap<String,SpellChecker.MyStats>	indexFile(String fileName) throws FileNotFoundException {
		HashMap<String,SpellChecker.MyStats> wordStats = new HashMap<String,SpellChecker.MyStats>();
		Scanner sc = new Scanner(new File(fileName)); //\\w meaning what?
		int lineNumber = 0;
		while (sc.hasNextLine()) { //scan through every line
			String thisLine = sc.nextLine();
			Scanner sc2 = new Scanner(thisLine).useDelimiter("[^\\w-']+");
			lineNumber++;
			while (sc2.hasNext()) { //scan through every word on the line
				String thisWord = sc2.next();
				if (wordStats.get(thisWord) != null) { //if this word has already occurred
					((MyStats)wordStats.get(thisWord)).occurrences++;
					((MyStats)wordStats.get(thisWord)).lineArr.add(lineNumber);
				} else {
					wordStats.put(thisWord, new MyStats(thisWord, isWord(thisWord), lineNumber));
				}

			}

		}

		return wordStats;

	} //Reads through the specified file and returns a HashMap mapping each string in the file to an instance of MyStats

	public boolean isWord(String s) {
		if (dictionary.contains(s.toLowerCase())) {
			return true;
		}
		return dictionary.contains(s);
	} //Determines if the specified string is a word based on the current dictionary. 
	//To be a word, either the input string must appear in the dictionary verbatim, or a lowercase version of the string must appear in the dictionary. This should take O(1) time on average

	public class MyStats {

		//Fields 
		private String word; //word that will be checked
		private int occurrences;
		private boolean isWord;
		private ArrayList<Integer> lineArr = new ArrayList<Integer>();

		//constructors
		public MyStats(String word, boolean isWord, int lineItOccurs) {
			this.occurrences = 1;
			this.isWord = isWord;
			lineArr.add(lineItOccurs); //add line number that contains the word into the list

		}

		public List<Integer> getLineNumbers() {
			return lineArr;
		} //returns a list containing all line numbers the string was on

		public int getOccurrences() {
			return occurrences;
		} //returns the number of times the string has been seen

		public boolean isWord() {
			return isWord;
		} //returns true if the string is a word; false otherwise

	} //maintains information pertaining to Strings read in from a file. For use in indexFile. 
	//These statistics include the number of occurrences of a string, the line numbers on which the string occurs, and whether or not the string is a word
}
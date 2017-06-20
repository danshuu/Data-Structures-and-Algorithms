/**
* Driver for Huffman class
* 
* @author Daniel Shu
* @version Project 6 CPE 103
* 
*/

import java.util.*;
import java.io.*; 

public class HuffmanDriver {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// OutputStream randomFile = new FileOutputStream(new File("randomFile.txt"));
		// BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(new File("testFiles/file_one_character.txt")));

		// String output = Huffman.compress("testFiles/file_one_character.txt", "output.txt");
		// String output = Huffman.compress("testFiles/file1.txt", "output.txt");

		Huffman.decompress("output.txt", "output2.txt");
		// System.out.println(output);
	}
}
/**
* This class compresses and decompresses text using Huffman encoding
* 
* @author Daniel Shu
* @version Project 6 CPE 103
* 
*/

import java.util.*;
import java.io.*;

public class Huffman {

	private static class Node implements Comparable<Node> {
		private boolean isLeaf;
		private Node left;
		private Node right;
		private Character symbol;
		private Integer frequency; //to be compared
		private Integer minASCII;

		//if node is just a node
		public Node(Node left, Node right) {
			this.isLeaf = false;
			this.left = left;
			this.right = right;
			this.symbol = null;
			this.frequency = left.frequency + right.frequency;
			this.minASCII = Math.min(left.minASCII, right.minASCII);
		} //if node is not a leaf 

		//if node is a leaf
		public Node(char symbol) {
			this.isLeaf = true;
			this.left = null;
			this.right = null;
			this.symbol = symbol;
			this.frequency = 1; //first time occurring will incur a frequency of 1.
			this.minASCII = symbol + 0;
		} 
		
		public int compareTo(Node other) {
			int comparison = (this.frequency).compareTo(other.frequency); 
			if (comparison == 0) {
				return this.minASCII.compareTo(other.minASCII);
			} else { //frequencies aren't the same
				return comparison; //if the frequencies were not the same
			}
		} //end of compareTo
	} //end of Node class
	
	private static void buildCodesMap(HashMap<Character, String> map, Node root, String code) {
		if (!(root.isLeaf)) {
			buildCodesMap(map, root.left, code + "0");
			buildCodesMap(map, root.right, code + "1");
		} else {
			map.put(root.symbol, code); //once it gets to the leaf, it'll start putting the associated codes for each symbol
		}
	}

	private static void buildString(Node root, StringBuilder sb) {
		if (!root.isLeaf) {
			buildString(root.left, sb);
			buildString(root.right, sb);
		} else {
			sb.append(root.symbol);
		}
	} //builds the string in order

	public Huffman() {
		
	} //empty constructor

	//infileName is the name of file to compress
	//outfileName is the name of the file to contain the compressed text
	public static String compress(String infileName, String outFileName) throws FileNotFoundException, IOException {
		BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(new File(infileName)));
		DataInputStream in = new DataInputStream(buffIn);

		//check if any contents in inFile
		int checkByte = in.read();
		if (checkByte == -1) {
			BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(new File(outFileName)));
			DataOutputStream out = new DataOutputStream(buffer);
			out.write(0);
			in.close();
			out.close();
			return "||";
		}
		//make frequency table using (HashMap)
		HashMap<Character, Node> frequencyTable = new HashMap<Character, Node>(); // All nodes in this hashmap are leaves
		Character currentSymbol;
		StringBuilder fileContents = new StringBuilder();
		while (checkByte != -1) {
			currentSymbol = (char)checkByte;
			fileContents.append(currentSymbol);
			if (!(frequencyTable.containsKey(currentSymbol))) {
				frequencyTable.put(currentSymbol, new Node(currentSymbol));
			} else {
				(frequencyTable.get(currentSymbol).frequency)++;
			}
			checkByte = in.read();
		}

		in.close();

		//make priority queue
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for (Node node : frequencyTable.values()) {
			pq.add(node);
		}
		
		Node leftChild, rightChild, root = null; //declare root and its children
		//pq currently contains all leafs
		//complete tree	
		while (pq.size() > 1) {
			leftChild = pq.poll();
			rightChild = pq.poll();
			root = new Node(leftChild, rightChild); //root will always be a node that's not a leaf
			pq.add(root); //adds new internal node with these 2 nodes as children back into pq
		} //until pq holds 1 node with 2 lines of children
		
		root = pq.poll();
		
		HashMap<Character, String> codes = new HashMap<Character, String>();
		buildCodesMap(codes, root, ""); //puts all leaves' chars into the map with its associated code

		ArrayList<Character> sortedChars = new ArrayList<Character>();
		for (Character ch : codes.keySet()) {
			sortedChars.add(ch);
		}
		
		//sort array list by ASCII char to write them in order.
		Collections.sort(sortedChars);
		//create bufferedoutputstream and dataoutputstream to write 
		BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(new File(outFileName)));
		DataOutputStream out = new DataOutputStream(buffer);
		//writing header
		out.write(sortedChars.size());
		
		for (int i = 0; i < sortedChars.size(); i++) {
			out.write(sortedChars.get(i)); //character
			out.writeInt(frequencyTable.get(sortedChars.get(i)).frequency); //frequency
		}

		//done writing header
		HuffmanBitStream huff = new HuffmanBitStream(buffer);
		String str = fileContents.toString(); //the input file contents in a string
		for (int i = 0; i < str.length(); i++) { //go through each char given
			String binaryCode = codes.get(str.charAt(i));
			for (int j = 0; j < binaryCode.length(); j++) { //go through each char of the binary code of the char
				huff.write(binaryCode.charAt(j));	
			}
		}

		huff.close();
		out.close();
		
		//build the string to return
		StringBuilder sbTemp = new StringBuilder("|");
		buildString(root, sbTemp);
		sbTemp.append("|");
		return sbTemp.toString();
	} //compresses the text in specified input file using Huffman encoding.




	public static void decompress(String infileName, String outFileName) throws FileNotFoundException, IOException {
		BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(new File(infileName)));
		DataInputStream in = new DataInputStream(buffIn);

		BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(new File(outFileName)));
		DataOutputStream out = new DataOutputStream(buffOut);

		HashMap<Character, Node> frequencyTable = new HashMap<Character, Node>(); // All nodes in this hashmap are leaves
		int size = in.read(); //how many character-value pairs there are.
		if (size == 0) {
			//empty file is already created
			in.close();
			out.close();
			return;
		} else if (size == 1) {
			Character ch = (char)(in.read()); //reads the character
			int value = in.readInt(); //reads the value
			for (int i = 0; i < value; i++) {
				out.writeByte(ch);
			}
			
			in.close();
			out.close();
			return;
		}

		//rebuild the tree (read the header)
		for (int i = 0; i < size; i++) {
			Character ch = (char)(in.read()); //reads the character
			int value = in.readInt(); //reads the value

			Node newNode = new Node(ch); //creates node with value
			// newNode.frequency = value; //changes values frequencies (this didn't work because it wasn't a direct reference to the node)
			frequencyTable.put(ch, new Node(ch));
			(frequencyTable.get(ch)).frequency = value; //changes values frequencies
			
		}

		//make priority queue
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for (Node node: frequencyTable.values()) {
			pq.add(node);
		}

		Node leftChild, rightChild, root = null; //declare root and its children
		//pq currently contains all leafs
		//complete tree	
		while (pq.size() > 1) {
			leftChild = pq.poll();
			rightChild = pq.poll();
			root = new Node(leftChild, rightChild); //root will always be a node that's not a leaf
			pq.add(root); //adds new internal node with these 2 nodes as children back into pq
		} //until pq holds 1 node with 2 lines of children
		
		root = pq.poll();
		
		HashMap<Character, String> codes = new HashMap<Character, String>();
		buildCodesMap(codes, root, ""); //puts all leaves' chars into the map with its associated code

		int numBitsToRead = 0;
		for (Node node : frequencyTable.values()) {
			numBitsToRead += (node.frequency * (codes.get(node.symbol)).length());
		}
		
		HuffmanBitStream huff = new HuffmanBitStream(buffIn); //create the huffman stream that wraps the same buffer file as the datainputstream
		StringBuilder binaries = new StringBuilder();
		int countBits = 1;
		int x = huff.read();

		while (x == 0 || x == 1) {
			binaries.append(x);
			countBits++;
			if (countBits > numBitsToRead) {
				break;
			}
			x = huff.read();
		}

		StringBuilder buildDecompressed = new StringBuilder();
		boolean keepTraversing = true;
		int pos = 0;
		String compressedString = binaries.toString();
		while (keepTraversing) {
			Node temp = root; //copy of root
			while (!temp.isLeaf) { //traverse till leaf is found
				if (compressedString.charAt(pos) == '0') { //'0', go left
					temp = temp.left;
					pos++;
					if (pos > numBitsToRead-1) {
						keepTraversing = false;
					}
				} else { // '1', go right
					temp = temp.right;
					pos++;
					if (pos > numBitsToRead-1) {
						keepTraversing = false;
					}
				}
			}
			buildDecompressed.append(temp.symbol);
		}
		
		String decompressedString = buildDecompressed.toString();
		for (int i = 0; i < decompressedString.length(); i++) {
			out.writeByte(decompressedString.charAt(i));
		}
		in.close(); //close input streams
		out.close(); //close the output stream
	} 
} // end of Huffman

//Method Descriptions
//Compression: 
//The compressed text will be written to the specified output file. 
	//if the specified output file already exists, its old contents will be erased
	//this method should be O(N) where (N) is the size of the input file in bytes
	//This method should:
		//Process the input file, counting the number of occurrences of each ASCII character
		//Create a Huffman Tree using the counts and the algorithm specified in the assignment
			//When joining 2 trees, the lesser of the trees must go on the left ('0' side)
			//When comparing Huffman trees, break any ties in weight by comparing in each tree. 
			//The tree containing the smallest character (determined by ASCII characters) is considered the lesser of the 2
		//Use the tree to generate codes for each ASCII character that occurred in the file
		//Write header information into the specified output file that will allow recreation of the Huffman tree when decompressing the file.
		//Use a DataOutputStream to write the header information to the file. Header has the following format:
			//number of codes that were generated. (#0-255) write a single byte to the file
			//Character-value pairs for each ASCII value that appeared in the file. Use a single byte for the ASCII character
			//and a 4-byte integer (use writeInt method) for number of occurrences in the file.
			//Write the character-value pairs out in ascending ASCII order. ***
		//Write bits to the output file corresponding to the encoding of each character in the input file. 
		//Use the HuffmanBitStream class provided to you.
		//Return a string representation of the Huffman tree. The string consists of all the leaves of the tree
		//in the order they are visited by a pre-order traversal enclosed in pipe characters ("||").
		//There are no delimiters between adjacent characters. For example, in the same file you are given

//Decompression
//decompresses the specified input file. The decompressed text will be written to the specified output file
	//if the specified output file already exists, its old contents will be erased.
	//this method should be O(N) where (N) is the size of the input file(the file to be decompressed) in bytes
	//This method should:
	//read the header information from the compressed input file. Use a DataInputStream
	//Build a Huffman tree from the header information
	//Use the Huffman tree to decode the compressed input file, writing to the output file. Use HuffmanBitStream to read bits from input file


//originally used for compareTo
				// if (this.isLeaf && other.isLeaf) { //both are leaves
				// 	return (this.symbol).compareTo(other.symbol);
				// } else if (!(this.isLeaf) && !(other.isLeaf)) { //both arent leaves
					
				// 	Node minThis = this.left;
				// 	while (!minThis.isLeaf) {
				// 		minThis = minThis.left;
				// 	} //until its the smallest element in the list

				// 	Node minOther = other.left;
				// 	while (!minOther.isLeaf) {
				// 		minOther = minOther.left;
				// 	} //until its the smallest element in the list
				// 	return (minThis.symbol).compareTo(minOther.symbol);
					
				// } else { //if one is a leaf and the other isnt
				// 	if (this.isLeaf && !(other.isLeaf)) { //this is a leaf, the other isn't a leaf
				// 		Node minOther = other.left;
				// 		while (!minOther.isLeaf) {
				// 			minOther = minOther.left;
				// 		} //until its the smallest element in the list
				// 		return (this.symbol).compareTo(minOther.symbol);
				// 	} else { //this isn't a leaf, the other is a leaf
				// 		Node minThis = this.left;
				// 		while (!minThis.isLeaf) {
				// 			minThis = minThis.left;
				// 		} //until its the smallest element in the list
				// 		return (minThis.symbol).compareTo(other.symbol);
				// 	} //end of else
				// } //end of else 

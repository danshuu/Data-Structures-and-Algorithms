import java.util.*;
import java.io.*;

public class Project6 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scInfile = new Scanner(new File("/Users/Danielshu/Desktop/School/cpe103/Project6/file0.txt"));
		HashMap<Character, Node> frequencyTable = new HashMap<Character, Node>(); // All nodes in this hashmap are leaves
		Character currentSymbol;
		scInfile.useDelimiter(""); //separates each char
		//make frequency table using (HashMap)
		StringBuilder fileContents = new StringBuilder();
		while (scInfile.hasNext()) {
			currentSymbol = scInfile.next().charAt(0);
			fileContents.append(currentSymbol);
			if (!(frequencyTable.containsKey(currentSymbol))) {
				frequencyTable.put(currentSymbol, new Node(currentSymbol));
			} else {
				(frequencyTable.get(currentSymbol).frequency)++;
			}
		}
		System.out.println(fileContents.toString());
		//make priority queue
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for (Node node: frequencyTable.values()) {
			pq.add(node);
		}
		
//		System.out.println("asdf");
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
		// for (int i = 0; i < sortedChars.size(); i++) {
		// 	System.out.println(sortedChars.get(i));
		// }
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
		// StringBuilder huffTree = new StringBuilder("|");
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
//			
		}
	
		private static void buildCodesMap(HashMap<Character, String> map, Node root, String code) {
			if (!(root.isLeaf)) {
				buildCodesMap(map, root.left, code + "0");
				buildCodesMap(map, root.right, code + "1");
			} else {
				map.put(root.symbol, code); //once it gets to the leaf, it'll start putting the associated codes for each symbol
			}
		}
	
	private static class Node implements Comparable<Node> {
		private boolean isLeaf;
		private Node left;
		private Node right;
		private Character symbol;
		private Integer frequency; //to be compared

		//if node is just a node
		public Node(Node left, Node right) {
			this.isLeaf = false;
			this.left = left;
			this.right = right;
			this.symbol = null;
			this.frequency = left.frequency + right.frequency;
		} //if node is not a leaf 

		//if node is a leaf
		public Node(char symbol) {
			this.isLeaf = true;
			this.left = null;
			this.right = null;
			this.symbol = symbol;
			this.frequency = 1; //first time occurring will incur a frequency of 1.
		} 
		
		public int compareTo(Node other) {
			// if (other == null) {
			// 	throw new NullPointerException(); 
			// } 

			int comparison = this.frequency.compareTo(other.frequency); 
			if (comparison == 0) {
				if (this.isLeaf && other.isLeaf) { //both are leaves
					return this.symbol.compareTo(other.symbol);
				} else if (!(this.isLeaf) && !(other.isLeaf)) { //both arent leaves
					
					Node minThis = this.left;
					while (!minThis.isLeaf) {
						minThis = minThis.left;
					} //until its the smallest element in the list

					Node minOther = other.left;
					while (!minOther.isLeaf) {
						minOther = minOther.left;
					} //until its the smallest element in the list
					return minThis.symbol.compareTo(minOther.symbol);
					
				} else { //if one is a leaf and the other isnt
					if (this.isLeaf && !(other.isLeaf)) { //this is a leaf, the other isn't
						Node minOther = other.left;
						while (!minOther.isLeaf) {
							minOther = minOther.left;
						} //until its the smallest element in the list
						return this.symbol.compareTo(minOther.symbol);
					} else {
						Node minThis = this.left;
						while (!minThis.isLeaf) {
							minThis = minThis.left;
						} //until its the smallest element in the list
						return minThis.symbol.compareTo(other.symbol);
					} //end of else
				} //end of else 
			} //end if first if
			return comparison; //if the frequencies were not the same
		} //end of compareTo

	} //end of Node class
}


import java.util.*;

import java.io.*;

public class Project6practice {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
//		StringBuilder sb = new StringBuilder("|");
//		buildString(sb);
//		System.out.println(sb.toString());
//		BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(new File("trial.txt")));
		BufferedInputStream buff = new BufferedInputStream(new FileInputStream(new File("/Users/Danielshu/Desktop/School/cpe103/Project6/testFiles/file0_compressed.txt")));
//		BufferedInputStream buff = new BufferedInputStream(new FileInputStream(new File("trial.txt")));
		DataInputStream in = new DataInputStream(buff);
		
		HashMap<Character, Node> frequencyTable = new HashMap<Character, Node>(); // All nodes in this hashmap are leaves
		int size = in.read(); //how many character-value pairs there are.
		//rebuild the tree (read the header)
		for (int i = 0; i < size; i++) {
			Character ch = (char)(in.read()); //reads the character
			int value = in.readInt(); //reads the value


			Node newNode = new Node(ch); //creates node with value
			newNode.frequency = value; //changes values frequencies
			frequencyTable.put(ch, new Node(ch));
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
		StringBuilder compressedString = new StringBuilder();
		int countBits = 1;
		compressedString.append(countBits);
//		System.out.println(compressedString.toString());
		Character x = '0';
		Character y = '1';
		System.out.println(x ==(y));
		
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
	
	private static void buildCodesMap(HashMap<Character, String> map, Node root, String code) {
		if (!(root.isLeaf)) {
			buildCodesMap(map, root.left, code + "0");
			buildCodesMap(map, root.right, code + "1");
		} else {
			map.put(root.symbol, code); //once it gets to the leaf, it'll start putting the associated codes for each symbol
		}
	}
	
	private static void buildString(StringBuilder sb) {
		for (int i = 0; i < 5; i++) {
			sb.append("yo");
		}
	}
}

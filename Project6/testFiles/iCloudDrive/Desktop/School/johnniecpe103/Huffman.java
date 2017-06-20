
import java.util.*;
import java.io.*;

//Johnnie Baba
//CPE 103-07
//Assignment 6
public class Huffman<T> {
   
   private PriorityQueue<Node> pq = new PriorityQueue<Node>();
   private HashMap<Character, Node> nodeHash = new HashMap<Character,Node> ();
   private StringBuilder help = new StringBuilder();
   private HashMap<Character, String> compressHash = new HashMap<Character, String>();
  
   
   private class Node implements Comparable<Node>{
      
      public char character;
      public int frequency;
      public Node leftChild, rightChild;
      public int ascii;
      public int min;
      
      public Node (char character){
         this.character = character;
         this.leftChild = null;
         this.rightChild = null;
         this.frequency = 1;
         this.ascii = character + 0;
         this.min = character + 0;
      }
      
      //node thats sum of frequencies
      public Node(Node lefts, Node rights){
         //character would be 0
         this.leftChild = lefts;
         this.rightChild = rights;
         this.frequency = lefts.frequency + rights.frequency;
         this.min = Math.min(lefts.min, rights.min);

      }
      
      public Node(Node node){
         this.character = node.character;
         this.leftChild = node.leftChild;
         this.rightChild = node.rightChild;
         this.frequency = node.frequency;
         this.ascii = node.ascii;
         this.min = node.min;
      }

      
      public int compareTo(Node o) { //change up comparable

         if(this.frequency > o.frequency){
            return 1; //this is a right child
         }else if(this.frequency == o.frequency){
            if(this.min > o.min){
               return 1; //this is a right child
            }
            return -1; // this is a left child
         }
         return -1; //this is less than o
      }
      
   }
   
   public Huffman(String fileName)throws FileNotFoundException, IOException{ //how to use buffered and filereader?
      FileReader fr = new FileReader(new File(fileName));
      BufferedReader br = new BufferedReader(fr); 
      int keepGoing = 0;
      keepGoing  = br.read();
      while(keepGoing != -1){ //make an arraylist of nodes to put into the queue
         Node toAdd = new Node((char) keepGoing);
         if(nodeHash.get( toAdd.character ) == null){ //place the character into the hash map if it's not there
            nodeHash.put(toAdd.character, toAdd);
         }else{
            //update the frequency of the character if it's there
            nodeHash.get(toAdd.character).frequency++;
            
            
         }
         keepGoing  = br.read();
         
      }
      //get all nodes from the hash map and put it into the priority queue
      for(Node nodes: nodeHash.values()){
         pq.add(nodes);
      }
      while(pq.size()>2){
         Node leftie = new Node( pq.poll()) ;
         Node rightie = new Node(pq.poll());
         Node sumz = new Node(leftie, rightie);
         pq.add(sumz);
         
      }
      Node finalLeft = new Node(pq.poll());
      Node finalRight = new Node(pq.poll());
      Node root = new Node(finalLeft, finalRight);
      String coder = "";
      codeBuilder(root, coder);
      pq.add(root);
      
//      System.out.println("left child: " + pq.peek().leftChild.character + " freq: " + pq.peek().leftChild.frequency);
//      System.out.println("right child: " + pq.peek().rightChild.character + " freq: " + pq.peek().rightChild.frequency);
//      System.out.println("left left child: " + pq.peek().leftChild.leftChild.character + " freq: " + pq.peek().leftChild.leftChild.frequency);
//      System.out.println("right right child: " + pq.peek().rightChild.rightChild.character + " freq: " + pq.peek().rightChild.rightChild.frequency);
//      System.out.println("left right child: " + pq.peek().leftChild.rightChild.character + " freq: " + pq.peek().leftChild.rightChild.frequency);
//      System.out.println("right left child: " + pq.peek().rightChild.leftChild.character + " freq: " + pq.peek().rightChild.leftChild.frequency);
//      System.out.println("right left left child: " + pq.peek().rightChild.leftChild.leftChild.character + " freq: " + pq.peek().rightChild.leftChild.leftChild.frequency);

      //      System.out.println("left right: " + pq.peek().leftChild.rightChild.character + " with code: " + compressHash.get(pq.peek().leftChild.rightChild.character));
//      System.out.println("left right left: " + pq.peek().leftChild.rightChild.leftChild.character );
      //    System.out.println("right right right: " + pq.peek().rightChild.rightChild.rightChild.character + " with code: " + compressHash.get(pq.peek().rightChild.rightChild.character));

   }
   
   
   public void compress(String infileName, String outfileName) throws FileNotFoundException, IOException{
      FileReader fr = new FileReader(new File(infileName));
      BufferedReader br = new BufferedReader(fr);
      FileWriter fw = new FileWriter(new File(outfileName));
      BufferedWriter bw = new BufferedWriter(fw);
      int keepGoing = 0;
      keepGoing  = br.read();
      while(keepGoing != -1){
         bw.write(compressHash.get((char) keepGoing));
         keepGoing = br.read();
      }
      bw.close();
   }
   
   public void decompress(String infileName, String outfileName) throws FileNotFoundException, IOException{
      FileReader fr = new FileReader(new File(infileName));
      BufferedReader br = new BufferedReader(fr);
      FileWriter fw = new FileWriter(new File(outfileName));
      BufferedWriter bw = new BufferedWriter(fw);
      int keepGoing = 0;
      Node ourHuff = pq.peek();
      do{
         keepGoing  = br.read();
         char move = (char) keepGoing;
//         System.out.println("our current character: " + ourHuff.character + " with freq: " + ourHuff.frequency);
         if(ourHuff.leftChild == null && ourHuff.rightChild == null){
//            System.out.println("NO CHILDREN !!!!!");
//            System.out.println("we are writing: " + ourHuff.character);
            bw.write(ourHuff.character);
            ourHuff = pq.peek();
//            System.out.println("freq: " + ourHuff.frequency + " we on top");
//            System.out.println("lets move with: " + move);
         }
         if( move == '0'){
//            System.out.println("we moving left move with: " + move);
            ourHuff = ourHuff.leftChild;
         }else if(move == '1'){
//            System.out.println("lego right move with: " + move);
            ourHuff = ourHuff.rightChild;
         }
      }while(keepGoing != -1);
     
      bw.close();
   }
   
   
   public String toString(){ //get all characters from pq and append to a string builder
      StringBuilder sb = new StringBuilder();
      StringBuilder bs = new StringBuilder();
      sb.append('|');
      sb.append(toStringHelper( pq.peek() , bs) );
      sb.append('|');
      return sb.toString();
   }
   
   private StringBuilder toStringHelper(Node n, StringBuilder s){
      if(n.character != 0){
         s.append(n.character);
      }
      if(n.leftChild!= null){
         toStringHelper(n.leftChild, s);
      }
      if(n.rightChild != null){
         toStringHelper(n.rightChild, s);
      }
      return s;
   }
   
   private void codeBuilder(Node n, String codez){
      if(n.character != 0){
         compressHash.put(n.character, codez);
      }
      if(n.leftChild != null){
         codeBuilder(n.leftChild, codez + 0);
      }if(n.rightChild != null){
         codeBuilder(n.rightChild, codez + 1);
      }
   }
   
}

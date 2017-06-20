/**
 * Provided starting point for Java-based tsort.
 *
 * @author Hatalsky/Jones - Starting point.
 * @author Daniel Shu
 *
 * @version CPE 103 Lab 12
 */
import java.io.*;
import java.util.*;

public class TSort {
   // Hides the constructor form javadoc utility and users.
   private TSort() {}

   /**
    * Performs a topological sort of the specified directed acyclic graph.  The
    * graph is given as a string containing pairs of vertices representing
    * edges separated by spaces.  The resulting string will be formatted
    * identically to the Unix utility {@code tsort}.  That is, one vertex per
    * line in topologically sorted order.
    *
    * @param edges the edges of the DAG specified as space separated
    * vertex-pairs
    *
    * @return a topological ordering for the specified DAG
    *
    * @throws IllegalArgumentException if:
    * <ul>
    *   <li>edges is emtpy with the message "input contains no edges"</li>
    *   <li>edges has an odd number of vertices (incomplete pair) with the
    *   message "input contains an odd number of tokens"</li>
    *   <li>the graph contains a cycle (isn't acyclic) with the message "input
    *   contains a loop"</li>
    * </ul>
    */
   private static class Vertex {
    private int inDegrees;
    private String str;
    private ArrayList<Vertex> adjacentList = new ArrayList<Vertex>(); //create a vertex list
    // private ArrayList<Vertex> adjList;

    public Vertex(String str) {
      this.str = str;
      this.inDegrees = 0;
      this.adjacentList = new ArrayList<Vertex>();
    } 
    public void incrementDegrees() {
      inDegrees++;
    }

    public void decrementDegrees() {
      inDegrees--;
    }

    public void addToAdjList(Vertex other) {
      this.adjacentList.add(other);
    }

    public ArrayList<Vertex> returnAdjList() {
      return adjacentList;
    }
   }

   public static String tsort(String edges) {
    Scanner sc = new Scanner(edges);
    if (!sc.hasNext()) {
      throw new IllegalArgumentException("input contains no edges");
    } 

    HashMap<String, ArrayList<Vertex>> hashMap = new HashMap<String, ArrayList<Vertex>>();
    Stack<Vertex> stack = new Stack<Vertex>();

    //add all verts to hashmap along with its associated adjacent list as the value
    while (sc.hasNext()) {
      String vertString = sc.next();
      Vertex vert = new Vertex(vertString);
      // System.out.println("\n\t" + vertString);
      // System.out.println("Looping through " + vert.returnStr());

      if (!(hashMap.containsKey(vertString))) {
        ArrayList<Vertex> adjList = makeAdjList(vert, edges);
//        for (int i = 0; i < adjList.size(); i++) {
//          System.out.println("Vertex: " + vert.returnStr());
//          System.out.println("adjacent " + (i+1) + " is " + adjList.get(i).returnStr());
//        }
        hashMap.put(vertString, adjList);

        //adds everything to the hash map and pushes all 0 in degrees
        // System.out.println("printing out in degrees for " + vertString + ": " + vert.inDegrees);
        // System.out.println(vertString + ": " + )
        if (vert.inDegrees == 0) {
          stack.push(vert);//push all vertices with in degree of 0 onto a stack
        }
      } //end of if 
    } //end of while

    // Note: Just for printing.
    // System.out.println("printing out hash map");
    for (String str: hashMap.keySet()){
      ArrayList<Vertex> associatedList = hashMap.get(str);  
      // System.out.print(str + ": ");  
      // for (int i = 0; i < associatedList.size(); i++) {
      //   System.out.print(associatedList.get(i).returnStr() + " ");
      // }
      // System.out.println("");
    } 
    if (stack.empty()) {
      throw new IllegalArgumentException("input contains a loop");
    }

    // System.out.println("printing out stack");
    // while (!stack.empty()) {
    //   System.out.println(stack.pop().returnStr());
    // }

    //build the string
    StringBuilder output = new StringBuilder();
    //the vertex can only be pushed into the stack if it has an in-degree of 0
    
    while (!stack.empty()) {
      System.out.println("pushing/popping to stack");
      Vertex poppedVertex = stack.pop();

      output.append(poppedVertex.str); //append the vertex's string
      output.append("\n");

//      System.out.println("adjacency is " + (hashMap.get(poppedVertex.returnStr())).get(0).returnStr());
      
      ArrayList<Vertex> tempAdjList = hashMap.get(poppedVertex.str);
      for (int i = 0; i < tempAdjList.size(); i++) {
        tempAdjList.get(i).decrementDegrees();
//        System.out.println(tempAdjList.get(i).returnStr() + " has an in degree of " + tempAdjList.get(i).returnDegrees());
        if (tempAdjList.get(i).inDegrees == 0) {
          stack.push(tempAdjList.get(i));
        } 
      } //end of for loop
    } //end of while loop
    return output.toString();
   }

   private static ArrayList<Vertex> makeAdjList(Vertex vert, String edges) {
    
    Scanner sc = new Scanner(edges);
    while (sc.hasNext()){
      String pairFirst = sc.next(); //first of the pair == vert
      //part to build adjacent list
      if (pairFirst.equals(vert.str)) { //if the string of the first pair is equal to the string othe vertex
        if (!sc.hasNext()) { //if no existing second pair
          throw new IllegalArgumentException("input contains an odd number of tokens");
        } else { //if there's an existing second pair
          String pairSecond = sc.next();//2nd of the pair
          if (pairFirst.equals(pairSecond)) {
            throw new IllegalArgumentException("input contains a loop");
          } else { //get the adjacent element and add it to the adjList
            Vertex adjVertex = new Vertex(pairSecond);
            vert.addToAdjList(adjVertex);
          }
        }
        //part to increment degrees
      } else { //first of pair doesn't equal vert
        if (!sc.hasNext()) { //if no existing second pair
          throw new IllegalArgumentException("input contains an odd number of tokens");
        } else { //if there's an existing second pair
          String pairSecond = sc.next();//2nd of the pair
          if (pairFirst.equals(pairSecond)) {
            throw new IllegalArgumentException("input contains a loop");
          } else if (pairSecond.equals(vert.str)) {
            vert.incrementDegrees();
          }
          //get the adjacent element and add it to the adjList
        } //end of else
      } // end of else
    } // end of while
    return vert.returnAdjList();
   }

   /**
    * Entry point for the Java-based tsort utility allowing the user to specify
    * a file, redirect a file, or specify the input manually followed by
    * cntl-d to signal the end of input.
    */
   public static void main(String[] args) {
      Scanner scanner = null;

      if (args.length == 0) {
         scanner = new Scanner(System.in);
      } else if (args.length == 1) {
         try {
            scanner = new Scanner(new File(args[0]));
         } catch(FileNotFoundException e) {
            System.out.format("TSort: %s: No such file or directory\n", args[0]);
            System.exit(1);
         }
      } else {
         System.out.format("TSort: extra operand `%s'\n", args[1]);
         System.exit(1);
      }

      StringBuilder input = new StringBuilder();

      while (scanner.hasNext()) {
         input.append(scanner.next() + " ");
      }

      scanner.close();

      try {
         System.out.print(tsort(input.toString()));
      } catch(IllegalArgumentException e) {
         System.out.println("TSort: " + e.getMessage());
         System.exit(1);
      }
   }
}
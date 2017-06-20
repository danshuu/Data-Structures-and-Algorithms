import java.util.*;
public class Lab12 {

	public static void main(String[] args) {
		String x = "hello";
		String y = "hello";
		System.out.println(x.equals(y));
		System.out.println(x == y);
//		Vertex vert = new Vertex("hello");
//		System.out.println(vert.returnDegrees());
//		String edge = "hello whatsup whatsup hello whats hello yoyoyo hello";
//		makeAdjList(vert, edge);
//		System.out.println(vert.returnDegrees());
		
//		String str = "5 7 \n \n\n\n\n8 9";
//		String[] strSplit = str.split(" ");
//		System.out.println(strSplit.length);
//		Scanner sc = new Scanner(str);
//		while (sc.hasNext()) {
//			System.out.println(sc.next());
//		}

	}
	   public static String tsort(String edges) {
		    Scanner sc = new Scanner(edges);
		    Scanner sc2 = new Scanner(edges);
		    if (!sc.hasNext()) {
		      throw new IllegalArgumentException("input contains no edges");
		    } 
		    HashMap<Vertex, ArrayList<Vertex>> hashMap = new HashMap<Vertex, ArrayList<Vertex>>();
		    Stack<Vertex> stack = new Stack<Vertex>();
		    while (sc.hasNext()) {
		      Vertex vert = new Vertex(sc.next());
		      if (!(hashMap.containsKey(vert))) {
		        ArrayList<Vertex> adjList = makeAdjList(vert, edges);
		        hashMap.puts(vert, adjList);
		        if (vert.returnDegrees() == 0) {
		          stack.push(vert);//push all vertices with in degree of 0 onto a stack
		        }
		      } //adds everything to the hash map and pushes all 0 in degrees
		     
		    }

		    //build the string
		    StringBuilder output = new StringBuilder();
		    //the vertex can only be pushed into the stack if it has an in-degree of 0
		    while (!stack.empty()) {
		      Vertex poppedVertex = stack.pop();
		      output.append(poppedVertex.returnStr()); //append the vertex's string
		      ArrayList<Vertex> tempAdjList = hashMap.get(poppedVertex);
		      for (int i = 0 i < tempAdjList.size(); i++) {
		        tempAdjList.get(i).decrementDegrees();
		        if (tempAdjList.get(i).returnDegrees() == 0) {
		          stack.push(tempAdjList.get(i));
		        }
		      }
		    }
		    return output;
		   }
   private static class Vertex {
	    private int inDegrees;
	    private String str;
	    // private ArrayList<Vertex> adjList;

	    public Vertex(String str) {
	      this.str = str;
	      this.inDegrees = 0;
	      // this.adjList = new ArrayList<Vertex>();
	    } 
	    public String returnStr() {
	      return str;
	    }
	    public void incrementDegrees() {
	      inDegrees++;
	    }
	    public int returnDegrees() {
	      return inDegrees;
	    }
	}
	
   private static ArrayList<Vertex> makeAdjList(Vertex vert, String edges) {
	    ArrayList<Vertex> adjacentList = new ArrayList<Vertex>(); //create a vertex list
	    Scanner sc = new Scanner(edges);

	    while (sc.hasNext()){
	      String pairFirst = sc.next(); //first of the pair == vert
	      //part to build adjacent list
	      if (pairFirst == vert.returnStr()) {
	        if (!sc.hasNext()) { //if no existing second pair
	          throw new IllegalArgumentException("input contains an odd number of tokens");
	        } else { //if there's an existing second pair
	          String pairSecond = sc.next();//2nd of the pair
	          if (pairFirst.equals(pairSecond)) {
	            throw new IllegalArgumentException("input contains a loop");
	          } else { //get the adjacent element and add it to the adjList
	        	  Vertex adjVertex = new Vertex(pairSecond);
	              adjacentList.add(adjVertex);
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
	          } else if (pairSecond.equals(vert.returnStr())) {
	            vert.incrementDegrees();
	          }
	          //get the adjacent element and add it to the adjList

	        } //end of else

	      } // end of else
	    } // end of while
	    sc.close();
	    return adjacentList;
	    
	   }
}

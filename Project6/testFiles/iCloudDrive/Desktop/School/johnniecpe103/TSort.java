/**
 * Provided starting point for Java-based tsort.
 *
 * @author Hatalsky/Jones - Starting point.
 * @author ? - Completed by.
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
   private static class Vertex{
      public int inDegree;
      public ArrayList<Vertex> adjacentTo;
      public String name;
      public Vertex(String points){
         this.inDegree = 0;
         this.adjacentTo = new ArrayList<Vertex>();
         this.name = points;
      }
   }
   
   public static String tsort(String edges) {
      StringBuilder sb = new StringBuilder(); //use .append anything to add to this
      String[] strArr = edges.split(" ");
      Stack<Vertex> s = new Stack<Vertex>();
      Vertex justPopped = null;
      if(strArr[0].equals("")){
         System.out.println("input contains no edges");
         throw new IllegalArgumentException();
      }else if(strArr.length % 2 == 1){
         System.out.println("input contains an odd number of tokens");
         throw new IllegalArgumentException();
      }
      ArrayList<Vertex> vertAl = vertimake(strArr);
      for(int i = 0; i< vertAl.size(); i++){ //push all vertices with in-degree 0 onto stack
         if(vertAl.get(i).inDegree == 0){
            s.push(vertAl.get(i));
         }
      }
      if(s.size()==0){
         System.out.println("input contains a loop");
         throw new IllegalArgumentException();
      }
      int vertices = vertAl.size();
      do{
         justPopped = s.pop();
         vertices--;
         for(int i = 0; i< justPopped.adjacentTo.size(); i++){
            for(int j = 0; j< vertAl.size(); j++){
               if(justPopped.adjacentTo.get(i).name.equals(vertAl.get(j).name)){
                  vertAl.get(j).inDegree--;
                  if(vertAl.get(j).inDegree==0){
                     s.push(vertAl.get(j));
                  }
               }
            }
         }
         sb.append(justPopped.name);
         sb.append('\n');
      }while(s.size() >0);
      if(vertices>0){
         System.out.println("input contains a loop");
         throw new IllegalArgumentException();
      }
      
      
      return sb.toString();
   }
   
   //private method to make an array list of vertices with their in-degree and what they're adjacent to
   private static ArrayList<Vertex> vertimake(String[] arr){
      ArrayList<Vertex> val = new ArrayList<Vertex>();
      for(int i=0; i< arr.length -1 ; i= i+ 2){
         int index = 0;
         int copy1 = 0;
         int copy2 = 0;
         while(index < val.size()){
            if(val.get(index).name.equals(arr[i])){
               Vertex addAdjacentTo = new Vertex(arr[i+1]);
               val.get(index).adjacentTo.add(addAdjacentTo);
               copy1++;
            }
            if(val.get(index).name.equals(arr[i+1])){
               val.get(index).inDegree++;
               copy2++;
            }
            index++;
         }
         if(copy1==0){
            Vertex ogVertex = new Vertex(arr[i]);
            Vertex newVertex = new Vertex(arr[i+1]);
            newVertex.inDegree++;
            ogVertex.adjacentTo.add(newVertex);
            val.add(ogVertex);
         }
         if(copy2 == 0){
            Vertex newVertex = new Vertex(arr[i+1]);
            newVertex.inDegree++;
            val.add(newVertex);
         }
      }
      return val;
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

      while(scanner.hasNext()) {
         input.append(scanner.next() + " ");
      }

      scanner.close();

      try {
         System.out.println(tsort(input.toString()));
      } catch(IllegalArgumentException e) {
         System.out.print("TSort: " + e.getMessage());
         System.exit(1);
      }
   }
}
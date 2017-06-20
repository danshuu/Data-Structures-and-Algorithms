//Johnnie Baba
//CPE 103-07
//Lab 13

/**
 * A partial implementation of a directed graph class to explore
 * Dijkstra's shortest-path algorithm.
 *
 * @author Hatalsky/Jones - Provided partial solution
 * @author ? - Completed by
 * @version CPE 103 Lab 13
 */
import java.io.*;
import java.util.*;

public class DiGraph {
   /* Provided/Required */
   private TreeMap<String, Vertex> vertices = new TreeMap<String, Vertex>();

   /* Provided/Required - should not need to modify
    * The edge class is used such that we may store the weights easily. */
   private static class Edge {
      private Vertex dest;
      private double weight;

      public Edge(Vertex dest, double weight) {
         this.dest = dest;
         this.weight = weight;
      }
   }

   /* Provided/Required - should not need to modify */
   private static class Vertex implements Comparable<Vertex> {
      private String name;
      private TreeMap<String, Edge> edges = new TreeMap<String, Edge>();
      private boolean known;
      private double distance = Double.POSITIVE_INFINITY;
      private Vertex prior;

      public Vertex(String name) {
         this.name = name;
      }

      public void addEdge(Vertex adj, double weight) {
         // TreeMap put() returns null when no matching element in tree 
         if (edges.put(adj.name, new Edge(adj, weight)) != null) {
            throw new IllegalArgumentException("Duplicate edge");
         }
      }

      // Used by priority queue used in Dikstra's shortest path algorithm.
      public int compareTo(Vertex that) {
         return ((Double)this.distance).compareTo(that.distance);
      }

      public String toString() {
         return this.name;
      }

      // For debugging purposes if and as necessary...
      public String debugToString() {
         StringBuilder sb = new StringBuilder()
            .append("Vertex name: ").append(name)
            .append("\nKnown: ").append(known)
            .append("\nPrior: ").append(prior)
            .append("\nDistance: ").append(distance)
            .append("\nAdjacencies:");

         for (String name : edges.keySet()) {
            sb.append(' ').append(name);
         }

         return sb.toString();
      }
   } // End class Vertex

   /**
    * Constructs a directed graph from a file containing the weighted
    * edges.  A weighted edge is specified as three values, separated
    * by whitespace, in the following order: the from-vertex as a
    * String, the to-vertex as a String, and the weight as a double.
    *
    * @param fileName the name of a file containing the weighted
    * edges (see the method's detailed description for the file's
    * format).
    *
    * @throws FileNotFoundException if the file is not found
    * @throws IllegalArgumentException if:
    * <ul>
    *   <li>the file is empty</li>
    *   <li>the input is mal-formed</li>
    *   <li>the graph contains a negative edge</li>
    * </ul>
    */
   public DiGraph(String fileName) throws FileNotFoundException {
      // TODO: Complete the constructor
      
      File file = new File( fileName );
      Scanner scan = new Scanner( file );
      String fromName;
      String toName;
      double weighter;
      
      while( scan.hasNext() ){
         
         try{
            
            fromName = scan.next();
            toName = scan.next();
            weighter = scan.nextDouble();
         }
         
         catch( InputMismatchException imp){
            
            throw new IllegalArgumentException();
         }
         
         Vertex fromVertex = vertices.get( fromName );
         Vertex toVertex = vertices.get( toName );
         
         if( fromVertex  == null ){
            
            fromVertex = new Vertex( fromName );
            vertices.put( fromName , fromVertex );
         }
         
         if( toVertex  == null ){
            
            toVertex = new Vertex ( toName );
            vertices.put( toName, toVertex );
         }
         
         if( weighter < 0 ){
            
            throw new IllegalArgumentException();
         }
         
         fromVertex.addEdge( toVertex,  weighter );
            
            
         }
      
      
//      while( scanLine.hasNextLine() ){
//         
//         String line[] = scanLine.nextLine().split(" "); //split the line into an array with 3 elements
//         System.out.println( "the line has this many stuff: " + line.length);
//         System.out.println( "first element is: " + line[0]);
//         //check if these vertices already exist
//         if( vertices.get( line[0] ) == null){        
//            Vertex fromVert = new Vertex( line[0] );
//            fromVert.known = false;
//            fromVert.prior = null;
//            fromVert.distance = Double.POSITIVE_INFINITY;
//            vertices.put( fromVert.name, fromVert);
//         }
//
//         if(vertices.get( line[1] ) == null){
//            Vertex toVert = new Vertex( line[1] );
//            toVert.known = false;
//            toVert.prior = null;
//            toVert.distance = Double.POSITIVE_INFINITY;
//            vertices.put( toVert.name, toVert);
//         }
//
//         double weight = Double.parseDouble( line[2] );
//         Edge newEdge = new Edge( vertices.get( line[1] ) , weight);
//         vertices.get( line[0] ).edges.put( line[1], newEdge);
//
//
//
//
//      }
      
      
   }

   /**
    * Applies Dijkstra's shortest path algorithm to the graph using
    * the specified vertex as the starting vertex. 
    *
    * @param from The name of the starting vertex.
    *
    * @throws IllegalArgumentException if the specified vertex is not
    * in the graph
    */
   public void setStart(String from) {
      // TODO: Complete setStart
      
      if(vertices.get( from ) == null){
         throw new IllegalArgumentException();
      }
      
      PriorityQueue<Vertex> vertexPQ = new PriorityQueue<Vertex>();
      Vertex start = vertices.get( from );
      start.distance = 0;
      vertexPQ.add( start );
      
      while( vertexPQ.size() > 0 ){
         
         Vertex dequeued = vertexPQ.poll();
         dequeued.known = true;
         
         for( String vertx: dequeued.edges.keySet()){
    
            Vertex adjacentVertex = vertices.get( vertx );
            Edge adjacentEdge = dequeued.edges.get( adjacentVertex.name );
            double theirDistance = dequeued.distance + adjacentEdge.weight;
            
            if( adjacentVertex.known == false ){
               
               if(adjacentVertex.distance > theirDistance){
                 
                  if( vertexPQ.contains( adjacentVertex ) ){
                     
                     vertexPQ.remove( adjacentVertex );
                     adjacentVertex.distance = theirDistance;
                     adjacentVertex.prior = dequeued;
                     vertexPQ.add( adjacentVertex );
                     
                  }else{
                     
                     adjacentVertex.distance = theirDistance;
                     adjacentVertex.prior = dequeued;
                     vertexPQ.add( adjacentVertex );

                  }
                  
               }               
            }            
         }
         
      }
      
   }

   /**
    * Provided: Returns a shortest path to the specified vertex from
    * the current start-vertex. 
    *
    * @param to the to-vertex whose path you want
    * @return the path from the current start-vertex to the specified
    * to-vertex
    */
   public String getPathTo(String to) {
      StringBuilder path = new StringBuilder();
      getPathTo(vertices.get(to), path);

      return path.toString();
   }
   
   /*
    * Provided: Recursive helper method for public getPathTo().
    */
   private void getPathTo(Vertex v, StringBuilder path) {
      if (v.prior != null) {
         getPathTo(v.prior, path);
         path.append(' ');
      }

      path.append(v.name);
   }

   /**
    * Provided: Returns the distance of the shortest path to the
    * specified vertex to the current start-vertex. 
    *
    * @param to the to-vertex whose distance you want
    * @return the distance from the current start-vertex to the
    * specified to-vertex
    */
   public double getDistanceTo(String to) {
      return vertices.get(to).distance;
   }
}
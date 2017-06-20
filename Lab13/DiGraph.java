/**
 * A partial implementation of a directed graph class to explore
 * Dijkstra's shortest-path algorithm.
 *
 * @author Hatalsky/Jones - Provided partial solution
 * @author Daniel Shu - Completed by
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
      Scanner sc = new Scanner(new File(fileName));
      if (!sc.hasNext()) { //if file is empty 
        throw new IllegalArgumentException("The file is empty");
      }  
      String fromVertexStr = null;
      String toVertexStr = null; 
      double weight = 0;
        
      while (sc.hasNext()) {
        fromVertexStr = sc.next();
        if (!sc.hasNext()) {
          throw new IllegalArgumentException("The input is mal-formed");
        } 
        toVertexStr = sc.next(); 
        if (!sc.hasNextDouble()){
          throw new IllegalArgumentException("The input is mal-formed");
        }
        weight = sc.nextDouble();
        if (weight < 0) {
          throw new IllegalArgumentException("The graph contains a negative edge");
        }

        Vertex fromVertex = vertices.get(fromVertexStr);
        if (fromVertex == null) {
          fromVertex = new Vertex(fromVertexStr);
          vertices.put(fromVertexStr, fromVertex);
        }

        Vertex toVertex = vertices.get(toVertexStr);
        if (toVertex == null) {
          toVertex = new Vertex(toVertexStr);
          vertices.put(toVertexStr, toVertex);
        }

        fromVertex.addEdge(toVertex, weight); //adds the edge vertex and associated weight to the originating vertex
      } //end of while


   } //constructs a directed graph from a file containing the weighted edges. 
   //A weighted edge is specified as 3 values, separated by a whitespace, in the following order:
   //The from-vertex as a string, the to-vertex as a String, and the weight as a double

   //fileName is the file containing the weightred edges

   /**
    * Applies Dijkstra's shortest path algorithm to the graph using
    * the specified vertex as the starting vertex. 
    *
    * @param from The name of the starting vertex.
    *
    * @throws IllegalArgumentException if the specified vertex is not
    * in the graph
    */
   public void setStart(String from) { //from = name of starting vertex
      if (!vertices.containsKey(from)) {
        throw new IllegalArgumentException("The specified vertex is not in the graph.");
      } //if specified vertex is not in the graph

      //RESET all vertexes (in case setStart was called more than once for a graph)
      for (Vertex vert : vertices.values()) { 
         vert.known = false;
         vert.distance = Double.POSITIVE_INFINITY;
         vert.prior = null;
      }

      PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
      vertices.get(from).distance = 0; //set starting vertex distance to 0
      vertices.get(from).prior = null; //set starting prior equal to 0
      pq.add(vertices.get(from)); //adds starting vertex to the priority queue. (sorted by distance)

      while (pq.size()>0) {
        Vertex dequeuedVertex = pq.poll();
        dequeuedVertex.known = true;

        for (Edge edge : dequeuedVertex.edges.values()) {
          if (edge.dest.known == false) {
            double newDist = edge.weight + dequeuedVertex.distance;
            if (newDist < edge.dest.distance) { 
              pq.remove(edge.dest);
              edge.dest.distance = newDist;
              edge.dest.prior = dequeuedVertex;
              pq.add(edge.dest);
            }
          }
        }
        // double newDistance = dequeuedVertex.get()
      }
   } //applies Dijkstra's shortest path algorithm to the graph using the specified vertex as the starting vertex

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

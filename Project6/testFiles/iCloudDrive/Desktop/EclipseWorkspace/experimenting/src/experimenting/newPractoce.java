package experimenting;

import java.util.*;

public class newPractoce {

	public static void main(String[] args) {
	      HashMap<String, Vertex> map = new HashMap<>();
	      ArrayList<Vertex> mapOrder = new ArrayList<>();
	      String str = "hello";
	      Vertex vert = new Vertex(str);
	      map.put(str, vert);
	      mapOrder.add(vert);
	      str = "nah";
	      vert.name = str;
	      System.out.println("vert.name: " + vert.name);
	      System.out.println(map.keySet());
	      System.out.println("map.get('hello').name " + map.get("hello").name);
	      System.out.println("mapOrder.get(0).name " + mapOrder.get(0).name);
	      

	}
	
   private static class Vertex {//implements Comparable<Vertex> {
	      private int inDeg = 0;
	      private String name;
	      private ArrayList<Vertex> adjVer = new ArrayList<>();
	      private Vertex(String name) {
	         this.name = name;
      }
   }	

}

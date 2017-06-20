
//Implementing Single Linked List without Iterator
import java.util.*;

public class LinkedList_noIt<Element> {
	private int size;
	private Node first;

	/** Constructor for objects of class LinkedList	 */
	public LinkedList_noIt()	{
		size = 0;
		first = null;
	}
	// return number of nodes
	public int getSize() {
	    return this.size;
	}//getSize
   // get element is specific location
 /*  public Element get(int index)	{
	    Node p = getNode(index);
	    return p.element;
	}*/
/*	
    public Element getFirst()
	{
	    if (first == null)	{throw new NoSuchElementException();}
      return first.element;
	}
  
	public Element removeFirst()    {
         if (first == null) {throw new NoSuchElementException();}
         Element element = first.element;
         first = first.next;
         return element;
      }
*/
   // remove node in specific location
   public void remove(int index)	{
	    if (index == 0)
	       first = first.next;
	    else {
	        Node p = getNode(index-1);
	        p.next = p.next.next;
	    }
	    size--;
	}//remove
	
	public void addFirst(Element element)
   {
       Node newNode = new Node(element);
       newNode.next = first;
       first = newNode;
   }

   //add element in given location
   public void add(int index, Element element)	{
	    Node newNode = new Node(element);
	    if (index == 0) {
	        newNode.next = first;
	        first = newNode;
	    }
	    else {
	        Node p = getNode(index-1);
	        newNode.next = p.next;
	        p.next = newNode;
	    }
	    size++;
	}//add
	//print the list
   public void printList(Node n)	{
		while (n != null){
         System.out.print(n.element + " ");
         n= n.next;
      }
      System.out.println();
	}//printList

	// Retive the node (to help with other methods)
	public Node getNode(int i)	{
	    Node p = first;
	    int pos = 0;
	    while (pos != i) {
	       p = p.next;
	       pos++;
	    }
	    return p;
	}//getNode

	/**
	 * Node class - local to LinkedList
	 */
	public class Node 	{
		private Element element;
		private Node next;
		//Constructor
		public Node(Element element){
		    this.element = element;
		    this.next = null;
		}
	}//Class Node
}//Class LinkedList_noIt

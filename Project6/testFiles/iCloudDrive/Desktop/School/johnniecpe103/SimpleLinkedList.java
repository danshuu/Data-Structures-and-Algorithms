//Johnnie Baba
//CPE 103-07
//Lab 01
//Description: This program will allow the user to create a linked list as well as do the following: add nodes,add nodes in
//certain places, get the size of the list, and get a node at any index in the linked list


public class SimpleLinkedList<T> implements SimpleList<T> {
   private int size;
   private Node head;
   private Node tail;
	
   public SimpleLinkedList(){
      size = 0;
      head = new Node(null);
      tail = new Node(null);
      head.next = tail;
      tail.previous= head;
   }
	
   public void add(T element){
      Node newNode = new Node(element);
      Node placeHolder = tail.previous;
      newNode.previous = placeHolder;
      newNode.next = tail;
      placeHolder.next = newNode;
      tail.previous = newNode;
      size++;
   }

   public void add(int index, T element){
      if(index <0 || index>size){
         throw new IndexOutOfBoundsException();
      }
      Node newNode = new Node(element);
      Node placeHolder = getNode(index);
      Node secondPlaceHolder = placeHolder.previous;
      secondPlaceHolder.next = newNode;
      newNode.previous = secondPlaceHolder;
      newNode.next = placeHolder;
      placeHolder.previous = newNode;
      size++;
   }
   private Node getNode(int i) {
      Node p = head.next;
      int pos = 0;
      while (pos != i) {
         p = p.next;
         pos++;
      }
      return p;
   }
	
   public T get(int index){
      if(index <0 || index>=size){
         throw new IndexOutOfBoundsException();
      }
      Node pos = getNode(index);
      return pos.element;
		
   }
	
   public T remove(int index){
      if(index <0 || index>=size){
         throw new IndexOutOfBoundsException();
      }
      Node desiredNode = getNode(index);
      desiredNode.next.previous = desiredNode.previous;
      desiredNode.previous.next = desiredNode.next;
      size--;
      return desiredNode.element;
   }
	
   public int size(){
      return size;
   }
	
	
	

	
   private class Node{
      public T element;
      public Node next;
      public Node previous;
      public Node(T element){
         this.element = element;
         this.next = null;
         this.previous = null;
      }
   }
}

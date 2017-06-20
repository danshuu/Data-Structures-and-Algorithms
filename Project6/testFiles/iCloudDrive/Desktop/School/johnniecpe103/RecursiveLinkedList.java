/**
 * A provided, partially complete, simple, recursive, singly-linked list
 * for CPE 103 Lab 6.
 *
 * @author Hatalsky/Jones (Provided skeleton).
 *
 * Insert you name as the second author below as the person that completed
 * the class.
 *
 * @author 
 * @version CPE 103 Lab 6
 */
// Class invariants:
//
// The head reference is never null.
// The head node's next field will be null when the list is empty.
// The next field of the last node in the list is always null.

//Must complete and create associated private 
//recursive helper methods for 
//the following: get(int index), add(int index, T element)
// remove(int index)

public class RecursiveLinkedList<T> implements SimpleList<T> {
   private class Node {
      public Node next;
      public T e;

      public Node() {
      }

      public Node(Node next, T e) {
         this.next = next;
         this.e = e;
      }
   }

   private Node head;
   private Throwable stackTrace;

   public RecursiveLinkedList() {
      head = new Node();
   }

   public void add(T element) {
      head.next = add(head.next, element);
   }
   
   public void addAlt(T element) {
      addAlt(head, element);
   }
   
 
   public T get(int index) {
      if(index < 0){
         throw new IndexOutOfBoundsException();
      }else{
         return get(index, head.next);
      }
   }
   public void add(int index, T element) {
      if(index<0){
         throw new IndexOutOfBoundsException();
      }
      if(index == 0){
         add(-1, head.next, element);
      }
      else{
         add(index, head.next, element);
      }
   }
   
   public T remove(int index) {
      if(index<0){
         throw new IndexOutOfBoundsException();
      }else{
         return remove(index, head);
      }
      
      
   }

   public int size() {
      return size(head.next);
   }
   
   public Throwable stackTrace() {
      return stackTrace;
   }
   
   //Private recursive helper method for public T get(int index)
   private T get(int index, Node node){
      stackTrace = new Throwable();
      if(index == 0){
         return node.e;
      }else{
         return get(index - 1, node.next);
      }
   }

   //Private recursive helper method for public T remove(int index)
   private T remove(int index, Node node){
      stackTrace = new Throwable();
      if(index == 0 && node.next.e.equals(head.next.e)){
         T value = head.next.e;
         head.next = head.next.next;
         return value;
      }
      else if(index == 0){
         T value = node.e;
         node.next = node.next.next;
         return value;
      }else{
         return remove(index-1, node.next);
      }
   }
   
   
   
   
   //Private recursive helper method for public void add(int index, T element)
   private void add(int index, Node node, T element){
      stackTrace = new Throwable();
      if(index == -1){
         Node fresh = new Node(); //new node
         fresh.e = element;
         fresh.next = head.next;
         head.next = fresh;
      }
      else if(index == 0){
         if(node.e == null){ //check if empty node
            node.e = element;
         }else{
            Node fresh = new Node(); //new node
            fresh.e = element;
            fresh.next = node.next;
            node = fresh;
         }
      }else{
         if(node.next == null){  //check if there's a next node
            node.next = new Node();
            add(index-1, node.next, element);
         }else{ //the case where there is another node with a value
            add(index-1, node.next,element);
         }
      }
      
      
   }
   
   // Private recursive helper method for public add(T)
   private Node add(Node node, T e) {
      stackTrace = new Throwable();

      if(node == null) {
        return new Node(null, e);
      } else {
         node.next = add(node.next, e);
      }

      return node;
   }

   // Private ALTERNATE recursive helper method for public add(T)
   private void addAlt(Node node, T e){
      stackTrace = new Throwable();

      if(node.next == null){
        node.next = new Node(null, e);
      }
      else{
         addAlt(node.next, e);
      }
   }

   // Private recursive helper method for public size(int) 
   private int size(Node node) {
      stackTrace = new Throwable();

      if (node == null) {
         return 0;
      }

      return 1 + size(node.next);
   }
}
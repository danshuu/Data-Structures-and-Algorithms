/**
 * A provided, partially complete, simple, recursive, singly-linked list
 * for CPE 103 Lab 6. Complete it without using loops of any kind.
 * Instance variables, private inner class Node, constructor, add(element) size() are already written and working.
 * Complete the public get(index), add(index, element) and remove(index) methods and their associated private helper methods
 * The best solutions recurse all the way to the place in the list where the work is to be done.
 *
 * @author Hatalsky/Jones (Provided skeleton).
 *
 * Insert you name as the second author below as the person that completed
 * the class.
 *
 * @author Daniel Shu
 * @version CPE 103 Lab 6
 */
// Class invariants:
//
// The head reference is never null.
// The head node's next field will be null when the list is empty.
// The next field of the last node in the list is always null.
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
      head.next = add(head.next, element); //needs an explanation, how does 
   }

   public void addSimple(T element) {
      addSimple(head, element);
   }

   public void add(int index, T element) {
      if (index < 0) {
         throw new IndexOutOfBoundsException();
      }
      addHelper(index, head, element);

      // throw new RuntimeException("You must complete this method!");
   }

   public T get(int index) {
      if (index < 0) {
         throw new IndexOutOfBoundsException();
      }
      return getHelper(index, head);
      // throw new RuntimeException("You must complete this method!");
   }

   public T remove(int index) {
      if (index < 0) {
         throw new IndexOutOfBoundsException();
      }
      return removeHelper(index, head);
      // throw new RuntimeException("You must complete this method!");
   }

   public int size() {
      return size(head.next);
   }

   public Throwable stackTrace() {
      return stackTrace;
   }

   //helps the add(index, element) method
   private void addHelper(int index, Node node, T e) {
      stackTrace = new Throwable();

      if (node == null) {
         throw new IndexOutOfBoundsException();
      }

      Node newNode = new Node(null, e); //create the Node

      if (index == 0) { // if index hits 0
         newNode.next = node.next; // set the newly created Node's next Node as the index 0's node's next
         node.next = newNode; // set the index 0 node's next equal to the newly create node
      } else {
         addHelper(index - 1, node.next, e); //recursively 
      }

   }

   //helps get method
   private T getHelper(int index, Node node) {
      stackTrace = new Throwable();

      if (node == null || node.next == null) { //if after recursively calling node.next, and the node is null, then the index is > size
         //therefore out of bounds
         throw new IndexOutOfBoundsException();
      }
      if (index == 0) {
         return node.next.e;
      } else {
         return getHelper(index-1,node.next); //node.next will only recurse as many times as size-1 (which is the same as index)
      }



   } //essentially using recursion to iterate through the linked list till it hits the desired index

   //helps remove method
   private T removeHelper(int index, Node node) {
      stackTrace = new Throwable();

      if (node == null || node.next == null) {
         throw new IndexOutOfBoundsException();
      } 
      if (index == 0) {
         Node temp = node.next;
         node.next = node.next.next;
         return temp.e;
      } else {
         return removeHelper(index-1, node.next);
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
   private void addSimple(Node node, T e){
      stackTrace = new Throwable();

      if(node.next == null){
         node.next = new Node(null, e);
      } else {
         addSimple(node.next, e);
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

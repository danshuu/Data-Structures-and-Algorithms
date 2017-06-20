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
public class ComplexRecursiveLinkedList<T> implements SimpleList<T> {
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

   public ComplexRecursiveLinkedList() {
      head = new Node();
   }

   public void add(T element) {
      head.next = add(head.next, element); //needs an explanation, how does this work
   }

   public void addSimple(T element) {
      addSimple(head, element);
   }

   public void add(int index, T element) {
      if (index < 0) {
         throw new IndexOutOfBoundsException();
      }
      head.next = addHelper(index, head.next, element);
   }

   public T get(int index) {
      if (index < 0) {
         throw new IndexOutOfBoundsException();
      }
      return getHelper(index, head);
   }

   public T remove(int index) {
      if (index < 0) {
         throw new IndexOutOfBoundsException();
      }
      return removeHelper(index, head);
   }

   public int size() {
      return size(head.next);
   }

   public Throwable stackTrace() {
      return stackTrace;
   }

   //helps the add(index, element) method
   private Node addHelper(int index, Node node, T e) {
      //doesn't work
      stackTrace = new Throwable();

      if (index == 0) {
         return new Node(node, e);
      } else if (node == null) {
         throw new IndexOutOfBoundsException();
      } else {
         node.next = addHelper(index-1, node.next, e);
      }

      return node;
      // Why is it that for add without index, when you hit null, you return the node, whereas for add WITH index,
      // when you hit null, it would be an indexoutofboundsexception? index only goes till to the last index + 1?

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

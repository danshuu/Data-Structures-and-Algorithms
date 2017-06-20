import java.util.List;
import java.util.NoSuchElementException;


/**
 * Provided BST class skeleton for students to complete. This class makes use
 * of Object Oriented structural recursion to solve the problem.
 *
 * Original Revision:
 * @author Hatalsky/Jones
 * @version Lab 7
 *
 * Completed By:
 * @author Daniel Shu
 */
public class BST<T extends Comparable<? super T>> {
   // Instance variables for BST class.
   // These are the only ones allowed!
   private final BSTNode<T> EMPTY_NODE = new EmptyNode();
   private BSTNode<T> root = EMPTY_NODE;
   private int size;

   // Polymorphic BST node type!
   private interface BSTNode<T> {
      public BSTNode<T> insert(T element);
      public boolean contains(T element);
      public T minimum(T minimum);
      public T maximum(T maximum);
      public void toSortedList(List<T> list);
   }

   ////////////////////////////////////////////////////////////////////////////
   // BST class methods...
   //

   /**
    * Inserts an element into the BST.  If the element is already in the BST,
    * the element being inserted is discarded.
    *
    * @param element The element to insert into the BST
    *
    * @throws IllegalArgumentException if the element is null
    */
   public void insert(T element) {
      if (element == null) {
         throw new IllegalArgumentException();
      }
      root = root.insert(element); //root is the initial case
   }

   /**
    * Determines whether or not an element is in the BST.
    *
    * @param element the element to search for in the BST
    *
    * @return true if the element is in the BST, false otherwise
    */
   public boolean contains(T element) {
      if (element == null) {
         return false;
      }

      return root.contains(element);
   }

   /**
    * Finds the minimum element in the BST.
    *
    * @return the minimum element in the BST
    *     
    * @throws NoSuchElementException if the BST is empty
    */
   public T minimum() {
      if (size == 0) {
         throw new NoSuchElementException();
      }

      return root.minimum(((Node)root).element);
   }

   /**
    * Finds the maximum element in the BST.
    *
    * @return the maximum element in the BST
    *
    * @throws NoSuchElementException if the BST is empty
    */
   public T maximum() {
      if (size == 0) {
         throw new NoSuchElementException();
      }

      return root.maximum(((Node)root).element);
   }

   /**
    * Takes the elements in the BST and places them in ascending order into the
    * list.
    *
    * @param list the list in which you will place elements
    */
   public void toSortedList(List<T> list) {
      root.toSortedList(list);
   }

   public int size() {
      return size;
   }

   ////////////////////////////////////////////////////////////////////////////
   // private EmptyNode class...
   //
   private class EmptyNode implements BSTNode<T> {
      // No instance variables needed or allowed!

      public BSTNode<T> insert(T element) {
        size++;
        return new Node(element);
      }

      public boolean contains(T element) {
        return false;
      }

      public T minimum(T element) {
          return element;  
      }

      public T maximum(T element) {
        return element;
      }

      public void toSortedList(List<T> list) {

      } //literally does nothing, because when it's an empty node, you just move on.
   }

   ////////////////////////////////////////////////////////////////////////////
   // private Node class...
   //
   private class Node implements BSTNode<T> {
      // These are the only instance variables needed and the only ones allowed!
      T element;
      BSTNode<T> left, right;

      // You may (and probably want to) write constructor(s)
      public Node(T element) {
        this.element = element;
        this.left = EMPTY_NODE;
        this.right = EMPTY_NODE;
      }

      public BSTNode<T> insert(T element) { //when you recursively call this function, it'll continually compare
      //the element and the node's element so you can reset the right/left nodes of each node and have it perpetually update
      //until the end of the method.
        if (element.compareTo(this.element) < 0) { //if the element belongs on the left side of BST
          left = left.insert(element);
        } else if (element.compareTo(this.element) > 0) { //if the element belongs on the right side of BST
          right = right.insert(element);
        }
        //don't insert if it is a duplicate value
        return this; //this as in the node
      }

      public boolean contains(T element) {
        if (element.compareTo(this.element) < 0) { //if the element belongs on the left side of BST
          return left.contains(element);
        } else if (element.compareTo(this.element) > 0) { //if the element belongs on the right side of BST
          return right.contains(element);
        } else { 
          return true; 
        }
      }

      //go all the way to the left until it hits an empty node, and return the element
      public T minimum(T element) {
        return left.minimum(this.element);
      }

      //go all the way to the right until it hits an empty node, and return the element
      public T maximum(T element) {
        return right.maximum(this.element);
      }

      public void toSortedList(List<T> list) {
        left.toSortedList(list);//starts at the left side and by recursively calling it you will end up at the leftest of lefts
        //The very left node starts adding, then recurses backwards with each function performing in order.
        list.add(this.element); //adds the middle element
        right.toSortedList(list); //goes all the way to the end of rights
      }
   }
}


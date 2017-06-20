import java.util.List;
import java.util.NoSuchElementException;


/**
 * Provided BST class skeleton for students to complete. This class makes use
 * of Object Oriented structural recursion to solve the problem.
 *
 * Original Revision:
 * @author Hatalsky/Jones
 * @version Lab 8
 *
 * Completed By:
 * @author Daniel Shu
 */
public class BST<T extends Comparable<? super T>> {
   // Instance variables for BST class.
   // These are the only ones allowed!
   private final BSTNode<T> EMPTY_NODE = new EmptyNode();
   private BSTNode<T> root = EMPTY_NODE;
   private int size; ; //default int initializes to 0

   // Polymorphic BST node type!
   private interface BSTNode<T> {
      public BSTNode<T> insert(T element);
      public boolean contains(T element);
      public T minimum(T minimum);
      public T maximum(T maximum);
      public void toSortedList(List<T> list);
      public BSTNode<T> remove(T element);
      public int treeHeight();
      public long internalPathLength(long depth);
      public boolean isEmpty();
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

   public void remove(T element) {
      root = root.remove(element);
      size--;
   } //must have O(logn) performance on average

   public int treeHeight() {
      if (size == 0) {
        return -1;
      }
      return root.treeHeight();
   } //O(n) performance
   //returns height of tree

   public long internalPathLength() {
      if (size == 0) {
        return -1;
      }
      return root.internalPathLength(0);
   } //O(n) performance
   //returns internal path length of the tree


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

      public boolean isEmpty() {
        return true;
     } //always returns true in the Empty Node class
   
      public BSTNode<T> remove(T element) {
        throw new NoSuchElementException();
      } //if emptyNode tries to remove, it would throw an exception

      public int treeHeight() {
        return -1;
      } //O(n) performance
      //returns height of tree

      public long internalPathLength(long depth) {
        return 0;
      } //O(n) performance
      //returns internal path length of the tree
   
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
      } //using this.element makes the argument dynamic, thus having each different left node's element in the argument and eventually returning the element at the leftest node

      //go all the way to the right until it hits an empty node, and return the element
      public T maximum(T element) {
        return right.maximum(this.element);
      } //using this.element makes the argument dynamic, thus having each different right node's element in the argument and eventually returning the element at the rightest node

      //in-order : left, root, right
      public void toSortedList(List<T> list) {
        left.toSortedList(list);//deep into the left side and gathers those elements first
        list.add(this.element); //adds the middle element
        right.toSortedList(list); //goes all the way to the end of rights
      }

      public BSTNode<T> remove(T element) {

        if (element.compareTo(this.element) < 0) {
          left = left.remove(element); 
        } else if (element.compareTo(this.element) > 0) {
          right = right.remove(element);
        } else { //element == this.element
          //if its a leaf node equal to it and it's children are empty nodes, then return EMPTY_NODE
          if (this.left.isEmpty() && this.right.isEmpty()) { // if element is a node with no children (can be implemented this way or checked with if its == EMPTY_NODE or .getClass() == EmptyNode.getClas())
            return EMPTY_NODE;
          } else if (this.left.isEmpty() && !(this.right.isEmpty())) { //if element is a node with right child only
            return right;
          } else if (this.right.isEmpty() && !(this.left.isEmpty())) { //if element is a node with left child only
            return left;
          } else { //if the element has 2 children
              this.element = right.minimum(this.element); //replaces the element with the minimum of the right subtree
              right = right.remove(this.element); //removes the minimum after it replaced
          }
        } //end of else
        return this; //should this be in the last else? 
      }

      public int treeHeight() {
        return 1 + Math.max(left.treeHeight(),right.treeHeight());
      } //O(n) performance
      //returns height of tree

      public long internalPathLength(long depth){
        System.out.println(depth);
        return left.internalPathLength(1 + depth) + right.internalPathLength(1 + depth) + depth;

      }

      public boolean isEmpty() {
        return false;
     } //returns false if its a regular node
   }
}


/**
 * Provided BST class skeleton for students to complete. This class makes use
 * of Object Oriented structural recursion to solve the problem.
 * Added for Project 4: This assignment builds on the BST you developed in Lab7 and Lab8 and
 * uses your SimpleArrayStack from Lab3. There are 2 distinct parts to this assignment:
 * 1. Making your BST class Iterable in-order and adding a get method to your BST 
 * 2. Creating 2 different BSTs and using your BSTs to develop an efficient solution to the problem 
 *    of translating Morse Code to text and text to Morse Code
 * 
 * Original Revision:
 * @author Hatalsky/Jones
 * @version Project 4
 *
 * Completed By:
 * @author Daniel Shu
 */

import java.util.List;
import java.util.NoSuchElementException;
// import java.util.Iterable; this is part of the lang library
import java.util.Iterator;

public class BST<T extends Comparable<? super T>> implements Iterable<T> {
   // Instance variables for BST class.
   // These are the only ones allowed!
   private final BSTNode<T> EMPTY_NODE = new EmptyNode();
   private BSTNode<T> root = EMPTY_NODE;
   private int size; //default int initializes to 0

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
      public T get(T element);
      // public Iterator<T> iterator();
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
   } //Inserts the specified element into this BST. If the element is already in the BST, the element being inserted is discarded.

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
   } //Determines whether or not an element is in the BST. Returns true if this BST contains the specified element. More formally, returns true if any only if this BST contains an element e such that element.compareTo(e) == 0.

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
      } //Finds and returns the minimum element in this BST.

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
   } //Finds and returns the maximum element in this BST.

   /**
    * Takes the elements in the BST and places them in ascending order into the
    * list.
    *
    * @param list the list in which you will place elements
    */
   public void toSortedList(List<T> list) {
      root.toSortedList(list);
   } //Takes the elements in this BST and places them in ascending order into the specified list.

   public int size() {
      return size;
   } //the number of elements in this BST

   public void remove(T element) {
      root = root.remove(element);
      size--;
   } //must have O(logn) performance on average
  //Removes the specified element from this BST. More formally, removes an element e such that element.compareTo(e) == 0, if this BST contains such an element.

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

   public T get(T element) {
      return root.get(element);
   } //returns the specified element in this BST. More formally, gets an element e such that element.compareTo(e) == 0, if this BST contains such an element

    public Iterator<T> iterator() {
      Iterator<T> it = new BSTIterator();
      return it;
      // return new BSTIterator(); //does this work by itself?
    } //returns an iterator for an in-order traversal of this BST

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

      public T get(T element) {
        throw new NoSuchElementException(); //if element is not in the tree
      } 
   
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

      public long internalPathLength(long depth){
         return left.internalPathLength(1 + depth) + right.internalPathLength(1 + depth) + depth;

      }

      public boolean isEmpty() {
        return false;
      } //returns false if its a regular node
      //optional method to be used for remove

      public T get(T element) {
        if (element.compareTo(this.element) < 0) {
          return left.get(element); 
        } else if (element.compareTo(this.element) > 0) {
          return right.get(element);
        } else { //element == this.element
          return this.element;
        } //end of else
        // return this; //should this be in the last else? 
      } 
   } //end of node class

     ////////////////////////////////////////////////////////////////////////////
     // private Iterator class...
     //
    private class BSTIterator implements Iterator<T>{

      private SimpleArrayStack<Node> stack;

      //@Override is a hint for the compiler to know that you're overriding the method of a parent class or interface
      public BSTIterator() {
        stack = new SimpleArrayStack<Node>();
        BSTNode<T> current = root;
        while (!current.isEmpty()) {
          stack.push((Node)current);
          current = ((Node)current).left; //current is still a BSTNode
        } //finished pushing the left side of the tree in the stack
        
      } //end of constructor

      public boolean hasNext() {
        if (stack.size() == 0) {
          return false;
        }
        return true;
      } //end of hasNext

      public T next() {
        if (stack.size() == 0) {
          return null;
        }
        BSTNode<T> tos = stack.pop(); //top of stack
        T result = ((Node)tos).element;
        if (!(((Node)tos).right.isEmpty())) { //if the top's right node isn't empty
        //tos won't have a left since it's coming up from the minimum
          tos = ((Node)tos).right;
          while (!(tos.isEmpty())) { //while right's node isn't empty
            stack.push((Node)tos); //push the nonempty node into stack
            tos = ((Node)tos).left; //keep setting tos to its left element and pushing the tos into stack until left is empty
          }
        }

        return result;
      } //end of next

      public void remove() {
        throw new UnsupportedOperationException();
      } //end of remove


    } //end of BSTIterator class
    //this class must return elements in ascending order (lowest to highest); in-order traversal
    //each call to hasNext() must operate in O(1) time
    //each call to next() must operate in O(1) time
    //use a stack of keep track of where you came from (and will return to) during iteration
    //use SimpleArrayStack from Lab3
}


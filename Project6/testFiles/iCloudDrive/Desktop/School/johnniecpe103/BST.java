
import java.util.Iterator;
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
 * @author Your Name Here!
 */
public class BST<T extends Comparable<? super T>> implements Iterable<T> {
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
      public BSTNode<T> remove(T element);
      public boolean isEmpty();
      public int treeHeight();
      public long internalPathLength(long depth);
      public T get(T element);
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

      root = root.insert(element);
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
   
   /**
    * Finds an element in the BST, removes it
    * 
    * @param element to remove in the BST
    * 
    * @return element that was removed
    */
   
   public void remove(T element){
      
      root =root.remove(element);
      size--;
      
      
      
   }
   
   /**
    * Calculates the height of the BST from root to the lowest leaf
    * 
    * @return height of BST
    */
   
   public int treeHeight(){
      return root.treeHeight();
   }
   
   
   /**
    * Calculates the internal path length, the sum of the depth of EVERY NODE
    * 
    * @return sum of the depth of EVERY NODE
    */
   
   public long internalPathLength(){
      if(this.size()==0){
         return -1;
      }
      return root.internalPathLength(0);
   }
   
   /**
    * Finds and returns the desired element from the BST, otherwise returns NoSuchElementException
    * 
    * @param desired element
    * 
    * @return desired element
    */
   
   public T get(T element){
      return root.get(element);
   }
   

   public int size() {
      return size;
   }
   
   public Iterator<T> iterator(){
      Iterator<T> iter = new BSTIterator();
      return iter;
      
   }

   ////////////////////////////////////////////////////////////////////////////
   // private EmptyNode class...
   //
   private class EmptyNode implements BSTNode<T> {
      // No instance variables needed or allowed!

      public BSTNode<T> insert(T element) {
         BSTNode<T> filler = new Node(element);
         size++;
         return filler;
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
      }
      
      public BSTNode<T> remove(T element){
         
         throw new NoSuchElementException();
      }
      
      public boolean isEmpty(){
         return true;
      }
      public int treeHeight(){
         return -1;
      }
      public long internalPathLength(long depth){
         return 0;
      }
      public T get(T element){
         throw new NoSuchElementException();
      }
      
   }
   
   ///////////
   private class BSTIterator implements Iterator<T>{
      private SimpleArrayStack<Node> sas;
      
      public BSTIterator(){
         sas = new SimpleArrayStack<Node>();
         BSTNode<T> n = root;
         while(n != EMPTY_NODE){
            sas.push((Node)n);
            n = ((Node)n) .left;
         }
         
      }

      @Override
      public boolean hasNext() {
         if(sas.size()==0){
            return false;
         }
         return true;
      }

      @Override
      public T next() {
         if(sas.size() == 0){
            return null;
         }
         Node top = sas.pop();
      
         if(top.right.isEmpty() == false){
            sas.push((Node)top.right);
            while(sas.peek().left.isEmpty() == false){
               sas.push((Node)sas.peek().left);
            }
         }
         
         return top.element;
         
      }

      @Override
      public void remove() {
         throw new UnsupportedOperationException();
         
      }
      
   }

   ////////////////////////////////////////////////////////////////////////////
   // private Node class...
   //
   private class Node implements BSTNode<T> {
      // These are the only instance variables needed and the only ones
      // allowed!
      T element;
      BSTNode<T> left, right;

      // You may (and probably want to) write constructor(s)
      public Node (T element){
         this.element = element;
         this.left = EMPTY_NODE;
         this.right = EMPTY_NODE;
      }

      public BSTNode<T> insert(T element) {
         if(element.compareTo(this.element)>0){
            right = right.insert(element);
         }else if(element.compareTo(this.element)<0){
            left = left.insert(element);
         }
         return this;
         
         
         
      }

      public boolean contains(T element) {
         if(element.compareTo(this.element)>0){
            return right.contains(element); //go right
         }else if(element.compareTo(this.element)<0){
            return left.contains(element); //go left
         }
         return true;
      }

      public T minimum(T element) {
         return left.minimum(this.element);
         
      }

      public T maximum(T element) {
         return right.maximum(this.element);
         
      }

      public void toSortedList(List<T> list) {
         left.toSortedList(list);
         list.add(this.element);
         right.toSortedList(list);
         
      }
      
      public BSTNode<T> remove(T element){
         if(element.compareTo(this.element)>0){ //go right if its greater
            right = right.remove(element);
         }else if(element.compareTo(this.element)< 0){//go left if its lesser
            left = left.remove(element);
         }else{
            if(left.isEmpty()){ //if left is empty node
               if(right.isEmpty()){ // if right is also an empty node
                  return EMPTY_NODE;
               }else{               //right is not an empty node
                  return right;
               }
            }else if(right.isEmpty()){ //if right is empty and left is not empty 
               return left;
            }else{ //if the node has two left children find the minimum of the right sub-tree, replace removed element with minimum
               this.element = right.minimum(this.element);
               right = right.remove(this.element);
            }
         }
         
         
         
         return this;
         
         
      }
      
      public boolean isEmpty(){
         return false;
      }
      
      public int treeHeight(){
         return Math.max(right.treeHeight(), left.treeHeight()) + 1;//return the greater height of the two plus 1
         
      }
      
      public long internalPathLength(long depth){
         long result = depth;
         result+= left.internalPathLength(depth+1);
         result += right.internalPathLength(depth+1);
         return result;
      }
      
      public T get(T element){
         if(element.compareTo(this.element)>0){
            return right.get(element);
         }else if(element.compareTo(this.element)<0){
            return left.get(element);
         }
         return this.element;
      }
      
   }
}

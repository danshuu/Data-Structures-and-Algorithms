//Johnnie Baba
//CPE 103-07
//Description: this program will allow to user to create a linked stack which will add elements to the top
//and remove elements on the top

import java.util.NoSuchElementException;



public class SimpleLinkedStack<T> implements SimpleStack<T>{
   
   
   private int size;
   private Node top;
   
   private class Node{
      public T element;
      public Node next;
      public Node(T element){
         this.element = element;
         this.next = null;
      }
   }
   
   public SimpleLinkedStack(){
      size = 0 ;
      top = new Node(null);
      
   }
   public T peek(){
      if(size == 0){
         throw new NoSuchElementException();
      }
      return top.element;
      
   }
   //Returns the element on the top of this stack (but does not remove it).
   
   public T  pop(){
      if(size == 0){
         throw new NoSuchElementException();
      }
      Node value = top;
      top = top.next;
      size--;
      return value.element;
   }
   //Removes and returns the element on the top of this stack.
   
   public void push(T element){
      Node newNode = new Node(element);
      newNode.next = top;
      top = newNode;
      size++;
   }
   //Adds the specified element to the top of this stack.
   
   public int size(){
      return size;
   }
   //Returns the number of elements in this stack.
   
   
 

}

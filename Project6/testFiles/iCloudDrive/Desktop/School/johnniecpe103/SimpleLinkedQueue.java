//Johnnie Baba
//CPE 103-07
//Lab 02
//Description:This program will allow the user 
import java.util.NoSuchElementException;

public class SimpleLinkedQueue<T> implements SimpleQueue<T> {
   private int size;
   private Node front;
   private Node end;
   
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
   
   public SimpleLinkedQueue(){
      int size = 0;
      front = new Node(null);
      end = new Node(null);
      front.next = end;
      end.previous = front;
   }
 
   public int size(){ //returns the size of the queue
      return size;
   }
   
   public T dequeue(){ //Removes the node at the front of the queue then returns the element
      if(size<=0){
         throw new NoSuchElementException();
      }
      Node valueHolder = front.next;
      front.next= front.next.next;
      front.next.previous= front;
      size--;
      return valueHolder.element;
   }
   
   public void enqueue(T element){ //Adds a node to the end of the queue
      Node newNode = new Node(element);
      Node placeHolder = end.previous;
      newNode.previous = placeHolder;
      newNode.next = end;
      placeHolder.next = newNode;
      end.previous = newNode;
      
      size++;
   }
   
   public T peek(){ //returns the element at the front of the queue without removing the node
      if(size==0){
         throw new NoSuchElementException();
      }
      return front.next.element;
   }
   

}

//Johnnie Baba
//CPE 103-07
//Description: This program will allow the user to create a stack that follows Last In First Out

import java.util.NoSuchElementException;

public class SimpleArrayStack<T> implements SimpleStack<T> {
   
   private int size;
   
   private T[] arr;
   
 
   @SuppressWarnings("unchecked")
   public SimpleArrayStack(){
      arr = (T[])new Object[10];
      size = 0;
   }
   
   public T peek(){
      if(size==0){
         throw new NoSuchElementException(); 
      }
      return arr[size-1];
   }
   //Returns the element on the top of this stack (but does not remove it).
   
   public T pop(){
      if(size==0){
         throw new NoSuchElementException(); 
      }
      T valueHolder = arr[size-1];
      arr[size-1] = null;
      size--;
      return valueHolder;
      
   }
   //Removes and returns the element on the top of this stack.
   
   @SuppressWarnings("unchecked")
   public void push(T element){
      arr[size] = element;
      size++;
      if(size == arr.length){
         T[] newArr = (T[])new Object[arr.length*2];
         arr = newArr;
      }
   }
   //Adds the specified element to the top of this stack.
   
   public int size(){
      return size;
   }
   //Returns the number of elements in this stack.
   
   public int capacity(){
      return arr.length;
   }

}

//Johnnie Baba
//CPE 103-07
//Description: This is an implementation of the simple array stack using O(n) for pop and push methods
import java.util.NoSuchElementException;

public class BadStack<T> implements SimpleStack<T> {
   
   private int size;
   
   private T[] arr;
   
 
   @SuppressWarnings("unchecked")
   public BadStack(){
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
      size--;   //decrement the size to prepare to move everything to the left
      T valueHolder = arr[0]; //the value that will be returned
      for(int i = size; i>0; i--){   //moves all the elements in the array to the left
         arr[i-1] = arr[i];
      }  
      return valueHolder;
      
   }
   //Removes and returns arr[0] the element on the top of this stack, then shifts the elements to the left by 1
   
   @SuppressWarnings("unchecked")
   public void push(T element){
      size ++;                            //increment the size to show a new element is coming in
      if(size == arr.length){             //double the array when it is about to be filled so that there's space
         T[] newArr = (T[])new Object[arr.length*2];
         arr = newArr;
      }
      for(int i = 0; i<size; i++){   //moves all the elements in the array to the right
         arr[i+1] = arr[i];
      }
      arr[0] = element;
   }
   //Adds the specified element to the top of this stack, but shifts current elements to the right by 1
   
   public int size(){
      return size;
   }
   //Returns the number of elements in this stack.

}

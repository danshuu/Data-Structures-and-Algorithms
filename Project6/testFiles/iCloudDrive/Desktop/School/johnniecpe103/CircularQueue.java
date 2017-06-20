import java.util.NoSuchElementException;


public class CircularQueue<T> implements SimpleQueue<T> {
   
   public static class MyException extends RuntimeException{
      public MyException(){
         
      }
      //Constructs a MyException with no detail message.
      public MyException(String s){
         super(s);
      }
      //Constructs a MyException with the specified detail message.
   }
   //Thrown to indicate you've had an exception in CircularQueue(int initialCapacity).
   
   
   
   private T[] arr;   
   //Holds the elements in the queue.
   
   private int back;  
   //Keeps track of the end of the queue.
   
   private int front; 
   //Keeps track of the front of the queue.
   
   public static final int INITIAL_LENGTH = 10; 
   //Has a value of 10.
   
   private int size;  
   //Optional: Keeps track of the size of the queue.
   
   
   @SuppressWarnings("unchecked")
   public CircularQueue(){
      arr = (T[])new Object[INITIAL_LENGTH]; 
      size = 0;
      front = 0;
      back = 0;
      
   }
   //Constructs an empty queue with an initial capacity given by INITIAL_LENGTH.
   
   @SuppressWarnings("unchecked")
   public CircularQueue(int initialCapacity){
      if(initialCapacity <= 0){
         throw new MyException();
      }
      arr =  (T[])new Object[initialCapacity];
      size = 0;
      front = 0;
      back = 0;
      
   }
   //Constructs an empty queue with the specified initial capacity.
   
   
   public T dequeue(){
      if(size==0){
         throw new NoSuchElementException(); 
      }
      T valueHolder = arr[front];
      arr[front] = null;
      
      if(front == arr.length-1){ //If front is at the last index of the queue and back is on a lesser index
         front = 0;
      }else{
         front++;
      }
      size--;
      return valueHolder;
      
   }
   //Removes and returns the element at the front of this queue.
   
   @SuppressWarnings("unchecked")
   public void enqueue(T element){
      if(size == arr.length){ //if our array is completely full
         T[] temp= (T[])new Object[arr.length *2]; //make another array that is double the size of the original
         for(int i = 0; i< arr.length; i++ ){
            if(front == arr.length){
               front = 0;
            }
            temp[i] = arr[front]; //use dequeue to place the elements
            front++;
            back = i+1;
            
         
         }
         front = 0;
         arr = temp;
      }
      arr[back] = element;
      if(back==arr.length-1){ //if the back pointer is at the end but the first index has no element
         back = 0;
      }else{
         back += 1;
      }
      size++;
   }
   //Adds the specified element to the end of this queue.
   
   
   public T peek(){
      if(size==0){
         throw new NoSuchElementException(); 
      }
      return arr[front];
   }
   //Returns the element at the front of this queue (but does not remove it).
   
   
   public int size(){
      return size;
   }
   //Returns the number of elements in this queue.
   
   
   public Object[] unusualMethodForTestingPurposesOnly(){
      return arr;
   }
   
   //Returns a reference to the private arr.
   
   
  
}

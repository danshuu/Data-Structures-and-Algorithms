//Johnnie Baba
//CE 103-07
//Program 3

public interface SimpleQueue<T> {
   T dequeue();
   //Removes and returns the element at the front of this queue
   void enqueue(T element);
   //Adds the specified element to the end of this queue
   T peek();
   //Returns the element at the front of this queue(but does not remove it)
   int size();
   //Returns the number of elements in this queue
}
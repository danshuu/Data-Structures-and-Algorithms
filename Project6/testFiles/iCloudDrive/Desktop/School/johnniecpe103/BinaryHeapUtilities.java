//Johnnie Baba
//CPE103
//Description: this program will allow the user to create a binary heap
import java.util.NoSuchElementException;


public class BinaryHeapUtilities {
   
   public static int height(int size){
      if(size < 0){
         throw new IllegalArgumentException();
      }
      int heapHeight =  (int) (Math.log(size)/Math.log(2));
      return heapHeight;
   }
   //Calculates the height of the heap given it's size.
  
   public static <T extends Comparable<? super T>> boolean  isHeap(T[] heap, int size){
      if(size<= 0 ){
         return false;
      }
      
      for(int i = size; i> 1 ; i--){ //checks each element to see if they are in order
         if(heap[i].compareTo(heap[i/2]) < 0){ 
            return false;
         }
         
      }
      return true;
   }
   //Checks to see if data in the specified array meets the heap order property for binary heaps.
   
   public static <T extends Comparable<? super T>> T leftChildOf(int index, T[] heap, int size){
      if(index <1 || index >size){//error if index is negative or greater than the size, first check
         throw new IndexOutOfBoundsException();
      }
      if(index*2 > size){//error if this doesn't have a left child
         throw new NoSuchElementException();
      }
      if(BinaryHeapUtilities.isHeap(heap, size) == false){ //error this isn't a heap, last check
         throw new IllegalArgumentException();
      }
      return heap[index * 2];
   }
   //Returns the left-child of the specified element.
   
   public static <T extends Comparable<? super T>> T parentOf(int index, T[] heap, int size){
      if(index <1 || index >size){ //first check
         throw new IndexOutOfBoundsException();
      }
      if(index / 2 < 1 || index == 1){//error if does not have parent, second check
         throw new NoSuchElementException();
      }
      if(BinaryHeapUtilities.isHeap(heap, size) == false){//last check
         throw new IllegalArgumentException();
      }
      return heap[index / 2];
   }
   //Returns the parent of the specified element.
   
   public static <T extends Comparable<? super T>> T rightChildOf(int index, T[] heap, int size){
      if(index <1 || index >size){//error if the index is greater than size or negative,first check
         throw new IndexOutOfBoundsException();
      }
      if(index * 2 + 1 > size){//error if there is no right child, second check
         throw new NoSuchElementException();
      }
      if(BinaryHeapUtilities.isHeap(heap, size) == false){//error if this isn't a heap,last check
         throw new IllegalArgumentException();
      }
      return heap[index * 2 + 1];
   }
   //Returns the right-child of the specified element.

}

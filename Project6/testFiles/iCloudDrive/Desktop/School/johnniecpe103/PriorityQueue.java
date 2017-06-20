import java.util.ArrayList;
import java.util.NoSuchElementException;

//Johnnie Baba
//CPE 103-07
//Program 3
//Description: This is a binary heap based queue. The program implements the ordering of elements similar to a binary 
//heap into the array based structure of a queue (FIFO)
public class PriorityQueue<T extends Comparable<? super T>> implements SimpleQueue<T> {

   private ArrayList<T> pq; // Array list for priority queue, stores binary heap
   private boolean isMax;

   public PriorityQueue() {
      pq = new ArrayList<T>();
      pq.add(null); // starts the user at the first index now
   }
   // Creates a minimum priority queue

   public PriorityQueue(boolean isMax) {
      pq = new ArrayList<T>();
      this.isMax = isMax;
      pq.add(null); // starts the user at the first index now

   }
   // Creates a maximum priority queue when isMax == true

   public PriorityQueue(T[] arr, int size) { // don't worry about these
                                             // constructors yet
      T[] using = arr;
      pq = new ArrayList<T>();
      pq.add(null);
      for (int i = 0; i < size; i++) {
         this.enqueue(using[i]);
      }

   }
   // Creates a minimum priority queue with specified elements.
   // The array is not a binary heap and should use these parameters
   // to construct a binary queue

   public PriorityQueue(T[] arr, int size, boolean isMax) {
      T[] using = arr;
      pq = new ArrayList<T>();
      pq.add(null);
      this.isMax = isMax;
      for (int i = 0; i < size; i++) {
         this.enqueue(using[i]);
      }
   }
   // Similar to the previous constructor but includes the
   // maximum queue check

   public T dequeue() {
      if (this.size() == 0) {
         throw new NoSuchElementException();
      }
      int index = 1; // index for the binary heap that starts at the root
      int index2 = 2;
      boolean done = false;
      T root = pq.get(1);
      T left = null;
      T right = null;
      if (this.size() == 1) {
         pq.remove(1);
         return root;
      }
      T last = pq.remove(this.size());
      pq.set(1, last);
      

      if (isMax == true) { // if this is a max  heap---------------------------------------children are less than parents
                          
         if (pq.size() == 2) {
            pq.set(index, last);
            done = true;
            return root;
         }

         while (!done) {

            index2 = 2 * index;
            if (index2 <= this.size()) { // if index has a left child
               left = pq.get(index2);
               if (index2 + 1 <= this.size()) { // there's a right child
                  right = pq.get(index2 + 1);
                  if (left.compareTo(right) >= 0) { // if left is greater than right
                     if (left.compareTo(last) >= 0) { // if left is greater than element
                        pq.set(index, left);
                        index = index2;
                     } else {
                        pq.set(index, last);
                        done = true;
                     }
                  } else {// if right greater than left
                     if (right.compareTo(last) >= 0) {
                        pq.set(index, right);
                        index = index2 + 1;
                     } else {
                        pq.set(index, last);
                        done = true;
                     }

                  }
               } else {
                  if (left.compareTo(last) >= 0) {// if left is greater than last
                     pq.set(index, left);
                     index = index2;
                  } else {
                     pq.set(index, last);
                     done = true;
                  }
               }
            } else {
               pq.set(index, last);
               done = true;
            }
         }

      } else {// if min heap parents are less than children
         if (pq.size() == 2) {
            pq.set(index, last);
            done = true;
            return root;
         }
         
         while (!done) {
            index2 = index * 2;            
            if(index2> this.size()){ //check if we don't have a left child
               pq.set(index, last);
               done = true;
               return root;
            }
            left = pq.get(index2);
            
            if(index2 + 1>this.size()){ //check if we don't have a right child
               if(last.compareTo(left)<0){ //set the last at the top if it is better than the left child
                  pq.set(index, last);
                  done = true;
                  return root;
               }else{
                  pq.set(index, left);
                  pq.set(index2, last);
                  done = true;
                  return root;
               }
            }
            right = pq.get(index2+1);
            if(left.compareTo(right)<0){
               if(left.compareTo(last)<0){
                  pq.set(index, left);
                  index = index2;
               }else{
                  pq.set(index, last);
                  done = true;
                  return root;
               }
            }else if(right.compareTo(left)<0){
               if(right.compareTo(last)<0){
                  pq.set(index, right);
                  index = index2 + 1;
               }else{
                  pq.set(index, last);
                  done = true;
                  return root;
               }
            }else{ //right and left are equal
               if(left.compareTo(last)<0){ //left is lesser than last
                  pq.set(index, left);
                  index = index2;
               }else{ //last is lesser than left
                  pq.set(index, last);
                  done = true;
                  return root;
               }
            }
            
         }
      }

      return root;
   }
   // 1.Save the item at the root of the binary heap for eventual return.
   // 2.Remove the last item from the heap; since you are dequeuing an element
   // this value shouldn't be here
   // any more or you would violate the structure property of a binary heap (it
   // must be a complete binary tree).
   // See if this removed item can be inserted into the "hole" you just created
   // at the root without violating
   // the order property. If it can, then you're done!
   // 3.If not done, then put the lesser of the left and right children in the
   // spot you just tried and see
   // if the removed value can be inserted into the new "hole" you just created
   // without violating the order property.
   // If it can, then you're done!
   // 4.If not done, repeat step 3, percolating down through the heap until you
   // find the first place
   // the removed value can go without violating the order property.
   // Be careful if/when you get down towards the bottom of the heap; not all
   // nodes have 2 children!
   // If you get to such a node, you will have to modify the approach slightly
   // or risk bad behaviours!
   // This would be an excellent test case for you to develop (among others)!
   // 5.Return the saved item (formerly at the top of the heap).

   // Removes and returns the first element(the root)
   // Checks for whether queue is min or max queue

   public void enqueue(T element) {
      int parentIndex = pq.size() / 2; // index for parent
      int enqueueIndex = pq.size();
      T parent = pq.get(parentIndex);
      boolean done = false;
      pq.add(element);
      if (this.isMax) { // if max heap

         while (!done) { // until we are are ready to enqueue

            if (this.size() > 1) {
               if (element.compareTo(parent) > 0) {
                  
                  pq.set(enqueueIndex, parent);
                  enqueueIndex = parentIndex;

                  if (parentIndex != 1) { // percolate up to index 1
                     parentIndex /= 2;
                     parent = pq.get(parentIndex);
                  }
                  if (enqueueIndex == 1) { // if the index is at the root then
                                           // stop
                     pq.set(enqueueIndex, element);
                     done = true;
                  }

               } else {
                  pq.set(enqueueIndex, element);
                  done = true;
               }

            } else {
               pq.set(1, element);
               done = true;
            }

         }

      } else { // if min heap

         while (!done) { // until we are are ready to enqueue

            if (this.size() > 1) {
               if (element.compareTo(parent) < 0) {

                  pq.set(enqueueIndex, parent);
                  enqueueIndex = parentIndex;

                  if (parentIndex != 1) { // percolate up to index 1
                     parentIndex /= 2;
                     parent = pq.get(parentIndex);
                  }

                  if (enqueueIndex == 1) { // if the index is at the root then
                                           // stop
                     pq.set(enqueueIndex, element);
                     done = true;
                  }

               } else {
                  pq.set(enqueueIndex, element); // enqueue child
                  done = true;
               }
            } else {

               pq.set(1, element);
               done = true;
            }

         }
      } // end of method
   }

   
   /*
    * 1.See if the element can be added to the end of the heap without violating
    * the order property of a binary heap. If it can, then you're done! 2.If not
    * done, then move the parent element to the spot you just tried and see if
    * the element can go where the parent was without violating the order
    * property. If it can, then you're done! 3.If not done, repeat step 2,
    * percolating up through the heap until you find the first place the value
    * can go without violating the order property. Be careful if/when you make
    * it to the root of the heap!
    */
   // Adds element to the end of the queue
   // Checks for whether queue is min or max queue

   public T peek() {
      if (pq.size() == 1) {
         throw new NoSuchElementException();
      }
      return pq.get(1);

   }
   // Returns the first element(the root)

   public int size() {
      return pq.size() - 1;
   }
   // Returns the number of elements

   public static <E extends Comparable<? super E>> void sort(E[] arr, int size) {
      PriorityQueue<E> pqSort = new PriorityQueue<E>();
      boolean done = false;
      for (int i = 0; i < size; i++) {
         pqSort.enqueue(arr[i]);
      }
      for (int i = 0; i < size; i++) {
         arr[i] = pqSort.dequeue();
      }

   }
   // Sorts the specified array into ascending order
   // using the priority queue

   public static <E extends Comparable<? super E>> E kth(E[] arr, int size, int k) {
      PriorityQueue<E> pqKth = new PriorityQueue<E>();
      int n = size;
      int i;
      if(n-k+1<k){
         pqKth.isMax=true;
         for (i = 0; i < n-k+1; i++) {
            pqKth.enqueue(arr[i]);   
         }
         
         for(i = n-k+1; i< n ;i++ ){
            if(arr[i].compareTo(pqKth.peek()) < 0){
               pqKth.dequeue();
               pqKth.enqueue(arr[i]);
            }
         }
         return pqKth.peek();
      }else{
         pqKth.isMax= false;
         for (i = 0; i < k; i++) {
            pqKth.enqueue(arr[i]);   
         }
         
         for(i = k; i< n ;i++ ){
            if(arr[i].compareTo(pqKth.peek()) > 0){
               pqKth.dequeue();
               pqKth.enqueue(arr[i]);
            }
         }
         return pqKth.peek();
      }
      
      
      

   }
   // Finds the kth largest number (1st largest, 2nd largest, etc.)
   // Assume all elements are unique

}

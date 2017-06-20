/* Sussan : 11/20 
   Linke List using ListIterator of Java
*/
import java.util.NoSuchElementException;
/**
   A linked list is a sequence of nodes with efficient element insertion and removal. This class
   contains a subset of the methods of the standard    java.util.LinkedList class.
*/
public class LinkedList {
   private Node first;

   // Constructs an empty linked list.
   
   public LinkedList()   {
      first = null;
   }

   /*
      @return the first element in the linked list   */
   public Object getFirst()   {
      if (first == null)
         throw new NoSuchElementException();
      return first.data;
   }

   /*
      Removes the first element in the linked list.
      @return the removed element   */
   public Object removeFirst()   {
      if (first == null)
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;
   }

   /*
      Adds an element to the front of the linked list.
      @param element the element to add   */
   public void addFirst(Object element)   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }

   /*
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list   */
   public ListIterator listIterator()   {
      return new LinkedListIterator();
   }
   //Class Node
   private class Node   {
      private Object data;
      private Node next;
   }
   // Class LinkedListIterator
   private class LinkedListIterator implements ListIterator   {
      private Node current;
      private Node previous;

      /*
         Constructs an iterator that points to the front of the linked list.  */
      public LinkedListIterator()  {
         current = null;
         previous = null;
      }

      /*
         Moves the iterator past the next element.
         @return the traversed element */
      public Object next()      {
         if (!hasNext())
            throw new NoSuchElementException();
         previous = current; // Remember for remove

         if (current == null)
            current = first;
         else
            current = current.next;

         return current.data;
      }

      /*
         Tests if there is an element after the iterator current.
         @return true if there is an element after the iterator current */
      public boolean hasNext()      {
         if (current == null)
            return first != null;
         else
            return current.next != null;
      }

      /*
         Adds an element before the iterator current and moves the iterator past the inserted element.
         @param element the element to add  */
      public void add(Object element) {
         if (current == null)   {
            addFirst(element);
            current = first;
         }
         else   {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = current.next;
            current.next = newNode;
            current = newNode;
         }
         previous = current;
      }//add

      /*
         Removes the last traversed element. This method may
         only be called after a call to the next() method. */
      public void remove()      {
         if (previous == current)
             throw new IllegalStateException();

         if (current == first) {
            removeFirst();
         }
         else  {
            previous.next = current.next;
         }
         current = previous;
      }//remove

      /*
         Sets the last traversed element to a different value.
         @param element the element to set */
      public void set(Object element)  {
         if (current == null)
            throw new NoSuchElementException();
         current.data = element;
      }
   }//Class LinkedListIterator
}//LinkedList

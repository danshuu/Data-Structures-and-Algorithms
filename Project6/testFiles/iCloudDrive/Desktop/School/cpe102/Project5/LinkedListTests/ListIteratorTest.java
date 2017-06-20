//Driver for using ListIterartor
import java.util.*;
/**
   A test program to reverse the entries in a linked list.*/
public class ListIteratorTest {  
   public static void main(String[] args)   { 
      LinkedList names = new LinkedList();
      names.addFirst("Jason");
      names.addFirst("Samuel");
      names.addFirst("Diana");
      names.addFirst("Zhang");
      ListIterator iter = names.listIterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println();
      iter.add("Sara");
      iter = names.listIterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println();
      iter.remove();
  //    iter = names.listIterator();//if you don't obtain the iterator it shows the old results, because you are at the end of the list
      while (iter.hasNext()) System.out.print(iter.next() + " ");
   }
}

//Johnnie Baba
//CPE 103-07
//Description: This program will test all of the methods in RecursiveLinkedList
import org.junit.*;

import static org.junit.Assert.*;
public class RecursiveLinkedListTests {
   
   @Test
   public void get_01(){
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();

      list.add(1);
      list.add(2);
      list.add(3);
      assertEquals((Integer)1, list.get(0));
      assertEquals((Integer)2, list.get(1));
      assertEquals((Integer)3, list.get(2));
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void get_error_01(){
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();

      list.add(1);
      list.add(2);
      list.add(3);
      list.get(-1);
   }
   
   @Test
   public void add_01(){
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(0, 1);
      list.add(1, 2);
      list.add(2, 3);
      list.add(3, 4);
      assertEquals((Integer)1, list.get(0));
      assertEquals((Integer)2, list.get(1));
      assertEquals((Integer)3,list.get(2));
      assertEquals((Integer)4, list.get(3)); 

   } 
   @Test
   public void remove_01(){
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(0, 1);
      list.add(1, 2);
      list.add(2, 3);
      list.add(3, 4);
      assertEquals((Integer)1,list.remove(0));
      assertEquals((Integer)2,list.remove(0));
      
   }
   
   

}

/**
 * JUnit tests for SimpleLinkedList.
 *
 * @author Brian Jones
 * @version Lab 1
 */
//Johnnie Baba
//CPE 103-07
//Lab 01
//Description: This program will test the functions of the SimpleLinkedList program

import org.junit.*;
import static org.junit.Assert.*;

public class SimpleLinkedListTests {
   @Test
   public void testSize_empty() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      assertTrue(list.size() == 0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAdd_atConstuctionOutOfBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(25, null);
   }
   
   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemoveOutOfBounds(){
      SimpleLinkedList<Integer> list= new SimpleLinkedList<Integer>();
      list.add(10);
      list.add(21);
      list.remove(2);
   }
   
   @Test(expected=IndexOutOfBoundsException.class)
   public void testAddOutOfBounds(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(2, 21);
   }
   
   @Test
   public void testIndexAddSingles(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(21);
      list.add(0, 66);
      assertTrue(listEquals(list, new int[] {66,21}));
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstruction() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.remove(0);
   }
   
   @Test
   public void testSingleAddAndSize(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(13);
      assertTrue(listEquals(list, new int[] {13}));
      assertTrue(list.size()==1);
   }
   
   @Test
   public void testEmptyList(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      assertTrue(list.size() == 0);
   }
   
   @Test 
   public void testAddTwo(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(1);
   	list.add(21);
   	assertTrue(listEquals(list, new int[] {1,21}));
   	
   }
   
   @Test
   public void emptyLinkedList(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      assertTrue(listEquals(list,new int[] {}));
   }
   
   @Test
   public void testAddRemoveOne(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(23);
      list.remove(0);
      assertTrue(list.size() == 0);
   }
   
   @Test 
   public void testIndexAdd(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(12);
      list.add(21);
      list.add(69);
      list.add(1, 81);
      assertTrue(listEquals(list, new int[] {12,81,21,69}));
   }
   
   @Test
   public void testRemoveIndexAdd(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(21);
      list.add(28);
      list.add(88);
      list.remove(2);
      list.add(2, 100);
      assertTrue(listEquals(list, new int[] {5,10,100,28,88}));
   }
   
   @Test
   public void testRemoveMiddleSize(){
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(4);
      list.add(5);
      list.add(69);
      list.remove(1);
      assertTrue(listEquals(list, new int[] {4,69}));
   }

   @Test
   public void testAddSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(20);
      assertTrue(listEquals(list, new int[] {5, 10, 15, 20}));
      assertTrue(list.size() == 4);
   }

   private boolean listEquals(SimpleLinkedList<Integer> list, int[] a) {
      if (list.size() != a.length) {
        return false;
      }
      for (int i = 0; i < a.length; i++) {
         if (list.get(i) != a[i]) {
            return false;
         }
      }

      return true;
   }
}
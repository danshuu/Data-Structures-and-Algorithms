/**
* Junit tests for BST
*
* @author Daniel Shu
* @version Lab 7 CPE103
*/

import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
public class BSTTests {
   
   @Test(expected = IllegalArgumentException.class)
   public void insertNullTest(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(null);
   }

   @Test(expected = IllegalArgumentException.class)
   public void containNullTest(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(null);
   }

   @Test(expected = NoSuchElementException.class)
   public void emptyMinTest(){
      BST<Integer> bst = new BST<Integer>();
      bst.minimum();
   }

   @Test(expected = NoSuchElementException.class)
   public void emptyMaxTest(){
      BST<Integer> bst = new BST<Integer>();
      bst.maximum();
   }

   @Test()
   public void insertContainTest(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(1);
      assertTrue(bst.contains(1));
      assertEquals(1, bst.size());
   }
   
   @Test()
   public void insertDuplicatesSizeTest(){
      BST<Integer> bst = new BST<Integer>();
      assertEquals(0, bst.size());
      bst.insert(1);
      bst.insert(1);
      bst.insert(1);
      bst.insert(1);
      bst.insert(1);
      bst.insert(1);
      bst.insert(1);
      bst.insert(1);
      bst.insert(1);
      bst.insert(1);
      assertTrue(bst.contains(1));
      assertEquals(1, bst.size());
   }
   
   @Test()
   public void insertContainAlotTest(){
      BST<Integer> bst = new BST<Integer>();
      for (int i = 0; i < 100; i++) {
         bst.insert((Integer)i);
      }

      for (int i = 0; i < 100; i++) {
         assertTrue(bst.contains((Integer)i));
      }

      assertFalse(bst.contains(-1));
      assertFalse(bst.contains(100));
      assertEquals(100, bst.size());
   }

   @Test()
   public void insertContainAlotMaxMinTest(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(1);
      bst.insert(100);
      bst.insert(999);
      bst.insert(-123);
      bst.insert(159);
      bst.insert(14);
      bst.insert(23541);
      bst.insert(511);
      bst.insert(188);
      bst.insert(0);
      bst.insert(-99);

      assertEquals(11, bst.size());
      assertEquals((Integer)23541, bst.maximum());
      assertEquals((Integer)(-123), bst.minimum());
   }
   
   @Test
   public void insertContainAlotMaxMinTest2(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(1);
      assertEquals((Integer)1, bst.minimum());
      bst.insert(9);
      assertEquals((Integer)9, bst.maximum());
      bst.insert(0);
      bst.insert(10);
      bst.insert(1332);
      bst.insert(2123);
      bst.insert(22);
      bst.insert(4040);
      bst.insert(9999999);
      bst.insert(-99999);
      assertEquals((Integer)9999999, bst.maximum());
      assertEquals((Integer)(-99999), bst.minimum());


   }
   @Test
   public void sortListTest(){
      BST<Integer> bst = new BST<Integer>();
      ArrayList<Integer> checker = new ArrayList<Integer>();
      bst.insert(1);
      bst.insert(2);
      bst.insert(12);
      bst.insert(100);
      bst.insert(0);
      bst.insert(9);
      bst.insert(5);
      bst.toSortedList(checker);
      assertEquals(7, checker.size());
      assertEquals((Integer)0, checker.get(0));
      assertEquals((Integer)1, checker.get(1));
      assertEquals((Integer)2, checker.get(2));
      assertEquals((Integer)5, checker.get(3));
      assertEquals((Integer)100, checker.get(checker.size()-1));


   }
   

   
   

}

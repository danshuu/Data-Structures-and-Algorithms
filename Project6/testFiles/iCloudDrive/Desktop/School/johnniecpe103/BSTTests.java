import org.junit.*;
import java.util.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
public class BSTTests {
   
   @Test()
   public void emptyNode_insertContain01(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(1);
      assertTrue(bst.contains(1));
   }
   
   @Test(expected = NoSuchElementException.class)
   public void get_error(){
      BST<Integer> bst = new BST<Integer>();
      bst.get(1);
      bst.insert(21);
      bst.get(2);
      bst.get(22);
   }
   
   @Test()
   public void insertContain(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(1);
      assertTrue(bst.contains(1));
      bst.insert(2);
      assertTrue(bst.contains(2));
      bst.insert(3);
      assertTrue(bst.contains(3));
      bst.insert(4);
      assertTrue(bst.contains(4));
      bst.insert(5);
      assertTrue(bst.contains(5));
      bst.insert(6);
      assertTrue(bst.contains(6));
      bst.insert(7);
      assertTrue(bst.contains(7));
      assertFalse(bst.contains(9));
      assertEquals(7, bst.size());
   }
   
   @Test(expected =NoSuchElementException.class)
   public void remove_error(){
      BST<Integer> bst = new BST<Integer>();
      bst.remove(1);
   }
   @Test
   public void minMax(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(1);
      assertEquals((Integer)1, bst.minimum());
      bst.insert(9);
      assertEquals((Integer)9, bst.maximum());
      bst.insert(0);
      bst.insert(2);
      bst.insert(12);
      bst.insert(21);
      bst.insert(22);
      bst.insert(4040);
      bst.insert(12000000);
      bst.insert(-1);
      bst.insert(-2000000);
      bst.insert(-8);
      assertEquals((Integer)12000000, bst.maximum());
      assertEquals((Integer)(-2000000), bst.minimum());


   }
   @Test
   public void sortaList(){
      BST<Integer> bst = new BST<Integer>();
      ArrayList<Integer> ls = new ArrayList<Integer>();
      bst.insert(22);
      bst.insert(2);
      bst.insert(12);
      bst.insert(21);
      bst.insert(4040);
      bst.toSortedList(ls);
      assertEquals(5, ls.size());
      assertEquals((Integer)2, ls.get(0));
      assertEquals((Integer)4040, ls.get(ls.size()-1));
      Integer[] ex = {2,12,21,22,4040};
      verify(ls,ex);

   }
   
   @Test
   public void treeHeight_01(){
      BST<Integer> bst = new BST<Integer>();
      assertEquals(-1,bst.treeHeight());
      bst.insert(1);
      bst.insert(2);
      assertEquals(1, bst.treeHeight());
      bst.insert(-3);
      bst.insert(-4);
      bst.insert(-5);
      bst.insert(-6);
      assertEquals(4, bst.treeHeight());
      bst.insert(3);
      bst.insert(4);
      bst.insert(5);
      bst.insert(6);
      assertEquals(5, bst.treeHeight());

   }
   
   @Test
   public void remove(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(1);
      bst.insert(2);
      bst.remove(2);
      assertFalse(bst.contains(2));
      assertEquals(1, bst.size());
      bst.remove(1);
      assertEquals(0, bst.size());
      bst.insert(1);
      bst.insert(2);
      bst.remove(1);
      bst.insert(3);
      bst.insert(4);
      bst.insert(5);
      bst.insert(6);
      assertEquals(5, bst.size());

     

   }
   
   @Test
   public void removeSort(){
      BST<Integer> bst = new BST<Integer>();
      ArrayList<Integer> ls = new ArrayList<Integer>();
      bst.insert(1);
      bst.insert(10);
      bst.insert(7);
      bst.insert(6);
      bst.insert(2);
      bst.remove(10);
      bst.toSortedList(ls);
      assertFalse(bst.contains(10));
      Integer[] ex = {1,2,6,7};
      verify(ls,ex);
   }
   
   @Test
   public void internalPathLength(){
      BST<Integer> bst = new BST<Integer>();
      assertEquals(-1, bst.internalPathLength());
      bst.insert(1);
      assertEquals(0, bst.internalPathLength());
      bst.insert(2);
      assertEquals(1, bst.internalPathLength());
      bst.insert(10);
      bst.insert(7);
      bst.insert(6);
      assertEquals(10, bst.internalPathLength());
      bst.insert(-1);
      bst.insert(-3);
      bst.insert(-7);
      assertEquals(16,bst.internalPathLength());
      bst.insert(-10);
      bst.insert(-6);
      assertEquals(24, bst.internalPathLength());

   }
   
   @Test
   public void iterator_01(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(50);
      bst.insert(30);
      bst.insert(25);
      bst.insert(20);
      bst.insert(15);
      Iterator<Integer> it = bst.iterator();
      assertEquals((Integer)15, it.next());
      assertEquals((Integer)20, it.next());
   }
   
   @Test
   public void iterator_02(){
      BST<Integer> bst = new BST<Integer>();
      assertFalse(bst.iterator().hasNext());
   }
   
   @Test(expected = UnsupportedOperationException.class)
   public void iterator_03(){
      BST<Integer> bst = new BST<Integer>();
      bst.iterator().remove();
   }
   
   @Test
   public void get01(){
      BST<Integer> bst = new BST<Integer>();
      bst.insert(1);
      bst.insert(3);
      bst.insert(0);
      assertEquals((Integer)1,bst.get(1));
   }
   
   private void verify(ArrayList<Integer> al, Integer[] expected) {
      for (int i = 0; i < expected.length; i++) {
         assertEquals(expected[i], al.get(i));
      }

   }
   
   

}

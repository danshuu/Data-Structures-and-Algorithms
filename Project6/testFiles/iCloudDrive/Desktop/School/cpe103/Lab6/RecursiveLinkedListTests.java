/**
 * JUnit tests for RecursiveLinkedList.
 *
 * @author Paul Hatalsky 
 * @version Lab 1
 */
import org.junit.*;
import static org.junit.Assert.*;
//import java.lang.reflect.*;

public class RecursiveLinkedListTests {
   @Test
   public void testSize_empty() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      assertEquals(0, list.size());
   }

   @Test
   public void testAddRemove_SizeEmpty() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(1);
      list.remove(0);
      assertTrue(list.size() == 0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAdd_atConstructionOutOfBounds() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(25, null);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAddatConstructionOutOfBounds() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(-1, 100);
   }

   //failed
   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstruction() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.remove(0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAddRemoveException() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(1);
      list.add(2);
      list.remove(3);
   }

   //failed
   @Test(expected=IndexOutOfBoundsException.class)
   public void testAddRemove3() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(1);
      list.add(2);
      list.remove(0);
      list.remove(0);
      list.remove(0);
   }

   //failed
   @Test(expected=IndexOutOfBoundsException.class)
   public void testGet_atConstruction() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.get(0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testGetAfterAdding() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(1);
      list.add(1,2);
      list.get(3);
   }

   @Test
   public void testAddSize() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(3, 20);
      listEquals(list, new Integer[] {5, 10, 15, 20});
   }

   @Test
   public void testAddWithIndex() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(0,5);
      list.add(1,10);
      list.add(2,15);
      list.add(3,20);
      listEquals(list, new Integer[] {5, 10, 15, 20});
   }

   @Test
   public void testAddWithIndex2() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(0,5);
      list.add(1,10);
      list.add(2,15);
      list.add(3,20);
      list.add(1,1);
      list.add(3,2);
      listEquals(list, new Integer[] {5, 1, 10, 2, 15, 20});
   }


   @Test
   public void testAddNull() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(3, 20);
      list.add(null);
      listEquals(list, new Integer[] {5, 10, 15, 20, null});

   }

   @Test
   public void testAddStrings() {
      RecursiveLinkedList<String> list = new RecursiveLinkedList<String>();
      list.add("Hi");
      list.add("daniel");
      list.add("shu");
      list.add("kyrie");
      list.add(null);
      listEquals(list, new String[] {"Hi", "daniel", "shu", "kyrie", null});

   }

   @Test
   public void testAddRemove() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(3, 20);
      list.add(null);
      list.remove(2);
      list.remove(2);
      listEquals(list, new Integer[] {5, 10, null});
   }

   @Test
   public void testAddRemoveGet() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(3, 20);
      list.add(null);
      list.remove(2);
      assertEquals((Integer)20, list.get(2));

   }

   @Test
   public void testAddRemoveSize() {
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(3, 20);
      list.add(null);
      list.remove(2);
      list.remove(2);
      assertEquals(list.size(),3);
   }

   @Test
   public void similarModifiedTest_addIndexStackDepth() {
      int startDepth, depth;
      RecursiveLinkedList<Integer> list = new RecursiveLinkedList<Integer>();
      startDepth = (new Throwable()).getStackTrace().length;

      list.add(0, 1);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 2, depth);

      list.add(0, 2);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 2, depth);

      list.add(1, 3);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 3, depth);
      
      list.add(2, 3);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);
      
      list.add(4, 3);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 6, depth);

      list.remove(2);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);

      list.get(2);
      depth = list.stackTrace().getStackTrace().length;
      assertEquals(startDepth + 4, depth);
   }


   private void listEquals(RecursiveLinkedList list, Object[] a) {
      assertEquals(a.length, list.size());
      for (int i = 0; i < a.length; i++) {
         assertEquals(a[i], list.get(i));
      }
   }

}
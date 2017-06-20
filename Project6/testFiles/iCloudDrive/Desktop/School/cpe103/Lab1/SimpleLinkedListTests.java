/**
 * JUnit tests for SimpleLinkedList.
 *
 * @author Paul Hatalsky 
 * @version Lab 1
 */
import org.junit.*;
import static org.junit.Assert.*;
//import java.lang.reflect.*;

public class SimpleLinkedListTests {
   @Test
   public void testSize_empty() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      assertEquals(0, list.size());
   }

   @Test
   public void testAddRemove_SizeEmpty() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(1);
      list.remove(0);
      assertTrue(list.size() == 0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAdd_atConstructionOutOfBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(25, null);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAddatConstructionOutOfBounds() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(-1, 100);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testRemove_atConstruction() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.remove(0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAddRemoveException() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(1);
      list.add(2);
      list.remove(3);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testAddRemove3() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(1);
      list.add(2);
      list.remove(0);
      list.remove(0);
      list.remove(0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testGet_atConstruction() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.get(0);
   }

   @Test(expected=IndexOutOfBoundsException.class)
   public void testGetAfterAdding() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(1);
      list.add(1,2);
      list.get(3);
   }


   @Test
   public void testAddSize() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(3, 20);
      listEquals(list, new Integer[] {5, 10, 15, 20});
   }

   @Test
   public void testAddWithIndex() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(0,5);
      list.add(1,10);
      list.add(2,15);
      list.add(3,20);
      listEquals(list, new Integer[] {5, 10, 15, 20});
   }

   @Test
   public void testAddNull() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(3, 20);
      list.add(null);
      listEquals(list, new Integer[] {5, 10, 15, 20, null});

   }

   @Test
   public void testAddStrings() {
      SimpleLinkedList<String> list = new SimpleLinkedList<String>();
      list.add("Hi");
      list.add("daniel");
      list.add("shu");
      list.add("kyrie");
      list.add(null);
      listEquals(list, new String[] {"Hi", "daniel", "shu", "kyrie", null});

   }

   @Test
   public void testAddRemove() {
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
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
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
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
      SimpleLinkedList<Integer> list = new SimpleLinkedList<Integer>();
      list.add(5);
      list.add(10);
      list.add(15);
      list.add(3, 20);
      list.add(null);
      list.remove(2);
      list.remove(2);
      assertEquals(list.size(),3);
   }


   private void listEquals(SimpleLinkedList list, Object[] a) {
      assertEquals(a.length, list.size());
      for (int i = 0; i < a.length; i++) {
         assertEquals(a[i], list.get(i));
      }
   }

}
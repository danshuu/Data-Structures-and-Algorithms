/**
* junit tests for BinaryHeapUtilities
* 
* @author Daniel Shu
* @version Lab5 CPE103
*/

import org.junit.*;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class BinaryHeapUtilitiesTests {
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptions() {
		BinaryHeapUtilities.height(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExceptions2() {
      Integer[] heap = new Integer[] {9999, -1, 3, -2, 7, 4, 9, -1, 8, -9999, -9999};

      BinaryHeapUtilities.parentOf(2, heap, 10);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testExceptions3() {
      Integer[] heap = new Integer[] {9999, -1, 3, -2, 7, 4, 9, -1, 8, -9999, -9999};

      BinaryHeapUtilities.parentOf(9, heap, 8);
	}

	@Test(expected = NoSuchElementException.class)
	public void testExceptions4() {
      Integer[] heap = new Integer[] {9999, -1, 3, -2, 7, 4, 9, -1, 8, -9999, -9999};

      BinaryHeapUtilities.parentOf(1, heap, 8);
	}

	@Test(expected = NoSuchElementException.class)
	public void testExceptions5() {
      Integer[] heap = new Integer[] {9999, -1, 3, -2, 7, 4, 9, -1, 8, -9999, -9999};

      BinaryHeapUtilities.leftChildOf(5, heap, 8);
	}

	@Test(expected = NoSuchElementException.class)
	public void testOrderHeapRightChildOfException() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      BinaryHeapUtilities.rightChildOf(15, heap, 15);
	}

	@Test
	public void testNonOrderHeap() {
      Integer[] heap = new Integer[] {9999, -1, 3, -2, 7, 4, 9, -1, 8, -9999, -9999};

      assertEquals(false, BinaryHeapUtilities.isHeap(heap, 10));
	}

	@Test
	public void testOrderHeap() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals(true, BinaryHeapUtilities.isHeap(heap, 15));
	}

	@Test
	public void testOrderHeapParentOf() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals((Integer)8, BinaryHeapUtilities.parentOf(10, heap, 15));
	}

	@Test
	public void testOrderHeapParentOf2() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals((Integer)5, BinaryHeapUtilities.parentOf(15, heap, 15));
	}

	@Test
	public void testOrderHeapParentOf3() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals((Integer)(-10), BinaryHeapUtilities.parentOf(3, heap, 15));
	}

	// @Test
	// public void testOrderHeapParentOf() {
 //      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

 //      assertEquals((Integer)8, BinaryHeapUtilities.parentOf(10, heap, 15));
	// }

	@Test
	public void testOrderHeapleftChildOf() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals((Integer)5, BinaryHeapUtilities.leftChildOf(7, heap, 15));
	}

	@Test
	public void testOrderHeapleftChildOf2() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals((Integer)1, BinaryHeapUtilities.leftChildOf(1, heap, 15));
	}

	@Test
	public void testOrderHeapleftChildOf3() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals((Integer)7, BinaryHeapUtilities.leftChildOf(2, heap, 15));
	}

	@Test
	public void testOrderHeapRightChildOf() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals((Integer)8, BinaryHeapUtilities.rightChildOf(2, heap, 15));
	}

	@Test
	public void testOrderHeapRightChildOf2() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals((Integer)2, BinaryHeapUtilities.rightChildOf(1, heap, 15));
	}

	@Test
	public void testOrderHeapRightChildOf3() {
      Integer[] heap = new Integer[] {9999, -10, 1, 2, 7, 8, 4, 5, 10, 11, 100, 9, 11, 5, 5, 6};

      assertEquals((Integer)6, BinaryHeapUtilities.rightChildOf(7, heap, 15));
	}

   @Test(expected = IllegalArgumentException.class)
   public void leftChild_exception_03_01(){
      Integer heap[] = {0,1,2,3,4,5,6,1};
      BinaryHeapUtilities.leftChildOf(1, heap, 7);
      
   }
   @Test(expected = IllegalArgumentException.class)
   public void leftChild_exception_03_02(){
      Integer heap[] = {0,1,3,2,1,1,3,4,1};
      BinaryHeapUtilities.leftChildOf(2, heap, 8);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void rightChild_exception_01_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8};
      int size = 7;
      int index = 8;
      BinaryHeapUtilities.rightChildOf(index, heap, size);
      BinaryHeapUtilities.rightChildOf(-1, heap, size);
      BinaryHeapUtilities.rightChildOf(0, heap, size);


   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void rightChild_exception_01_02(){
      Integer heap[] = {0,1,2,3,4,5,6,7};
      BinaryHeapUtilities.rightChildOf(0, heap, 6);
   }
   
   @Test(expected = NoSuchElementException.class)
   public void rightChild_exception_02_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
      BinaryHeapUtilities.rightChildOf(7, heap, 12);
   }
   
   @Test(expected = NoSuchElementException.class)
   public void rightChild_exception_02_02(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
      BinaryHeapUtilities.rightChildOf(8, heap, 12);
      BinaryHeapUtilities.rightChildOf(9, heap, 12);
      BinaryHeapUtilities.rightChildOf(10, heap, 12);
      BinaryHeapUtilities.rightChildOf(11, heap, 12);
      BinaryHeapUtilities.rightChildOf(12, heap, 12);
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void rightChild_exception_03_01(){
      Integer heap[] = {0,1,2,3,4,5,6,1};
      BinaryHeapUtilities.rightChildOf(1, heap, 7);
      
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void rightChild_exception_03_02(){
      Integer heap[] = {0,1,3,2,1,1,3,4,1};
      BinaryHeapUtilities.rightChildOf(2, heap, 8);
   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void parentOf_exception_01_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7};
      BinaryHeapUtilities.parentOf(0, heap, 6);
   }
   
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void parent_exception_01_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8};
      int size = 7;
      int index = 8;
      BinaryHeapUtilities.parentOf(index, heap, size);
      BinaryHeapUtilities.parentOf(0, heap, size);
      BinaryHeapUtilities.parentOf(-1, heap, size);


   }
   
   @Test(expected = NoSuchElementException.class)
   public void parent_exception_02_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
      BinaryHeapUtilities.parentOf(1, heap, 12);
   }
   
}
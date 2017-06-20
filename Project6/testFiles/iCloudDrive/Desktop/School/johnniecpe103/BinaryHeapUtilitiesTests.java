//Johnnie Baba
//CPE 103-07
//Description: This is used to test BinaryHeapUtilities
import org.junit.*;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
public class BinaryHeapUtilitiesTests {
   
   
   @Test
   public void height(){
      Integer heap[] = { null,1,2,3,4,5,6,7};
      int size = 7;
      assertEquals(BinaryHeapUtilities.height(size), 2);
      assertEquals(BinaryHeapUtilities.height(1), 0);

   }
   
   @Test
   public void isHeap_01(){
      Integer heap[] = { null,1,2,3,4,5,6,7};
      int size = 7;
      assertTrue(BinaryHeapUtilities.isHeap(heap, size));
      assertFalse(BinaryHeapUtilities.isHeap(heap, -2));
   }
   
   @Test
   public void isHeap_02(){
      Integer heap[] = {0,6,2,3,4,5,6,1};
      int size = 7;
      assertFalse(BinaryHeapUtilities.isHeap(heap, size));
   }
   
   @Test
   public void isHeap_03(){
      Integer heap[] = {0,1,2,3,4,5,6,7};
      int size = 0;
      assertFalse(BinaryHeapUtilities.isHeap(heap, size));
      assertTrue(BinaryHeapUtilities.isHeap(heap, heap.length-1));
   }
   @Test
   public void leftChild_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
      int size = 12;
      int index = 3;
      
      assertEquals((Integer)6,BinaryHeapUtilities.leftChildOf(index, heap, size));
      assertEquals((Integer)8,BinaryHeapUtilities.leftChildOf(4, heap, size));
      assertEquals((Integer)10,BinaryHeapUtilities.leftChildOf(5, heap, size));
      assertEquals((Integer)12,BinaryHeapUtilities.leftChildOf(6, heap, size));
      assertEquals((Integer)4,BinaryHeapUtilities.leftChildOf(2, heap, size));
      assertEquals((Integer)2,BinaryHeapUtilities.leftChildOf(1, heap, size));

   }
   
   @Test
   public void rightChild_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
      int size = 12;
      int index = 3;
      assertEquals((Integer)7,BinaryHeapUtilities.rightChildOf(index, heap, size));
      assertEquals((Integer)9,BinaryHeapUtilities.rightChildOf(4, heap, size));
      assertEquals((Integer)11,BinaryHeapUtilities.rightChildOf(5, heap, size));
      assertEquals((Integer)5,BinaryHeapUtilities.rightChildOf(2, heap, size));
      assertEquals((Integer)3,BinaryHeapUtilities.rightChildOf(1, heap, size));

   }
   
   public void parent_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
      int size = 12;
      int index = 3;
      
      assertEquals((Integer)1,BinaryHeapUtilities.parentOf(index, heap, size));
      assertEquals((Integer)6,BinaryHeapUtilities.parentOf(12, heap, size));
      assertEquals((Integer)5,BinaryHeapUtilities.parentOf(11, heap, size));
      assertEquals((Integer)5,BinaryHeapUtilities.parentOf(10, heap, size));
      assertEquals((Integer)4,BinaryHeapUtilities.parentOf(9, heap, size));
      assertEquals((Integer)4,BinaryHeapUtilities.parentOf(8, heap, size));
      assertEquals((Integer)3,BinaryHeapUtilities.parentOf(7, heap, size));
      assertEquals((Integer)3,BinaryHeapUtilities.parentOf(6, heap, size));
      assertEquals((Integer)2,BinaryHeapUtilities.parentOf(5, heap, size));
      assertEquals((Integer)2,BinaryHeapUtilities.parentOf(4, heap, size));
      assertEquals((Integer)1,BinaryHeapUtilities.parentOf(3, heap, size));
      assertEquals((Integer)1,BinaryHeapUtilities.parentOf(2, heap, size));


   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void leftChild_exception_01_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7};
      int size = 7;
      int index = 8;
      BinaryHeapUtilities.leftChildOf(index, heap, size);
      BinaryHeapUtilities.leftChildOf(-1, heap, size);

   }
   
   @Test(expected = IndexOutOfBoundsException.class)
   public void leftChild_exception_01_02(){
      Integer heap[] = {0,1,2,3,4,5,6,7};
      BinaryHeapUtilities.leftChildOf(0, heap, 6);
   }
   
   @Test(expected = NoSuchElementException.class)
   public void leftChild_exception_02_01(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
      BinaryHeapUtilities.leftChildOf(7, heap, 12);
   }
   @Test(expected = NoSuchElementException.class)
   public void leftChild_exception_02_02(){
      Integer heap[] = {0,1,2,3,4,5,6,7,8,9,10,11,12};
      BinaryHeapUtilities.leftChildOf(8, heap, 12);
      BinaryHeapUtilities.leftChildOf(9, heap, 12);
      BinaryHeapUtilities.leftChildOf(10, heap, 12);
      BinaryHeapUtilities.leftChildOf(11, heap, 12);
      BinaryHeapUtilities.leftChildOf(12, heap, 12);
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
import static org.junit.Assert.*;
import java.util.Random;
import java.util.Arrays;
import org.junit.*;

public class QuadraticSortsTests 
{   
   @Test
   public void TestBubbleSort01()
   {
      Integer[] test = new Integer[] {8, 6, 7};
      QuadraticSorts.bubbleSort1(test);
      assertEquals(new Integer(6), test[0]);
      assertEquals(new Integer(7), test[1]);
      assertEquals(new Integer(8), test[2]);
   }
    
    @Test
    public void TestBubbleSort02()
    {
       Integer[] test = new Integer[] {4, 1, 3, 2, 5};
       QuadraticSorts.bubbleSort2(test);

       assertEquals(new Integer(1), test[0]);
       assertEquals(new Integer(2), test[1]);
       assertEquals(new Integer(3), test[2]);
       assertEquals(new Integer(4), test[3]);
       assertEquals(new Integer(5), test[4]);
    }
    
    @Test
    public void testSelectionSort(){
       Integer[] test = new Integer[] {3, 1, 2};
       QuadraticSorts.selectionSort(test);
       assertEquals(new Integer(1), test[0]);
       assertEquals(new Integer(2), test[1]);
       assertEquals(new Integer(3), test[2]);
    }
    
    @Test
    public void testInsertionSort()
    {
       Integer[] test = new Integer[] {4, 1, 3, 2, 5};
       QuadraticSorts.insertionSort(test);
       assertEquals(new Integer(1), test[0]);
       assertEquals(new Integer(2), test[1]);
       assertEquals(new Integer(3), test[2]);
       assertEquals(new Integer(4), test[3]);
       assertEquals(new Integer(5), test[4]);
    }
    
    @Test
    public void bubbleSort1TestWithRandom()
    {
       int size = 100;
       Integer[] test = new Integer[size];
       Integer[] arr  = new Integer[size];

       Random rand = new Random(-9999);
       for (int i = 0; i < size; i++) 
       {
          test[i] = rand.nextInt();
          arr[i]  = test[i];
       }
       Arrays.sort(arr);
       QuadraticSorts.bubbleSort1(test);
       for(int i = 0; i < size; i++)
       {
          assertEquals(arr[i], test[i]);
       }
    }
    
    @Test
    public void bubbleSort2TestWithRandom()
    {
       int size = 100;
       Integer[] test = new Integer[size];
       Integer[] arr  = new Integer[size];

       Random rand = new Random(-9999);
       for (int i = 0; i < size; i++) 
       {
          test[i] = rand.nextInt();
          arr[i]  = test[i];
       }
       Arrays.sort(arr);
       QuadraticSorts.bubbleSort2(test);
       for(int i = 0; i < size; i++)
       {
          assertEquals(arr[i], test[i]);
       }
    }
    
    @Test
    public void SelectionSortTestWithRandom()
    {
       int size = 100;
       Integer[] test = new Integer[size];
       Integer[] arr = new Integer[size];

       Random rand = new Random(-9999);
       for (int i = 0; i < size; i++) 
       {
          test[i] = rand.nextInt();
          arr[i] = test[i];
       }
       Arrays.sort(arr);
       QuadraticSorts.selectionSort(test);
       for(int i = 0; i < size; i++)
       {
          assertEquals(arr[i], test[i]);
       }
    }
    
    @Test
    public void InsertionSort1TestWithRandom()
    {
       int size = 100;
       Integer[] test = new Integer[size];
       Integer[] arr = new Integer[size];

       Random rand = new Random(-9999);
       for (int i = 0; i < size; i++) 
       {
          test[i] = rand.nextInt();
          arr[i] = test[i];
       }
       Arrays.sort(arr);
       QuadraticSorts.insertionSort(test);
       for(int i = 0; i < size; i++)
       {
          assertEquals(arr[i], test[i]);
       }
    }
  
}
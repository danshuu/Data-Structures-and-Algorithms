import java.util.Random;

public class TestDriver {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      
      int size = 2500;
      Integer[] array = new Integer[size];
      Random rand = new Random(-9999);
      for (int i = 0; i < size; i++) {
         array[i] = rand.nextInt();
      }
      long t1 = System.currentTimeMillis();
      
      QuadraticSorts.insertionSort(array);
      
      
      
      System.out.println( (System.currentTimeMillis() - t1));
      
      

      
      
   }

}
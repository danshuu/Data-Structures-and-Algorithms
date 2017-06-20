import java.util.Arrays;

//Johnnie Baba
//CPE 103-07
//Lab10


public class QuadraticSorts {
   
   public static <T extends Comparable<? super T>> void bubbleSort1(T[] array){
      int length = array.length;
      T temp;
      boolean swapped = false;
      do{
         swapped = false;
         for(int i = 1; i< length; i++){
            if(array[i-1].compareTo(array[i]) > 0){
               temp = array[i-1];
               array[i-1] = array[i];
               array[i] = temp;
               swapped = true;

            }
         }
      }while(swapped);

   }

   public static <T extends Comparable<? super T>> void bubbleSort2(T[] array){
      int length = array.length;
      boolean swapped = false;
      T temp;
      swapped = false;
      do{
         swapped = false;
         for(int i = 1; i< arrLength; i++){
            if(array[i-1].compareTo(array[i]) > 0){
               temp = array[i-1];
               array[i-1] = array[i];
               array[i] = temp;
               swapped = true;

            }
         }
         arrLength--;
      }while(swapped);      
      
      

   }
   
   public static <T extends Comparable<? super T>> void selectionSort(T[] array){
      int length = array.length;
      T temp;

      for(int i = 0; i< length; i++){
         int min = i;
         for(int j = i +1; j< length; j++){
            if(array[j].compareTo(array[min])< 0){
               min = j;
            }
         }
         if(min != i){
            temp = array[i];
           
            array[i] = array[min];
            array[min] = temp;

         }
      }
   }
   
   public static <T extends Comparable<? super T>> void insertionSort(T[] array){
      int length = array.length;
      T temp;
      for(int i = 1; i<length; i++){
         temp = array[i];
         int j = i-1;
         while(j>=0 && array[j].compareTo(temp)>0){
            array[j+1] = array[j];
            j --;
         }
         array[j+1] = temp;
      }
   }
   
   




}

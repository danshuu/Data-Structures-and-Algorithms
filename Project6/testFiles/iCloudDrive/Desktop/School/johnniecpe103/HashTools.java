import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Johnnie Baba
//CPE 103-07
//Lab 09
public class HashTools {
   
   
   public static <T> int collisions(List<T> list, int tableSize, Hashable<T> hashable) {
      int collisions = 0;
      tableSize = PrimeTools.nextPrime(tableSize);
      boolean[] arr = new boolean[tableSize];
      for(int i = 0; i < list.size(); i ++){
         int ndx = hashable.hash(list.get(i)) % tableSize;
         ndx = Math.abs(ndx);
         if(arr[ndx]== true){
            collisions++;
         }else{
            arr[ndx] = true;
         }
      }
      
      return collisions;
   }
   
   public static <T> int maxCollisions(List<T> list, int tableSize, Hashable<T> hashable){
      tableSize = PrimeTools.nextPrime(tableSize);
      int[] arr = new int[tableSize];
      for(int i = 0; i < list.size(); i ++){
         int ndx = hashable.hash(list.get(i)) % tableSize;
         ndx = Math.abs(ndx);
         if(arr[ndx] != 0){
            arr[ndx] ++;
         }else{
            arr[ndx] = 1;
         }
      }
      Arrays.sort(arr);
      return arr[arr.length-1];
   }
   
   public static <T> double avgCollisions(List<T> list, int tableSize, Hashable<T> hashable) {
      int used = 0;
      double elements = 0;
      tableSize = PrimeTools.nextPrime(tableSize);
      boolean[] arr = new boolean[tableSize];
      for(int i = 0; i < list.size(); i ++){
         int ndx = hashable.hash(list.get(i)) % tableSize;
         ndx = Math.abs(ndx);
         if(arr[ndx]== true){
            elements++;
         }else{
            arr[ndx] = true;
            used++;
            elements++;
         }
      }
      
      return elements / used;
   }
   
   public static <T> int unused(List<T> list, int tableSize, Hashable<T> hashable) {
      double elements = 0;
      tableSize = PrimeTools.nextPrime(tableSize);
      int unused = tableSize;
      boolean[] arr = new boolean[tableSize];
      for(int i = 0; i < list.size(); i ++){
         int ndx = hashable.hash(list.get(i)) % tableSize;
         ndx = Math.abs(ndx);
         if(arr[ndx] == false){
            arr[ndx] = true;
            unused -- ;
         }
      }
      
      return unused;
   }
   

}

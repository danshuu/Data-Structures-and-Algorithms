import java.util.*;

/**
 * Tester.java - A class to play with and test your Lab08b Code.  Your code
 *               MUST compile and run with this tester to receive any credit
 *               for the lab.  Feel free to add to it!!!
 * 
 * @author: Julie Workman
 * @version: 5/16/16 - original
 */
public class Tester8b
{
   public static void main(String[] args)
   {
      IntegerList nums = new IntegerList(10, 100, 1);
      int index;
      
      // should display each int on its own line with no extra spaces after the int
      System.out.println("The unsorted nums:\n" + nums);
    
      nums.mySLOsort(new Descending());
      System.out.println("The nums sorted descending:\n" + nums);
    
      nums.mySLOsort();
      System.out.println("The nums sorted naturally:\n" + nums);
      
      // calls it to make sure it doesn't crash, you should probably test more!
      index = nums.binarySearch(78);
     
      // add code here to test more stuff...
   }
}

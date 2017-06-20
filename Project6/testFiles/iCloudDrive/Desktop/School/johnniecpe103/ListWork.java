//Description: This program will allow the user to search for a target value in an array as well as
//iterate through a given array and display each element to the user
//Name: Johnnie Baba
//CPE 103-07
//Lab 00
import java.util.*;
public class ListWork {

   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int[] intArray = new int[10];
      Integer[] integerArray = new Integer[10];
      boolean askAgain = false;
      int userInput;
      int i = 0;
      while(i<integerArray.length){
         System.out.println("Enter integers");
         try{
            userInput = scan.nextInt();
            intArray[i] = userInput;
            i++;
         }
         catch(InputMismatchException ex){
            scan.nextLine();
         }
      }
		
      System.out.println(Arrays.toString(intArray));
   }
	
   public static <T> void print(T[] arr){
      for(int i=0; i< arr.length; i++){ //Iterate through the whole array and print each integer
         System.out.println(arr[i]);
      }	
   }
	
   public static <T> boolean search(T[] arr, T target){
      boolean result = false;
      for(int i=0; i< arr.length; i++){ //Iterate through the whole array
         if( arr[i]==null ){ //Check if the array has a null value
            if(target==null && arr[i]== target){ //If the null value is also the target value 
               result = true; //result is true if the array and the target value are the same
            }
         }else if(arr[i].equals(target)){ //Otherwise, iterate through the array to see if the target value is in the array
            result = true; //result is true, meaning that the target is in the array
         }
      }
      return result;  //Return the result whether it is true or false
   }
	
}

//Description: This program allows the user to 
//enter up to six integer and float values and display those values in their respective categories
//Name: Johnnie Baba
//CPE 103-07
//Lab: 00

import java.util.*;
public class Separator {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      final int N = 6;
      int[] ints = new int[N]; //create an array to hold N amount of integers
      float[] floats = new float[N]; //create an array to hold N amount of floats
      int floatTotal = 0; //initialize a counter for the number of floats to 0
      int intTotal = 0; //initialize a counter for the number of integers to 0
      while(floatTotal < N + 1 && intTotal < N + 1){
         if(scan.hasNextInt()){ //if the user enters some integers
            if(intTotal == N){ //check if there is space
               break; //if there is no space then stop including the user's integer inputs
            }
            ints[intTotal] = scan.nextInt();
            intTotal++;
         }else if(scan.hasNextFloat()){
            if(floatTotal == N){
               break;
			}
			floats[floatTotal] = scan.nextFloat();
			floatTotal++;
         }else{
            break;
         }		
      }
      System.out.print("Integers: ");
      for(int i=0;i<intTotal;i++){
         System.out.print(ints[i] + " ");
      }
      System.out.println("");
      System.out.print("Floats: ");
      for(int i=0;i<floatTotal; i++){
         System.out.print(floats[i] + " ");
      }
   }

}

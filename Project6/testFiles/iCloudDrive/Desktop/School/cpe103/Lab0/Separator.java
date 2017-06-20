//Lab 0
//Separator - inputs integers and floats, and outputs them on screen in 2 lines
//Integers:
//Floats:
//initialize n as constant, 6; use hasNextInt and hasNextFloat
//stop taking input when: ctrl+D


import java.util.*;
import java.io.*;

public class Separator {

	private static final int n = 6;

	public static void main(String[] args) {

		//initialize the size of the array
		int[] intList = new int[n];
		float[] floatList = new float[n];

		Scanner sc = new Scanner(System.in);

		int tempInt = 0; //only used for while loop to keep iterate through the array
		int tempFloat = 0; //only used for while loop to keep iterate through the array
		String resultInt = ""; //used to concatenate the integers so it can be printed on one line with spaces inbetween
		String resultFloat = ""; //used to concatenate the floats so it can be printed on one line with spaces inbetween

		while (tempInt < n || tempFloat < n) {
			//inputs for integers and floats concurrently until both are filled, or if one is filled and user 
			//tries to add to it again (then it would break)
			//while either list is unfilled

			if (sc.hasNextInt()) { //if next input is integer

				if (tempInt == n) {
					//if intlist is full, and an int is attempted to be added, break and print the lists
					//while the next input is an integer and the intList is already full
					break;

				}

				intList[tempInt] = sc.nextInt(); //set the value of the array position to the input
				resultInt += intList[tempInt] + " ";
				tempInt++; //increment the index of the array

			} else if (sc.hasNextFloat()) { 

				if (tempFloat == n) {
					//if floatlist is full, and a float is attempted to be added, break and print the lists
					//while the next input is a float and the floatList is already full
					break;

				}

				floatList[tempFloat] = sc.nextFloat(); //set the value of the array position to the input
				resultFloat += floatList[tempFloat] + " ";
				tempFloat++; //increment the index of the array

			} else {

				break;

			}

		}

		System.out.println("Integers: " + resultInt);
		System.out.println("Floats: " + resultFloat);

	}

	
}
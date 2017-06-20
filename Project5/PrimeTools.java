/**
* This class contains various methods dealing with prime numbers
* PrimeTools is a standalone class
* Hashable is an interface; do it before StringHash, BetterHash, and MyHash
*
* @author Daniel Shu
* @version Lab9 CPE103
*/

import java.util.NoSuchElementException;

public class PrimeTools {
	//Methods
	public static boolean isPrime(int value) {
		if (value > 2 && value % 2 == 1) { //if odd number greater than 2

		    //if not, then just check the odds
		    // i * i < value because you wouldn't have to worry about the integer values before and after it since they are even numbers
		    // and you don't have to check for even numbers since you are already in this condition
		    for(int i = 3; i * i <= value; i+=2) { //if its not divisible by 3, its not divisible by 3 squared
		        if(value % i == 0) { //check if value divisible by i (i is always odd)
		            return false;
		        }
		    }
		    return true;

		} else if (value == 2) { //if 2
			return true;
		} else { //number less than 2 or even number greater than 2
			return false;	
		} //squared would be a quicker way to check
		

	} //determines if the given number is a positive prime. You may use any algorithm you wish including any that you find online.
	//prime numbers are whole numbers greater than 1, whose only 2 whole-number factors are 1 and itself

	public static int nextPrime(int value) {
		if (value < 0) {
			throw new IllegalArgumentException();
		} 

		if (value >= 0 && value <=2) {
			return 2;
		} else { //value greater than 2
			int increment = value;
			switch (value%2) {
				case 1: //odd number greater than 2
					while (!(isPrime(increment))) {
						if (increment > Integer.MAX_VALUE) {
							throw new NoSuchElementException();
						}

						increment+=2;
					} //end of while

					break;
				case 0: //even number greater than 2
					increment++; //increment = next odd number
					while (!(isPrime(increment))) {
						if (increment > Integer.MAX_VALUE) {
							throw new NoSuchElementException();
						}

						increment+=2;
					} //end of while

					break;
						
				} //end of switch

				return increment;
			}


	} //finds and returns the first prime number greater than or equal to the specified value
}
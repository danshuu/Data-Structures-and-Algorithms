import java.util.*;

public class Lab9 {

	public static void main(String[] args) {
		
//		System.out.println(isPrime(70));
//		int counter = 0;
//		
//		counter = counter + 'Z';
//		
//		System.out.println(counter);
		
//		String sh = "daniel";
//		
//		System.out.println(sh.hashCode());
//			
		
//		System.out.println(hash("DANIEL"));

//		int[] booArr = new int[10];
//		
//		for (int i = 0; i < booArr.length; i++) {
//			System.out.println(booArr[i]);
//		} //will print all false because default boolean array initializes all values to false
//	}
//	
//	private static boolean isPrime(int value) {
//		if (value > 2 && value % 2 == 1) { //if odd number greater than 2
//
//		    //if not, then just check the odds
//		    for(int i=3;i<value;i=i+2) {
//		        if(value%i==0)
//		            return false;
//		    }
//		    return true;
//
//		} else if (value == 2) { //if 2
//			return true;
//		} else { //number less than 2 or even number greater than 2
//			return false;	
//		}
		
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		
//		arr.add(100);
//		arr.add(-100);
//		arr.add(1);
//		arr.add(10);
//		
//		System.out.println(Collections.max(arr));
		
//		int[] primes = new int[] {2, 3, 5, 7, 11};
//		
//		int from = 0;
//		
//		for (int i = 0; i < primes.length; i++) {
//		   for (int j = from; j < primes[i]; j++) {
//		      System.out.println(PrimeTools.nextPrime(j) + " + " + primes[i]);
//		      System.out.println(primes[i]);
//    		  System.out.println(PrimeTools.nextPrime(j));
//		   }
//		   from = primes[i] + 1;
//		}
//		String s = "";
//		System.out.println(s.hashCode());
		System.out.println(PrimeTools.isPrime(9));
	}
	
//	private static int hash(String s) {
//
//		int hash = 0;
//		int len = s.length();
//
//		for (int i = 0; i < len; i++) {
//			// There are 95 displayable ASCII characters, 97 is the next prime
//			hash = hash * 97 + s.charAt(i);
//		}
//
//		return hash;
//
//	} 

	private static int hash(String s) {

		int myHash = 0;
		int len = s.length();

		for (int i = 0; i < len; i++) {
			// There are 95 displayable ASCII characters, 97 is the next prime
			myHash = (myHash * 6) * (s.charAt(i)) + s.charAt(i);
		}

		return myHash;

	} 
	
	private static class PrimeTools {
		//Methods
		public static boolean isPrime(int value) {
			if (value > 2 && value % 2 == 1) { //if odd number greater than 2

			    //if not, then just check the odds
			    // i * i < value because you wouldn't have to worry about the integer values before and after it since they are even numbers
			    // and you don't have to check for even numbers since you are already in this condition
			    for(int i = 3; i * i < value; i+=2) { //if its not divisible by 3, its not divisible by 3 squared
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

}
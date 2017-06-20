import java.util.Scanner;
import java.util.ArrayList;

public class Lab5 {

	public static void main(String[] args) {
		// String [] st={"j"};
		ArrayList<String> stringList = new ArrayList<String>();
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<Double> doubleList = new ArrayList<Double>();;
		System.out.print("Enter an int, double, any random text, or type \"quit\" to end: ");
		Scanner sc = new Scanner(System.in);
		// float that = sc.nextFloat();
		// System.out.println("after defining scanner");
		//convert to int/double if necessary
		while (!sc.hasNext("quit")) {
			// System.out.println(sc.hasNextInt()); 
			// ^ this checks if the one is an int
			if (sc.hasNextInt()) {
				// System.out.println(sc.nextInt()); 
				// Is there a difference in concept between nextDouble/Int() vs. nextLine()?
				intList.add(sc.nextInt()); // is this the input prompt, or the 
				// hasNext(), and this method is just calling it??
				sc.nextLine();
				// System.out.println(sc.hasNextDouble());
			} else if (sc.hasNextDouble()) {
				// System.out.println(sc.nextInt());
				doubleList.add(sc.nextDouble());
				sc.nextLine();
			} else {
				// System.out.println(sc.nextLine());
				stringList.add(sc.nextLine());
				// sc.nextLine(); *** why doesnt this one need to be here?
			}
			System.out.print("Enter an int, double, any random text, or type \"quit\" to end: ");

		}
		// integers
		//prints Integers:
		// Integer[0] is 95, etc etc
		System.out.println("Integers:");
		for (int i = 0; i < intList.size(); i++) {
			System.out.println("	Integer[" + i + "] is " + intList.get(i));
		}

		// Doubles
		//prints Doubles:
		// Double[0] is 95, etc etc
		System.out.println("Doubles:");
		for (int i = 0; i < doubleList.size(); i++) {
			System.out.println("	Double[" + i + "] is " + doubleList.get(i));
		}

		// Other
		//prints Other:
		// Other[0] is 95, etc etc
		System.out.println("Other:");
		for (int i = 0; i < stringList.size(); i++) {
			System.out.println("	Other[" + i + "] is " + stringList.get(i));
		}

// 		if (that != "quit") {
// 			do {
// 				try {

// 				}
// //				try
// //				if (Integer.parseInt(that) instanceof Integerthat instanceof String) {
// //					stringList.add(that);
// //				} else if () {
// //					intList.add(that);
// //				} else if (that instanceof Double) {
// //					doubleList.add(that);
// //				}
// 			} while (input != "quit");
			
		 } //else {
		// 	System.out.println("Integers: ");
		// 	System.out.println("Doubles: ");
		// 	System.out.println("Other: ");
		// }
		
	}



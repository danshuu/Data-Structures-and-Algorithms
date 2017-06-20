import java.util.Scanner;
import java.util.ArrayList;

public class Lab5 {

	public static void main(String[] args) {
		ArrayList<String> stringList;
		ArrayList<Integer> intList;
		ArrayList<Double> doubleList = new ArrayList<Double>();;
		System.out.println("Enter an int, double, any random text, or type \"quit\" to end:");
		Scanner sc = new Scanner(System.in);
		that = sc.nextLine();
		//convert to int/double if necessary
		if (that != "quit") {
			do {
//				try
//				if (Integer.parseInt(that) instanceof Integerthat instanceof String) {
//					stringList.add(that);
//				} else if () {
//					intList.add(that);
//				} else if (that instanceof Double) {
//					doubleList.add(that);
//				}
			} while (input != "quit");
			
			System.out.println("Enter an int, double, any random text, or type \"quit\" to end:");
			Scanner sc = new Scanner(System.in);
			that = sc.nextLine();
		} else {
			System.out.println("Integers: ");
			System.out.println("Doubles: ");
			System.out.println("Other: ");
		}
		
	}

}

/**
* A counter of certain symbols to see if expressions handed in RPNAcceptanceTests were matched, used to help debug
* @author Daniel Shu
* @version Project 2 CPE103
*/

public class CheckIfMatchingSymbols {

	public static void main(String[] args) {

		String expression = args[0];
		String symbol = args[1];

		int count = 0;

		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == symbol.charAt(0)) { 
				count++;
			}
		}

		System.out.println("The " + symbol + " symbol occurred " + count + " times.");

	}
	
}
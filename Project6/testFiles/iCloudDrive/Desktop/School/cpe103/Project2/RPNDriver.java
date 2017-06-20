/**
* Driver for RPN class
* @author Daniel Shu
* @version Project 2 CPE103
*/

public class RPNDriver {

	public static void main(String[] args) {

		//System.out.println(RPN.evaluateRPN(" "));

		System.out.println(RPN.evaluateRPN("5 1 2 + 4 ^ + 3 -"));

		System.out.println(RPN.toRPN("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));

		System.out.println(RPN.evaluateInfix("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));

		System.out.println(RPN.evaluateRPN("2  3 4 5  6  + - *  /"));

		System.out.println(RPN.evaluateRPN("1234"));

		System.out.println(RPN.toRPN("( 2 / ( 3 / ( 4 / 5 ) ) )"));

		System.out.println(RPN.toRPN("5 * ( 6 + 3 - 7 * 3 + 2 ) / 6"));

		System.out.println(RPN.evaluateRPN("38 1.2 * 3.6 2.8 / + 6 - 3.7 2 / 5 / + 3 - 23 + 1.1 / 2.2 + 2.4 5 / - 1 - 1.6 3 / 9 / 2.8 * 3 = 6.2 4 / 12.8 2 * 1.1 / 4.4 3.2 1.1 5.2 / 9.9 * - / - + - +"));

	}

}
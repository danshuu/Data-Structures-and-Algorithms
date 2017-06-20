/**
* A RPN class containing various static methods for reverse polish notation 
* @author Daniel Shu
* @version Project 2 CPE103
*/

public class RPN {
	//no constructor
	public static double evaluateInfix(String infix) {
		String exp = RPN.toRPN(infix); 
		return RPN.evaluateRPN(exp);
	} //evaluates the given infix expression

//*****Can you use scanner to scan an array?*******
	public static double evaluateRPN(String expression) {

		String[] stringSplit = expression.split(" ");
		for (int i = 0; i < stringSplit.length; i++) {
			expression = expression.replace("  ", " ");
		} //modifies the parameter, and gets rid of all double spaces -> makes it into a clean expression with single spaces

		SimpleLinkedStack<Double> stack = new SimpleLinkedStack<Double>();

		double first;
		double second;
		double result = 0;

		String[] strArray = expression.split(" ");

		if (strArray.length == 1) { 
			return Double.parseDouble(strArray[0]); //if expression had only 1 value to begin with, return that value
		} //strArray only holds one expression that has no spaces in it.

		for (String each:strArray) {

			try {

				double thisDouble = Double.parseDouble(each);
				stack.push(thisDouble);

			} catch (NumberFormatException e) {

				if (stack.size() < 2) {
					throw new IllegalArgumentException(expression);
				}

				switch (each) {

					case "^":
						second = stack.pop();
						first = stack.pop(); //gets value that was deeper in stack
						result = Math.pow(first,second);
						stack.push(result);
						break;
					case "*": 
						second = stack.pop();
						first = stack.pop(); //gets value that was deeper in stack
						result = first*second;
						stack.push(result); 
						break;
					case "/":
						second = stack.pop();
						first = stack.pop(); //gets value that was deeper in stack
						result = first/second;
						stack.push(result);
						break;
					case "+":
						second = stack.pop();
						first = stack.pop(); //gets value that was deeper in stack
					 	result = first+second;
						stack.push(result);
						break;
					case "-":
						second = stack.pop();
						first = stack.pop(); //gets value that was deeper in stack
						result = first-second;
						stack.push(result);
						break;

					default:

						throw new IllegalArgumentException(expression);

				} //end of switch

			} //end of catch
		
		} //end of array loop

		//forgot to account for if stack had more than 1 value in the end, but had no more operators.

		if (stack.size() == 1) {
			return result;
		} else {
			throw new IllegalArgumentException(expression);
		} //if there is more than one 


	} //evaluates the given RPN expression
	//every value and operator in the expression must have at least one whitespace character around it
	//exception will be thrown if the expression is not well-formed

	public static String toRPN(String infix) {

		SimpleLinkedStack<String> stack = new SimpleLinkedStack<String>();

		String[] strArray = infix.split(" "); //split the string
		String rpn = "";

		for (String each:strArray) {

			try {

				double thisDouble = Double.parseDouble(each);
				rpn += each + " "; //adds the value to the RPN

			} catch (NumberFormatException e) {

				switch (each) {

					case "^": 

						stack.push(each);
						break;

					case "*":
						if (stack.size() > 0) { //if stack isn't empty, check if top isnt lesser precedence
							//if top of the stack doesn't have lower priority and isn't an opening bracket
							if (!(stack.peek().equals("+")) && !(stack.peek().equals("-")) && !(stack.peek().equals("("))) {
								//if the top of the stack isnt +, -, or (
								while(!(stack.peek().equals("+")) && !(stack.peek().equals("-")) && !(stack.peek().equals("("))) {
									//while the top of the stack isnt +. -, or ()
									String poppedChar = stack.pop();
									rpn += poppedChar + " "; //adds the equal/higher priority operator into the rpn
									//if stacks empty after popping, break out of the while loop
									if (stack.size() == 0) {
										break;
									}
								}
								stack.push(each); //push the original operator into the stack
							} else {
								stack.push(each);
							}
						} else { //if stack is empty, then just push encountered operator
							stack.push(each);
						}

						break;

					case "/":
						if (stack.size() > 0) { //if stack isn't empty, check if top isnt lesser precedence
							if (!(stack.peek().equals("+")) && !(stack.peek().equals("-")) && !(stack.peek().equals("("))) {
								while(!(stack.peek().equals("+")) && !(stack.peek().equals("-")) && !(stack.peek().equals("("))) {

									String poppedChar = stack.pop();
									rpn += poppedChar + " "; //adds the equal/higher priority operator into the rpn

									if (stack.size() == 0) {
										break;
									}
								}
								stack.push(each); //push the original operator into the stack
							} else {
								stack.push(each);
							}
						} else {
							stack.push(each);
						}

						break;
						
					case "+":
						if (stack.size() > 0) { //if stack isn't empty, check if top isnt lesser precedence
							if (!(stack.peek().equals("("))) {
								while (!(stack.peek().equals("("))) {
									String poppedChar = stack.pop();
									rpn += poppedChar + " "; //adds the equal/higher priority operator into the rpn
								
									if (stack.size() == 0) {
										break;
									}
								}
								stack.push(each); //push the original operator into the stack
							} else {
								stack.push(each);
							}
						} else { //if stack is empty, then just push encountered operator
							stack.push(each);
						}

						break;
						
					case "-":
						if (stack.size() > 0) { //if stack isn't empty, check if top isnt lesser precedence
							if (!(stack.peek().equals("("))) {
								while (!(stack.peek().equals("("))) {
									String poppedChar = stack.pop();
									rpn += poppedChar + " "; //adds the equal/higher priority operator into the rpn
								
									if (stack.size() == 0) {
										break;
									}
								}
								stack.push(each); //push the original operator into the stack
							} else {
								stack.push(each);
							}
						} else {
							stack.push(each);
						}

						break;
						
					case "(":
						stack.push(each);
						break;

					case (")"):
						if (stack.size() > 0) { //if stack isn't empty, check if top isnt lesser precedence

							String pop = "";
							while (!(pop.equals("(")) && (stack.size() > 0)) { //while pop doesn't equal to a open bracket and size isn't 0
								//if pop == open bracket, it's popped and nothing should be done
								pop = stack.pop();
								if (!(pop.equals("("))) {
									rpn += pop + " ";
								} else {
									break;
								}

							} //end of while
						} else {
							throw new IllegalArgumentException();
						}

						break;

					default:
						break;

				}

			}

		} //end of String Array loop

		if (stack.size() == 0 && rpn.charAt(rpn.length()-1) == ' ') {
			rpn = rpn.substring(0,rpn.length()-1); //excludes the last element
		} //deletes the last character if the stack is empty and the last char in the rpn is a whitespace

		int stackSize = stack.size(); //store the stackSize
		for (int i = 0; i < stackSize; i++) {
			if (i < stackSize-1) {
				rpn += stack.pop() + " ";
			} else {
				rpn += stack.pop();
			}
		}

		return rpn;
		
	} //Converts the given infix expression to reverse polish notation

} //
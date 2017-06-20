/**
* BSC has one public static method called isBalanced with a parameter type String and return type boolean
* returns true if parameter String, all brackets, braces, and parentheses [], < >, {}, (), are balanced
* Characters other than symbols being checked are skipped and ignored
* method should never throw an exception
* must use SimpleArrayStack in the method
* returns false otherwise
* @author Daniel Shu
* @version Lab3 cpe103
*/

public class BSC {
	//no constructor
	public static boolean isBalanced(String string) { //***why make this method static? 
													//***technically you can just do this with an arraylist?

		//create a simplearraystack
		SimpleArrayStack<Character> chars = new SimpleArrayStack<Character>(); 

		// if (string.length() == 0) {
		// 	return true; 
		// } //empty String is considered balanced
		//unnecessary because chars is the important one, although this may save time, its indubitably going to take more memory

		for (int i = 0; i < string.length(); i++) {

			//experimenting with case switch
			//pushes all opening symbols into the stack
			switch (string.charAt(i)) {
				//Intentional fall through execution
				case '[': 
				case '<':
				case '{': 
				case '(':
					// char newChar = string.charAt(i);
					chars.push(string.charAt(i));
					break;

				case ']':
					if (chars.size() == 0) { //if stack is empty and closing symbol
						return false;
					} else { //if stack isn't empty and closing symbol
						if (chars.pop() != '[') { //if the popped char isn't a opening symbol
							return false;
						}
					} //if stack is empty, return false because first char shouldn't be a closing symbol
					//avoid throwing exceptions
					break;
				case '>':
					if (chars.size() == 0) { //if stack is empty and closing symbol
						return false;
					} else { //if stack isn't empty and closing symbol
						if (chars.pop() != '<') { //if the popped char isn't a opening symbol
							return false;
						}
					} //if stack is empty, return false because first char shouldn't be a closing symbol
					//avoid throwing exceptions
					break;
				case '}':
					if (chars.size() == 0) { //if stack is empty and closing symbol
						return false;
					} else { //if stack isn't empty and closing symbol
						if (chars.pop() != '{') { //if the popped char isn't a opening symbol
							return false;
						}
					} //if stack is empty, return false because first char shouldn't be a closing symbol
					//avoid throwing exceptions
					break;
				case ')':
					if (chars.size() == 0) { //if stack is empty and closing symbol
						return false;
					} else { //if stack isn't empty and closing symbol
						if (chars.pop() != '(') { //if the popped char isn't a opening symbol
							return false;
						}
					} //if stack is empty, return false because first char shouldn't be a closing symbol
					//avoid throwing exceptions	
					break;
				
				default:
					break; //ignore non-symbol characters
				} //end of switch statement

		} //end of the string

		if (chars.size() == 0) {
			return true;
		} else {
			return false;
		} //return true if nothing in the stack, false if otherwise

		// //completely unnecessary for this lab
		// switch (string.charAt(0)) {
		// 	//you can have an intentional "fall through" fpr these blocks of code
		// 	case ']':
		// 		return false;
		// 	case '>':
		// 		return false;
		// 	case '}':
		// 		return false;
		// 	case ')':
		// 		return false;
		// 	default:
		// 		break;
		// } //if first char is a closing symbol, then it isn't balanced

		// switch (string.charAt(string.length()-1)) {
		// 	//you can have an intentional "fall through" fpr these blocks of code
		// 	case '[':
		// 		return false;
		// 	case '<':
		// 		return false;
		// 	case '{':
		// 		return false;
		// 	case '(':
		// 		return false;
		// 	default:
		// 		break;
		// } //if last char is an opening symbol, then it isn't balanced


	} //balanced if every right symbol has its corresponding left counterpart and vice versa; and they have to be correctly arranged

}
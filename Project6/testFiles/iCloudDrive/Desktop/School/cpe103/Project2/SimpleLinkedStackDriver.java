/**
* Test Driver for SimpleLinkedStack
*
* @author Daniel Shu
* @version Project 2 CPE103
*/

public class SimpleLinkedStackDriver {

	public static void main(String args[]) {

		SimpleLinkedStack<Integer> stack = new SimpleLinkedStack<Integer>();

		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}

		for (int i = 0; i < 9; i++) {
			System.out.println(stack.pop());
		}

		stack.push(100);
		stack.push(999);
		stack.push(757);

		int size = stack.size();

		for (int i = 0; i < size; i++) {
			System.out.println(stack.pop());
		}

	}



}
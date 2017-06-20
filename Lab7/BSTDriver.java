/**
* Test Driver for BinarySearchTree
*
* @author Daniel Shu
* @version Lab 7 CPE103
*/

public class BSTDriver {

	public static void main(String args[]) {

		BST<Integer> bst = new BST<Integer>();

		bst.insert(-6615);
		bst.insert(0);
		bst.insert(52);
		bst.insert(245);
		bst.insert(-15);
		bst.insert(55);
		bst.insert(456);
		bst.insert(5);
		bst.insert(123);
		System.out.println("The maximum element of the tree is " + bst.maximum());
		System.out.println("The minimum element of the tree is " + bst.minimum());
		System.out.println(printIf(bst.contains(0)) + 0);
		System.out.println(printIf(bst.contains(12345)) + 12345);

	}

	private static String printIf(boolean contains) {
		if (contains) {
			return "The Binary Search Tree contains ";
		} else {
			return "The Binary Search Tree does not contain ";
		}
	}



}
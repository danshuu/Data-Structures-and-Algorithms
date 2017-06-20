/**
* Test Driver for BinarySearchTree
*
* @author Daniel Shu
* @version Lab 8 CPE103
*/

import java.util.*;

public class BSTDriver {

	public static void main(String args[]) {

		BST<Integer> bst = new BST<Integer>();

		bst.insert(1);
		bst.insert(2);
		bst.insert(12);
		bst.insert(100);
		bst.insert(0);
		bst.insert(9);
		bst.insert(5);
		bst.remove(3);

		// bst.insert(2);
		// bst.insert(4);
		// bst.insert(6);
		// bst.insert(8);
		// bst.insert(7);
		// bst.insert(-15);
		// bst.insert(-6615);
		// bst.insert(0);
		// bst.insert(52);
		// bst.insert(245);

		
		// bst.insert(55);
		// bst.insert(456);
		// bst.insert(5);
		// bst.insert(123);
		// System.out.println("The maximum element of the tree is " + bst.maximum());
		// System.out.println("The minimum element of the tree is " + bst.minimum());
		// System.out.println(printIf(bst.contains(0)) + 0);
		// System.out.println(printIf(bst.contains(12345)) + 12345);
		// BST<Integer> bst = makeTree(makeRandomArray(1000, -387));


		System.out.println("The height of the tree is " + bst.treeHeight());
		System.out.println("The internal path length of the tree is " + bst.internalPathLength());


	}

	private static String printIf(boolean contains) {
		if (contains) {
			return "The Binary Search Tree contains ";
		} else {
			return "The Binary Search Tree does not contain ";
		}
	}


   private static int[] makeRandomArray(int size, int seed)
   {
      int[] array = new int[size];
      Random rand = new Random(seed);

      for (int i = 0; i < size; i++)
      {
         array[i] = rand.nextInt();
      }

      return array;
   }

   private static BST<Integer> makeTree(int[] array)
   {
      BST<Integer> bst = new BST<Integer>();

      for (int i = 0; i < array.length; i++)
      {
         bst.insert(array[i]);
      }

      return bst;
   }



}
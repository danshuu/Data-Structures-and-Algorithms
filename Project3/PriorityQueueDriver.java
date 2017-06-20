/**
* Test Driver for PriorityQueue
*
* @author Daniel Shu
* @version Project 3 CPE103
*/

public class PriorityQueueDriver {

	public static void main(String args[]) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		// for (int i = 100; i < 110; i++) {
		// 	pq.enqueue(i);

		// }
		// System.out.println("The size of the list after the loop is " + pq.size());

		// pq.enqueue(null);
		// pq.enqueue(3);
		// pq.enqueue(5);
		// pq.enqueue(3);
		// pq.enqueue(7);
		// pq.enqueue(5);
		// pq.enqueue(8);
		// pq.enqueue(9);
		// pq.enqueue(6);
		// System.out.println("done enqueuing");
		// int x = pq.dequeue();

		// int removed = pq.remove(1);

		// for (int i = 0; i < 9; i++) {
		// 	System.out.println(stack.pop());
		// }

		// pq.enqueue(500);
		// pq.enqueue(500);
		// pq.enqueue(480);
		// pq.enqueue(25);
		// pq.enqueue(28);
		// pq.enqueue(27);
		// pq.enqueue(27);
		// pq.enqueue(30);
		// pq.enqueue(3);

		// // // pq.enqueue(1);
		// // // pq.enqueue(2);
		// // // pq.enqueue(3);
		// // // pq.enqueue(4);
		// // // pq.enqueue(5);
		// // // pq.enqueue(6);
		// // // pq.enqueue(0);
		// // // pq.enqueue(5);
		// // // pq.enqueue(4);
		// // // pq.enqueue(7);
		// // // pq.enqueue(8);
		// // // pq.enqueue(5);
		// // // pq.enqueue(6);
		// // // pq.enqueue(1);

		// System.out.println("size after enqueueing is " + pq.size());
		// System.out.println("dequeued element is " + pq.dequeue());
		// System.out.println("dequeued element is " + pq.dequeue());
		// System.out.println("dequeued element is " + pq.dequeue());
		// System.out.println("dequeued element is " + pq.dequeue());
		// System.out.println("dequeued element is " + pq.dequeue());
		// System.out.println("dequeued element is " + pq.dequeue());
		// System.out.println("dequeued element is " + pq.dequeue());
		// System.out.println("dequeued element is " + pq.dequeue());
		// int size = pq.size();
		// // int x = pq.dequeue();
		// for (int i = 0; i < size; i++) {
		// 	System.out.println(pq.get(i));
		// }

		// for (int i = 0; i < size; i++) {
		// 	System.out.println(pq.get(i));
		// }

		// System.out.println("The removed element was " + x);
		// System.out.println("Size after dequeueing is " + pq.size());

		// Integer[] intArray = {123,34,567,12,10,100,10000};

		// pq.sort(intArray, intArray.length);
		// for (int i = 0; i < intArray.length; i++) {
		// 	System.out.println(intArray[i]);
		// }

		// System.out.println(pq.kth(intArray, 7, 7));

		//start of efficiency testing
		int size2 = 1000000;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < size2; i++) {
			pq.enqueue(i);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Enqueueing " + size2 + " elements took " + (endTime-startTime) + "ms");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < size2; i++) {
			pq.dequeue();
		}
		endTime = System.currentTimeMillis();
		System.out.println("Dequeueing " + size2 + " elements took " + (endTime-startTime) + "ms");

		Integer[] intList = new Integer[size2];
		for (int i = 0; i < size2; i++) {
			intList[i] = i;
		}

		startTime = System.currentTimeMillis();
		pq.sort(intList,size2);
		endTime = System.currentTimeMillis();
		System.out.println("Sorting " + size2 + " elements took " + (endTime-startTime) + "ms");
	}

	//testing how break works
	// 	boolean flag = true;
	// 	// whileloop:
	// 	while (flag) {
	// 		if (flag) {
	// 			System.out.println("break");
	// 			break;
	// 		}

	// 	}

	// }

}
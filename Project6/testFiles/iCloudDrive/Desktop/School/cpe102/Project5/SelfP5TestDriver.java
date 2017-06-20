public class SelfP5TestDriver {

	public static void main(String[] args) {

		BasicLinkedList<Integer> list = new BasicLinkedList<Integer>();
		// for (int i = 0; i < 5; i++) {
		// 	list.add(i);
		// }
     	int expected[] = {88, 66, 77, 55, 99};
     	int i = 0;
     	list.add(88);
     	// list.add(66);
     	// list.add(77);
     	// list.add(55);
     	// list.add(99);


		BasicListIterator<Integer> iter = list.basicListIterator(); 

		iter.next();
		iter.previous();
      // 	while(iter.hasNext()) {
      // 		System.out.println("iter: " + iter.next() + " expected: " + expected[i++] + " i: " + i);

      // 	}

      // while(iter.hasPrevious())
      // {
      //    System.out.println("iter: " + iter.previous() + " expected: " + expected[--i] + " i: " + i);
      // }
		// System.out.println(list.get(2));
		// System.out.println(list.get(4));
		// // System.out.println(list.get(5));

		// // for (int i = 0; i < 5; i++) {
		// // 	System.out.println(iter.next());
		// // }	

		// while (iter.hasNext()) {
		// 	System.out.println(iter.next());
		// }
		// 	System.out.println("starting previous");

		// while (iter.hasPrevious()) {

		// 	System.out.print(iter.previous() + " , ");
		// }



	}
	
}
package cpe102project5;

public class testDriver {

	public static void main(String[] args) {
		BasicLinkedList<Integer> linkedList = new BasicLinkedList();
		linkedList.add(5);
		linkedList.add(2);
		linkedList.add(100);
		System.out.println(linkedList.head.element);
	}

}

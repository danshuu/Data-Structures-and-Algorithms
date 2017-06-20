
public class SimpleLinkedListDriver {

	public static void main(String[] args) {
		SimpleLinkedList<Integer> myList = new SimpleLinkedList<Integer>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		
		myList.remove(0);
		
		for(int i =0; i<myList.size(); i++){
			System.out.print(myList.get(i));
		}

	}

}

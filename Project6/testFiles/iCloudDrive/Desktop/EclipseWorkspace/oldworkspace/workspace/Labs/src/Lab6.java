
public class Lab6<T> {

	private static Node head;
	private static Throwable stackTrace;
	private static int x = 0;
//	public Lab6() {
////		int pseudoIndex = 0;
//		head= new Node();
//
//	}

	public static void main(String[] args) {
		//practice
		head = new Node();
		addSimple(new Integer(1));
		System.out.println(x);
		addSimple(new Integer(1));
		System.out.println(x);
		addSimple(new Integer(1));
		System.out.println(x);
		addSimple(new Integer(1));
		System.out.println(x);
		
	}

	public static void addSimple(Integer element) {
		addSimple(head, element);
	}

	private static void addSimple(Node node, Integer e){
		stackTrace = new Throwable();

		if(node.next == null){
			x++;
			node.next = new Node(null, e);
			
		} else {

			addSimple(node.next, e);
		}
	}

	public Throwable stackTrace() {
		return stackTrace;
	}
	
//	private Node addHelper(int index, Node node, T e) {
////		stackTrace = new Throwable();
//
//	    if (index < 0 || index > size(head.next)) {
//	    	throw new IndexOutOfBoundsException();
//	    }
//	    int psuedoIndex = 0;
//
//	    if (psuedoIndex == index) {
//	    	return 
//	    } else {
//	    	psuedoIndex++;
//	         node.next = add(index + 1, node.next, e);
//	    }
//	} //end of addhelper
//
	private static class Node {
		public Node next;
		public Integer e;

		public Node() {
		}

		public Node(Node next, Integer e) {
			this.next = next;
			this.e = e;
		}
	}

}
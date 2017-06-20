public class L1TestDriver {
	
	public static void main(String[] args) {

		SimpleLinkedList<Integer> x = new SimpleLinkedList<Integer>();
		x.add(5);
		x.add(1,10);
		x.add(100);
		x.add(null);
		x.remove(1);

		for (int i =0; i < x.size(); i++) {
			System.out.println(x.get(i));
		}

		System.out.println("size: ");
		System.out.println(x.size());

	}

}
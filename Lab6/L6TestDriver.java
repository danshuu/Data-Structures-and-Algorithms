public class L6TestDriver {
	
	public static void main(String[] args) {

		ComplexRecursiveLinkedList<Integer> x = new ComplexRecursiveLinkedList<Integer>();

		x.add(5);
		x.add(1,100);
		x.add(500);
		x.add(3,3);
		x.add(0,10);
		x.add(5,100000);
		x.add(1,1);

		// x.remove(0);



		for (int i =0; i < x.size(); i++) {
			System.out.println(x.get(i));
		}

		System.out.println("size: ");
		System.out.println(x.size());

	}

}
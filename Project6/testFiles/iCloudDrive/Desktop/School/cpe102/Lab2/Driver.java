public class Driver {
	public static void main(String[] args) {
	    // Declare and test a Counter object ...
	    int mod = 5;
	 
		Counter ct = new Counter(mod);

		// some sample tests
		System.out.println("Initial count: " + ct.currentCount()); 
		ct.incrementCount();
		System.out.println("Incremented once: " + ct.currentCount());
		ct.incrementCount();
		for (int i = 0; i < 10; i++) {
			if (ct.currentCount() == mod) {
				ct.rollover();
			} // end of if statement
			System.out.println(ct.currentCount());
			ct.incrementCount();
			
		} // end of for loop
		int beforeReset = ct.currentCount() - 1;
		ct.reset();
		System.out.println("Reset: " + ct.currentCount());

		ct.incrementCount();

		for (int i = 0; i < 10; i++) {
			if (ct.currentCount() == mod) {
				ct.rollover();
			} // end of if statement
			System.out.println(ct.currentCount());
			ct.incrementCount();
			
		} // end of for loop
	         // more tests...
		System.out.println("Unreset: " + beforeReset);
	} // end of main
}
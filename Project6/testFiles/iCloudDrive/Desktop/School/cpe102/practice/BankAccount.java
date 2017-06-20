public class BankAccount {
	private double balance;
	private int accountNumber;
	private static int lastAssignedNumber = 1000;

	public void BankAccount(double balance) {
		lastAssignedNumber++; //updates the static field
		accountNumber = lastAssignedNumber; // sets the instance field
		// this.balance = balance - lastAssignedNumber;
	} //end of method
} // end of main



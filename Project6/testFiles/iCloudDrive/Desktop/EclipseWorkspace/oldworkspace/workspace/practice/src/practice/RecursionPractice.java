package practice;

public class RecursionPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count7(771717177));
		System.out.println(Integer.valueOf("4"));
	}
	
	public static int count7(int n) {
		//base case
		if (n < 7) {
			return 0;
		}
		
		if (n%10 == 7) {
			return 1 + count7(n/10);
			//n/10 always rounds down 
		}
		return count7(n/10);
	}

}


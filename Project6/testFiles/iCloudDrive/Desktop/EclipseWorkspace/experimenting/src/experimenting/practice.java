package experimenting;

public class practice {

	public static void main(String[] args) {
//		String str = "2 4 5 7      8 0       10 1 1 1 1 1";
//		String[] stringSplit = str.split(" ");
//		for (int i = 0; i < stringSplit.length; i++) {
//			str = str.replace("  ", " ");
//		}
//
//		
////		String str = "2  3 4 5  6  + - *  /";
//		String[] split = str.split(" ");
//		String result = "";
//		
//		
//		for (String each: split) {
////			if (each.equals(" ")) {
////				each = "";
////			}
////			for (int i = 0; i < each.length(); i++) {
////				if (each.charAt(i) == ' ') {
////					each.charAt(i) = '';
////				}
////			}
//			each = each.replace(" ", "");
//			System.out.println(each);
//			result += each + " ";
//		}
//		
//		System.out.println(result.substring(0,result.length()-1));
		
//		
//		result += "sup";
//		
//		String[] split2 = result.split(" ");
//		System.out.println(split2.length);

//		String str2 = "11000   ";
//		
//		double thisDouble = Double.parseDouble(str2);
//		
//		System.out.println(thisDouble);
//		
//		for (int i = 0; i < 10; i++) {
//			System.out.println(i); 
//			if (i == 4) {
//				System.out.println("found it");
//				break;
//			}
//		} //tested to see if it would break out of the entire loop or just the current loop
	//testing passing by reference
		
		int x = 5;
//		increment(x);
//		System.out.println(x);
		//doesn't update the variable because java passes by value only.
		if ((x = 6) == 6) {
			System.out.println("Java interprets left to write");
		}
	
	}
	
	private static void increment(int intg) {
		intg++;
	}
	

}

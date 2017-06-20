package practice;
import java.util.*;
//practicing the string methods and scanners
public class practice {
	public static boolean stringE(String bruh) {
		int count = 0;
		for (int i = 0; i < bruh.length(); i++) {
			if (bruh.charAt(i) == 'e') {
				count++;
			} // end of if
		} // end of for loop
		return (count >= 1 && count <= 3);
	}
	public static void main(String[] args) {
//		String x = "aaaaaaa";
//		System.out.println(stringE(x));
////		String y = x.replace("e","");
//		System.out.println(x.replace("aaaaaa","y"));
//		Scanner sc = new Scanner(System.in);
//		int z = sc.nextInt();
//		System.out.println("The integer you inputted was: " + z);
//		Scanner sc2 = new Scanner(System.in);
//		String lol = sc2.next();
//		System.out.println("You typed: " + lol);

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		while (first%2 != 0) {
			first = sc.nextInt();
		}
		int second = sc.nextInt();
		//exclusive for second
		for (int i = first; i < second; i+=2) {
			arrayList.add(i);
			
		}
		for (int i = 0; i < arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}
	}

}

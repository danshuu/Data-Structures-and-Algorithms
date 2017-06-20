package practice;

import java.util.Comparator;

public class Compare {

	public static void main(String[] args) {
//		String x = "hello";
//		String y = "yolo";
//		System.out.println(x.compareTo(y));
//		System.out.println((Integer.valueOf("2")).getClass());
//		System.out.println((String.valueOf(2)).getClass());
//		System.out.println((Integer.toString(2)).getClass());
//		System.out.println((String.valueOf(2)).getClass());
//		System.out.println(true);
		
//		Integer x = 5;
//		int y = 5;
//		
//		System.out.println(x.equals(y));
		
		System.out.println(isPalindrome("AyayAthththththtayayA"));
	}

	public static boolean isPalindrome(String sentence) {
		//use substring method
		//base case: if first letter is equal to last letter, replace with ""
		//if length() == 1 or 0, return true
		//else return false
		if (sentence.length() == 1 || sentence.length() == 0) {
			return true;
		} 

		if (sentence.charAt(0) == sentence.charAt(sentence.length()-1)) {
//			System.out.println(sentence.charAt(0) == sentence.charAt(sentence.length()-1));
			return isPalindrome(sentence.substring(1,sentence.length()-1));
		}
		return false;
		
	}
}

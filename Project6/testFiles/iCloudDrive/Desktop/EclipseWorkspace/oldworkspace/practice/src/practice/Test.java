package practice;
//import java.lang.*;
//import java.awt.*;
import java.util.*;
import java.io.*;

public class Test {
	public static void main(String args[]) {
//		String str1 = "A";
//	    String str2 = new String("S");
//	    String str3 = new String("B");      
//	    int result = str1.compareTo(str2);
//	    System.out.println(result);	      
//	    result = str2.compareTo(str3);
//	    System.out.println(result);
		
//		int[] lst = {5,4,3,1412,1,3};
//	    Arrays.sort(lst,0,lst.length);
//	    for (int i = 0; i < lst.length; i++)
//	    	System.out.println(lst[i]);
	    
//		int num[] = {1,2,3,4};
//		try {
//			System.out.println(num[16]);
//		} catch(IndexOutOfBoundsException e) {
//			System.out.println("Index " + e.getMessage() + " doesn't exist");
//		}
//		try {
//	        throw new IOException();
//	    } catch(IOException e) {
//	         System.out.println("Completed!");
//	    }
		
//		ArrayList x = new ArrayList<Integer>(5);
		//5 is just the capacity
//		x.add(0,4);
//		x.add(1,3);
//		x.add(2,100);
//		x.remove(2);
//
//		int i;
//		for (i=0;i<x.size();i++) {
//			System.out.println(x.get(i));
//		}
		
//		int[] n = {5,3,15,11514,-4};
//		Arrays.sort(n);
//		for (int i = 0; i < n.length; i++) {
//			System.out.println(n[i]);
//		}
		
//		ArrayList<Integer> x = new ArrayList<Integer>(){{
//			add(52);
//			add(0);
//			add(-25);
//			add(100);
//			add(6);
//		}};
		
//		ArrayList<String> x = new ArrayList<String>(Arrays.asList("yo","abc","hello","world","yoyo"));
//
//		Collections.reverse(x);
//		for (int i = 0; i < x.size(); i++) {
//			System.out.println(x.get(i));
//		}
//		System.out.println("ascending order now");
//		Collections.sort(x);
//		for (int i = 0; i < x.size(); i++) {
//			System.out.println(x.get(i));
//		}
//		System.out.println("descending now");
//		Collections.sort(x,Collections.reverseOrder());
//		for (int i = 0; i < x.size(); i++) {
//			System.out.println(x.get(i));
//		}
		
//		String x = "0123456789";
//		System.out.println(x.substring(0,2));
		// return 01, not 012 because its exclusive
		
		System.out.println(isPalindrome("oooooo"));
//		String x = "ho";
//		System.out.println(x.substring(2).length());
		System.out.println(countSpaces("hello there my name is bob"));
		int[] in = {1,-15,25252,100,999,-99,25,50,500,99999};
		System.out.println(findMax(in,2));
		
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
			if (isPalindrome(sentence.substring(1,sentence.length()-1)) == true);
//			System.out.println(sentence.substring(1,sentence.length()-1));
			return true;
		}
		return false;
		
	}
	
	public static int countSpaces(String sentence) {
		if (sentence.length() == 0 || sentence == null) {
			return 0;
		}

		if (sentence.charAt(0) == ' ') { 
			return (1 + countSpaces(sentence.substring(1, sentence.length())));
		} 
		return countSpaces(sentence.substring(1));
	}
	
	public static int findMax(int[] items, int index) {
		//assume index is between 0 and items.length
		//assume array is not empty and integers are > 0
		//base case: return max number if there is only 1 element left
		//recursively increase index to find max
		if (index == items.length-1) {
			return items[items.length-1];
		}
		return Math.max(items[index],findMax(items,index+1));
	}
}
	
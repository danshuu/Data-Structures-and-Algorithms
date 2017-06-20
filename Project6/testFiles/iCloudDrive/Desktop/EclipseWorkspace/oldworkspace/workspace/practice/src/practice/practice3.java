package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class practice3 {

	public static void main(String[] args) {
//		String[] s = new String[5];
//		s[0] = "yo";
//		s[1] = "yo";
//		s[2] = "yo";
//		s[3] = "yo";
//		s[4] = "yo";
//		for (String c: s) {
//			System.out.print(c);
//		}
		
		String x = "kobe bryant";
		String y = new String("yo");
		
//		System.out.println(x == y);
//		System.out.println(x.equals(y));
//		System.out.println('y'+"");
//		System.out.println(doubleChar("heythere"));
//		
//		char a = 'a';
//		
//		String A = "A";
//		
//		System.out.println(a);
//		System.out.println(A);
		
		//length - 1 if you want to rid of the last letter of the string
//		System.out.println(x.substring(0,x.length()-1));  
		
//		ArrayList<String> list = new ArrayList<String>();
//		
//		list.add("yo");
//		list.add(x);
//		list.add(1, "slide in the dms");
//		
//		x = "sup";
//		list.set(0, x);
//		
//		
//		
//		for (String each:list) {
//			System.out.println(each);
//		}
//		
//		String[] newList = new String[list.size()];
//		
//		list.toArray(newList);
//		
//		for (String each:newList) {
//			System.out.println(each);
//		}
		
		ArrayList<Integer> newArrayList = new ArrayList<Integer>(20);
		newArrayList.add(4);
		newArrayList.add(8);
		newArrayList.add(5);
		newArrayList.add(4);
		newArrayList.add(4);

//		System.out.println(newArrayList.size());
		for (int the:newArrayList) {
			System.out.println(the);
		}
		System.out.println("after reverse");
		Collections.reverse(newArrayList);
		for (int i = 0; i < newArrayList.size(); i++) {
		     System.out.println(newArrayList.get(i));
		}		
		
	}
	
	private static String doubleChar(String str) {
		  String newString = "";
		  for (int i = 0; i < str.length(); i++) {
		     newString += 'x';
		  }
		  return newString;
		}
	
	public static void fill_array() {
		Random rdm = new Random();
		Double[] doub = new Double[10];
		for(int i=0;i<doub.length;i++){
			doub[i] = rdm.nextDouble();
		}
	}
	
}





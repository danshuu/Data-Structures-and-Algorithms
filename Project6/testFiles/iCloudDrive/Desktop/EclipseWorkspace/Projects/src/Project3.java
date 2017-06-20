import java.util.*;

public class Project3 {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
//		ArrayList<Integer> arrList2 = new ArrayList<Integer>();
//		arrList.add(null);
//		arrList.add(null);
////		arrList.add(15);
////		arrList.add(3);
//		arrList2.addAll(arrList);
//		Collections.swap(arrList2, 0, 1);
////		
//		Collections.sort(arrList);
//		System.out.println(arrList2);
		for (int i = 0; i < 1000000; i++) {
			arrList.add(i);
		}
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 999999; i++) {
			Collections.swap(arrList, i, i+1);

		}
		long endTime = System.currentTimeMillis();
		System.out.println("The process to change 1000000 elements took " + (endTime-startTime) + "ms");
		System.out.println("The current time is " + System.nanoTime());
		//Conclusion: removing and adding takes MUCH longer than setting
	}

}

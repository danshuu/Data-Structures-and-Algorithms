public class RecursionLab extends java.lang.Object{
	
	//3 static methods must be implemented recursively
	public static int countSpaces(String sentence) {
		//base case: when length of sentence is 0, return 0
		//if the first letter of the string == ' ', 
		//return (1 + the function of substring starting form index 1)
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
		//base case2: 1 element has to be the last element in the array
		//recursively increase index to find max
		if (index == items.length-1) {
			return items[items.length-1];
		}
		return Math.max(items[index],findMax(items,index+1));
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

}

public class whatever {
	public static void main(String[] args) {
		int[] x = {5,3,12,-14,100};
		sort(x);
		int i = 0;
		while (i < x.length) {
			System.out.println(x[i++]);
		}
		whatever that = new whatever();
		whatever that2 = new whatever();
		System.out.println(whatever instanceof whatever);
	}
	
	
	
	public static void sort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[minIndex] > nums[j]) {
					minIndex = j;
				}
			}
			// got the j index that holds the minimum of the list
			int store = nums[minIndex];// stores the minimum
			nums[minIndex] = nums[i];
			nums[i] = store;
		}
	}
}

public class Lab01
//remember to comment after closing brackets
{
   public static void main(String[] args)
   {
      // declaring and initializing some variables
 	int x = 5;
 	String y = "hello";
	double z = 9.8;
 
     
      // printing the variables
	System.out.println("x: " + x + " y: " + y + " z: " + z); 

   
      // a list (make an array in java)
      int[] nums = {3, 6, -1, 2, 1};
   
      //Print the array
	for (int each = 0; each < 5; each++)
	{
	   System.out.println(nums[each]);
	}
     
      
      // call function charCount
	int numFound = charCount(y,'l');
	System.out.println("Found: " + numFound);


   
      // a counting for loop
	for (int i = 1; i < 11; i++)
	{
	   System.out.println(i + ",");
   }
   }//mainFunction charCount find number of character c in string s
  public static int charCount(String s, char c)
   {
	int count = 0;

	for (int ch = 0; ch < s.length(); ch++)
	{
	   if (s.charAt(ch) == c)
	   {
		count++;
	   }
	}
	return count;
   }//method	


}//class

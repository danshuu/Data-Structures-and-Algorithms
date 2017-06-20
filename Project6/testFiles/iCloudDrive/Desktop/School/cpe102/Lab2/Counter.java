/**
 * A simple integer counter.
 *
 * @author Daniel Shu
 * @version Lab 02
 * @version CPE102-05 
 * @version Fall 2016
 */
 
public class Counter 
{
   // instance variables
   private int count; // current count
  
   /**
    * Default constructor: Create a new Counter, with the count 
    * initialized to 0.
    */
   public Counter () 
   {
    count = 0;
   }

   public Counter (int mod) 
   {
   	count = 0;
   }
   /**
    * The number of items counted.
    */
   public int currentCount () 
   { 
   	return count;
   }
  
   /**
    * Increment the count by 1.
    */
   public void incrementCount () 
   {
    count = count + 1;
   }
  
   /**
    * Reset the count to 0.
    */
   public void reset () 
   {
    count = 0;
   }

   // public void unreset ()
   // {
   // 	count = currentCount (); 
   // }

   public void rollover ()
   {
   	count = 0;
   }

   // public void modular ()
   // {
   // 	return mod;
   // }
}
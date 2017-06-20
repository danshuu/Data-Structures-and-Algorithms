import java.util.NoSuchElementException;

//Johnnie Baba
//CPE 103-07
//Lab 09
public class PrimeTools {
   
   
   /**
    * Checks if a number is a positive prime number
    * 
    * @param value
    * @return true if positive prime and false otherwise
    */
   public static boolean isPrime(int value){
      if(value <= 1){
         return false;
      }else{
         if(value == 2){
            return true;
         }else if(value %2==0){
            return false;
         }
         for(int i=3;i*i< value;i+=2) {
            if(value% i ==0){
               return false;
            }
         }
      }

      return true;
   }
   
   public static int nextPrime(int value){
      if(value < 0){
         throw new IllegalArgumentException(); 
      }
      if(value == 1){
         return 1;
      }else if(value == 2){
         return 2;
      }
      
      int retPrime = value;
      

      while(PrimeTools.isPrime(retPrime)==false){
         if(retPrime > 2147483647){
            throw new NoSuchElementException();
         }
         retPrime+= 1;
         
      }


      return retPrime;
   }
}

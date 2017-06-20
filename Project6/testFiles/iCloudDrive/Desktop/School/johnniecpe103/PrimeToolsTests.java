//Johnnie Baba
//CPE 103-07
//Lab 09
import org.junit.*;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
public class PrimeToolsTests {
   
   
   @Test(expected = IllegalArgumentException.class)
   public void errors_01(){
      PrimeTools.nextPrime(-1);
   }
   
   
   @Test
   public void isPrimeNextPrime(){
      assertFalse(PrimeTools.isPrime(1));
      assertEquals(2,PrimeTools.nextPrime(1));
      assertTrue(PrimeTools.isPrime(2));
      assertEquals(2, PrimeTools.nextPrime(2));
      assertEquals(3,PrimeTools.nextPrime(3));
      assertTrue(PrimeTools.isPrime(13));
      assertEquals(13, PrimeTools.nextPrime(13));
      assertTrue(PrimeTools.isPrime(7907));
      assertEquals(7907, PrimeTools.nextPrime(7907));
      assertFalse(PrimeTools.isPrime(7909));
      assertFalse(PrimeTools.isPrime(9));
   }
   
   @Test
   public void isPrimeRework(){
      assertFalse(PrimeTools.isPrime(1));
      assertFalse(PrimeTools.isPrime(0));
      assertTrue(PrimeTools.isPrime(2));
      assertTrue(PrimeTools.isPrime(3));
      assertTrue(PrimeTools.isPrime(5));
      assertTrue(PrimeTools.isPrime(7));
      assertTrue(PrimeTools.isPrime(11));
      assertTrue(PrimeTools.isPrime(13));
      assertTrue(PrimeTools.isPrime(17));
      assertTrue(PrimeTools.isPrime(19));
      assertTrue(PrimeTools.isPrime(23));
      assertTrue(PrimeTools.isPrime(29));
      assertTrue(PrimeTools.isPrime(31));
      assertTrue(PrimeTools.isPrime(37));
      assertTrue(PrimeTools.isPrime(41));
      assertTrue(PrimeTools.isPrime(43));
      assertTrue(PrimeTools.isPrime(47));
      assertTrue(PrimeTools.isPrime(53));
      assertTrue(PrimeTools.isPrime(59));
      assertTrue(PrimeTools.isPrime(61));
      assertTrue(PrimeTools.isPrime(67));
      assertTrue(PrimeTools.isPrime(71));
      assertTrue(PrimeTools.isPrime(73));
      assertTrue(PrimeTools.isPrime(79));
      assertTrue(PrimeTools.isPrime(83));
      assertTrue(PrimeTools.isPrime(89));
      assertTrue(PrimeTools.isPrime(97));
      assertTrue(PrimeTools.isPrime(101));

   }
   
   @Test
   public void tableSizeSample(){
      assertFalse(PrimeTools.isPrime(100));
      assertEquals(PrimeTools.nextPrime(100), 101);
   }

}

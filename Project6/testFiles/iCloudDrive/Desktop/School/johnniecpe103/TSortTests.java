//Johnnie Baba
//CPE 103-07

import org.junit.*;
import static org.junit.Assert.*;
public class TSortTests {
   
   @Test
   public void sample1(){
      assertEquals(TSort.tsort("101 102 102 103 102 225 103 348 348 349 103 357 225 357 349 430 357 430 430 431 348 445"), "101\n102\n225\n103\n357\n348\n445\n349\n430\n431\n");
   }
   
   @Test
   public void sample2(){
      assertEquals(TSort.tsort("blue black red blue red green green blue green purple purple blue"), "red\ngreen\npurple\nblue\nblack\n");
   }
   
   @Test
   public void sample3(){
      assertEquals(TSort.tsort("1 2 1 9 1 8 9 8 9 10 8 11 10 11 2 3 3 11 3 4 4 7 4 5 7 5 7 13 7 6 6 14 6 12"), "1\n9\n10\n8\n2\n3\n4\n7\n6\n12\n14\n13\n5\n11\n");
   }
   
   @Test
   public void sample4(){
      assertEquals(TSort.tsort("3 8 3 10 5 11 7 8 7 11 8 9 11 2 11 9 11 10"), "7\n5\n11\n2\n3\n10\n8\n9\n");
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void exception1(){
      TSort.tsort("");
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void exception2(){
      TSort.tsort("1 2 3 4 5");
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void exception3(){
      TSort.tsort("101 102 102 101 103 225");
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void exception3_1(){
      TSort.tsort("101 102 102 101 102 103");
   }
   
   @Test(expected = IllegalArgumentException.class)
   public void exception3_2(){
      TSort.tsort("101 102 102 103 103 101");
   }
   

}

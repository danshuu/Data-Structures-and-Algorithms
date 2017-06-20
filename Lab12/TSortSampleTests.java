/**
 * JUnit tests for TSort assignment.
 *
 * @author Paul Hatalsky
 * @version 12/2/2016 Developed for CPE 103 Lab 12. 
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TSortSampleTests
{
   @Test
   public void test13_input1() 
   {
      String input = "101 102\n102 103\n102 225 103 348 348 349 103\n357 225 357 349 430 357 430\n\n\n\n430 431 348 445";
      String expect = "101 102 225 103 357 348 445\n349\n430\n431\n";
      String actual = TSort.tsort(input);

      Scanner scanExpect = new Scanner(expect);
      Scanner scanActual = new Scanner(actual);

      while (scanExpect.hasNext())
      {
         assertEquals(scanExpect.next(),scanActual.next());
      }
      assertFalse(scanActual.hasNext());
   }

}
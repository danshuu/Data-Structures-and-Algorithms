/**
 * JUnit test for Huffman class *
 * @author Daniel Shu
 * @version CPE 103 Program 6
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;

public class HuffmanTests {
   // This test has no assertions because it's not testing correctness.  Feel
   // free to modify this test to assert correctness.  Storing the results is
   // done for compile time type checking of your return types.
   @Test
   public void test1() throws FileNotFoundException, IOException {
      // You'll need file0.txt and file0_compressed_solution in the same directory
      String s = Huffman.compress("file0.txt", "file0_compressed.txt");
      assertEquals("| bdca|", s);
      Process proc = Runtime.getRuntime().exec("diff file0_compressed_solution.txt file0_compressed.txt");
      assertEquals(-1, proc.getInputStream().read());  // Verifies that diff had no output
      assertEquals(-1, proc.getErrorStream().read());  // Verifies that diff had no output
      
      Huffman.decompress("file0_compressed.txt", "file0_copy.txt");
      proc = Runtime.getRuntime().exec("diff file0.txt file0_copy.txt");
      assertEquals(-1, proc.getInputStream().read()); // Verifies that diff had no output
      assertEquals(-1, proc.getErrorStream().read()); // Verifies that diff had no output
   }
} 

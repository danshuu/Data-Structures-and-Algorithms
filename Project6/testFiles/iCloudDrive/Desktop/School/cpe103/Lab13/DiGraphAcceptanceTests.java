/**
 * JUnit tests for Dijkstra's Shortest Path assignment.
 *
 * @author Paul Hatalsky
 * @version 03/10/2016 Developed for CPE 103 Lab 13. 
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.*;
import org.junit.runner.Description;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.lang.annotation.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DiGraphAcceptanceTests
{
   private static PrintWriter testSummaryFile;
   private static String longFileString;

   @Retention(RetentionPolicy.RUNTIME)
   @Target({ ElementType.TYPE, ElementType.METHOD})
   @Documented
   public @interface TestDescription {
       public String desc();
   }
   @Rule
   public TestRule watcher = new TestWatcher() {
      protected void starting(Description description) {
         System.out.printf("\b\bStarting: %-60s", description.getMethodName());
         testSummaryFile.printf("Starting: %-60s", description.getMethodName());
      }
   };
   @Rule
   public Stopwatch sw = new Stopwatch() {
      String s;
      protected void finished(long nanos, Description description) {
         System.out.println(s);
         testSummaryFile.println(s);
      }
      protected void succeeded(long nanos, Description description) {
         s = " Passed" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
      }
      protected void failed(long nanos, Throwable e, Description description) {
         s = " FAILED" + " (" + runtime(TimeUnit.MILLISECONDS) + " ms)";
         TestDescription t = description.getAnnotation(TestDescription.class);
         if (t != null)
            s += "\nFailed test description:\n" + t.desc();
      }
   };

   @BeforeClass 
   public static void init() throws FileNotFoundException {
      try {
         testSummaryFile = new PrintWriter("testSummary.txt");
      }
      catch (Exception e) {}
   }

   @AfterClass
   public static void cleanUp() {
      testSummaryFile.close();
   }   
   private static final Class cls = DiGraph.class;
/*
   @Test
   public void test01_verifySuperClass() 
   {
      assertTrue(cls.getSuperclass() == Object.class);
   }

   @Test
   public void test02_verifyInterfaces() 
   {
      Class[] faces = cls.getInterfaces();
      assertTrue(faces.length == 0);
   }

   @Test
   public void test03_verifyFields() 
   {
      Field[] fields = cls.getDeclaredFields();
      assertTrue(fields.length == 1);
   }

   @Test
   public void test04_verifyConstructors() 
   {
      Constructor[] cons = cls.getDeclaredConstructors();
      assertTrue(cons.length <= 1);
   }
*/
   private static DiGraph graph;

   @Test(timeout = 10000)
   public void test05_make9_20() throws FileNotFoundException
   {
      graph = new DiGraph("inputText9.20");
      graph.setStart("v1");
   }
   
   @Test(timeout = 10000)
   public void test06_getPathv1tov6() 
   {
      String expect = "v1 v4 v7 v6";
      String actual = graph.getPathTo("v6").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test07_getDistancev1tov6() 
   {
      assertEquals(6.0, graph.getDistanceTo("v6"), 0.000001);
   }

   @Test(timeout = 10000)
   public void test08_getPathv1tov2() 
   {
      String expect = "v1 v2";
      String actual = graph.getPathTo("v2").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test09_getDistancev1tov2() 
   {
      assertEquals(2.0, graph.getDistanceTo("v2"), 0.000001);
   }

   @Test(timeout = 10000)
   public void test10_getPathv1tov5() 
   {
      String expect = "v1 v4 v5";
      String actual = graph.getPathTo("v5").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test11_getDistancev1tov5() 
   {
      assertEquals(3.0, graph.getDistanceTo("v5"), 0.000001);
   }

   @Test(timeout = 1000)
   @TestDescription(desc="Time allowed: 1000 ms")
   public void test12_makeSparse() throws FileNotFoundException
   {
      graph = new DiGraph("inputSparse");
   }

   @Test(timeout = 200)
   @TestDescription(desc="Time allowed: 200 ms")
   public void test13_startAA() 
   {
      graph.setStart("AA");
   }

   @Test(timeout = 1000)
   @TestDescription(desc="Time allowed: 1000 ms")
   public void test14_makeSparseAndSet() throws FileNotFoundException
   {
      graph = new DiGraph("inputSparse");
      graph.setStart("AA");
   }

   @Test(timeout = 10000)
   public void test15_getPathAAtoAA() 
   {
      String expect = "AA";
      String actual = graph.getPathTo("AA").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test16_getDistanceAAtoAA() 
   {
      assertEquals(0, graph.getDistanceTo("AA"), 0.000001);
   }

   @Test(timeout = 10000)
   public void test17_getPathAAtoBB() 
   {
      String expect = "AA QI KZ BB";
      String actual = graph.getPathTo("BB").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test18_getDistanceAAtoBB() 
   {
      assertEquals(27.5, graph.getDistanceTo("BB"), 0.000001);
   }

   @Test(timeout = 10000)
   public void test19_getPathAAtoCC() 
   {
      String expect = "AA QT QX CC";
      String actual = graph.getPathTo("CC").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test20_getDistanceAAtoCC() 
   {
      assertEquals(25.5, graph.getDistanceTo("CC"), 0.000001);
   }

   @Test(timeout = 10000)
   public void test21_startXJ() 
   {
      graph.setStart("XJ");
   }

   @Test(timeout = 10000)
   public void test22_getPathXJtoIM() 
   {
      String expect = "XJ UE ZY AZ HL IM";
      String actual = graph.getPathTo("IM").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test23_getDistanceXJtoIM() 
   {
      assertEquals(21.5, graph.getDistanceTo("IM"), 0.000001);
   }

   
   @Test(timeout = 1000)
   @TestDescription(desc="Time allowed: 1000 ms")
   public void test24_makeMedium() throws FileNotFoundException
   {
      graph = new DiGraph("inputMedium");
   }
   
   @Test(timeout = 40)
   @TestDescription(desc="Time allowed: 40 ms")
   public void test25_startMediumAA() 
   {
      graph.setStart("AA");
   }

   @Test(timeout = 1000)
   @TestDescription(desc="Time allowed: 1000 ms")
   public void test26_makeMediumAndSet() throws FileNotFoundException
   {
      graph = new DiGraph("inputMedium");
      graph.setStart("AA");
   }
 
   @Test(timeout = 10000)
   public void test27_getMediumPathAAtoAB() 
   {
      String expect = "AA LC DA PK AB";
      String actual = graph.getPathTo("AB").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test28_getMediumDistanceAAtoAB() 
   {
      assertEquals(6.0, graph.getDistanceTo("AB"), 0.000001);
   }

   @Test(timeout = 10000)
   public void test29_getMediumPathAAtoKK() 
   {
      String expect = "AA LN ED VM ZH KK";
      String actual = graph.getPathTo("KK").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test30_getMediumDistanceAAtoKK() 
   {
      assertEquals(7.5, graph.getDistanceTo("KK"), 0.000001);
   }

   @Test(timeout = 4000)
   @TestDescription(desc="Time allowed: 4000 ms")
   public void test31_makeDense() throws FileNotFoundException
   {
      graph = new DiGraph("inputDense");
   }
   
   @Test(timeout = 100)
   @TestDescription(desc="Time allowed: 100 ms")
   public void test32_startDenseQQ() 
   {
      graph.setStart("QQ");
   }

   @Test(timeout = 4000)
   @TestDescription(desc="Time allowed: 4000 ms")
   public void test33_makeDenseAndSet() throws FileNotFoundException
   {
      graph = new DiGraph("inputDense");
      graph.setStart("QQ");
   }
 
   @Test(timeout = 10000)
   public void test34_getDensePathQQtoXX()
   {
      String expect = "QQ RN JK XX";
      String actual = graph.getPathTo("XX").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test35_getDenseDistanceQQtoXX() 
   {
      assertEquals(4.5, graph.getDistanceTo("XX"), 0.000001);
   }

   @Test(timeout = 10000)
   public void test36_getDensePathQQtoVB() 
   {
      String expect = "QQ PT XH VB";
      String actual = graph.getPathTo("VB").trim();
      assertEquals(expect, actual);
   }

   @Test(timeout = 10000)
   public void test37_getDenseDistanceQQtoVB() 
   {
      assertEquals(4.5, graph.getDistanceTo("VB"), 0.000001);
   }
   
   @Test(timeout = 10000, expected = IllegalArgumentException.class) 
   public void test38_inputEmpty() throws FileNotFoundException
   {
      graph = new DiGraph("inputEmpty");
   }
   
   @Test(timeout = 10000, expected = IllegalArgumentException.class) 
   public void test39_inputBadWeight() throws FileNotFoundException
   {
      graph = new DiGraph("inputBadWeight");
   }
   
   @Test(timeout = 10000, expected = IllegalArgumentException.class) 
   public void test40_inputNegativeWeight() throws FileNotFoundException
   {
      graph = new DiGraph("inputNegativeWeight");
   }
   
   @Test(timeout = 10000, expected = IllegalArgumentException.class) 
   public void test41_inputBadFormat() throws FileNotFoundException
   {
      graph = new DiGraph("inputBadFormat");
   }
   
 

}

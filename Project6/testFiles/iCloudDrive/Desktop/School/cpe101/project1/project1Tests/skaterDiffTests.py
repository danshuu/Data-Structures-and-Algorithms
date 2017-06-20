import unittest
import os

class TestCases(unittest.TestCase):
   def test_case0(self):
      os.system("python3 -B project1.py < testCase/test0.txt > studentOut0")
      self.assertEqual(os.system("tr -d '[:space:]' < studentOut0 | diff -wB outputs/test0.txt - &> DIFFout0") >> 8, 0)

   def test_case1(self):
      os.system("python3 -B project1.py < testCase/test1.txt > studentOut1")
      self.assertEqual(os.system("tr -d '[:space:]' < studentOut1 | diff -wB outputs/test1.txt - &> DIFFout1") >> 8, 0)

   def test_case2(self):
      os.system("python3 -B project1.py < testCase/test2.txt > studentOut2")
      result1 = os.system("tr -d '[:space:]' < studentOut2 | diff -wB outputs/test2.txt - &> DIFFout2") >> 8
      result2 = os.system("tr -d '[:space:]' < studentOut2 | diff -wB outputs/test2alt.txt - &> DIFFout2alt") >> 8
      # Allow students to pass even if they corrected the typo in the spec.
      self.assertTrue(result1 == 0 or result2 == 0)

   def test_case3(self):
      os.system("python3 -B project1.py < testCase/test3.txt > studentOut3")
      self.assertEqual(os.system("tr -d '[:space:]' < studentOut3 | diff -wB outputs/test3.txt - &> DIFFout3") >> 8, 0)

   def test_case4(self):
      os.system("python3 -B project1.py < testCase/test4.txt > studentOut4")
      self.assertEqual(os.system("tr -d '[:space:]' < studentOut4 | diff -wB outputs/test4.txt - &> DIFFout4") >> 8, 0)

   def test_case5(self):
      os.system("python3 -B project1.py < testCase/test5.txt > studentOut5")
      result1 = os.system("tr -d '[:space:]' < studentOut5 | diff -wB outputs/test5.txt - &> DIFFout5") >> 8
      result2 = os.system("tr -d '[:space:]' < studentOut5 | diff -wB outputs/test5alt.txt - &> DIFFout5alt") >> 8
      # Allow students to pass even if they printed "0.0" instead of "0.000."
      self.assertTrue(result1 == 0 or result2 == 0)

   def test_case6(self):
      os.system("python3 -B project1.py < testCase/test6.txt > studentOut6")
      self.assertEqual(os.system("tr -d '[:space:]' < studentOut6 | diff -wB outputs/test6.txt - &> DIFFout6") >> 8, 0)

   def test_case7(self):
      os.system("python3 -B project1.py < testCase/test7.txt > studentOut7")
      self.assertEqual(os.system("tr -d '[:space:]' < studentOut7 | diff -wB outputs/test7.txt - &> DIFFout7") >> 8, 0)

# Run the unit tests.
if __name__ == '__main__':
   unittest.main()


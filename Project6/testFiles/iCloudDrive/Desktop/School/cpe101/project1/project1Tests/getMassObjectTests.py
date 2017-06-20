import unittest
from project1 import *

class TestCases(unittest.TestCase):
   def test_getMassObject_1(self):
      self.assertEqual(getMassObject('t'), 0.1)

   def test_getMassObject_2(self):
      self.assertEqual(getMassObject('p'), 1.0)

   def test_getMassObject_3(self):
      self.assertEqual(getMassObject('r'), 3.0)

   def test_getMassObject_4(self):
      self.assertEqual(getMassObject('g'), 5.3)

   def test_getMassObject_5(self):
      self.assertEqual(getMassObject('l'), 9.07)

   def test_getMassObject_6(self):
      self.assertEqual(getMassObject('z'), 0.0)

# Run the unit tests.
if __name__ == '__main__':
   unittest.main()


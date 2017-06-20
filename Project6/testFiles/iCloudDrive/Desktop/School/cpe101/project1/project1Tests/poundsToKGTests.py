import unittest
from project1 import *

class TestCases(unittest.TestCase):
   def test_poundsToKG_1(self):
      self.assertAlmostEqual(poundsToKG(100), 45.3592)
      
   def test_poundsToKG_2(self):
      self.assertAlmostEqual(poundsToKG(140), 63.50288)
      
   def test_poundsToKG_3(self):
      self.assertAlmostEqual(poundsToKG(0), 0.0)

# Run the unit tests.
if __name__ == '__main__':
   unittest.main()


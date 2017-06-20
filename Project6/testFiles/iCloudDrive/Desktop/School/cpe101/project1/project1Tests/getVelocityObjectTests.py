import unittest
from project1 import *

class TestCases(unittest.TestCase):
   def test_getVelocityObject_1(self):
      self.assertAlmostEqual(getVelocityObject(30), 12.12435565)
      
   def test_getVelocityObject_2(self):
      self.assertAlmostEqual(getVelocityObject(50), 15.6524758)
     
   def test_getVelocitySkater_1(self):
      self.assertAlmostEqual(getVelocitySkater(63.50288, 0.1, 12.124355), 0.0190926)
     
   def test_getVelocitySkater_2(self):
      self.assertAlmostEqual(getVelocitySkater(45.3592, 5.3, 15.6524758), 1.8289150)


# Run the unit tests.
if __name__ == '__main__':
   unittest.main()


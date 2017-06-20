import unittest
from landerFuncs import *

class TestCases(unittest.TestCase):
   def testUpdateAcceleration(self):
      self.assertAlmostEqual(updateAcceleration(1.62, 0), -1.62)

   def testUpdateAltitude(self):
      self.assertAlmostEqual(updateAltitude(100.05, 20.6, 1.62), 121.46)
      
   def testUpdateVelocity1(self):
      self.assertAlmostEqual(updateVelocity(50.23, 50.23), 100.46)

   def testUpdateFuel(self):
      self.assertAlmostEqual(updateFuel(5, 1), 4)

# Run the unit tests.
if __name__ == '__main__':
   unittest.main()


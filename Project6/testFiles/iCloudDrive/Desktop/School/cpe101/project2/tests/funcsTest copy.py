#Project 2
#Name: Daniel Shu
#This is the Lunar Module project. In this project I will create a function that will return the resule of certain scenarios that are decided by the user. The program is a game in which the Lunar Module has to land on the ground (altitude of zero) after above ground at a given altitude. With each second that passes by, fuel will be diminishing at an amount based on user's input. When altitude reaches zero, the game is decided on the ending velocity at which the LM reaches the ground.

import unittest
from landerFuncs import *

class TestCases(unittest.TestCase):
   def testUpdateAcceleration1(self):
   	self.assertAlmostEqual(updateAcceleration(1.62, 10), 1.62)

   def testUpdateAcceleration2(self):
   	self.assertAlmostEqual(updateAcceleration(1.62, 5), 0)

   def testUpdateAltitude1(self):
   	self.assertAlmostEqual(updateAltitude(50, 10, 10), 65)

   def testUpdateAltitude2(self):
   	self.assertAlmostEqual(updateAltitude(75.0, 5, 2), 81)
      
   def testUpdateVelocity1(self):
   	self.assertAlmostEqual(updateVelocity(20, 15), 35)

   def testUpdateVelocity2(self):
   	self.assertAlmostEqual(updateVelocity(12, 5), 17)

   def testUpdateFuel1(self):
   	self.assertAlmostEqual(updateFuel(10, 1), 9)

   def testUpdateFuel2(self):
   	self.assertAlmostEqual(updateFuel(20, 9), 11)

# Run the unit tests.
if __name__ == '__main__':
   unittest.main()


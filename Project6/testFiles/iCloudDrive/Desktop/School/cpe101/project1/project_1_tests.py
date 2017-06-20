import unittest
from project1 import *

class TestCases(unittest.TestCase):
    def test_poundsToKG(self):
        self.assertAlmostEqual(poundsToKG(100), 45.3592,\
         msg = "Testing poundsToKG")

    def test_getMassObject(self):
        self.assertEqual(getMassObject('l'), 9.07,\
         msg = "Testing getMassObject")

    def test_getVelocityObject(self):
        self.assertAlmostEqual(getVelocityObject(30), 12.12435565,\
         msg = "Testing getVelocityObject")

    def test_getVelocitySkater(self):
        self.assertAlmostEqual(getVelocitySkater(45.3592, 5.3, 15.6524758),\
         1.8289150, msg = "Testing getVelocitySkater")

if __name__ == '__main__':
    unittest.main()

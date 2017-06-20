#Name: Daniel Shu
#Lab 5
#Programming exercises: 1, 3-5, and 11-14 in section 6.9 of text

import math
#exercise 1
#Old MacDonald song
def exercise1(animal, animalSound):
	# cow = "moo"
	# duck = "quack"
	# dog = "woof"
	# cat = "meow"
	# bird = "chirp"
	print("Old MacDonald had a farm, Ee-igh, Ee-igh, Oh!\nAnd on that farm he had a",animal, "Ee-igh, Ee-igh, Oh!\nWith a",animalSound+",", animalSound, "here and a",animalSound+",", animalSound,"there.\nHere a",animalSound+", there a", animalSound, "everywhere a", animalSound +",", animalSound+".\nOld MacDonald had a farm, Ee-igh, Ee-igh, Oh!")

#exercise 3
#write definitions for these 
def sphereArea(radius):
	area = 4 * math.pi * (radius ** 2)
	return area

def sphereVolume(radius):
	volume = 4/3 * math.pi * (radius ** 3)
	return volume

def exercise3(radius):
	print("The surface area of the sphere having given the radius is", round(sphereArea(radius),2))
	print("The volume of the sphere having given the radius is", round(sphereVolume(radius),2))

#exercise 4
#write definitions for these
def sumN(n):
	#returns the sum of the first n natural numbers
	add = 0
	for i in range(n):
		add = add + i
	return add

def sumNCubes(n):
	#returns the sum of the cubes of the first n natural numbers
	cube = 0
	for i in range(n):
		cube = cube + (i ** 3)
	return cube

def exercise4():
	n = eval(input("Enter a number for n: "))
	print("The sum of the first", n, "natural numbers is", sumN(n))
	print("The sum of the cubes of the first", n, "natural numbers is", sumNCubes(n))

#exercise 5
def pizzaArea(radius):
	area = math.pi * (radius ** 2)
	return area

def costPerSquareInch(radius, price):
	cost_per_square_inch = price/pizzaArea(radius)
	return cost_per_square_inch

def exercise5(radius, price):
	print("The area of the pizza is", round(pizzaArea(radius),2))
	print("The cost per square inch is", round(costPerSquareInch(radius,price),2))

#exercise 11
#squareEach(nums), nums is a list of numbers
#square each entry in the list
def squareEach(nums):
	square_list = []
	for x in range(len(nums)):
		nums[x] = nums[x] ** 2
	return nums

#exercise 12
#sum of the list
def sumList(nums):
	add = 0
	for x in nums:
		add = add + x
	return add

#exercise 13
def toNumbers(strList):
	int_list = []
	for x in range(len(strList)):
		strList[x] = eval(strList[x])
	return strList

#exercise 14
def exercise14():
	file = input("File input: ")
	openFile = open(file, 'r')
	readFile = openFile.read()
	list_numbers = list(readFile)

	integer_list =  toNumbers(list_numbers)
	square_list = squareEach(integer_list)
	sum_list = sumList(square_list)
	print("The sum of the squares of values in the file is", sum_list)

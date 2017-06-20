#Daniel Shu
#CPE 101
#April 8 2016 Friday
#Chapter 3

#exercise 1
#volume = 4/3 pi * r ^ 3
#area = 4 pi * r ^ 2
import math
def exercise1():
	print("This program calculates the volume and surface area of a sphere given the radius.")
	radius = eval(input("Enter a number of inches for radius:"))
	V = 4/3 * math.pi * (radius ** 3)
	A = 4 * math.pi * (radius ** 2)
	print("The volume is equal to ", V,"inches cubed.")
	print("The area is equal to ", A, "inches squared.")

#exercise 2
#cost per square inch of a circular pizza given the diameter and price
#area = pi * r ^ 2
def exercise2():
	print("This program calculates the cost per square inch of a circular pizza.")
	diameter, price = eval(input("Enter a number of inches for diameter and price separated by a comma: "))
	r = diameter/2
	A = math.pi * (r ** 2)
	cost_per_square_inch = round(price/A,3)
	print("The cost per square inch is equal to", cost_per_square_inch, "dollars.")

#exercise 3
#determine the molecular weight of a carbohydrate based on the number of hydrogen, carbon, and oxygen atoms.
#Given the weights (grams/ mole)
#H = 1.0079
#C = 12.011
#O = 15.9994
def exercise3():
	print("The program calulates the molecular weight of a carbohydrate.")
	H_atoms = eval(input("Enter the number of hydrogen atoms: "))
	C_atoms = eval(input("Enter the number of carbon atoms: "))
	O_atoms = eval(input("Enter the number of oxygen atoms: "))
	Weight_H = 1.0079
	Weight_C = 12.011
	Weight_O = 15.994
	molecular_weight = round((H_atoms * Weight_H) + (C_atoms * Weight_C) + (O_atoms * Weight_O),3)
	print("The total molecular weight of a carbohydrate based on the number of atoms is", molecular_weight, "grams per mole.")

#exercise 4
#distance to a lightning strike based on the time elapsed between the flash and the sound of thunder.
#speed of sound = 1100 ft/sec
#1 mile = 5280 ft
def exercise4():
	print("The program calculates the distance to a lightning strike.")
	seconds_elapsed = eval(input("What is the number of seconds elapsed between the flash and sound of thunder? "))
	distance_in_feet = 1100 * seconds_elapsed
	distance_in_miles = round(distance_in_feet/5280,3)
	print("The distance to a lightning strike is", distance_in_miles, "miles")

#exercise 5
#coffee sells $10.50 a pound plus cost of shipping
#each order ships fo $0.86 per pound + $1.50 fixed cost for over head
#calculate the cost of an order
def exercise5():
	print("This program calculates the cost of an order.")
	pounds = eval(input("How many pounds of coffee are there? "))
	coffee = 10.50 * pounds
	shipping = 0.86 * pounds + 1.5
	print("The total cost of an order is", coffee + shipping, "dollars.")

#exercise 6
#calculate the slope of a line through 2 (non-vertical) points entered by the user
#slope = (y2 - y1)/(x2 - x1)
def exercise6():
	print("This program calculates the slope of a line.")
	x1, y1 = eval(input("Enter the x and y values for the 1st coordinate, separated by commas: "))
	x2, y2 = eval(input("Enter the x and y values for the 2nd coordinate, separated by commas: "))
	slope = round((y2 - y1)/(x2 - x1), 1)
	print("The slope of the line is", slope)

#exercise 7
#program that accepts 2 points and determines the distance between them
#distance = ((x2 - x1)**2+(y2-y1)**2)**0.5
def exercise7():
	print("This program calculates the distance between 2 points.")
	x1, y1 = eval(input("Enter the x and y values for the 1st coordinate, separated by commas: "))
	x2, y2 = eval(input("Enter the x and y values for the 2nd coordinate, separated by commas: "))
	distance = round(((x2 - x1)**2+(y2-y1)**2)**0.5, 2)
	print("The distance between the 2 points is", distance)

#exercise11
#find the sum of the first n natural numbers
#have the user provide n
def exercise11():
	print("This program finds the sum of the first n natural numbers.")
	n = eval(input("What is the value of n?: "))
	sum_n = 0
	for i in range(n):
		sum_n = sum_n + i
		print(i, sum_n)
	print("The sum of the first", n, "numbers is", sum_n)

#exercise12
#find the sum of the cubes of the first n natural numbers where value of n is provided by user
def exercise12():
	print("This program finds the sum of cubes of the first n natural numbers.")
	n = eval(input("What is the value of n?: "))
	sum_n_cubed = 0
	for i in range(n):
		sum_n_cubed = sum_n_cubed + (i ** 3)
		print(sum_n_cubed)
	print("The sum of the first", n, "numbers is", sum_n_cubed)

#exercise13
#find the sum of a series of number entered by the user
#prompt the user to input the values of the numbers to be summed
def exercise13():
	print("This program finds the sum of a series of numbers.")
	n = eval(input("Enter a number of numbers to be summed: "))
	sum_of_numbers = eval(input("Enter the value of the number: "))
	for i in range(n-1):
		number_values = eval(input("Enter the value of the number: "))
		sum_of_numbers = number_values + sum_of_numbers 
		print(sum_of_numbers)
	print("The sum of the", n, "numbers is equal to", sum_of_numbers)

#exercise15
#approximates the value of pi by summing the terms of this series:
# 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + ...
#prompt the user to input the number for n, the number of terms to sum, and then output the sum of the first n terms of the series
def exercise15():
	print("This program approximates the value of pi using a series: 4/1 - 4/3 + 4/5 - 4/7 + 4/9 - 4/11 + ...")
	n = eval(input("Enter the number for n, the number of terms to sum: "))
	numerator = 4
	denominator = 1
	negative = -1
	sum_series = 0
	for i in range(n):
		negative = negative * (-1) 
		denominator = (2 * i + 1) * negative
		sum_series = sum_series + numerator/denominator
		print(numerator, denominator, negative, numerator/denominator, sum_series)
	print("The sum of the series is", sum_series)

#exercise16
#Fibonacci sequence of numbers where each successive number is the sum of the previous 2
#1, 1, 2, 3, 5, 8, 13, ...
#n is a value input by the user
def exercise16():
	print("This program computes the sum of the two preceding numbers in a Fibonacci sequence, given the nth term.")
	n = eval(input("Enter the number for n for the nth term value in which the last two numbers are summed: "))
	first_preceding_number = 0
	last_preceding_number = 1
	Fibonacci = 1
	for i in range(n-1):
		Fibonacci = first_preceding_number + last_preceding_number
		first_preceding_number = last_preceding_number
		last_preceding_number = Fibonacci
	print("The", n,"th term in the Fibonacci sequence is", Fibonacci,".")

	

#Daniel Shu
#CPE101
#April 6 2016
#Chapter 2

#exercise 1
#convert.py
def exercise1():
	print("This program converts Celsius into Fahrenheit.")
	Celsius = eval(input("What is the Celsius temperature? "))
	Fahrenheit = (9/5)*Celsius + 32
	print("The temperature is", Fahrenheit, "degrees Fahrenheit.")

#exercise 3
#avg2.py
# a simple program to average 2 exam scores
# Illustrates use of multiple input
def exercise3():
	print("This program computes the average of three exam scores.")
	score1, score2, score3 = eval(input("Enter 3 scores separated by commas: "))
	average = (score1 + score2 + score3)/3
	print("The average of the scores is:", average)

#exercise 4
#convert.py
#loop 5 times
def exercise4():
	print("This program converts celsius into Fahrenheit.")
	for i in range(5):
		Celsius = eval(input("What is the Celcius temperature? "))
		Fahrenheit = (9/5)*Celsius + 32
		print(Fahrenheit)

#exercise 5
#convert.py
#10 degree increments
def exercise5():
	print("This program converts Celsius into Fahrenheit.")
	Celcius = 0
	for i in range(11):
		Fahrenheit = (9/5)*Celcius + 32
		print(Celcius, Fahrenheit)
		Celcius = Celcius + 10

#exercise 9
#convertbackwards.py
#Fahrenheit to Celsius
def exercise9():
	print("This program converts Fahrenheit into Celcius.")
	Fahrenheit = eval(input("What is the Fahrenheit temperature? "))
	Celsius = (Fahrenheit - 32)*(5/9)
	print(Celsius)

#exercise 10
#convert km to miles
#1 km = 0.62 miles
def exercise10():
	print("This program converts kilometers to miles.")
	Kilometers = eval(input("What is the number of kilometers? "))
	Miles = Kilometers*0.62
	print(Miles, "miles")

#exercise 11
#convert feet to inches
#1 foot = 12 inches
def exercise11():
	print("This program converts inches into feet.")
	inches = eval(input("What is the number of inches? "))
	feet = inches *(1/12)
	print(feet, "feet")

#exercise 12
#python calculator program
#mathematical expression
#loop up to 100
def exercise12():
	print("This program allows the user to type a mathematical expression and calculate the value.")
	for i in range(100):
		expression = eval(input("Type a mathematical expression. "))
		print(expression)
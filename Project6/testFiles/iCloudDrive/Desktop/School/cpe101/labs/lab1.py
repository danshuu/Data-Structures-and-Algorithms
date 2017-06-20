#Daniel Shu
#April 1, 2016
#CPE 101-05

#File: chaos.py
#A simple program illustrating chaotic behavior

#exercise 2
def exercise2():
    print("This program illustrates a chaotic function")
    x = eval(input("Enter a number between 0 and 1: "))
    for i in range (10):
        x = 3.9 * x * (1 - x)
        print (x)

#The 2 programs are behaving differently in that exercise 2 spits out a smaller number because it is a function of 2.0 compared to 3.9 in exercise 3.

#exercise 3
def exercise3():
    print("This program illustrates a chaotic function")
    x = eval(input("Enter a number between 0 and 1: "))
    for i in range (10):
        x = 2.0 * x * (1 - x)
        print (x)

#exercise 4
def exercise4():
    print("This program illustrates a chaotic function")
    x = eval(input("Enter a number between 0 and 1: "))
    for i in range (20):
        x = 2.0 * x * (1 - x)
        print (x)

#exercise 5
def exercise5():
    print("This program illustrates a chaotic function")
    n = eval(input("How many numbers should I print?"))
    x = eval(input("Enter a number between 0 and 1: "))
    for i in range (n):
        x = 2.0 * x * (1 - x)
        print (x)

#exercise 6
def exercise6():
    print("This program illustrates a chaotic function")
    x = eval(input("Enter a number between 0 and 1: "))
    for i in range (100):
        x = 3.9 * x * (1 - x)
        print (x)
    x = eval(input("Enter a number between 0 and 1: "))
    for i in range (100):
        x = 3.9 * (x - x * x)
        print (x)
    x = eval(input("Enter a number between 0 and 1: "))
    for i in range (100):
        x = 3.9 * x - 3.9 * x * x
        print (x)

#The results are the same for the first input by using the same number. This makes sense because the equations are equivalent to each other. After the first number, the numbers returned differ from each other, which is most likely due to the arbitrary numbers being inputted into the function within the given range.

#exercise 7
def exercise7():
    print("This program illustrates a chaotic function")
    x = eval(input("Enter a number between 0 and 1:"))
    y = eval(input("Enter a number between 0 and 1:"))
    for i in range (10):
        x= 3.9 * x * (1-x)
        y= 3.9 * y 
        print (x, y)
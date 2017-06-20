#Daniel Shu
#lab 6
#Programming exercises 3-5, and 11 in chapter 13.6

#exercise 3
#palindrome is a sentence that is read the same way if spelled forwards or backwards
import string
def exercise3():
	print("This program checks an inputted phrase for whether or not it is a palindrome.")
	phrase = input("Enter a phrase: ")
	forwardWord = ""
	backwardWord = ""
	punctuation = string.punctuation
	for x in range(len(phrase)):
		flagBackward = 0
		backwardIndex = - x - 1
		for punc in punctuation:
			if phrase[backwardIndex] == punc or phrase[backwardIndex] == " ":
				flagBackward = 1
		if flagBackward == 0:
			backwardWord = backwardWord + phrase[backwardIndex]
	for y in range(len(phrase)):
		flagForward = 0
		for punc in punctuation:
		#y is the forward index
			if phrase[y] == punc or phrase[y] == " ":
				flagForward = 1
		if flagForward == 0:
			forwardWord = forwardWord + phrase[y]
	lowerbackward = backwardWord.lower()
	lowerforward = forwardWord.lower()
	if lowerbackward == lowerforward:
		print("This is a palindrome.")
	else:
		print("This is not a palindrome.")

#exercise4
#recursive function that finds the largest number in a list
def exercise4(intList):
	if len(intList) == 1:
		return intList[0]
	else:
		maxNum = exercise4(intList[1:])
		if maxNum > intList[0]:
			return maxNum
		else: 
			return intList[0]

#exercise 5 allows the user to enter a number and a base and then prints out the num//base and then the num%base
# def baseConversion(num, base):




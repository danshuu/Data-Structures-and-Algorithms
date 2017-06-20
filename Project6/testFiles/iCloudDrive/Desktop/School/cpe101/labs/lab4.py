#Daniel Shu
#CPE-101
#April 15, 2016
#Lab 4
#exercises 2-4, 7, 9, 10, and 14

#exercise2
#input quiz score, print out grade
#5-A 4-B 3-C 2-D 1-F 0-F
def exercise2():
	print("This exercise prints out your grade depending on your quiz score out of 5.")
	grade = "FFDCBA"
	quiz_score = int(input("What is your quiz score in integer form out of 5? "))
	print("Your quiz score is", grade[quiz_score])

#exercise3
#input exam score, print out grade
def exercise3():
	print("This exercise prints out your grade depending on your exam score out of 100.")
	quiz_score = eval(input("What is your exam score in integer form out of 100? "))
	if 90 <= quiz_score <= 100:
		print("A")
	elif 80 <= quiz_score < 90:
		print("B")
	elif 70 <= quiz_score < 80:
		print("C")
	elif 60 <= quiz_score < 70:
		print("D")
	elif quiz_score < 60:
		print("F")
		
#exercise4 5 4 3 2
#This program allows the user to type in a phrase and output the acronym for that phrase.
#acronym is all CAPS
def exercise4():
	print("This exercise prints out the acronym in all uppercase of a phrase.")
	phrase = input("Enter a phrase separated by spaces. ")
	slist = phrase.split()
	result = ""
	for i in range(len(slist)):
		result = result + slist[i][0].capitalize()
	print(result)

#exercise7
#caesar cipher code based on key value input
#if user inputs the word 'sourpuss', it would be encoded as 'uqwtrwuu'
def exercise7():
	message = input("What is the string of plaintext? ")
	key = eval(input("What is the key value used to shift the message? "))
	encoded_message = ""
	for x in message:
		if ord(x) + key > 122:
			code = chr(64 + (ord(x) + key)%122)
		elif ord(x) + key < 65:
			code = chr(122 - 64%(ord(x) + key))
		else: 
			code = chr(ord(x) + key)
		encoded_message = encoded_message + code
		#concatenation
	print(encoded_message)


#exercise9
#count the number of words in a sentence entered by the user
def exercise9():
	sentence = input("Enter a sentence: ")
	words = sentence.split()
	concatenation = ""
	#assigning concatenation to a var
	for x in words:
		concatenation = concatenation + x + " "
	print("The number of words in the sentence is", concatenation.count(" "))

#exercise10
#program that calculates the average word length in a sentence entered by user
def exercise10():
	sentence = input("Enter a sentence: ")
	words = sentence.split()
	concatenation = ""
	no_spaces = ""
	for x in words:
		concatenation = concatenation + x + " "
		#entire sentence with spaces
		#used to count the number of words in a sentence
		no_spaces = no_spaces + x
		#entire sentence without spaces
		#used to count the number of total letters in a sentence excluding spaces
	print("The average word length in the sentence is", len(no_spaces)/concatenation.count(" "))
	print(words[0])

#exercise14
#word count; this program analyzes a file to determine the number of 
#lines, words, and characters contained therein.
#input file name and then print 3 numbers showing the count of 
#lines, words, and characters in the file



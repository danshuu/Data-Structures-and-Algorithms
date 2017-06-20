#Project 4
#Name: Daniel Shu
#Project Description: This project allows the user to input a list of 100 characters
#and search for certain words within the 10 x 10 puzzle that can be exposed 
#if the word is spelled frontwards, backwards, upwards, or downwards
from funcs import*

def main():
	puzzle = input()
	# puzzle_list = list(puzzle)
	#turn string into list
	words = input()
	words_list = words.split()
	row1 = puzzle[0:10]
	row2 = puzzle[10:20]
	row3 = puzzle[20:30]
	row4 = puzzle[30:40]
	row5 = puzzle[40:50]
	row6 = puzzle[50:60]
	row7 = puzzle[60:70]
	row8 = puzzle[70:80]
	row9 = puzzle[80:90]
	row10 = puzzle[90:100]
	crossword = [row1, row2, row3, row4, row5, row6, row7, row8, row9, row10]
	#crossword is a list of strings

	#backwards puzzle utilizes puzzle string and reverses it
	backwards_puzzle = ''.join(reversed(puzzle))
	reverse_row1 = backwards_puzzle[0:10]
	reverse_row2 = backwards_puzzle[10:20]
	reverse_row3 = backwards_puzzle[20:30]
	reverse_row4 = backwards_puzzle[30:40]
	reverse_row5 = backwards_puzzle[40:50]
	reverse_row6 = backwards_puzzle[50:60]
	reverse_row7 = backwards_puzzle[60:70]
	reverse_row8 = backwards_puzzle[70:80]
	reverse_row9 = backwards_puzzle[80:90]
	reverse_row10 = backwards_puzzle[90:100]
	#list of rows after reversing the original string
	crosswordReverse = [reverse_row1, reverse_row2, reverse_row3, reverse_row4, reverse_row5, reverse_row6, reverse_row7, reverse_row8, reverse_row9, reverse_row10]
	# print(crosswordReverse)
	#down puzzle utilizes puzzle string and turns the columns into rows and rows into columns
	downwards_puzzle_list = []
	for column in range(len(crossword)):
		for row in crossword:
			downwards_puzzle_list.append(row[column])
	downwards_puzzle = ''.join(downwards_puzzle_list)
	down_row1 = downwards_puzzle[0:10]
	down_row2 = downwards_puzzle[10:20]
	down_row3 = downwards_puzzle[20:30]
	down_row4 = downwards_puzzle[30:40]
	down_row5 = downwards_puzzle[40:50]
	down_row6 = downwards_puzzle[50:60]
	down_row7 = downwards_puzzle[60:70]
	down_row8 = downwards_puzzle[70:80]
	down_row9 = downwards_puzzle[80:90]
	down_row10 = downwards_puzzle[90:100]
	#list of rows after columns were converted into the rows
	crosswordDown = [down_row1, down_row2, down_row3, down_row4, down_row5, down_row6, down_row7, down_row8, down_row9, down_row10]
	# print(crosswordDown)
	#up puzzle is just the reverse of down puzzle
	upwards_puzzle = ''.join(reversed(downwards_puzzle))
	up_row1 = upwards_puzzle[0:10]
	up_row2 = upwards_puzzle[10:20]
	up_row3 = upwards_puzzle[20:30]
	up_row4 = upwards_puzzle[30:40]
	up_row5 = upwards_puzzle[40:50]
	up_row6 = upwards_puzzle[50:60]
	up_row7 = upwards_puzzle[60:70]
	up_row8 = upwards_puzzle[70:80]
	up_row9 = upwards_puzzle[80:90]
	up_row10 = upwards_puzzle[90:100]
	#list of rows after columns were converted into rows, and then reversed
	crosswordUp = [up_row1, up_row2, up_row3, up_row4, up_row5, up_row6, up_row7, up_row8, up_row9, up_row10]

	print("Puzzle: \n")
	print(row1)
	print(row2)
	print(row3)
	print(row4)
	print(row5)
	print(row6)
	print(row7)
	print(row8)
	print(row9)
	print(row10)
	print("")


	for word in words_list:
		if checkDirection(crossword, crosswordReverse, crosswordDown, crosswordUp, word) != "word not found":
			print(word + ":", checkDirection(crossword, crosswordReverse, crosswordDown, crosswordUp, word), "row:", checkRow(crossword, crosswordReverse, crosswordDown, crosswordUp, word), "column:", checkColumn(crossword, crosswordReverse, crosswordDown, crosswordUp, word))
		else:
			print(word + ": word not found")

if __name__ == '__main__':
	main()


	# print(crosswordUp)
	# print(up_row1)
	# print(up_row2)
	# print(up_row3)
	# print(up_row4)
	# print(up_row5)
	# print(up_row6)
	# print(up_row7)
	# print(up_row8)
	# print(up_row9)
	# print(up_row10)

#print out the 10 x 10 puzzle
	# print(reverse_row1)
	# print(reverse_row2)
	# print(reverse_row3)
	# print(reverse_row4)
	# print(reverse_row5)
	# print(reverse_row6)
	# print(reverse_row7)
	# print(reverse_row8)
	# print(reverse_row9)
	# print(reverse_row10)

	# print(down_row1)
	# print(down_row2)
	# print(down_row3)
	# print(down_row4)
	# print(down_row5)
	# print(down_row6)
	# print(down_row7)
	# print(down_row8)
	# print(down_row9)
	# print(down_row10)

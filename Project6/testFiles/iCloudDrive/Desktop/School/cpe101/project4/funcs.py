
def checkForward(crossword, word):
	index = 0
	#index is the word's index
	full_word = ""
	for row in crossword:
		y = 0
		#y represents the word's row's index
		checking = False
		while y < len(row):
		# for y in range(len(row)): 
			#range is always 10
			if word[index] == row[y]: # and word[index + 1] == row[y + 1]:
				full_word = full_word + word[index]
				index += 1
				checking = True
				if full_word == word:
					return True
			else:
				if checking == True:
					index = 0
					y = y - 1
					full_word = ""
				else:
					index = 0
					full_word = ""
				checking = False
			y += 1
	return False

def checkBackward(crosswordReverse, word):
	index = 0
	full_word = ""
	for row in crosswordReverse:
		y = 0
		checking = False
		while y < len(row):
		# for y in range(len(row)): 
			#range is always 10
			if word[index] == row[y]: # and word[index + 1] == row[y + 1]:
				full_word = full_word + word[index]
				index += 1
				checking = True
				if full_word == word:
					return True
			else:
				if checking == True:
					index = 0
					y = y - 1
					full_word = ""
				else:
					index = 0
					full_word = ""
				checking = False
			y += 1
	return False

def checkDown(crosswordDown, word):
	index = 0
	full_word = ""
	for row in crosswordDown:
		y = 0
		checking = False
		while y < len(row):
		# for y in range(len(row)): 
			#range is always 10
			if word[index] == row[y]: # and word[index + 1] == row[y + 1]:
				full_word = full_word + word[index]
				index += 1
				checking = True
				if full_word == word:
					return True
			else:
				if checking == True:
					index = 0
					y = y - 1
					full_word = ""
				else:
					index = 0
					full_word = ""
				checking = False
			y += 1
	return False

def checkUp(crosswordUp, word):
	index = 0
	full_word = ""
	for row in crosswordUp:
		y = 0
		checking = False
		while y < len(row):
		# for y in range(len(row)): 
			#range is always 10
			if word[index] == row[y]: # and word[index + 1] == row[y + 1]:
				full_word = full_word + word[index]
				index += 1
				checking = True
				if full_word == word:
					return True
			else:
				if checking == True:
					index = 0
					y = y - 1
					full_word = ""
				else:
					index = 0
					full_word = ""
				checking = False
			y += 1
	return False

def checkDirection(crossword, crosswordReverse, crosswordDown, crosswordUp, word):
	if checkForward(crossword, word) == True:
		forward = "(FORWARD)"
		return forward
	elif checkBackward(crosswordReverse, word) == True:
		backward = "(BACKWARD)"
		return backward
	elif checkDown(crosswordDown, word) == True:
		down = "(DOWN)"
		return down
	elif checkUp(crosswordUp, word) == True:
		up = "(UP)"
		return up
	else: 
		unfound = "word not found"
		return unfound

def checkRow(crossword, crosswordReverse, crosswordDown, crosswordUp, word):
	#SHOULD BE 9 - ROW???
	index = 0
	#crossword, crosswordReverse, crosswordDown, and crosswordUp
	#are all lists of rows in arranged order
	for row in range(len(crossword)):
		column = crossword[row].find(word)
		if column != -1:
			return row
	for row in range(len(crosswordReverse)):
		column = crosswordReverse[row].find(word)
		if column != -1:
			realRow = 9 - row
			return realRow
	for row in range(len(crosswordDown)):
		column = crosswordDown[row].find(word)
		if column != -1:
			return column
	for row in range(len(crosswordUp)):
		column = crosswordUp[row].find(word)
		if column != -1:
			realColumn = 9 - column
			return realColumn

#use find function to determine the column of the word
def checkColumn(crossword, crosswordReverse, crosswordDown, crosswordUp, word):
	#SHOULD BE 9 - COLUMN???
	index = 0
	for row in range(len(crossword)):
		column = crossword[row].find(word)
		if column != -1:
			return column
	for row in range(len(crosswordReverse)):
		column = crosswordReverse[row].find(word)
		if column != -1:
			realColumn = 10 - column
			return realColumn
	for row in range(len(crosswordDown)):
		column = crosswordDown[row].find(word)
		if column != -1:
			return row		
	for row in range(len(crosswordUp)):
		column = crosswordUp[row].find(word)
		if column != -1:
			realRow = 9 - row
			return realRow



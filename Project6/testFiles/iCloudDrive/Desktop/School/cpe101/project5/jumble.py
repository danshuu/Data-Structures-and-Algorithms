def main(fileName):
	openFile = open(fileName, 'r')
	readFile = openFile.read()
	listWords = readFile.split()
	# print(listWords)
	jumbledWord = input("Please enter a jumbled word: ")
	jumbledAnagrams = anagrams(jumbledWord.lower())

	foundWords = []
	accumulator = 0	
	for word in listWords:
		for jumble in jumbledAnagrams:
			if word == jumble:
				foundWords.append(word)
				accumulator = accumulator + 1
	if accumulator == 0:
		print("Your word cannot be unjumbled.")
	elif accumulator == 1:
		print("Your word is", foundWords[0] + ".")
	elif accumulator > 1:
		print("Your words are:")
		for words in foundWords:
			print(words)


def anagrams(jumbledWord):
	if jumbledWord == "":
		return [jumbledWord]
	else:
		anagram_list = []
		for w in anagrams(jumbledWord[1:]):
			for pos in range(len(w) + 1):
				anagram_list.append(w[:pos] + jumbledWord[0] + w[pos:])
		realAnagramList = list(set(anagram_list))
		return realAnagramList

if __name__ == '__main__':
	main('words.txt')
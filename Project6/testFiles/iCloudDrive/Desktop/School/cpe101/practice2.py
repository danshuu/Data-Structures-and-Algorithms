#practice continued
import string
import math

def sequence(intList):
	countList = []
	accumulator = 1
	for each in range(len(intList) - 1):
		if intList[each] == intList[each + 1]:
			accumulator = accumulator + 1
			countList.append(accumulator)
		else: 
			accumulator = 1
			countList.append(accumulator)
	countList.sort()
	longestCont = countList[-1]
	return longestCont

def sum_2D(list_lists):
	add = 0
	for each in list_lists:
		for num in each:
			add = add + each[num]
	return add

def sum_2D_indices(list_lists):
	add = 0
	for each in list_lists:
		for num in range(len(each)):
			add = add + each[num]
	return add

def search_2D(list_lists, search):
	searchList = []
	for each in range(len(list_lists)):
		for num in range(len(list_lists[each])):
			if list_lists[each][num] == search:
				searchList.append((each, num))
	return searchList
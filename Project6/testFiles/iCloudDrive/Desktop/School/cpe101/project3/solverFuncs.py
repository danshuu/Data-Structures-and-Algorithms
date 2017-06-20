# Project 3
# Name: Daniel Shu
# This project helps the user solve a calcudoku puzzle taking into account the number of cages, cage sum, number of cells within the cage, and the cage cell positions.

#POSITIONS of cells
# 0  1  2  3  4 
# 5  6  7  8  9
# 10 11 12 13 14
# 15 16 17 18 19
# 20 21 22 23 24

#inputs: # of cages
# cage_sum #number_of_cells cell_list

#cell_list = 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
#row1 = 0  1  2  3  4
#row2 = 5  6  7  8  9	
#row3 = 10 11 12 13 14
#row4 = 15 16 17 18 19
#row5 = 20 21 22 23 24
def check_cages_valid(cell_list, cage_split):
		#		new_list.append(empty_list[int(cell_list[z])])
				
	for x in range(len(cage_split)):
		#cage split is a list of each cages inputs
		#[[cage 1 inputs],[cage 2 inputs], [etc...]]
		cage_sum = cage_split[x][0]
		number_of_cells = cage_split[x][1]
		empty_list = []
		#correct range
		for y in range(2, int(number_of_cells) + 2):
			empty_list.append(cage_split[x][y])
			#empty list is now a list of each cages positions
			#[[cage 1 positions],[cage 2 position],[etc...]]
		cage_list =[]
		addition = 0
		for a in empty_list:
			#a is the position for each cage
			#[[1,4,8],[4,5,6],[etc...]]
			#a would go from positions 1 -> 4 -> 8 for the first cage in this for loop
			addition = addition + cell_list[int(a)]

			cage_list.append(cell_list[int(a)]) 
			#cage list is now a list of the values of all positions listed for each cage
			#[3,4,5]

		#if complete and addition != sum
		if cage_list.count(0) == 0 and addition != int(cage_sum):
			#	print("False")
			return False

		#if incomplete and addition >= sum
		elif cage_list.count(0) != 0 and addition >= int(cage_sum):
		#	 print("False")
			 return False
				#if incomplete and addition < sum
				#elif cell_list[int(z)].count(0) >= 1 and addition < int(cage_sum):
				#	return True
				#if compete and addition = sum (else true)
				#if cell_list[int(z)] != 0 and addition == int(cage_sum):
				#	return True
	#else:
#		print("true")
	return True

def check_rows_valid(cell_list, cell_location):
	row_start = cell_location - cell_location % 5
	row_end = row_start + 5
	current_row_list = cell_list[row_start : row_end]
	if current_row_list.count(cell_list[cell_location]) > 1:
		return False
	elif (cell_location + 1) % 5 == 0 and cell_list[cell_location] == 0:
		return False
	else:
		return True 

def check_columns_valid(cell_list, cell_location):
	five_ahead = cell_location
	five_back = cell_location
	while five_ahead <= 19:
		five_ahead = five_ahead + 5
		if cell_list[five_ahead] == cell_list[cell_location]:
#			print("False") 
			return False
	while five_back >= 5:
		five_back = five_back - 5
		if cell_list[five_back] == cell_list[cell_location]:
#			print("False")
			return False
	return True

# def main():
# 	cell_list = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
# 	number_of_cages = eval(input("Number of cages: "))
# 	if number_of_cages == 0:
# 		number_of_cells = 0
# 		initiate_position = 0
# 		while initiate_position < len(cell_list) and initiate_position >= 0: #stops when initiate position > 25
# 		#		print('---------------')

# 			if cell_list[initiate_position] < 5:
# 				cell_list[initiate_position] = cell_list[initiate_position] + 1
					
# 				if check_rows_valid(cell_list, initiate_position) == True and check_columns_valid(cell_list, initiate_position) == True:# and check_cages_valid(cell_list, number_of_cages, cage_split, cage_sum, empty_list, addition) == False:
# 					initiate_position = initiate_position + 1
# 			elif cell_list[initiate_position] == 5:
# 				cell_list[initiate_position] = 0
# 				initiate_position = initiate_position - 1
# 	else:
# 		print("")
# 		for x in range(number_of_cages):
# 			cage = input("Cage number" + str(x) + ": ")
			
# 			cage_split = cage.split()
# 			cage_sum = cage_split[0]
# 			number_of_cells = cage_split[1]
# 			#	print(cage_split)
# 			#	print(number_of_cells)
# 			empty_list = []
# 				#turn the cage
# 			for y in range(2, int(number_of_cells) + 2):
# 				empty_list.append(cage_split[y])
# 			addition = 0
# 			for a in empty_list:
# 				addition = addition + cell_list[int(a)] 

# 		initiate_position = 0
# 		while initiate_position < len(cell_list) and initiate_position >= 0: #stops when initiate position > 25
# 		#		print('---------------')

# 			if cell_list[initiate_position] < 5:
# 				cell_list[initiate_position] = cell_list[initiate_position] + 1
# 				print(cell_list)
					
# 				if check_rows_valid(cell_list, initiate_position) == True and check_columns_valid(cell_list, initiate_position) == True and check_cages_valid(cell_list, number_of_cages, cage_split, cage_sum, empty_list, addition) == False:
# 					initiate_position = initiate_position + 1
				
# 			elif cell_list[initiate_position] == 5:
# 				cell_list[initiate_position] = 0
# 				initiate_position = initiate_position - 1
# 			check_cages_valid(cell_list, number_of_cages, cage_split, cage_sum, empty_list, addition)
#		while initiate_position < 25:
#			if check_cages_valid(cell_list, number_of_cages) == True:
#				initiate_position = initiate_position + 1
	
#	if check_cages_valid(cell_list, number_of_cages) == False:


			#print(cell_list[initiate_position])

				
#			print('x pos', x)
#			print('cell_list[x] val', cell_list[x])

#			while cell_list[x] > 5:
#				cell_list[x] = 0 
#				x = x - 1
	# for x in range(number_of_cages):
	# 	cage = input("Cage number" + str(x) + ": ")
	
	# 	cage_split = cage.split()
	# 	cage_sum = cage_split[0]
	# 	number_of_cells = cage_split[1]
	# #	print(cage_split)
	# #	print(number_of_cells)
	# 	empty_list = []
	# 	#turn the cage
	# 	for y in range(2, int(number_of_cells) + 2):
	# 		empty_list.append(cage_split[y])
	# 	addition = 0
	# 	for a in empty_list:
	# 		addition = addition + cell_list[int(a)] 
	# 	print("addition", addition)
	#check_cages_valid(cell_list, number_of_cages)
#	for x in range(number_of_cages):
#		cage = input("Cage number" + str(x) + ": ")
		
#		cage_split = cage.split()
#		cage_sum = cage_split[0]
#		number_of_cells = cage_split[1]
	#	print(cage_split)
	#	print(number_of_cells)
#		empty_list = []
		#turn the cage
#		for y in range(2, int(number_of_cells)+2):
#			empty_list.append(cage_split[y])
#		print(empty_list)
	#increment each duplicate cell by 1


		#list_of_cells = cage.split[2:number_of_cells + 2]
		#print(list_of_cells)
#	while initiate_position < 25: #stops when initiate position > 25
#		print(initiate_position, "initiate_position")
#		print('---------------')
#		if cell_list[initiate_position] < 5:
#			cell_list[initiate_position] = cell_list[initiate_position] + 1
#			print(cell_list[initiate_position],"cell_list[initiate_position]")
			

#			while check_rows_valid(cell_list, initiate_position) == False and check_columns_valid(cell_list, initiate_position) == False:
#				if cell_list[initiate_position] < 5:
#					cell_list[initiate_position] = cell_list[initiate_position] + 1 
				
#				elif cell_list[initiate_position] == 5:
#					cell_list[initiate_position] = 0
#					initiate_position = initiate_position - 1
		#	if check_rows_valid(cell_list, initiate_position) == True and check_columns_valid(cell_list, initiate_position) == True:
#		initiate_position = initiate_position + 1
			#print(cell_list[initiate_position])

#		if x % 5 == 4 and x <= 4:
#			print(concatenate[x - 4: x + 5],"\n")
#		elif x % 5 == 4 
#			print(concatenate[x - 9: x + 1],"\n")
#		elif x % 5 == 4 and (x > 9 and x <= 14) or x % 5 == 4 and (x > 19 and x <=24):
#			print(concatenate[x - 8: x + 1],"\n")
		# prints the first row twice???
	# concatenate = ""
	# for x in range(len(cell_list)):
	# 	concatenate = concatenate + str(cell_list[x]) + " "
	# print(concatenate[0:9])
	# print(concatenate[10:19])
	# print(concatenate[20:29])
	# print(concatenate[30:39])
	# print(concatenate[40:49])
 	# print(cell_list)
# if __name__ == '__main__':
# 	main()
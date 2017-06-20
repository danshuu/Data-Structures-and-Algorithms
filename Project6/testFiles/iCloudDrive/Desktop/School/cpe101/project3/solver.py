# Project 3
# Name: Daniel Shu
# This project helps the user solve a calcudoku puzzle taking into account the number of cages, cage sum, number of cells within the cage, and the cage cell positions.

from solverFuncs import*

def main():
	cell_list = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	number_of_cages = eval(input("Number of cages: "))
	if number_of_cages == 0:
		number_of_cells = 0
		initiate_position = 0
		while initiate_position < len(cell_list) and initiate_position >= 0:

			if cell_list[initiate_position] < 5:
				cell_list[initiate_position] = cell_list[initiate_position] + 1
					
				if check_rows_valid(cell_list, initiate_position) == True and check_columns_valid(cell_list, initiate_position) == True:
					initiate_position = initiate_position + 1
			elif cell_list[initiate_position] == 5:
				cell_list[initiate_position] = 0
				initiate_position = initiate_position - 1
	else:
		cage_split = []
		#cage_split is now appended as a list of lists
		#each list within contains a list of the values at the positions the user inputted
		for x in range(number_of_cages):
			cage = input("Cage number" + str(x) + ": ")
			cage_split.append(cage.split())

		initiate_position = 0
		while initiate_position < len(cell_list) and initiate_position >= 0: 

			if cell_list[initiate_position] < 5:
				cell_list[initiate_position] = cell_list[initiate_position] + 1
				
				if check_rows_valid(cell_list, initiate_position) == True and check_columns_valid(cell_list, initiate_position) == True and check_cages_valid(cell_list, cage_split) == True:
					initiate_position = initiate_position + 1
				
			elif cell_list[initiate_position] == 5:
				cell_list[initiate_position] = 0
				initiate_position = initiate_position - 1

	#concatenate is intended to print out the solution
	concatenate = ""
	for x in range(len(cell_list)):
		concatenate = concatenate + str(cell_list[x]) + " "
	print("")
	print("Solution:")
	print(concatenate[0:9])
	print(concatenate[10:19])
	print(concatenate[20:29])
	print(concatenate[30:39])
	print(concatenate[40:49])

if __name__ == '__main__':
	main()
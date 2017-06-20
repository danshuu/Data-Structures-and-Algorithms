/* Name: Daniel Shu */
/* Assignment 7 CPE225 */
/* Practice writing a recursive function in C */
/* Understand what function calls look like at the machine level */
/*  */
/*  */
#include <stdio.h> /* input output library */
#include "part1count.h"

/* Part 1: C Recursion */

/*
* This function counts backward from x to 1 by one.
* For example, calling this function with a value of 5 should * result in the following output:
* 5, 4, 3, 2, 1
*/
int main() {
	int value;
	printf("Enter your integer: ");
	scanf("%d", &value);

	printf("Counting backwards.\n");
	countBackwardFrom(value);

	printf("Counting forward.\n");
	countForwardTo(value);

	return 0;
}

void countBackwardFrom(int x) {
	if (x == 1) {
		printf("1\n");
	} else {
		printf("%d", x);
		printf(", ");
		countBackwardFrom(x-1);
	}
}

void countForwardTo(int x) {
	if (x > 0) {
		if (x == 1) {
			printf("%d", x);
		} else {
			countForwardTo(x-1);
			printf(", %d", x);
		}
	} 
	/* got the commas correctly */
}

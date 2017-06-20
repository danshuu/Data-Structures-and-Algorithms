/* Name: Daniel Shu */
/* Assignment 6 CPE225 */
/* In the pop, return the popped value in the first argument */
/* Create an associated stack.h file that holes the prototype of all of the stack functions */
/* These functions should only manipulate the stack; they may not print anything*/
/*  */

#include <stdio.h>
#include "stack.h" 


/* Global variables */
int arr[10]; /* creates an array that holds 10 elements */
int indx = 0;
int lastPushed;
int i;

int push(int value) {
 	if (indx >= 10) {
 		return 1; /* overflow */ 
 	}
 	/* check if value is an int */
 	lastPushed = value;
 	arr[indx] = lastPushed;
 	indx++; /* increment indx */

 	return 0;
} 


int pop(int *value) {
	if (indx <= 0) {
		return 1; /* underflow */
	}
	 
	*value = arr[indx-1]; /* saves the popped element */
	indx--;

	return 0;
}

void printStack(int value) {
	printf("Stack: ");
	if (value == 0) {
		for (i = 0; i < indx; i++) {
			if (i == indx) {
				printf("%d", arr[i]);
			} else {
				printf("%d ", arr[i]);
			}
		}
	} else if (value == 1) {
		for (i = 0; i < indx; i++) {
			if (i == indx) {
				printf("%x", arr[i]);
			} else {
				printf("%x ", arr[i]);
			}		
		}
	} else if (value == 2) {
		for (i = 0; i < indx; i++) {
			if (i == indx) {
				printf("%c", arr[i]);
			} else {
				printf("%c ", arr[i]);
			}		
		}
	} 

}
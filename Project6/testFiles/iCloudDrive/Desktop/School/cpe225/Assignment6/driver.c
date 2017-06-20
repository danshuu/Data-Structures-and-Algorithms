#include <stdio.h>
#include "stack.h"

int main() {

	char letter;
	int value;
	int mode = 0;
	int popped;
	int underflow = 0;
	int overflow = 0;

	printf("Welcome to the stack program.\n\n");
	printf("Enter option: ");
	scanf("%c", &letter); /* why doesn't there need to be a space before the %c here but it's required in the loop? */
	while (letter != 'x') {
		if (letter == 'u') {
			printf("What number? ");
			scanf("%d", &value);
			overflow = push(value); 
			if (overflow == 1) {
				printf("Overflow!!!\n");
			}

			printStack(mode);
			overflow = 0;
		} else if (letter == 'o') {
			underflow = pop(&popped);
			if (underflow == 1) {
				printf("Underflow!!!\n");
			} else {
				printf("Popped ");
				printf("%d\n", popped);
			}
			printStack(mode);
			underflow = 0;

		} else if (letter == 'd') {
			mode = 0;
			printStack(mode);

		} else if (letter == 'h') {
			mode = 1;
			printStack(mode);

		} else if (letter == 'c') {
			mode = 2;
			printStack(mode);

		} 


		printf("\n\nEnter option: ");
		scanf(" %c", &letter);

		if (letter == 'x') {
			printf("Goodbye!\n");
		}

	} /* end of while loop */ 
	return 0;
}
/* Name: Daniel Shu */
/* Assignment 8 CPE225 */
/* Write a program that will parse an input file searching for occurrences of a word. */
/* It will output the total number of occurrences and all the lines with the word in it. */
/* Assume no lines in the file will be longer than 100 characters */
/* No assumptions made about how many occurrence of the word will be in the file */
/* MUST use a linked list and allocate space for each word occurrence as you go */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "myGrep.h"

void printWordStats(Node *header); /* declare function */

void printWordStats(Node *header) {
	Node *current = header;
	Node *ptr;
	while (current-> next != NULL) {
		printf("line %d; word %d; %s", current->lineNumber, current->wordLocation, current->lineThatContainsWord);
		ptr = current;
		current = current->next;
		free(ptr);
	}
}

int main(int argc, char **argv) {
	/* all declarations */
	int i;
	char line[100];
	char longestLine[100];
	int numChars = 0;
	int mainLineNumber = 0;
	int mainWordLocation;
	int wordOccurrences = 0;
	char *token;
	char savedLine[100];
	/* char *savedLine; ??*/

	FILE *file;

	Node *head = malloc(sizeof(Node));
	Node *tail;
	head->next = NULL; /* allocate memory space for the head */
	tail = head;
	if (argc != 3) {
		printf("myGrep: improper number of arguments \n");
		printf("Usage: ./a.out <filename> <word>\n");
		return 0;
	 /* open file */
	} 
	/* if 3 arguments */
	file = fopen(argv[1], "r");
	if (file) { /* if file was successfully opened */
		
		/* print command line arguments */
		for (i = 0; i < argc; i++) {
			if (i == argc - 1) {
				printf("%s\n", argv[i]);
			} else {
				printf("%s ", argv[i]);
			}
		}
		
		while (fgets(line, 100, file) != NULL) { /* goes through each line */
			mainWordLocation = 0; /* starts at 0 for each line traversed */
			mainLineNumber++;
			if (strlen(line) > numChars) {
				numChars = strlen(line);
				strcpy(longestLine, line);

			}
			/* savedLine = line; ???*/
			strcpy(savedLine, line);
			token = strtok(line, " \n");
			/* printf("savedline is %s", savedLine); */
			/* adding all tokens equivalent to argv[argc-1] to the linked list */
			while (token != NULL) {
				/* printf("%s\n", token); */
				if (strcmp(token, argv[argc-1]) == 0) {

					wordOccurrences++; /* increment word occurrences */
					
					strcpy(tail->lineThatContainsWord, savedLine);
					tail->lineNumber = mainLineNumber-1;
					tail->wordLocation = mainWordLocation;

					tail->next = malloc(sizeof(Node));
					tail->next-> next= NULL;
					tail = tail->next;

				}
				mainWordLocation++;
				token = strtok(NULL, " \n");
			} /* end of if statement */

			/*printf("%ld characters in this line.", strlen(line));
			puts(line);*/
		} /* end of while loop */
		
		printf("longest line: %s", longestLine);
		printf("num chars: %d\n", strlen(longestLine));
		printf("num lines: %d\n", mainLineNumber);
		printf("total occurrences of word: %d\n", wordOccurrences);
		printWordStats(head);
		/* free(head); */
		fclose(file);

	} else { /* if file can't be opened */
		printf("Unable to open file: %s\n", argv[1]);
	} /* end of else */

	return 0;
} 

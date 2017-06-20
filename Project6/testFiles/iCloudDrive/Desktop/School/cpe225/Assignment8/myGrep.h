/* use strtok to parse each line */

typedef struct NodeClass {

	char lineThatContainsWord[100];
	int lineNumber;
	int wordLocation;
	struct NodeClass *next;

} Node;

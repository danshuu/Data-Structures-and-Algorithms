#include <stdio.h>

int t;
int j;

int main() {
	/*
	{
		int t = 2;
		printf("%d\n", t);
		
		printf("%d\n", t);
		t = 3;
		
		printf("%d\n", t);
	}

	printf("%d\n", t);
	*/
	int x;
	t = 5;
	j = t += 1;
	printf("t is ");
	printf("%d\n", t);
	printf("j is ");
	printf("%d\n", j);
	x = 5 * 5 + 2;
	x = x + 2 * 2;
	printf("x is ");
	printf("%d\n", x);
}

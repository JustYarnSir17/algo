#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main() {
	int a, b,i=0,j=0;

	scanf("%d %d", &a, &b);
	while (a) {
		i = (i * 10) + (a % 10);
		a = a / 10;
	}
	while (b) {
		j = (j * 10) + (b % 10);
		b = b / 10;
	}
	if (i < j)
		printf("%d", j);
	else if (j < i)
		printf("%d", i);


	
}
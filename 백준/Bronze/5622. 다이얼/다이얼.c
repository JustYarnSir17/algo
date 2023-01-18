#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int dial(char a);

int main() {
	char arr[17];
	int i,sum=0;

	fgets(arr, 17, stdin);
	arr[strlen(arr) - 1] = 0;
	
	for (i = 0; i < strlen(arr); i++)
	{
		sum += dial(arr[i]);
	}
	sum += strlen(arr);

	printf("%d", sum);
	

}

int dial(char a) {

	
	if (64 < a&& a < 68) {
		return 2;
	}
	else if (67 < a&&a < 71) {
		return 3;
	}
	else if (70 < a && a < 74) {
		return 4;
	}
	else if (73 < a && a < 77) {
		return 5;
	}
	else if (76 < a && a < 80) {
		return 6;
	}
	else if (79 < a && a < 84) {
		return 7;
	}
	else if (83 < a && a < 87) {
		return 8;
	}
	else if (86 < a && a < 89) {
		return 9;
	}
}
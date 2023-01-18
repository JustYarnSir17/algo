#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	char str[80];
	int* arr;
	int n, i, j, count, sum;

	scanf("%d", &n);
	arr = malloc(sizeof(int) * n);

	for (i = 0; i < n; i++) {
		count = 0;
		sum = 0;
		scanf("%s", str);
		for (j = 0; j < 80; j++) {
			if (str[j] == 'O')
			{
				count++;

				sum += count;
			}
			else if (str[j] == 'X')
			{
				count = 0;

				sum += count;
			}
			if (str[j] != 'O' && str[j] != 'X')
				break;


		}
		arr[i] = sum;
	}
	for (i = 0; i < n; i++) {
		printf("%d\n", arr[i]);

	}

	
	


	
}
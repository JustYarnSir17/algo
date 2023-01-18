#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define Max 101


int main() {
	int n, i, j, k, sum = 0,cal;
	char arr[Max];


	scanf("%d", &n);
	getchar();

	for (i = 0; i < n; i++) {
		fgets(arr, 101, stdin);
		arr[strlen(arr) - 1] = 0;
		cal = 1;
		for (j = 0; j < strlen(arr); j++) {
			if (cal == 0)
				break;
			for (k = j+1; k < strlen(arr); k++) {
				if (arr[j] == arr[k]) {
					if (arr[j] != arr[k - 1]) {
						cal = 0;
					}
					else {
						j = k;
						k++;
					}
				}
			}
		}
		if (cal != 0) {
			sum++;
		}





	}
				
	printf("%d", sum);
}


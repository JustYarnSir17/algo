#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>



int main() {
	int arr1[3];
	int arr2[2];
	int sum[6];
	int i, j,k=0,min;

	for (i = 0; i < 3; i++) {
		scanf("%d", &arr1[i]);
		getchar();
	}for (i = 0; i < 2; i++) {
		scanf("%d", &arr2[i]);
		getchar();
	}

	for (i = 0; i < 3; i++) {
		for (j = 0; j < 2; j++) {
			sum[k] = arr1[i] + arr2[j]-50;
			k++;
		}
	}
	min = sum[0];
	for (i = 0; i < 6; i++) {
		if (min > sum[i])
			min = sum[i];
	}
	printf("%d", min);
}


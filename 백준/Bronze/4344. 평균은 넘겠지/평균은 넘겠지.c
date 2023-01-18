#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int * test;
	int n, i, j, k, score, count=0;
	double* arr, sum=0;

	scanf(" %d", &n);
	arr = (double*)malloc(sizeof(double) * n);
	for (i = 0; i < n; i++) {
		sum = 0;
		scanf(" %d", &j);
		test = malloc(sizeof(int) * j);
		for (k = 0; k < j; k++) {
			scanf(" %d", &score);
			test[k] = score;
			sum += score;

		}
		sum = sum / j;
		for (k = 0; k < j; k++) {
			if (test[k] > sum)
				count++;
			arr[i] = ((double)count / (double)j)*100;
		}

		count = 0;

		
	}

	for (k = 0; k < n; k++) {
		printf("%.3lf%%\n", arr[k]);
	}
	

	
	


	
}
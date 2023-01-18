#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main() {
	int t, k, n, i,j,l,x,sum,h;
	int* cal, ** arr;


	scanf("%d", &t);
	cal = (int)malloc(sizeof(int) * t);
	for (i = 0; i < t; i++) {
		scanf("%d %d", &k, &n);
		h = k + 1;
		arr = (int**)malloc(sizeof(int*) * h);
		for (j = 0; j < h; j++) {
			arr[j] = (int*)malloc(sizeof(int) * n);
		}
		for (j = 0; j < n; j++) {
			arr[0][j] = j + 1;
		}
		for (j = 1; j < h; j++) {

			for (l = 0; l < n; l++) {
				sum = 0;
				for (x = 0; x <= l; x++) {
					sum += arr[j - 1][x];
				}
				arr[j][l] = sum;
			}

		}
		cal[i] = arr[k][n-1];
		for (j = 0; j < h; j++) {
			free(arr[j]);
		}
		free(arr);
	}
	for (i = 0; i < t; i++) {
		printf("%d\n", cal[i]);
	}


}
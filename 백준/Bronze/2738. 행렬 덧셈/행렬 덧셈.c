#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


void sum(int** A, int** B, int n, int m) {
	int i, j;
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			A[i][j] += B[i][j];
		}
	}
}



int main() {
	int** a, ** b;
	int i, j, n, m;

	scanf("%d %d", &n, &m);

	a = (int**)malloc(sizeof(int*) * n);
	b = (int**)malloc(sizeof(int*) * n);
	for (i = 0; i < n; i++) {
		a[i] = (int*)malloc(sizeof(int) * m);
		b[i] = (int*)malloc(sizeof(int) * m);
	}

	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			scanf("%d", &a[i][j]);
		}
	}
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			scanf("%d", &b[i][j]);
		}
	}

	sum(a, b, n, m);
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			printf("%d ", a[i][j]);
		}
		printf("\n");
	}


}
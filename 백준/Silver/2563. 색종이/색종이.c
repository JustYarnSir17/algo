#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main() {
	int arr[100][100] = { 0, };
	int i,j,n,m,k,l,count=0;

	scanf("%d", &n);

	for (i = 0; i < n; i++) {
		scanf("%d %d", &j, &m);
		for (k = j; k < j + 10; k++) {
			for (l = m; l < m + 10; l++) {
				arr[k][l] = 1;

			}
		}
	}
	for (i = 0; i < 100; i++) {
		for (j = 0; j < 100; j++) {
			if (arr[i][j] == 1)
				count++;
		}
	}
	printf("%d", count);

}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int a[9][9];
	int max=0, row, col,i,j;

	for (i = 0; i < 9; i++) {
		for (j = 0; j < 9; j++) {
			scanf("%d", &a[i][j]);
		}
	}

	for (i = 0; i < 9; i++) {
		for (j = 0; j < 9; j++) {
			if (max <= a[i][j])
			{
				max = a[i][j];
				col = i;
				row = j;
			}
		}
	}

	printf("%d\n%d %d", max, col+1, row+1);
}

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, m,i,j,count_a,count_b,a,b,val,min=64;
	char** arr,c;
	scanf("%d %d", &n, &m);
	arr = (int**)malloc(sizeof(char*) * n);
	for (i = 0; i < n; i++) {
		arr[i] = (int*)malloc(sizeof(char) * m);
	}
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			scanf(" %c", &arr[i][j]);
		}
	}
	for (i = 0; i < n-7; i++) {
		for (j = 0; j < m-7; j++) {
			count_a = 0;
			count_b = 0;
			c = arr[i][j];
			for (a = i; a < i + 8; a++) {
				for (b = j; b < j + 8; b++) {
					if ((a + b) % 2 == (i+j)%2)
					{
						if (arr[a][b] != c)
							count_a++;
						else
							count_b++;
					}
					else
						if (arr[a][b] == c)
							count_a++;
						else
							count_b++;
				}
			}
			val = count_a <= count_b ? count_a : count_b;
			if (min > val)
				min = val;
		}
	}
	printf("%d", min);
}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, m,i,j,x,y;
	int* arr,*sum;
	scanf("%d %d", &n, &m);
	arr = (int*)malloc(sizeof(int) * n);
	sum = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
		if (i == 0)
			sum[i] = arr[i];
		else
			sum[i] = sum[i - 1] + arr[i];
	}
	for (i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		if (x == 1) {
			printf("%d\n", sum[y - 1]);
		}
		else
			printf("%d\n", sum[y-1] - sum[x - 2]);
	}
	return 0;

}
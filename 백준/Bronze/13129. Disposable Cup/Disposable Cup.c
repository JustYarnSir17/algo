#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int a, b, n,i;
	int* arr;
	scanf("%d %d %d", &a, &b, &n);
	arr = (int*)malloc(sizeof(int) * n);
	for (i = 1; i <= n; i++) {
		arr[i - 1] = (i * b) + (a * n);
	}
	for (i = 0; i < n; i++) {
		printf("%d ", arr[i]);
	}
}
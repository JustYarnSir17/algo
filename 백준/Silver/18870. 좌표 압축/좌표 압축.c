#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void merge(int* arr, int left, int right) {
	int mid = (left + right) / 2;
	int L, R, k;
	int* tmp;
	L = k = left;
	R = mid + 1;
	tmp = (int*)malloc(sizeof(int) * right + 1);
	while (L <= mid && R <= right) {
		tmp[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
	}
	while (L <= mid)
		tmp[k++] = arr[L++];
	while (R <= right)
		tmp[k++] = arr[R++];
	for (k = left; k <= right; k++)
		arr[k] = tmp[k];
    free(tmp);
}


void mergeSort(int* arr, int left, int right) {
	if (left == right)return;
	int mid = (left + right) / 2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, right);
}

int unique(int* arr, int size) {
	int i, j = 0;
	for (i = 1; i < size; i++) {
		if (arr[j] == arr[i]) continue;
		arr[++j] = arr[i];
	}
	return ++j;
}

int BS(int* arr, int size, int data) {
	int low = 0, high = size - 1, mid;
	while (low <= high) {
		mid = (low + high) / 2;
		if (arr[mid] < data) low = mid + 1;
		else if (arr[mid] > data) high = mid - 1;
		else return mid;
	}
}

int main() {
	int n, i, j, len;
	int* arr, * b;
	scanf("%d", &n);
	arr = (int*)malloc(sizeof(int) * n);
	b = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
		b[i] = arr[i];
	}
	mergeSort(b, 0, n - 1);
	len = unique(b, n);

	for (i = 0; i < n; i++) {
		printf("%d ", BS(b, len, arr[i]));
	}
}
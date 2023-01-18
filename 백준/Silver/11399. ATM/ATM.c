#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void Qsort(int *arr, int left, int right) {
	int L, R;
	int pivot;
	int temp;
	L = left;
	R = right;
	pivot = arr[(left + right) / 2];
	do {
		while (arr[L] < pivot) {
			L++;
		}
		while (arr[R] > pivot) {
			R--;
		}
		if (L <= R) {
			temp = arr[L];
			arr[L] = arr[R];
			arr[R] = temp;
			L++;
			R--;
		}
	} while (L <= R);

	if (left < R) {
		Qsort(arr, left, R);
	}
	if (L < right) {
		Qsort(arr, L, right);
	}
}


int main() {
	int n,i;
	int *arr;
	int sum = 0,idx;
	scanf("%d", &n);
	arr = (int*)malloc(sizeof(int)*n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	Qsort(arr, 0, n - 1);
	idx = n;
	for (i = 0; i < n; i++) {
		sum += arr[i] * idx;
		idx--;
	}
	printf("%d", sum);

}
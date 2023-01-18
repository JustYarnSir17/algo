#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void mergeSort(int *arr, int left, int right) {
	int mid = (left + right) / 2;
	int L, R, k;
	int *tmp;
	L = k = left;
	R = mid + 1;
	tmp = (int*)malloc(sizeof(int)*right + 1);
	while (L <= mid && R <= right) {
		tmp[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
	}
	while (L <= mid) {
		tmp[k++] = arr[L++];
	}
	while (R <= right) {
		tmp[k++] = arr[R++];
	}
	for (int i = left; i <= right; i++) {
		arr[i] = tmp[i];
	}


}

void merge(int *arr, int left, int right) {
	if (left == right)return;
	int mid = (left + right) / 2;
	merge(arr, left, mid);
	merge(arr, mid + 1, right);
	mergeSort(arr, left, right);
}


int main() {
	int arr[3];
	scanf("%d %d %d", &arr[0], &arr[1], &arr[2]);
	merge(arr, 0, 2);
	printf("%d", arr[1]);
}
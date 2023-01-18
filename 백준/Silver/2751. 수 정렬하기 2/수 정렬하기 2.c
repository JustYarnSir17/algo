#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define MAX 1000000
int tmp[MAX];


void merge(int arr[], int left, int right) {
	int L, R, k, a;
	int mid = (left + right) / 2;
	L = left;
	R = mid + 1;
	k = left;
	while (L <= mid && R <= right)
		tmp[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
	if (L > mid) {
		for (a = R; a <= right; a++) {
			tmp[k++] = arr[a];
		}
	}
	else {
		for (a = L; a <= mid; a++) {
			tmp[k++] = arr[a];
		}
	}
	for (a = left; a <= right; a++) {
		arr[a] = tmp[a];
	}
}

void mergeSort(int arr[], int left, int right) {
	if (left == right)return;
	int mid;
	mid = (left + right) / 2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, right);
}


void printArr(int arr[], int size) {
	int i;
	for (i = 0; i < size; i++) {
		printf("%d\n", arr[i]);
	}
}


int main() {
	int n,*arr,i;

	scanf("%d", &n);
	arr = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);

	}
	mergeSort(arr, 0, n-1);
	printArr(arr, n);



}
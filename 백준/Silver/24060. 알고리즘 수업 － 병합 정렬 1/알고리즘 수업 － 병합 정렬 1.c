#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define Max 500001
int data[Max];
int tmp[Max];
int count = 0;
int n, k;
bool flag = false;

void merge(int* arr, int left, int right) {
	int mid = (left + right) / 2;
	int L, R, a;
	L = a = left;
	R = mid + 1;
	while (L <= mid && R <= right) {
		tmp[a++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
	}
	while (L <= mid) {
		tmp[a++] = arr[L++];
	}
	while (R <= right) {
		tmp[a++] = arr[R++];
	}
	for (a = left; a <= right; a++) {
		arr[a] = tmp[a];
		count++;
		if (count == k) {
			printf("%d", arr[a]);
			flag = true;
			return;
		}
	}
}

void mergeSort(int* arr, int left, int right) {
	if (left == right)return;
	int mid = (left + right) / 2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, right);
}

int main() {
	int i;
	scanf("%d %d", &n, &k);
	for (i = 0; i < n; i++) {
		scanf("%d", &data[i]);
	}
	mergeSort(data, 0, n-1);
	if (!flag) {
		printf("-1");
	}
	return 0;
}


#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void merge(int* arr, int left, int right);
void mergeSort(int* arr, int left, int right);
int Fre(int* arr, int n);

int main() {
	int n, i, * arr;
	int mid, fre, range;
	double avg = 0;
	scanf("%d", &n);
	arr = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	mergeSort(arr, 0, n - 1);
	for (i = 0; i < n; i++) {
		avg += arr[i];
	}
	avg = round(avg / n);
	mid = arr[n / 2];
	range = arr[n - 1] - arr[0];
	fre = Fre(arr, n);

	printf("%d\n%d\n%d\n%d", (int)avg, mid, fre, range);

}

void mergeSort(int* arr, int left, int right) {
	if (left == right)return;
	int mid = (left + right) / 2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, right);

}

void merge(int* arr, int left, int right) {
	int mid = (left + right) / 2;
	int L, R, k;
	int* tmp;
	tmp = (int*)malloc(sizeof(int) * right + 1);
	L = k = left;
	R = mid + 1;
	while (L <= mid && R <= right) {
		tmp[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
	}
	while (L <= mid)
		tmp[k++] = arr[L++];
	while (R <= right)
		tmp[k++] = arr[R++];
	for (k = left; k <= right; k++) {
		arr[k] = tmp[k];
	}
	free(tmp);
}

int Fre(int* arr, int n) {
	int b[8001] = { 0, }, count = 0, re = 0;
	int i, idx;
	for (i = 0; i < n; i++) {
		idx = arr[i] + 4000;
		b[idx] ++;
		if (b[idx] > count)
			count = b[idx];

	}
	for (i = 0, idx = 0; i < 8001; i++) {
		if (b[i] == 0)
			continue;
		if (b[i] == count) {
			if (re == 0) {
				idx = i;
				re++;
			}
			else if (re == 1) {
				idx = i;
				break;
			}
		}
	}
	return idx - 4000;

}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int val;
	int count;
}card;

void merge(card* arr, int left, int right) {
	int mid = (left + right) / 2;
	int L, R, k;
	card* tmp;
	L = k = left;
	R = mid+1;
	tmp = (card*)malloc(sizeof(card) * right + 1);
	while (L <= mid && R <= right) {
		tmp[k++] = arr[L].val <= arr[R].val ? arr[L++] : arr[R++];
	}
	while (L <= mid)
		tmp[k++] = arr[L++];
	while (R <= right)
		tmp[k++] = arr[R++];
	for (k = left; k <= right; k++)
		arr[k] = tmp[k];
    free(tmp);
}

void mergeSort(card* arr, int left, int right) {
	if (left == right) return;
	int mid=(left+right)/2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, right);
}

int unique(card* arr, int size) {
	int i, j = 0;
	for (i = 1; i < size; i++) {
		if (arr[j].val == arr[i].val) {
			arr[j].count++;
			continue;
		}
		arr[++j] = arr[i];

	}
	return ++j;
}

int BS(card* arr, int size, int data) {
	int low = 0, high = size - 1, mid;
	while (low <= high) {
		mid = (low + high) / 2;
		if (arr[mid].val < data)low = mid + 1;
		else if (arr[mid].val > data)high = mid - 1;
		else return arr[mid].count;
	}
	return 0;
}

int main() {
	int n, m,i,*b,len;
	card* a;
	scanf("%d", &n);
	a = (card*)malloc(sizeof(card) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", &a[i].val);
		a[i].count = 1;
	}
	scanf("%d", &m);
	b = (int*)malloc(sizeof(int) * m);
	for (i = 0; i < m; i++) {
		scanf("%d", &b[i]);
	}
	mergeSort(a, 0, n - 1);
	len = unique(a, n);
	for (i = 0; i < m; i++) {
		printf("%d ", BS(a, len, b[i]));
	}

}
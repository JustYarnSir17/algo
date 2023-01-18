#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int val;
	int t;

}mm;

void merge(int* arr, int left, int right) {
	int mid = (left + right) / 2;
	int L, k, R;
	int* tmp;
	L = k = left;
	R = mid + 1;
	tmp = (int*)malloc(sizeof(int) * right + 1);
	while (L <= mid && R <= right)
	{
		tmp[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
	}
	while (L <= mid)
		tmp[k++] = arr[L++];
	while (R <= right)
		tmp[k++] = arr[R++];
	for(k=left;k<=right;k++)
		arr[k]=tmp[k];

	free(tmp);

}

void mergeSort(int* arr, int left, int right) {
	if (left == right)return;
	int mid = (left + right) / 2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, right);
}

int BinarySearch(int* arr, int size, int finddata) {
	int low = 0, high = size - 1,mid;
	while (low <= high) {
		mid = (low + high) / 2;
		if (arr[mid] > finddata)high = mid - 1;
		else if (arr[mid] < finddata)low = mid + 1;
		else return 1;
	}
	return 0;

}

int main() {
	int n,m,i,j;
	int* a;
	mm* b;
	scanf("%d", &n);
	a = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	scanf("%d", &m);
	b = (mm*)malloc(sizeof(mm) * m);
	for (i = 0; i < m; i++) {
		scanf("%d", &b[i].val);
	}
	mergeSort(a, 0, n - 1);
	for (i = 0; i < m; i++) {
		b[i].t = BinarySearch(a, n, b[i].val);

	}
	for (i = 0; i < m; i++) {
		printf("%d\n", b[i].t);
	}

}
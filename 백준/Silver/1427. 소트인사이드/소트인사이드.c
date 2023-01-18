#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define max 10

void merge(char* arr, int left, int mid, int right);
void mergeSort(char* arr, int left, int right);
void printfArr(char* arr, int size);

int main() {
	char arr[max];
	int len;
	scanf("%s", arr);
	len = strlen(arr);
	mergeSort(arr, 0, len - 1);
	printfArr(arr, len);

}


void mergeSort(char* arr, int left, int right) {
	if (left == right)return;
	int mid = (left + right) / 2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, mid, right);

}

void merge(char* arr, int left, int mid, int right) {
	char* tmp;
	int L, R, k;
	L = k = left;
	R = mid + 1;
	tmp = (char*)malloc(sizeof(char) * right + 1);
	while (L <= mid && R <= right) {
		tmp[k++] = arr[L] >= arr[R] ? arr[L++] : arr[R++];

	}
	while (L <= mid) {
		tmp[k++] = arr[L++];

	}
	while (R <= right) {
		tmp[k++] = arr[R++];

	}
	for (k = left; k <= right; k++) {
		arr[k] = tmp[k];

	}
	free(tmp);
}
void printfArr(char* arr, int size) {
	int i;
	for (i = 0; i < size; i++) {
		printf("%c", arr[i]);
	}
}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
typedef struct {
	int x, y;

}dot;

void merge(dot* arr, int left, int mid, int right);
void mergeSort(dot* arr, int left, int right);
void printfArr(dot* arr, int size);

int main() {
	dot* arr;
	int n,i;
	scanf("%d", &n);
	arr = (dot*)malloc(sizeof(dot) * n);
	for (i = 0; i < n; i++) {
		scanf("%d %d", &arr[i].x, &arr[i].y);
	}
	mergeSort(arr, 0, n - 1);
	printfArr(arr, n);


}


void mergeSort(dot* arr, int left, int right) {
	if (left == right)return;
	int mid = (left + right) / 2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, mid, right);

}

void merge(dot* arr, int left, int mid, int right) {
	dot* tmp;
	int L, R, k;
	L = k = left;
	R = mid + 1;
	tmp = (dot*)malloc(sizeof(dot) * right + 1);
	while (L <= mid && R <= right) {
		if (arr[L].y < arr[R].y) {
			tmp[k++] = arr[L++];

		}
		else if (arr[R].y < arr[L].y) {
			tmp[k++] = arr[R++];

		}
		else {
			if (arr[L].x < arr[R].x) {
				tmp[k++] = arr[L++];
			}
			else {
				tmp[k++] = arr[R++];
			}
		}

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
void printfArr(dot* arr, int size) {
	int i;
	for (i = 0; i < size; i++) {
		printf("%d %d\n", arr[i].x,arr[i].y);
	}
}
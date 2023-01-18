#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
typedef struct {
	int num;
	int age;
	char name[101];

}person;

void merge(person* arr, int left, int mid, int right);
void mergeSort(person* arr, int left, int right);
void printfArr(person* arr, int size);

int main() {
	person* arr;
	int n, i;
	scanf("%d", &n);
	arr = (person*)malloc(sizeof(person) * n);
	for (i = 0; i < n; i++) {
		scanf("%d %s", &arr[i].age, &arr[i].name);
		arr[i].num = i;
	}
	mergeSort(arr, 0, n - 1);
	printfArr(arr, n);


}


void mergeSort(person* arr, int left, int right) {
	if (left == right)return;
	int mid = (left + right) / 2;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, mid, right);

}

void merge(person* arr, int left, int mid, int right) {
	person* tmp;
	int L, R, k;
	L = k = left;
	R = mid + 1;
	tmp = (person*)malloc(sizeof(person) * (right + 1));
	while (L <= mid && R <= right) {
		if (arr[L].age < arr[R].age) {
			tmp[k++] = arr[L++];

		}
		else if (arr[R].age < arr[L].age) {
			tmp[k++] = arr[R++];

		}
		else {
			if (arr[L].num <= arr[R].num) {
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
void printfArr(person* arr, int size) {
	int i;
	for (i = 0; i < size; i++) {
		printf("%d %s\n", arr[i].age, arr[i].name);
	}
}
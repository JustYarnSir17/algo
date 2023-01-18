#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct {
	int len;
	char words[51];
}str;


void merge(str *a, int left, int right) {
	str* tmp;
	int L, R, k,b;
	int mid = (left + right) / 2;
	L = left;
	R = mid + 1;
	k = left;
	tmp = (str*)calloc(right + 1, sizeof(str));
	while (L <= mid && R <= right) {
		if (a[L].len < a[R].len) {
			tmp[k++] = a[L++];

		}
		else if (a[L].len > a[R].len) {
			tmp[k++] = a[R++];
		}
		else {
			if (strcmp(a[L].words, a[R].words) < 0) {
				tmp[k++] = a[L++];

			}
			else
				tmp[k++] = a[R++];
		}
	}
	if (L > mid) {
		for (b = R; b <= right; b++) {
			tmp[k++] = a[b];
		}
	}
	else
	{
		for (b = L; b <= mid; b++) {
			tmp[k++] = a[b];
		}

	}
	for (b = left; b <= right; b++) {
		a[b] = tmp[b];
	}
	free(tmp);
}


void mergeSort(str *a, int left, int right) {
	if (left == right) {
		return;
	}
	int mid;
	mid = (left + right) / 2;
	mergeSort(a, left, mid);
	mergeSort(a, mid + 1, right);
	merge(a, left, right);
	
}

void printfArr(str* a, int size) {
	int i;
	for (i = 0; i < size; i++) {
		printf("%s\n", a[i].words);
	}
}



int main() {
	int n,i,j;
	str* a;
	scanf("%d", &n);
	a = (str*)malloc(sizeof(str) * n);
	for (i = 0; i < n; i++) {
		scanf("%s", &a[i].words);
		a[i].len = strlen(a[i].words);
		for (j = 0; j < i; j++) {
			if (strcmp(a[i].words, a[j].words) == 0) {
				i --;
				n --;
				break;
			}
		}
	}
	mergeSort(a, 0, n - 1);

	printfArr(a, n);

}
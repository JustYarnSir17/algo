#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int x;
	int y;
} men;

int main() {
	int n,i,j,count=0;
	men* arr;
	int* b;
	scanf("%d", &n);
	arr = (men*)malloc(sizeof(men) * n);
	b = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d %d", &arr[i].x, &arr[i].y);
	}
	for (i = 0; i < n; i++) {
		count = 0;
		for (j = 0; j < n; j++)
			if (arr[i].x < arr[j].x && arr[i].y < arr[j].y)
				count++;
		printf("%d ", count + 1);
	}
	return 0;

}
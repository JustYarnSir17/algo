#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int x;
	int y;
}Element;

Element data[101];
top = -1;

int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
	int temp = (x1 * y2 + x2 * y3 + x3 * y1);
	temp = temp - y1 * x2 - y2 * x3 - y3 * x1;
	if (temp == 0)
		return 1;
	else
		return 0;
}


int main() {
	int n, i, j, k, count=0;
	char** arr;
	scanf("%d", &n);
	arr = (char**)malloc(sizeof(char*) * n);
	for (i = 0; i < n; i++) {
		arr[i] = (char*)malloc(sizeof(char) * n);
	}
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			scanf(" %c", &arr[i][j]);
			if (arr[i][j] != '.') {
				top++;
				data[top].x = i;
				data[top].y = j;
			}
		}
	}
	for (i = 0; i <= top; i++) {
		for (j = i + 1; j <= top; j++) {
			for (k = j + 1; k <= top; k++) {
				if (ccw(data[i].x, data[i].y, data[j].x, data[j].y, data[k].x, data[k].y) == 1) {
					count++;
				}
			}
		}
	}
	printf("%d", count);
}

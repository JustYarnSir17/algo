#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, m, b, i, j, max = 0, min = 256, idx, height, time, dig, tmp;
	int** arr;
	int min_time = -1;
	scanf("%d %d %d", &n, &m, &b);
	arr = (int**)malloc(sizeof(int*) * n);
	for (i = 0; i < n; i++) {
		arr[i] = (int*)malloc(sizeof(int) * m);
	}
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			scanf("%d", &arr[i][j]);
			if (max < arr[i][j])
				max = arr[i][j];
			if (min > arr[i][j])
				min = arr[i][j];
		}
	}
	for (idx = max; idx >= min; idx--) {
		time = 0;
		tmp = b;
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++) {
				dig = arr[i][j] - idx;
				if (dig > 0) {
					tmp += dig;
					time += 2 * dig;
				}
				else if (dig < 0) {
					tmp += dig;
					time -= dig;
				}
			}

		}if (tmp >= 0) {
			if (min_time < 0) {
				min_time = time;
				height = idx;
			}
			else if (min_time > time) {
				min_time = time;
				height = idx;
			}
		}

	}
	printf("%d %d", min_time, height);
	return 0;
}
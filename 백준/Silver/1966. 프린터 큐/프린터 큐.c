#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


int main() {
	int test, n, m, count, front,val;
	int i, j,k;
	int arr[100] = { 0, };

	scanf("%d", &test);
	for (i = 0; i < test; i++) {
		scanf("%d %d", &n, &m);
		count = 1;
		front = 0;
		val = 0;
		for (j = 0; j < n; j++) {
			scanf("%d", &arr[j]);
		}
		while (1) {
			for (k = 0; k < n; k++) {
				if (arr[k] > val)val = arr[k];
			}
			while (arr[front] != val) {
				front = (front + 1) % n;
			}
			if (front == m)break;
			arr[front] = 0;
			front = (front + 1) % n;
			val = 0;
			count++;
		}
		printf("%d\n", count);
	}
	return 0;
}
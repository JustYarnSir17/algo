#include <stdio.h>

int main() {
	int* a;
	int n;
	int i,j;
	scanf("%d %d", &n, &i);
	a = (int*)malloc(sizeof(int) * n);
	for (j = 0; j < n; j++) {
		scanf("%d", &a[j]);
	}
	for (j = 0; j < n; j++) {
		if (a[j] < i) {
			printf("%d ", a[j]);
		}
	}


	return 0;
}
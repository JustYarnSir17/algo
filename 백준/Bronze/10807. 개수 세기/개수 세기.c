#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, i, v, count = 0;
	int* a;

	scanf(" %d", &n);


	a = (int*)malloc(sizeof(int) * n);

	for (i = 0; i < n; i++) {
		scanf(" %d", a+i);
	}
	
	scanf(" %d", &v);

	for (i = 0; i < n; i++) {
		if (v == a[i]) {
			count++;
		}
	}

	printf("%d", count);

	return 0;

}
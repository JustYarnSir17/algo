#include <stdio.h>

int main() {
	int A[9];
	int max, count,i;

	for (i = 0; i < 9; i++) {
		scanf("%d", &A[i]);
	}
	max = A[0];
	count = 1;
	for (i = 0; i < 9; i++) {
		if (A[i] > max) {
			max = A[i];
			count = i+1;
		}

	}
	printf("%d\n%d", max, count);
	
	return 0;
}
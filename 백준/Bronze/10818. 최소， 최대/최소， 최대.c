#include <stdio.h>

int main() {
	int size,i,min,max;

	scanf("%d", &size);
	int* a = malloc(sizeof(int) * size);
	for (i = 0; i < size; i++) {
		scanf("%d", &a[i]);

	}
	max = a[0];
	min = a[0];
	for (i = 0; i < size; i++) {
		if (a[i] > max) {
			max = a[i];

		}
		if (a[i] < min) {
			min = a[i];
		}
	}
	printf("%d %d\n", min, max);

			




	
	return 0;
}
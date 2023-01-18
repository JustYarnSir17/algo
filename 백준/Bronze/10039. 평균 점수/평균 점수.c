#include <stdio.h>

int main() {
	int a[5];
	int i;



	scanf("%d", &a[0]);
	scanf(" %d", &a[1]);
	scanf(" %d", &a[2]);
	scanf(" %d", &a[3]);
	scanf(" %d", &a[4]);
	for (i = 0; i < 5; i++) {
		if (a[i] < 40) {
			a[i] = 40;
		}
	}
	printf("%d", (a[0]+a[1]+a[2]+a[3]+a[4]) / 5);

	
	return 0;
}
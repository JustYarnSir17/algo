#include <stdio.h>

int main() {
	int a, b,c;
	int i,max=0,min;
	scanf("%d %d", &a, &b);
	if (a > b) {
		min = b;
		c = a;
	}
	else {
		min = a;
		c = b;
	}

	for (i = 1; i <= min; i++) {
		if (a % i == 0 && b % i == 0) {
			max = i;
		}
	}
	for (i = c;; i++) {
		if (i % a == 0 && i % b == 0) {
			min = i;
			break;
		}
	}
	printf("%d %d", max, min);
}
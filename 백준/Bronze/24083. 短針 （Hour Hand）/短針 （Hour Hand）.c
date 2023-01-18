#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int a, b,n;
	scanf("%d %d", &a, &b);
	n = (a + b) % 12;
	if (n == 0)
		n = 12;
	printf("%d", n);
}
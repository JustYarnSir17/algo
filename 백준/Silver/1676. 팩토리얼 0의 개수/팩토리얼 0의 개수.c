#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int count = 0, a, b, c;
	int n;
	scanf("%d", &n);
	a = n / 5;
	b = n / 25;
	c = n / 125;
	printf("%d", a + b + c);
	return 0;
}
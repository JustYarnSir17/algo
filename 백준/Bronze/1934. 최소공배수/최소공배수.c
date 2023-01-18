#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int gcd(int a, int b) {
	if (b == 0)
		return a;
	return gcd(b, a % b);
}

int main() {
	int n,i,a,b;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d %d", &a, &b);
		printf("%d\n", (a * b) / gcd(a, b));
	}
	return 0;
	
}
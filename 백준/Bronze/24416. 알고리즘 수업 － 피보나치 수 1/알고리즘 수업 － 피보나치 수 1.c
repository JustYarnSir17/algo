#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int count_1 = 1, count_2 = 0;
int f[41];

int fib(int n) {
	if (n == 1 || n == 2) {
		return 1;
	}
	else {

		count_1++;
		return fib(n - 1) + fib(n - 2);
		
	}
	}

int fibo(n) {
	int i;
	f[1] = f[2] = 1;
	for (i = 3; i <= n; i++) {
		f[i] = f[i - 1] + f[i - 2];
		count_2++;
	}
	return f[n];
}


int main() {
	int n;
	scanf("%d", &n);
	fib(n);
	fibo(n);
	printf("%d %d", count_1, count_2);
}


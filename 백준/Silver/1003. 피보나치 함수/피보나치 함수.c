#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
typedef struct {
	int zero;
	int one;
}fibo;

fibo f[41];

void fib() {
	int i;
	f[0].zero = 1;
	f[0].one = 0;
	f[1].zero = 0;
	f[1].one = 1;
	for (i = 2; i < 41; i++) {
		f[i].zero = f[i - 1].zero + f[i - 2].zero;
		f[i].one = f[i - 1].one + f[i - 2].one;
	}
}

int main() {
	int t,i,n;
	scanf("%d", &t);
	fib();
	for (i = 0; i < t; i++) {
		scanf("%d", &n);
		printf("%d %d\n", f[n].zero,f[n].one);
	}
}
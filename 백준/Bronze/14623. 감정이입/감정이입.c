#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#include <math.h>

void cal(long long n) {
	if (n < 2) {
		printf("%lld", n);
	}
	else {
		cal(n / 2);
		printf("%lld", n % 2);
	}
}


int main() {
	char a[31], b[31];
	long long len,n,tmp=0,i;
	scanf("%s %s", a, b );
	len = strlen(a);
	for (i = 0; i < len; i++) {
		tmp += (a[i] - '0') * pow(2, len - 1 - i);
	}
	n = tmp;
	len = strlen(b);
	tmp = 0;
	for (i = 0; i < len; i++) {
		tmp += (b[i] - '0') * pow(2, len - 1 - i);
	}
	n = n * tmp;
	cal(n);
	return 0;


}
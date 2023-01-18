#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

const int mod= 1234567891;

int main() {
	int n,i;
	long long sum=0, r=1;
	char arr[51];
	scanf("%d", &n);
	scanf("%s", arr);
	for(i=0;i<n;i++){
		sum = (sum+(arr[i] - 'a' + 1) *r) % mod;
		r = (r * 31) % mod;
	}
	printf("%lld", sum);
	return 0;
}
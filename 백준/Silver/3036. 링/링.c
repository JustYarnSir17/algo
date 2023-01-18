#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int gcd(int n, int m) {
	if (m == 0)return n;
	return gcd(m, n % m);
}

int main() {
	int n,i,num;
	int* arr,*b;
	scanf("%d", &n);
	arr = (int*)malloc(sizeof(int) * n);
	b = (int*)malloc(sizeof(int) * n - 1);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	for (i = 1; i < n; i++) {
		b[i - 1] = arr[i];
	}
	for (i = 0; i < n - 1; i++) {
		num = gcd(arr[0], b[i]);
		printf("%d/%d\n", arr[0] / num, b[i] / num);
	}


}
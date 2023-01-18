#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define swap(a,b,temp){temp=a;a=b;b=temp;}

int main() {
	int n,k,i,j,temp;
	int* a;

	scanf("%d %d", &n, &k);
	a = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	for (i = 0; i < n; i++) {
		for (j = i + 1; j < n; j++) {
			if (a[i] < a[j]) {
				swap(a[i], a[j], temp);
			}
		}
	}

	printf("%d", a[k-1]);


}
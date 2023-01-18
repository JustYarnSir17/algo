#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>
int main() {
	int arr[5];
	int n,i,sum=0;

	for (i = 0; i < 5; i++) {
		scanf("%d", &arr[i]);
		sum += pow(arr[i], 2);

	}
	sum = sum % 10;
	printf("%d", sum);
}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n,i,m=-1;
	double* arr,sum=0;
	scanf("%d", &n);
	arr = (double*)malloc(sizeof(double) * n);
	for (i = 0; i < n; i++) {
		scanf("%lf", &arr[i]);
		if (m < arr[i])
			m = arr[i];
	}
	for (i = 0; i < n; i++) {
		arr[i] = (arr[i] / m) * 100;
		sum += arr[i];
	}
	sum = sum / n;
	printf("%lf", sum);
	


	

}
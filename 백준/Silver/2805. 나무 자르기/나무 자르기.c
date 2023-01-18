#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n,i;
	long long* arr;
	long long m,high=0,low,mid,max,sum,val;
	scanf("%d %lld", &n, &m);
	arr = (long long*)malloc(sizeof(long long) * n);
	for (i = 0; i < n; i++) {
		scanf("%lld", &arr[i]);
		if (high < arr[i])
			high = arr[i];
	}
	low = 1;
	max = 0;
	while (low <= high) {
		mid = (low + high) / 2;
		sum = 0;
		val = 0;
		for (i = 0; i < n; i++) {
			if (arr[i] - mid >= 0) {
				val += arr[i] - mid;
				sum += val;
				val = 0;
			}

		}
		if (sum < m)
			high = mid - 1;
		else if (sum >= m) {
			low = mid + 1;
			if (max < mid) {
				max = mid;
			}
		}
	}
	printf("%d", max);
	return 0;
	

}
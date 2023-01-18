#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main() {
	long long  low = 1, high, mid,val;
	int k, n, i, max = 0, count = 0;;
	long long* arr;
	scanf("%d %d", &k, &n);
	arr = (long long *)malloc(sizeof(long long) * k);
	for (i = 0; i < k; i++) {
		scanf("%lld", &arr[i]);
		if (max < arr[i])
			max = arr[i];
	}
	high = max;
	val = 0;
	while (low <= high) {
		mid = (low + high) / 2;
		count = 0;
		for (i = 0; i < k; i++) {
			count += arr[i] / mid;
		}
		if (count < n) {
			high = mid - 1;
		}
		else if (count >= n) {
			low = mid + 1;
			if (val < mid)val = mid;
		}
	}
	printf("%lld", val);
	return 0;

}

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int n,i,val;
	long long max = 0, min = 1000001;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &val);
		if (val > max)
			max = val;
		if (val < min)
			min = val;
	}
	printf("%lld",max*min);

}
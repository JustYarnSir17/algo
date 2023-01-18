#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, k,i,count=0,num=0;
	int* arr;
	scanf("%d %d", &n, &k);
	arr = (int*)malloc(sizeof(int) * n + 1);
	for (i = 1; i <= n; i++) {
		arr[i] = 1;
	}
	i = 1;
	printf("<");
	while (1) {
		if (arr[i] == 1)num++;
		if (arr[i] == 1 && num == k) {
			num = 0;
			arr[i] = 0;
			count++;
			if (count == n) {
				printf("%d>", i);
				break;
			}
			printf("%d, ",i);
		}
		i++;
		if (i > n)i = i - n;
	}
	return 0;
}
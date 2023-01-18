#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define MAX 123456*2+1

int main() {
	int n,i,j,arr[MAX] = { 0, },count=0;
	arr[0] = 1; arr[1] = 1;
	for (i = 2; i <= MAX; i++) {
		if (arr[i] == 1) {
			continue;
		}
		else {
			for (j = 2; i * j <= MAX; j++) {
				arr[i * j] = 1;
			}
		}
	}
	while (1) {
		scanf("%d", &n);
		if (n == 0)
			break;
		
		for (i = n+1; i <= 2 * n; i++) {
			if (arr[i] == 0)
				count++;
		}
		printf("%d\n", count);
		count = 0;
	}
	return 0;

}

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define max 10001
int count[max] = { 0, };

int main() {
	int n, num,i;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &num);
		count[num] ++;
	}
	for (i = 0; i < max; i++) {
		if (count[i] != 0) {
			while (count[i] > 0) {
				printf("%d\n", i);
				count[i]--;
			}
		}
	}
}

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int i, j,k;
	int h;
	int s[5];
	scanf(" %d %d", &i, &j);
	h = i * j;
	for (k = 0; k < 5; k++) {
		scanf(" %d", &s[k]);
	}
	for (k = 0; k < 5; k++) {
		printf("%d ", s[k]-h);
	}
}
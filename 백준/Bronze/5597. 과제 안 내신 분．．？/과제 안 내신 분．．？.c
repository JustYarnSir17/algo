#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main() {
	bool a[30]={false};
	int i,b;

	for (i = 0; i < 28; i++) {
		scanf("%d", &b);
		a[b - 1] = true;
	}

	for (i = 0; i < 30; i++) {
		if (!a[i]) {
			printf("%d\n", i + 1);
		}
	}

}

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int main() {
	int n, r, i, j, l, count = 0;
	char arr[20];

	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf(" %d", &r);
		scanf(" %s", arr);
		l = strlen(arr);
		for (j = 0; j < l; j++) {
			count = 0;
			while (1) {
				printf("%c", arr[j]);
				count++;
				if (count == r)
					break;
			}
		}
		printf("\n");
	}


}
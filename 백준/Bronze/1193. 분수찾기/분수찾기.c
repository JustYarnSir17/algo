#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>



int main() {
	int n, i,j, count = 0;
	

	scanf("%d", &n);
	for (i = 2;; i++) {
		for (j = 1; j < i; j++) {
			if ((i - 1) % 2 == 1) {

				count++;
				if (count == n) {
					printf("%d/%d", i - j, j);
					break;
				}
			}
			else {
				if ((i - 1) % 2 == 0) {

					count++;
					if (count == n) {
						printf("%d/%d", j, i - j);
						break;
					}
				}
			}
		}
		if (count == n)
			break;
	}
}



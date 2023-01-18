#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int n,count=0,i=665,j=0,k;
	scanf("%d", &n);
	while (count != n) {

		i++;
		k = i;
		while (k > 665) {
			
			j = k % 10;
			if (j == 6) {
				j = (k / 10) % 10;
				if (j == 6) {
					j = (k / 100) % 10;
					if (j == 6) {
						count++;
						break;
					}
				}
			}

			k = k / 10;
		}
	}
	printf("%d", i);
}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>



int main() {
	int n,i,count=1;
	i = 1;

	scanf("%d", &n);
	while (1) {
		if (i >= n) {
			printf("%d", count);
			break;
		}
		else {
			i += 6*count;
			count++;
		}
	}
	
}



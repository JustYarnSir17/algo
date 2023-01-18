#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>




int main() {
	double a, b, v;
	int i = 0;

	scanf("%d %d %d", &a, &b, &v);
	if (v == a) {
		i = 1;
	}
	else {
			i = ceil((v - b) / (a - b));
			
		}
	
	printf("%d", i);
}


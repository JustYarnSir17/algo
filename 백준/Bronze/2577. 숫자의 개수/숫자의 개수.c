#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>


int main() {
	int x, y, z;
	int sum;
	int* a[100];
	int i,j;
	int count1 = 0,count2=0;
	int* b[10];
	scanf("%d %d %d", &x, &y, &z);
	sum = x * y * z;
	while (1) {
		if (sum < 10) {
			a[count1] = sum;
			break;
		}
		a[count1] = sum % 10;
		sum = sum / 10;
		count1++;
	}

	for (i = 0; i < 10; i++) {
		for (j = 0; j <= count1; j++) {
			if (a[j] == i) {
				count2++;
			}
		}
		b[i] = count2;
		count2 = 0;
	}

	for (i = 0; i < 10; i++) {
		printf("%d\n", b[i]);
	}
	return 0;

}

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int i,j,arr[5],avg=0,mid,temp;
	for (i = 0; i < 5; i++) {
		scanf("%d", &arr[i]);
		avg += arr[i];
	}
	for (i = 0; i < 5; i++) {
		for (j = i + 1; j < 5; j++) {
			if (arr[i] > arr[j]) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	avg = avg / 5;
	mid = arr[2];
	printf("%d\n%d", avg, mid);

}
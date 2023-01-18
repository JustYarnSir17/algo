#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int main() {
	int arr[10], i,j,temp,count=1;

	for (i = 0; i < 10; i++) {
		scanf("%d", &arr[i]);
		arr[i] = arr[i] % 42;
	}
	for (i = 0; i < 10; i++) {
		for (j = 0; j < i; j++) {
			if (arr[j] > arr[i]) {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
	}
	j = arr[0];
	for (i = 0; i < 10; i++) {
		if (j != arr[i]) {
			count++;
			j = arr[i];
		}
	}
	printf("%d", count);
}
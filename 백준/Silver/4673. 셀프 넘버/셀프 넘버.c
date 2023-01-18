#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int arr[10001]={0,};
	int i, j, k,sum;
	for (i = 1; i < 10001; i++) {
		j = i;
		sum = i + (j % 10);
		if (j >= 10) {
			while (j >= 10) {
				j = j / 10;

				sum += (j % 10);
			}
		}
			
		if (sum < 10001) {
			arr[sum] = 1;
		}
	}
	for (i = 1; i < 10001; i++) {
		if (arr[i] == 0) {
			printf("%d\n", i);
		}
	}
	

}
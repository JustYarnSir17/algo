#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main(){
	int n,i,sum=0;
	int* arr;

	scanf("%d", &n);
	arr = (int)malloc(sizeof(int) * n);
	
	for (i = 0; i < n; i++) {
		scanf("%1d", &arr[i]);
		sum += arr[i];
	}
	printf("%d", sum);

}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int main(){
	int *arr,n, m,i,j,k,sum=0;

	scanf("%d %d", &n, &m);
	arr = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	for (;; m--) {
		for (i = 0; i < n; i++) {
			for (j = 0; j < i; j++) {
				for (k = 0; k < j; k++) {
					if (arr[i] + arr[j] + arr[k] == m)
					{
						sum = m;
						break;

					}
				}
			}
			if (sum != NULL)
				break;
		}
		if (sum != NULL)
			break;
	}
	printf("%d", sum);

}
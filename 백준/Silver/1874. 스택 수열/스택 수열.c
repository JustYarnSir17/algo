#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define Max 100001
int data[Max];
char result[Max * 2];
int top=-1;

int main() {
	int n, i, idx=0, idx_2=0, val=1;
	int* arr;
	scanf("%d", &n);
	arr = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	while(1){
		if (top == -1 || data[top] < arr[idx]) {
			data[++top] = val++;
			result[idx_2++] = '+';
		}
		else if (data[top] == arr[idx]) {
			top--;
			result[idx_2++] = '-';
			idx++;
		}
		else {
			printf("NO\n");
			return 0;
		}
		if (idx_2 == n * 2)break;

	}
	for (i = 0; i < idx_2; i++) {
		printf("%c\n", result[i]);
	}
	return 0;
}
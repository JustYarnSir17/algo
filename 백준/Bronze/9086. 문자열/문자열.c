#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
int main() {
	int n,i,len;
	char arr[1000];
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%s", arr);
		len = strlen(arr);
		printf("%c%c\n", arr[0], arr[len - 1]);
	}
	return 0;
	
}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	char arr[100],alp[26];
	int i,j;
	scanf("%s", arr);
	for (i = 0; i < 26; i++) {
		for (j = 0; j < strlen(arr); j++) {
			if (97 + i == arr[j]) {
				alp[i] = j;
				break;
			}
			alp[i] = -1;
		}
		printf("%d ", alp[i]);
	}
}
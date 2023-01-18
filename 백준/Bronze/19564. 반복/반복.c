#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
int main() {
	char arr[100001];
	char b[26] = { "abcdefghijklmnopqrstuvwxyz" };
	int idx = 0,i,count=0,len;
	scanf("%s", arr);
	len = strlen(arr);
	while (1) {
		count++;
		for (i = 0; i < 26; i++) {
			if (arr[idx]==b[i]) {
				idx++;
			}
		}
		if (idx == len)
			break;

	}
	printf("%d", count);

}
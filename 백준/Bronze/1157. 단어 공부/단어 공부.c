#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define Max 1000000

int main() {
	char arr[Max];
	int al[26];
	int n, i, j,count,max=0,num=0;

	scanf("%s", arr);
	n = strlen(arr);
	for (i = 0; i < 26; i++) {
		count = 0;
		for (j = 0; j < n; j++) {
			if (arr[j] == 65 + i || arr[j] == 97 + i) {
				count++;
			}
		}
		al[i] = count;
	}
		for (j = 0; j < 26; j++) {
			if (max < al[j]) {
				max = al[j];
				num = j;
			}
		}
		for (i = 0; i < 26; i++) {
			if (max == al[i]&&num!=i) {
				printf("?");
				break;
			}
			if(i==25)
			printf("%c", 65 + num);
		}


}
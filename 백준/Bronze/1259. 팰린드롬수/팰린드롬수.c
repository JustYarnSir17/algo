#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>


int main() {
	char a[6],b[6];
	int len,i,tf=1;

	while (1) {
		tf = 1;
		scanf("%s", a);
		if (strcmp(a, "0") == 0) {
			tf = -1;
			break;
		}

		len = strlen(a);

		for (i = 0; i < len; i++) {
			b[len - 1 - i] = a[i];
		}
		for (i = 0; i < len; i++) {
			if (a[i] != b[i]) {
				tf = 0;
				break;
			}
		}

		if (tf == 1) {
			printf("yes\n");
		}
		else if (tf == 0)
			printf("no\n");
		else
			break;
	}
	return 0;
}
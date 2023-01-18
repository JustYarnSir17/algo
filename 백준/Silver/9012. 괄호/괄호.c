#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define Max 51
int main() {
	int n,i,j,len,count=0;
	char arr[Max];

	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%s", arr);
		len = strlen(arr);
		count = 0;
		for (j = 0; j < len; j++) {
			if (arr[j] == '(') {
				count++;
			}
			else
			{
				count--;
			}
			if (count < 0)
				break;
		}
		if (count != 0)
			printf("NO\n");
		else
			printf("YES\n");
		

	}
}


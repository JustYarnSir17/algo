#include <stdio.h>
#include <string.h>

#define MAX 1000001


int main() {
	char a[MAX];
	int count = 0, i, j;


	scanf("%[^\n]s", a);
	j = strlen(a);
	for (i = 0; i < j; i++) {
		if (a[i] == ' ')
		{
			if (i != 0 && i != j - 1) {
				count++;
			}

			if (j == 1)
				count = -1;
		}
	}

	printf("%d", count+1);
}
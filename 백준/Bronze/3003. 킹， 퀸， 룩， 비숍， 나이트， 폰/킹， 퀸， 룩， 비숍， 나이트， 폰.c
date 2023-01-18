#include <stdio.h>

int main() {
	int a[6] = { 0 };
	int b[6] = { 1,1,2,2,2,8 };
	int i,c;
	for (i = 0; i < 6; i++) {
		scanf(" %d", &a[i]);

	}
	for (i = 0; i < 6; i++) {
		c = b[i] - a[i];
		printf("%d ", c);
	}
		
}
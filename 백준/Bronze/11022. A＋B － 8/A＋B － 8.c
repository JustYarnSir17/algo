#include <stdio.h>

int main() {
	int a;
	int x,y,i;
	scanf("%d", &a);
	for (i = 1; i <= a; i++) {
		scanf("%d %d", &x, &y);
		printf("Case #%d: %d + %d = %d\n", i, x, y, x + y);
	}

	return 0;
}
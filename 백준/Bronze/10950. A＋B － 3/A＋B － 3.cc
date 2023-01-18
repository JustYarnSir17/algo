#include <stdio.h>

int main() {
	int a;
	int i, x, y;
	scanf("%d", &a);
	for (i = 0; i < a; i++) {
		scanf("%d %d", &x, &y);
		printf("%d\n", x + y);
	}
	return 0;
}
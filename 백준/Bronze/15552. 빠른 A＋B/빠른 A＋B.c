#include <stdio.h>

int main() {
	int a, b,c;
	int i;
	scanf("%d", &a);
	for (i = 0; i < a; i++) {
		scanf("%d %d", &b, &c);
		printf("%d\n", b + c
			);
	}

	return 0;
}
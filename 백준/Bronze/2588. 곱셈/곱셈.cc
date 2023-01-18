#include <stdio.h>

int main() {
	int a, b;
	int x, y, z;
	scanf("%d", &a);
	scanf("%d", &b);
	z = b % 10;
	y = (b % 100) / 10;
	x = (b / 100);
	printf("%d\n", z=a * z);
	printf("%d\n", y=a * y);
	printf("%d\n", x=a * x);
	printf("%d\n", (100 * x) + (10 * y) + z);
	

	

	return 0;
}
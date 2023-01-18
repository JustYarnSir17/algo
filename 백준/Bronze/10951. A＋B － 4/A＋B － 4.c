#include <stdio.h>

int main() {
	int a, b;

	while (scanf("%d",&a)!=EOF&&scanf("%d",&b)!=EOF) {
		printf("%d\n", a + b);
	}

	
	return 0;
}
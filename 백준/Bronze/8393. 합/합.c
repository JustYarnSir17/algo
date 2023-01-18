#include <stdio.h>

int main() {
	int a, count=0;
	int i;
	scanf("%d", &a);
	for (i = 1; i <= a; i++) {
		count+=i;
	}
	printf("%d",count);
	return 0;
}
#include <stdio.h>

#define MAX 1000000000



int main() {
	int x,n;
	int sum=0;
	int a, b,c;
	int i;

	scanf(" %d", &x);
	scanf(" %d", &n);

	for (i = 0; i < n; i++) {
		scanf(" %d %d", &a, &b);
		c = a * b;
		sum += c;
		c = 0;

	} 
	if (sum == x)
		printf("Yes");
	else
		printf("No");
 }
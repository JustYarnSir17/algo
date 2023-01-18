#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>



int main() {
	int fix, flex, price;
	int num = 0;
	scanf("%d %d %d", &fix, &flex, &price);

	if (flex >= price) {
		printf("-1");
	}
	else
	{
		num = (-fix) / (flex - price)+1;
		printf("%d", num);

	}
}


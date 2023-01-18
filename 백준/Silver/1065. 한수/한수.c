#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int n,i,arr[1001]={0,},a,b,c,r,count=0;
	for (i = 1; i < 1001; i++) {
		if (i < 100)
			arr[i] = 1;
		if (i >= 100) {
			a = i / 100;
			b = (i / 10) % 10;
			c = i % 10;
			r = a - b;
			if (b - c == r) {
				arr[i] = 1;
			}
		}

	}

	scanf("%d", &n);
	for (i = 1; i <= n; i++) {
		if (arr[i] == 1) {
			count++;
			
		}
	}
	printf("%d", count);

}
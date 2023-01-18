#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>



int main() {
	int n;
	int t, f, min=-1;
	int i, j;

	scanf("%d", &n);
	for (i = 0;i<=n/5; i++) {
		for (j = 0;j<=n/3; j++) {
			if (i == (n - 3 * j) / 5&&(n-3*j)%5==0) {
				
					min = i + j;
			}
		}
	}
	if (min > 0) {
		printf("%d", min);
	}
	else
		printf("-1");
	

	
	
	

}



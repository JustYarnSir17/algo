#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <math.h>




int main() {
	int a,*arr;
	int h, w,n,i,x,y,f;

	scanf("%d", &a);
	arr = (int)malloc(sizeof(int) * a);
	for (i = 0; i < a; i++) {
		scanf("%d %d %d", &h, &w, &n);
		if (n > h) {
			if ((n % h) == 0){
				x = n / h;
				y = h;
			}
			else {
				x = (n / h) + 1;
				y = (n % h);
			}
		}
		else {
			x = 1;
			y = n;
		}

		f = 100 * y + x;
		arr[i] = f;

	}

	for (i = 0; i < a; i++) {
		printf("%d\n",arr[i]);
	}

}


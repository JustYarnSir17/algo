#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <math.h>

int main(){
	int x, y, z,temp;

	while (1) {
		scanf("%d %d %d", &x, &y, &z);
		if (x == 0|| y == 0||z==0) {
			break;
		}

		x = pow(x, 2);
		y = pow(y, 2);
		z = pow(z, 2);
		if (z == x + y||x==z+y||y==z+x)
			printf("right\n");
		else
			printf("wrong\n");

	}
}
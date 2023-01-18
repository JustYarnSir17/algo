#include <stdio.h>

int main() {
	int a, count=0,b, x, y,z;


	scanf("%d", &a);
	if (a >= 10) {
		x = a / 10;
		y = a % 10;
		z = x + y;
		if (z >= 10) {
			z = z%10;
		}
		b = 10 * y + z;
		count++;
	}
	else {
		x = 0;
		y = a;
		z = x + y;
		b = 10 * y + z;
		count++;
	}

	while (!(b == a)) {
		if (b >= 10) {
			x = b / 10;
			y = b % 10;
			z = x + y;
			if (z >= 10) {
				z = z % 10;
			}
			b = 10 * y + z;
			count++;
		}
		else {
			x = 0;
			y = b;
			z = x + y;
			b = 10 * y + z;
			count++;
		}
		
	}
	printf("%d", count);
	


	
	return 0;
}
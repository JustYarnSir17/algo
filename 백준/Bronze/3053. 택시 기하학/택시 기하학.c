#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define _USE_MATH_DEFINES
#include <math.h>
int main() {
	double r, a, b;
	scanf("%lf", &r);
	a = M_PI * pow(r, 2);
	b = 2 * pow(r,2);
	printf("%lf\n%lf", a, b);
}
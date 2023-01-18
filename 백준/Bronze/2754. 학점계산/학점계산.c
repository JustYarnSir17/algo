#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	char arr[3];
	double sum;
	fgets(arr,3,stdin);
	if (arr[0] == 'A') {
		sum = 4;
	}
	else if (arr[0] == 'B') {
		sum = 3;
	}
	else if (arr[0] == 'C') {
		sum = 2;
	}
	else if (arr[0] == 'D') {
		sum = 1;
	}
	else if (arr[0] == 'F') {
		sum = 0;
	}
	
	if (arr[1] == '+') {
		sum += 0.3;
	}
	else if (arr[1] == '-') {
		sum -= 0.3;
	}
	
	
	printf("%.1lf", sum);


}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>



int main() {
	int x,i;
	int data[1000001];
	scanf("%d", &x);
	data[1] = 0;
	for (i = 2; i <=x; i++) {
		data[i] = data[i - 1] + 1;
		if (i % 2 == 0) {
			if (data[i] > data[i / 2] + 1) {
				data[i] = data[i / 2] + 1;
			}
		}
		if (i % 3 == 0) {
			if (data[i] > data[i / 3] + 1) {
				data[i] = data[i / 3] + 1;
			}
		}
	}
	printf("%d", data[x]);
	return 0;
}

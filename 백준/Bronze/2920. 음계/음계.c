#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main() {
	int arr[8];
	int i,count;
	for (i = 0; i < 8; i++) {
		scanf("%d", &arr[i]);

	}
	if (arr[0] == 8) {
		for (i = 1; i < 8; i++) {
			if (arr[i] != 8-i) {
				count = 0;
				break;
			}
			else
				count = -1;

		}
	}
	else if (arr[0] == 1) {
		for (i = 1; i < 8; i++) {
			if (arr[i] != i+1)
			{
				count = 0;
				break;
			}
			else
				count = 1;
		}
	}
	switch (count) {
	case 1:
		printf("ascending");
		break;
	case 0:
		printf("mixed");
		break;
	case -1:
		printf("descending");
		break;
	}

	
}
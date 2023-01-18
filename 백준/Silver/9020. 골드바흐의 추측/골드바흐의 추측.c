#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define MAX 10001

int main() {
	int arr[MAX];
	int i, j,n,m,k,l;
	arr[0] = 1, arr[1] = 1;

	for (i = 2; i < MAX; i++) {
		if (arr[i] == 1)
			continue;
		else {
			for (j = 2; i * j < MAX; j++) {
				arr[i * j] = 1;
			}
		}
	}

	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &m);
		k = m / 2;
		j = k;
		l = k;
		while (1) {
			if (arr[j] != 1 && arr[l] != 1) {
				printf("%d %d\n", j, l);
				break;
			}
			else {
				j--;
				l++;
			}
		
		}

	}


}

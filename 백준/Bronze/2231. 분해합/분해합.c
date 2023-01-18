#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int main(){
	int *arr,n,i=1,f,j,sum,m,com;

	scanf("%d", &n);
	f = n;
	com = n;
	m = n;
	while (1) {
		if (n / 10 == 0) {
			break;
		}
		else
			n = n / 10;
		i++;
	}
	arr = (int*)malloc(sizeof(int) * i);
	while (1) {
		for (;f>0; f--) {
			n = f;
			sum = f;
			for (j = 0; j < i; j++) {
				arr[j] = n % 10;
				n = n / 10;
				sum += arr[j];
			}
			
			if (sum == com) {
				if (m > f) {
					m = f; 
				}
		}
		}
		if (m != NULL) {
			if (m == com) {
				m = 0;
				break;
			}
			else
				break;
		}
			
		else {
			m = 0;
			break;
		}
	}

	printf("%d", m);
	

	
}
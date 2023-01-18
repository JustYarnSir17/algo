#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() {
	int n, k,nn,kk, nk,i,ans;

	scanf("%d %d", &n, &k);
	nn = 1;
	kk = 1;
	nk = n - (n - k);
	for (i = 0; i < nk; i++) {
		nn *= n;
		kk *= k;
		n--;
		k--;
	}
	ans = nn / kk;
	printf("%d", ans);
}
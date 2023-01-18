#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
long long arr[1001][1001];




int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	int i, j;
	for (i = 1; i <= n; i++) {
		for (j = 1; j <= m; j++) {
			if (i == 1) {
				arr[i][j] = 1;
			}
			else if (j == 1) {
				arr[i][j] = 1;
			}
			else
				arr[i][j] = (arr[i - 1][j] + arr[i][j - 1] + arr[i - 1][j - 1])%1000000007;
		}
		if (i == n && j == m) break;
	}

	printf("%lld", arr[n][m]);
	return 0;

}
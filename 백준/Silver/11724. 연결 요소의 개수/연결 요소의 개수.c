#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int data[1001][1001]={0,};
int DFSv[1001]={0,};

void DFS(int v, int n) {
	int i, count = 1;
	DFSv[v] = 1;
	for (i = 1; i <= n; i++) {
		if (data[v][i] == 1 && DFSv[i] == 0) {
			DFS(i, n);
		}
	}
}

int main() {
	int n, m,i,count=0;
	int x, y;
	scanf("%d %d", &n, &m);
	for (i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		data[x][y] = 1;
		data[y][x] = 1;
	}
	for (i = 1; i <= n; i++) {
		if (DFSv[i] == 0) {
			count++;
			DFS(i, n);
		}
	}
	printf("%d", count);


}
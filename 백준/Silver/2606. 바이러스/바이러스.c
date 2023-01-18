#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int com[101][101]={0,};
int DFSv[101] = { 0, };

void DFS(int v, int n) {
	int i;
	DFSv[v] = 1;
	for (i = 1; i <= n; i++) {
		if (com[v][i] == 1 && DFSv[i] == 0) {
			DFS(i, n);
		}
	}
}

int main() {
	int n, m,i;
	int x, y, count=0;
	scanf("%d %d", &n, &m);
	for (i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		com[x][y] = 1;
		com[y][x] = 1;
	}
	DFS(1, n);
	for (i = 0; i < 101; i++) {
		if (DFSv[i] != 0) count++;
	}
	printf("%d", count-1);

}

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int graph[1001][1001]={0,};
int DFSv[1001]={0,};
int BFSv[1001]={0,};
int queue[1001];

void DFS(int a, int n) {
	int i;
	DFSv[a] = 1;
	printf("%d ", a);
	for (i = 1; i <= n; i++) {
		if (graph[a][i] == 1 && DFSv[i] == 0) {
			DFS(i, n);
		}
	}
	return;
}

void BFS(int a, int n) {
	int front = 0, rear = 0, pop, i;
	printf("%d ", a);
	queue[0] = a;
	rear++;
	BFSv[a] = 1;

	while (front < rear) {
		pop = queue[front];
		front++;
		for (i = 1; i <= n; i++) {
			if (graph[pop][i] == 1 && BFSv[i] == 0) {
				printf("%d ", i);
				queue[rear] = i;
				rear++;
				BFSv[i] = 1;
			}
		}
	}
	return;
}

int main() {
	int n, m, v;
	int x, y,i;
	scanf("%d %d %d", &n, &m, &v);
	for (i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		graph[x][y] = 1;
		graph[y][x] = 1;
	}
	DFS(v, n);
	printf("\n");
	BFS(v, n);
	return 0;
}
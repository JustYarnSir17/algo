#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int cnt = 0;
int n, m;
int dr[4] = { 1,0,-1,0 };
int dc[4] = { 0,1,0,-1 };
vector<vector<char>>arr;
void find(int r, int c) {
	vector<vector<bool>>v(n, vector<bool>(m));
	queue<pair<int, int>> q;
	int count = -1;
	v[r][c] = true;
	q.push(make_pair(r, c));
	while (!q.empty()) {
		int size = q.size();
		count++;

		for (int s = 0; s < size; s++) {
			pair<int, int> node = q.front();
			q.pop();
			for (int i = 0; i < 4; i++) {
				
				int nr = node.first + dr[i];
				int nc = node.second + dc[i];
				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if (arr[nr][nc] == 'L' && !v[nr][nc]) {
					v[nr][nc] = true;
					q.push(make_pair(nr, nc));
				}
			}
		}
		
	}
	cnt = max(count, cnt);

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	
	cin >> n >> m;
	arr=vector<vector<char>>(n,vector<char>(m));

	for (int i = 0; i < n; i++) {
		string tmp;
		cin >> tmp;

		for (int j = 0; j < m; j++) {
			
			arr[i][j]=tmp.at(j);
			
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (arr[i][j] == 'L') {
				find(i, j);
			}
		}
	}

	cout << cnt;

	return 0;



}
#include<iostream>
#include <vector>

using namespace std;


int main() {
	int n;
	int m;
	cin >> n>>m;
	vector<vector<int>> arr(n, vector<int>(n, 0));
	for (int i = 0; i < m; i++) {
		int a;
		int b;
		cin >> a>> b;
		arr[a - 1][b - 1] = -1;
		arr[b - 1][a - 1] = 1;

	}
	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][k] == 1 && arr[k][j] == 1) {
					arr[i][j] = 1;
				}
				else if (arr[i][k] == -1 && arr[k][j] == -1) {
					arr[i][j] = -1;
				}
			}
		}
	}
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		int count = 0;
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 0) {
				++count;
			}
		}
		if (count == 1) {
			++cnt;
		}
	}

	cout << cnt;
	return 0;
}
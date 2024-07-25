#include <iostream>
#include <vector>
#include <queue>

using namespace std;
int n, m, k, x;
vector<vector<int>> list;
int* arr;
int MAX = 1000000;


void find() {
	for (int i = 0; i < n; i++) {
		arr[i] = MAX;
	}
	arr[x-1] = 0;
	queue<int> q;
	q.push(x-1);
	int time = 0;
	while (!q.empty()) {
		int size = q.size();
		time++;
		for (int i = 0; i < size; i++) {
			int curr = q.front();
			q.pop();
			for (int j = 0; j < list[curr].size(); j++) {
				if (arr[list[curr].at(j)] > time) {
					arr[list[curr].at(j)] = time;
					q.push(list[curr].at(j));
				}
			}
		}
	}
}

int main() {
	cin >> n >> m >> k >> x;
	arr = new int[n];
	list.resize(n);
	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		list[a - 1].push_back(b-1);
	}
	find();
	bool tr = false;
	for (int i = 0; i < n; i++) {
		if (arr[i] == k) {
			tr = true;
			cout << i + 1 << endl;
		}
	}
	if (!tr) {
		cout << -1;
	}
}
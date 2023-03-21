#include <iostream>
using namespace std;
int cnt = 0;
int *arr;
int n, m;
int sum = 0;

void cal(int idx) {
	if (sum == m) {
		cnt++;
		return;
	}
	else if (sum > m) {
		return;
	}
	if (idx == n) {
		return;
	}
	sum += arr[idx];
	cal(idx + 1);
	sum -= arr[idx];
	cal(idx + 1);


}
int main() {
	int T;
	cin >> T;
	for (int t = 1; t <= T; t++) {
		cnt = 0;
		sum = 0;
		cin >> n >> m;
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			cin >> arr[i];

		}
		cal(0);
		cout << "#" << t << " " << cnt<<endl;
		
	}



}
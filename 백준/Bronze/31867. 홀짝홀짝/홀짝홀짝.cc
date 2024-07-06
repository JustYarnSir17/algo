#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

int main() {
	int n;
	cin >> n;
	int* arr = new int[n];
	string str;
	cin >> str;
	
	for (int i = 0; i < n; i++) {
		arr[i] = str[i] - '0';
	}
	int e = 0;
	int o = 0;
	int answer = 0;

	for (int i = 0; i < n; i++) {
		if (arr[i] % 2 == 0) {
			++e;
		}
		else {
			++o;
		}
	}

	if (e > o) {
		answer = 0;
	}
	else if (o > e) {
		answer = 1;
	}
	else {
		answer = -1;
	}

	cout << answer << endl;

	return 0;
}
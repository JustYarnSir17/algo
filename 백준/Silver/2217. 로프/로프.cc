#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

int main() {
	int n;
	cin >> n;
	vector<int>vec;

	int max = 0;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		vec.push_back(tmp);
	}
	sort(vec.begin(), vec.end(), greater<int>());
	

	for (int i = 0; i < n; i++) {
		int tmp = vec[i] * (i + 1);
		if (max < tmp) {
			max = tmp;
		}
	}

	cout << max<<endl;
	return 0;
}
#include <iostream>
#include <queue>
#include <set>
using namespace std;



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;
	vector<string> arr(n);
	
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int len = arr[0].length();
	for (int i = len-1; i >=0; i--) {
		set<string> s;
		bool tr = false;
		for (int j = 0; j < n; j++) {
			string tmp = arr[j].substr(i);
			if (s.find(tmp) != s.end()) {
				tr = true;
				break;
			}
			s.insert(tmp);
		}
		if (!tr) {
			cout << (len-i);
			break;
		}
	}
	

	return 0;

}
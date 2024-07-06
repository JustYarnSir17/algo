#include <iostream>
#include <vector>
#include <algorithm>


using namespace std;

int main() {
	unsigned int n;
	unsigned int cnt=0;
	cin >> n;
	
	for (int i = 1; i <= n; i++) {
		if (n - i > i) {
			++cnt;
			n -= i;
		}
		else {
			++cnt;
			break;
		}
	}
	cout << cnt << endl;

	return 0;
}
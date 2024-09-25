#include <iostream>
#include <queue>
using namespace std;



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;
	priority_queue<int> gifts;
	vector<int> students(m);
	for (int i = 0; i < n; i++) {
		int gift;
		cin >> gift;
		gifts.push(gift);

	}

	for (int i = 0; i < m; i++) {
		cin >> students[i];
		
	}
	bool tr = false;
	for (int i = 0; i < m; i++) {
		if (students[i] > gifts.top()) {
			tr = true;
			break;
		}
		else {
			int tmp = gifts.top() - students[i];
			gifts.pop();
			if (tmp > 0) {
				gifts.push(tmp);
			}
		}
	}

	if (tr) {
		cout << "0";
	}
	else {
		cout << "1";

	}

	return 0;


}
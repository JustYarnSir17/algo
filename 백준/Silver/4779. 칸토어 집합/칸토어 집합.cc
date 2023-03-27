#include <iostream>
using namespace std;
void cal2(int n) {
	for (int i = 0; i < n; i++) {
		cout << " ";
	}
}
void cal(int n) {
	if (n > 1) {
		cal(n / 3);
		cal2(n / 3);
		cal(n / 3);
		
	}
	else if (n == 1) {
		cout << "-";
		return;
	}
	
	
	
}


int main() {
	int n;
	while (cin>>n) {
		int tmp = 1;
		for (int i = 0; i < n; i++)
			tmp *= 3;
		cal(tmp);
		cout << endl;
	}

}
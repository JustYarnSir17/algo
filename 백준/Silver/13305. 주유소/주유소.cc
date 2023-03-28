#include <iostream>
using namespace std;
long long int *arr;
long long int *b;
long long int sum = 0;
int n;
void cal(int idx) {
	if (idx == n - 1)
		return;
	long long int tmp = 0;
	int idx2 = n-1;
	for (int i = idx + 1; i < n; i++) {
		if (arr[i] < arr[idx]) {
			idx2 = i;
			break;
		}
		
	}
	for (int i = idx; i < idx2; i++) {
		tmp += arr[idx] * b[i];
	}
	sum += tmp;
	cal(idx2);

}


int main() {
	n;
	cin >> n;
	arr = new long long int[n];
	b = new long long int[n - 1];
	for (int i = 0; i < n - 1; i++) {
		cin >> b[i];

	}
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	cal(0);
	cout << sum;

	
}
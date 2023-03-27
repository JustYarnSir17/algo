#include <iostream>
using namespace std;

long long int cal(long long int a, long long int b) {
	
	return b ? cal(b, a%b) : a;

	
}

int main() {
	long long int a, b;
	cin >> a >> b;
	long long int tmp = cal(b, a);
	long long int sum = a * b;
	cout << sum / tmp;

}
#include <iostream>
using namespace std;

int main() {
	int a, b, c;
	cin >> a >> b >> c;
	if (a == b && b == c &&c == 60) { 
		cout << "Equilateral";
	}
	else if (a + b + c == 180 && a == b || a == c || b == c) {
		cout << "Isosceles";
	}
	else if (a + b + c == 180 && a != b && a != c && b != c) {
		cout << "Scalene";
	}
	else if (a + b + c != 180) {
		cout << "Error";
	}

}
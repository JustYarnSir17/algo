#include<iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

int main() {

	int n;
	cin >> n;
	int* arr = new int[1001];
	arr[1] = 1;//1은 SK
	arr[2] = 2;//2는 CY
	arr[3] = 1;
	for (int i = 4; i <= 1000; i++) {
		if (arr[i - 3] == arr[i - 1]) {
			arr[i] = arr[i - 3] == 1 ? 2 : 1;
		}
	}
	if(arr[n] == 1) {
		cout << "SK";
	}
	else {
		cout << "CY";
	}


	return 0;
}
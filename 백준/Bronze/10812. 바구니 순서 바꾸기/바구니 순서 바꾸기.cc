#include <iostream>
	using namespace std;

	
	void cal(int *arr, int begin, int mid, int end) {
		int size = end - begin+1;
		int *b = new int[size];
		
		int idx = 0;
		for (int i = mid; i <= end; i++) {
			b[idx++] = arr[i];
		}
		for (int i = begin; i <= mid - 1; i++) {
			b[idx++] = arr[i];
		}

		idx = begin;

		for (int i = 0; i < size; i++) {
			arr[idx++] = b[i];
		}
	}

	int main() {
		int n, m;
		int *arr;

		cin >> n >> m;
		arr = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		for (int i = 0; i < m; i++) {
			int a, b, c;
			cin >> a >> b >> c;	
			cal(arr, a, c, b);
		
		}
		for (int j = 1; j <= n; j++) {
			cout << arr[j] << " ";
		}

	}
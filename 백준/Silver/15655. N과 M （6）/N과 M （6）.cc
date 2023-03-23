#include <iostream>
using namespace std;
int *arr;
int n, m;
bool * v;
int *b;
int count = 0;



void merge(int left, int right) {

	int L, R, k,mid;
	mid = (left + right) / 2;
	int * tmp = new int[n];
	L = k = left;
	R = mid + 1;
	while (L <= mid && R <= right) {
		tmp[k++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];

	}
	while (L <= mid) {
		tmp[k++] = arr[L++];

	}
	while (R <= right) {
		tmp[k++] = arr[R++];
	}
	for (k = left; k <= right; k++) {
		arr[k] = tmp[k];
	}

	free(tmp);
}



void mergeSort(int left, int right) {
	if (left < right) { 
	int mid = (left + right) / 2;
	mergeSort(left, mid);
	mergeSort(mid + 1, right);
	merge(left, right);
}
}

void cal(int count,int idx) {
	if (count == m) {
		for (int i = 0; i < m; i++) {
			cout << b[i] << " ";

		}
		cout << endl;
		return;

	}
	
	for (int i= idx+1; i < n; i++) {
		if (v[i]!=true) {
			b[count] = arr[i];
			v[i] = true;
			cal(count + 1, i);
			v[i] = false;
		}
	}

}

int main() {
	
	cin >> n>> m;
	
	arr = new int[n];
	v = new bool[n];
	b = new int[m];
	for (int i = 0; i < n; i ++) {
		cin >> arr[i];
	}
	mergeSort(0, n - 1);
	cal(0, -1);

}
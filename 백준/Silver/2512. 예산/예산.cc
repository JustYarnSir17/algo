#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, m;
    cin >> n;
    vector<int> arr(n);
    int answer = 0;
    int maxNum = 0;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        maxNum = max(maxNum, arr[i]);
    }
    cin >> m;
    int left = 0, right = maxNum;
    while (left <= right) {
        int mid = (left + right) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += min(arr[i], mid);
        }
        if (sum <= m) {
            answer = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    cout << answer;
    return 0;
}
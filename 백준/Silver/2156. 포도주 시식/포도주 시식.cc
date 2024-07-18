#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    vector<int>dp(n);
    dp[0] = arr[0];
    dp[1] = arr[0] + arr[1];
    dp[2] = max(max(arr[0] + arr[1], arr[0] + arr[2]), arr[1] + arr[2]);
    for (int i = 3; i < n; i++) {
        dp[i] = max(max(dp[i - 1], dp[i - 2] + arr[i]), dp[i - 3] + arr[i - 1] + arr[i]);
    }

    cout << dp[n-1];
    return 0;
}
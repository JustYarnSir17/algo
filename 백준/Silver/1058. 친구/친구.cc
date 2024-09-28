#include <iostream>
#include <algorithm>
#include <vector>
#include <limits.h>
using namespace std;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<vector<int>> arr(n,vector<int>(n,INT_MAX));

    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        for (int j = 0; j < n; j++) {
            if (str.at(j) == 'Y') {
                arr[i][j] = 1;
            }

        }
    }
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (arr[i][k] !=INT_MAX && arr[k][j] !=INT_MAX) {
                    arr[i][j] = min(arr[i][j],arr[i][k]+arr[k][j]);
                }
            }
        }
    }
    
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (arr[i][j] <= 2) {
                count++;
            }
        }
        if (cnt < count) {
            cnt = count;

        }
    }
    cout << cnt;
    

    return 0;
}
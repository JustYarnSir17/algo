#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    int m;
    cin >> n >> m;

    // 초기화
    vector<vector<int>> arr(n, vector<int>(n, 10000));
    for (int i = 0; i < n; i++) {
        arr[i][i] = 0; // 자기 자신으로의 거리는 0으로 설정
    }

    // 간선 입력
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        arr[a-1][b-1] = 1;
        arr[b-1][a-1] = 1;
    }

    // 플로이드-워셜 알고리즘
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][k] < 10000 && arr[k][j] < 10000) {
                    arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
    }
    int min = 10000;
    int idx = 0;
    for (int i = 0; i < n; i++) {
        int tmp = 0;
        for (int j = 0; j < n; j++) {
            tmp += arr[i][j];
        }
        if (min > tmp) {
            min = tmp;
            idx = i+1;
        }
    }

    cout << idx;
    return 0;
}
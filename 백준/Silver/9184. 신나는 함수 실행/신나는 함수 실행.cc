#include <iostream>

using namespace std;

int arr[21][21][21];

int w(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0)
        return 1;
    if (a > 20 || b > 20 || c > 20)
        return arr[20][20][20];
    return arr[a][b][c];
}

int main() {
    for (int i = 0; i <= 20; i++) {
        for (int j = 0; j <= 20; j++) {
            for (int k = 0; k <= 20; k++) {
                if (i == 0 || j == 0 || k == 0) {
                    arr[i][j][k] = 1;
                }
                else if (i < j && j < k) {
                    arr[i][j][k] = arr[i][j][k - 1] + arr[i][j - 1][k - 1] - arr[i][j - 1][k];
                }
                else {
                    arr[i][j][k] = arr[i - 1][j][k] + arr[i - 1][j - 1][k] + arr[i - 1][j][k - 1] - arr[i - 1][j - 1][k - 1];
                }
            }
        }
    }

    int a, b, c;
    while (true) {
        cin >> a >> b >> c;
        if (a == -1 && b == -1 && c == -1)
            break;
        cout << "w(" << a << ", " << b << ", " << c << ") = " << w(a, b, c) << endl;
    }

    return 0;
}
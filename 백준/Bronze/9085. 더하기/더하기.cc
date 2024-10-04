#include <iostream>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    for (int time = 0; time < t; time++) {
        int n;
        cin >> n;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp;
            cin >> tmp;
            sum += tmp;
        }
        cout << sum << "\n";
    }
    cout << endl;


    return 0;
}
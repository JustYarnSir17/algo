#include<iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;
int main() {
    int n, m;
    cin >> n >> m;
    vector<int> a(n);
    vector<int>b(m);

    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    for (int i = 0; i < m; i++) {
        cin >> b[i];
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());


    int idx1 = 0, idx2 = 0;
    string answer = "";
    while (idx1 < n && idx2 < m) {
        if (a[idx1] < b[idx2]) {
            answer.append(to_string(a[idx1++])+" ");
            
        }
        else {
            answer.append(to_string(b[idx2++]) + " ");
        }
    }
    while (idx1 < n) {
        answer.append(to_string(a[idx1++]) + " ");
    }
    while (idx2 < m) {
        answer.append(to_string(b[idx2++]) + " ");
    }

    cout << answer;
    
    return 0;
}
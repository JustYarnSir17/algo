#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int val = 0;
int n;
vector<int>arr;
vector<bool> v;

int cal(vector<int>a) {
    int sum = 0;

    for (int i = 0; i < n - 1; i++) {
        sum += abs(a[i] - a[i + 1]);
    }
    return sum;
}

void find(int size,vector<int> answer) {
    if (size == n) {
        val=max(val,cal(answer));
        return;
    }

    for (int i = 0; i < n; i++) {
        if (!v[i]) {
            v[i] = true;
            answer.push_back(arr[i]);
            find(size + 1, answer);
            answer.pop_back();
            v[i] = false;
        }
    }

}


int main() {
    
    
    cin >> n;
    arr= vector<int>(n);
    v = vector<bool>(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    vector<int>answer;
    find(0, answer);

    cout << val;

    return 0;
}
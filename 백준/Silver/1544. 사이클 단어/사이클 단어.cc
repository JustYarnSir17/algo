#include <iostream>
#include <queue>
#include <unordered_set>
using namespace std;



int main() {
    int n;
    cin >> n;
    int cnt = 0;
    unordered_set<string> set;
    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        bool tr = false;
        for (int j = 0; j < str.length(); j++) {
            string tmp = "";
            tmp += str.substr(j);
            tmp += str.substr(0, j);
            if (set.find(tmp) != set.end()) {
                tr = true;
            }
            
        }
        if (!tr) {
            cnt++;
        }
        set.insert(str);
        
    }

    cout << cnt << endl;

    return 0;
}
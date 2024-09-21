#include <iostream>
#include <unordered_set>
#include <algorithm>
#include <vector>

using namespace std;


int main() {
    int t;
    cin >> t;
    for (int time = 0; time < t; time++) {
        int n;
        cin >> n;
        vector<int> students(n);
        for (int i = 0; i < n; i++) {
            int tmp;
            cin >> tmp;
            students[i] = tmp;
        }
        int m = 1;
        while (m < 1000000) {
            unordered_set<int> set;
            bool tr = false;
            for (int i = 0; i < n; i++) {
                int tmp = students[i] % m;
                if (set.find(tmp) != set.end()) {
                    m++;
                    tr = true;
                    break;
                }
                set.insert(tmp);

            }
            if(!tr){

                break;
            }

        }
        cout << m << endl;
    }



    return 0;
}
#include <iostream>
#include <unordered_map>
#include <algorithm>
#include <vector>

using namespace std;


int main() {
    int n, m;
    cin >> n >> m;

    unordered_map<string, string> member;
    unordered_map<string, vector<string>> group;

    for (int i = 0; i < n; i++) {
        string gr;
        int num;
        cin >> gr;
        cin >> num;
        vector<string> mem(num);
        for (int j = 0; j < num; j++) {
            string person;
            cin >> person;
            member[person] = gr;
            mem[j] = person;
        }
        group[gr] = mem;
        
    }
    for (int i = 0; i < m; i++) {
        string str;
        int quiz;
        cin >> str >> quiz;
        if (quiz == 0) {
            vector<string>& members = group[str];
            sort(members.begin(), members.end());
            for (const string& member : members) {
                cout << member << endl;
            }
            
        }
        else {
            cout << member[str] << endl;


        }
    }



    return 0;
}